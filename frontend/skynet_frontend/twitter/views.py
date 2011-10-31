from django.shortcuts import render_to_response
from skynet_frontend.twitter.models import Tweet, Keyword, TweetKeyword, User
from jsonrpc import JSONRPCService, jsonremote
from django.core.urlresolvers import reverse
from django.http import HttpResponse

from django.template import RequestContext

def index(request):
    return render_to_response("twitter/index.html", { 'keywordcloud': Keyword.get_keyword_cloud(), 'tweets': Tweet.objects.all() }, context_instance=RequestContext(request)) 

def search(request):
    search_string = request.GET.get('q', '')
    if(search_string):
        tweets = TweetKeyword.objects.filter(keyword__keyword=search_string)
    else:
        tweets = TweetKeyword.objects.all()
    
    cloud = Keyword.get_keyword_cloud() #TODO: Cloud should be based on search
    return render_to_response("twitter/tweets.html", { 'keywordcloud': cloud, 'tweets': tweets }) 

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
            pass
        
        return Tweet.objects.values('id').all()
    
    
    
