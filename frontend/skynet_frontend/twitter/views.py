from django.core.urlresolvers import reverse
from django.db.models import Q, Count
from django.http import HttpResponse
from django.shortcuts import render_to_response
from django.template import RequestContext

from skynet_frontend.keywordcloud.models import KeywordCloud
from skynet_frontend.twitter.models import Tweet, Keyword, User
from jsonrpc import JSONRPCService, jsonremote
from datetime import datetime


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
        
        tweet_ids = tweets.values_list('id', flat=True)
        keywords = Keyword.get_all_in_tweets(tweet_ids)
        cloud = KeywordCloud(keywords)
            
        return {
            'tweet_ids': [str(tweet_id) for tweet_id in tweet_ids[:20]],
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
            'tweet_ids': [str(tweet_id) for tweet_id in tweet_ids[:20]],
            'cloud':cloud,
        }
        
        
    @staticmethod
    def do_query(filters):
        tweets = Tweet.objects.all()
        
        for filter in filters:
            if filter['type']=='keyword':
                search_string = filter['value']
                tweets = tweets.distinct().filter(keywords__keyword=search_string)
                
            if filter['type']=='user':
                search_string = filter['value']
                tweets = tweets.distinct().filter(Q(keywords__keyword=search_string) | Q(user__name=search_string))
                
            if filter['type']=='geo':
                search_string = filter['country']
                tweets = tweets.distinct().filter(place__country=search_string)
                if filter['value']:
                    tweets = tweets.distinct().filter(place__name=filter['value'])
        
        return tweets        
            
    @staticmethod
    @jsonremote(service)
    def cloud():
        tweets = Tweet.objects.all()
        tweet_ids = tweets.values_list('id', flat=True)                
        keywords = Keyword.get_all_in_tweets(tweet_ids)
        cloud = KeywordCloud(keywords)
        return cloud
    
    
