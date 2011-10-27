from django.shortcuts import render_to_response
from skynet_frontend.twitter.models import TweetIndex, Tweet
from jsonrpc import JSONRPCService, jsonremote
from django.core.urlresolvers import reverse

def index(request):
    return render_to_response("somela/index.html", { 'keywords': TweetIndex().getCloudMap(), 'tweets': Tweet.objects.all() })

def rpc(request):

    rpc     = JSONRPCService( TwitterRpcMethods() )
    result  = rpc(request)

    return result

class TwitterRpcMethods(object):

    url = reverse("twitter-rpc")

    @jsonremote
    def add(self, x, y):
        return x+y

    @jsonremote
    def sub(self, x, y):
        return x-y

    @jsonremote
    def load_tweet(self, tweet_id):
        return Tweet.objects.get(pk=tweet_id)
    
    def test(self):
        pass
     
    @jsonremote
    def sayHello(self, *args):
        return "hello "

