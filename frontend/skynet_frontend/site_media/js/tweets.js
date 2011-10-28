(function($){
	var api = window.api || (window.api = {
		
		
		'Base': function(json){
			var base = this;
			$.each(json,function(key, value){
				base[key] = value;
			});
			
		},
		'Tweet': function(json){
			api.Base.prototype.constructor.call(this, json);
			
		},
		'User': function(json){
			api.Base.prototype.constructor.call(this, json);
			
		},
		cache:{
			'collections':{},
			'get': function(type, id){
				var item = null;				
				var col = api.cache.collections[type];				
				if(col){
					item = col[""+id];
				}
				return item;
			},
			'set': function(id, item){
				var type = typeof item;
				var col = api.cache.collections[item.constructor];				
				if(!col){
					col = api.cache.collections[item.constructor] = {};					
				}
				col[""+id] = item;
			}
		},
		
	});
	$.jsonRPC.setup({
	  	endPoint: '/twitter/rpc/'
	});
	
	api.Tweet.prototype = api.Base;
	api.User.prototype = api.Base;
	/*
	 * Send along CSRF security token otherwise requests will fail
	 */
	$.ajaxSetup({ 
     beforeSend: function(xhr, settings) {
         function getCookie(name) {
             var cookieValue = null;
             if (document.cookie && document.cookie != '') {
                 var cookies = document.cookie.split(';');
                 for (var i = 0; i < cookies.length; i++) {
                     var cookie = jQuery.trim(cookies[i]);
                     // Does this cookie string begin with the name we want?
                 if (cookie.substring(0, name.length + 1) == (name + '=')) {
                     cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                     break;
                 }
             }
         }
         return cookieValue;
         }
         if (!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
             // Only send the token to relative URLs i.e. locally.
             xhr.setRequestHeader("X-CSRFToken", getCookie('csrftoken'));
         }
        }
 	});
	api.Tweet.prototype.getUser = function(callback){
		api.User.get(this.user_id, callback);
		
	}
	
	api.Tweet.get = function(tweetId, callback) {
		var tweet = api.cache.get(api.Tweet, tweetId);
		if(tweet){
			console.log("serving Tweet with id: "+tweetId+" from cache.;")
			callback(tweet);
			return;
		}
		
		$.jsonRPC.request('load_tweet', {
		  params: [tweetId],
		  success: function(result){
		  	console.log("success");
		  	console.log(result);
		  	var tweet = new api.Tweet(result.result);
		  	api.cache.set(tweetId, tweet);
		  	callback(tweet);
		  },
		  error: function(result){
		  	console.log(result);
	  		callback(null);
		  },
	  	});
	}
	api.User.get = function(userId, callback) {
		var user = api.cache.get(typeof api.User, userId);
		if(user){
			console.log("serving User with id: "+userId+" from cache.;")
			callback(user);
			return;
		}
		$.jsonRPC.request('load_user', {
		  params: [userId],
		  success: function(result){
		  	var user = new api.User(result.result);
		  	api.cache.set(userId, user);
		  	callback(user);
		  },
		  error: function(result){
		  	console.log(result);
	  		callback(null);
		  },
	  	});
	}
	console.log("loaded");
})(jQuery);





