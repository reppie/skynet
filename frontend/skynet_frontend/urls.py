from django.conf.urls.defaults import patterns, include, url
from django.contrib import admin

admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
#     url(r'^$', 'skynet_frontend.views.home', name='home'),
#     url(r'^skynet_frontend/', include('skynet_frontend.foo.urls')),

    (r'^somela/$', 'somela.views.index'),
    url(r'^admin/', include(admin.site.urls)),
)
