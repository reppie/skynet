from skynet_frontend.twitter.models import *
from django.contrib import admin

admin.site.register((Tweet, TweetIndex, SourceType, Place, User, PlaceType, BoundingBox, Country))