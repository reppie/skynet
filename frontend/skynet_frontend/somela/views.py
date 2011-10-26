from django.shortcuts import render_to_response
from skynet_frontend.twitter.models import TweetIndex, Tweet

def index(request):
    return render_to_response("somela/index.html", { 
        'keywords': TweetIndex().getCloudMap() ,
        'tweets': Tweet.objects.all()
    })