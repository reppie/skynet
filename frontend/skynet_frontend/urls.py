import os
from django.conf.urls.defaults import patterns, include, url
from django.contrib import admin
from django.conf import settings

admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
#     url(r'^$', 'skynet_frontend.views.home', name='home'),
#     url(r'^skynet_frontend/', include('skynet_frontend.foo.urls')),

    (r'^somela/$', 'somela.views.index'),
    url(r'^admin/', include(admin.site.urls)),
)

absoluteStaticPath = os.path.join(settings.PROJECT_PATH, 'static')
urlpatterns += patterns('',
    (r'^static/(?P<path>.*)$', 'django.views.static.serve',
        {'document_root': absoluteStaticPath, 'show_indexes': True}),
)