from datetime import datetime
from django.core.urlresolvers import reverse
from django.db.models import Q
from django.http import HttpResponse
from django.shortcuts import render_to_response
from django.template import RequestContext
from jsonrpc import JSONRPCService, jsonremote
from skynet_frontend.keywordcloud.models import KeywordCloud
from skynet_frontend.twitter.models import Tweet, Keyword, User

def index(request):
    return render_to_response("twitter/index.html", { }, context_instance=RequestContext(request)) 

service = JSONRPCService()

def rpc(request):
    result  = service(request)
    return HttpResponse(result, mimetype='application/json')

class TwitterRpcMethods(object):

    url = reverse("twitter-rpc")

    @staticmethod
    @jsonremote(service)
    def load_tweet(tweet_id):
        tweet = Tweet.objects.get(pk=tweet_id)
        return tweet
    
    @staticmethod
    @jsonremote(service)
    def load_user(user_id):
        user = User.objects.get(pk=user_id)
        return user
    
    @staticmethod
    @jsonremote(service)
    def search_tweets(filters):
        tweets = TwitterRpcMethods.do_query(filters)
            
        exclude = []    
        for filter in filters:
            if filter['type'] == 'keyword':
                exclude.append(filter['value'])
            elif filter['type'] == 'user':
                exclude.append('@' + filter['value'])
        
        tweet_ids = tweets.values_list('id', flat=True)
        keywords = Keyword.get_all_in_tweets(tweet_ids)
        cloud = KeywordCloud(keywords, exclude=exclude)
            
        return {
            'tweet_ids': [str(tweet_id) for tweet_id in tweet_ids or []],
            'cloud':cloud,
        }
        
    @staticmethod
    @jsonremote(service)
    def check_for_update(filters, last):
        
        last = datetime.fromtimestamp(last)
        tweets = TwitterRpcMethods.do_query(filters)
        tweets.distinct().filter(created_at__gt=last)
        tweet_ids = tweets.values_list('id', flat=True)
        keywords = Keyword.get_all_in_tweets(tweet_ids)
        cloud = KeywordCloud(keywords)
            
        return {
            'tweet_ids': [str(tweet_id) for tweet_id in tweet_ids],
            'cloud':cloud,
        }
        
    @staticmethod
    def do_query(filters):
        tweets = Tweet.objects.all()
        
        for filter in filters:
            value = filter['value']
            if filter['type']=='keyword':
                tweets = tweets.distinct().filter(keywords__keyword=value)
                
            if filter['type']=='user':
                tweets = tweets.distinct().filter(Q(keywords__keyword="@"+value) | Q(user__screen_name=value))
            
            if filter['type']=='tag':
                tweets = tweets.distinct().filter(hashtags__text=value)
                
            if filter['type']=='geo':
                country = filter['country']
                tweets = tweets.distinct().filter(place__country=country)
                if filter['value']:
                    tweets = tweets.distinct().filter(place__name=value)
            if filter['type']=='time':
                from_time = datetime.fromtimestamp(value)
                tweets = tweets.distinct().filter(created_at__gte=from_time)
                if filter['to']:
                    to_time = datetime.fromtimestamp(filter['to'])
                    tweets = tweets.distinct().filter(created_at__lte=to_time)
                    
        return tweets        
            
    @staticmethod
    @jsonremote(service)
    def cloud(filters):
        tweets = Tweet.objects.all()
        tweet_ids = tweets.values_list('id', flat=True)                
        keywords = Keyword.get_all_in_tweets(tweet_ids)
        cloud = KeywordCloud(keywords, num_keywords=100)
        return cloud
        
