from django.shortcuts import render_to_response
from skynet_frontend.twitter.models import Tweet, Keyword, User
from jsonrpc import JSONRPCService, jsonremote
from django.core.urlresolvers import reverse
from django.http import HttpResponse

def index(request):
    return render_to_response("twitter/index.html", { 'keywordcloud': Keyword.get_keyword_cloud(), 'tweets': Tweet.objects.all() }) 

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
       
        return {
            'id': tweet.id,
            'text': tweet.text,
            'user_id': tweet.user_id,
        }
    @staticmethod
    @jsonremote(service)
    def load_user(user_id):
        user = User.objects.get(pk=user_id)
       
        return {
            'id': user.id,
            'name': user.name,
            'screen_name': user.screen_name,
        }