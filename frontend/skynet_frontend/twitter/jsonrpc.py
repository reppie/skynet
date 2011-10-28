# jsonrpc.py
#   original code: http://trac.pyworks.org/pyjamas/wiki/DjangoWithPyJamas
#   also from: http://www.pimentech.fr/technologies/outils
from django.utils import simplejson
import sys

# JSONRPCService and jsonremote are used in combination to drastically
# simplify the provision of JSONRPC services.  use as follows:
#
# from jsonrpc import JSONRPCService, jsonremote
#
# jsonservice = JSONRPCService()
#
# @jsonremote(jsonservice)
# def test(request, echo_param):
#     return "echoing the param back: %s", echo_param
#
# then dump jsonservice into urlpatterns:
#  (r'^service1/$', 'djangoapp.views.jsonservice'),

version = '2.0'

def response(id, result):
    return simplejson.dumps({'jsonrpc': version, 'id':id,
                             'result':result, 'error':None})
def error(id, code, message):
    return simplejson.dumps({'id': id, 'jsonrpc': version,
                             'error': {'name': 'JSONRPCError',
                                       'code': code,
                                       'message': message
                                       }
                                 })

class JSONRPCService:
    def __init__(self, method_map={}):
        self.method_map = method_map

    def add_method(self, name, method):
        self.method_map = self.method_map or {}
        self.method_map[name] = method

    def __call__(self, request, extra=None):
        # We do not yet support GET requests, something pyjamas does
        # not use anyways.
        data = simplejson.loads(request.raw_post_data)
        # Altered to forward the request parameter when a member method
        # is invoked <julien@pimentech.net>
        id, method, params = data["id"],data["method"], data["params"] or request.REQUEST.values()
        if method in self.method_map:
            try:
                result = self.method_map[method](*params)
                return response(id, result)
            except BaseException:
                etype, eval, etb = sys.exc_info()
                return error(id, 100, '%s: %s %s' %(etype.__name__, eval, params))
            except:
                etype, eval, etb = sys.exc_info()
                return error(id, 100, 'Exception %s: %s' %(etype, eval))
        else:
            return error(id, 100, 'method "%s" does not exist' % (method))


def jsonremote(service):
    def remotify(func):
        if isinstance(service, JSONRPCService):
            service.add_method(func.__name__, func)
        else:
            emsg = 'Service "%s" not found' % service.__name__
            raise NotImplementedError, emsg
        return func
    return remotify