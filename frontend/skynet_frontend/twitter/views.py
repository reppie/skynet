from django.core.urlresolvers import reverse
from django.db.models import Q, Count
from django.http import HttpResponse
from django.shortcuts import render_to_response
from django.template import RequestContext

from skynet_frontend.keywordcloud.models import KeywordCloud
from skynet_frontend.twitter.models import Tweet, Keyword, User
from jsonrpc import JSONRPCService, jsonremote


def index(request):
    return render_to_response("twitter/index.html", { 'keywordcloud': Keyword.get_keyword_cloud(), 'tweets': Tweet.objects.all() }, context_instance=RequestContext(request)) 

def search(request):
    search_string = request.GET.get('q')
    tweets = Tweet.objects.all()
    if(search_string):
        if(search_string.startswith('@')):
            tweets = tweets.distinct().filter(Q(keywords__keyword=search_string) | Q(user__name=search_string[1:]))
        else:
            tweets = tweets.distinct().filter(keywords__keyword=search_string)
    
    tweet_ids = tweets.values_list('id', flat=True)
    keywords = Keyword.get_all_in_tweets(tweet_ids)
    cloud = KeywordCloud(keywords)
    
    return render_to_response("twitter/tweets.html", {
                                                      'search_string': search_string,
                                                      'keywordcloud': cloud,
                                                      'tweet_ids': tweet_ids
                                                      }, context_instance=RequestContext(request))

def tweets(request):
    return render_to_response("twitter/tweets.html", { 'keywordcloud': Keyword.get_keyword_cloud(), 'tweets': Tweet.objects.all() }, context_instance=RequestContext(request)) 


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
        for filter in filters:
            if filter['type']=='keyword':
                search_string = filter['value']
                tweets = Tweet.objects.all()
                
                if(search_string.startswith('@')):
                    tweets = tweets.distinct().filter(Q(keywords__keyword=search_string) | Q(user__name=search_string[1:]))
                else:
                    tweets = tweets.distinct().filter(keywords__keyword=search_string)
                    
                tweet_ids = tweets.values_list('id', flat=True)
                
                
                keywords = Keyword.get_all_in_tweets(tweet_ids)
                cloud = KeywordCloud(keywords)
                
            return {
                    'tweet_ids': [str(tweet_id) for tweet_id in tweet_ids],
                    'cloud':cloud,
            }
    
    
    
