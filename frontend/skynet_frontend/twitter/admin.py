from skynet_frontend.twitter.models import Tweet, User, Keyword, TweetKeyword
from django.contrib import admin

admin.site.register((Tweet, User, Keyword, TweetKeyword))