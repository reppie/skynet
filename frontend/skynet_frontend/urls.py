import os
from django.conf.urls.defaults import patterns, include, url
from django.contrib import admin
from django.conf import settings

admin.autodiscover()

urlpatterns = patterns('',
    (r'^$', 'twitter.views.index'),
    url(r'^twitter/rpc/', 'twitter.views.rpc', name='twitter-rpc'),
    url(r'^admin/', include(admin.site.urls)),
)

absoluteStaticPath = os.path.join(settings.PROJECT_PATH, 'site_media')
urlpatterns += patterns('',
    (r'^site_media/(?P<path>.*)$', 'django.views.static.serve',
        {'document_root': absoluteStaticPath, 'show_indexes': True}),
)