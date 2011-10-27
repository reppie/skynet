from django.shortcuts import render_to_response
from skynet_frontend.twitter.models import TweetIndex, Tweet

def index(request):
    return render_to_response("twitter/index.html", { 'keywordcloud': TweetIndex().get_keyword_cloud(), 'tweets': Tweet.objects.all() })