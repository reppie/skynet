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
		'TweetList': function(element, tweets){
			this.$tweetList = element;
			this.reset(tweets);
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
			'set': function(type, item){
				var col = api.cache.collections[type];				
				if(!col){
					col = api.cache.collections[type] = {};					
				}
				col[""+item.id] = item;
			}
		},
		
	});
	var tweetListKey = "__TweetList";
	$.fn.TweetList = function(tweetIds) {
		var tweetList = this.data(tweetListKey);
		if(!tweetList){
			tweetList = new api.TweetList(this, tweetIds);
			this.data(tweetListKey, tweetList);
		}else if (tweetIds){
			tweetList.reset(tweetIds);
		}
		return tweetList;
    };
	
	api.TweetList.prototype.reset = function(tweetIds){
		var tweetList = this;
		this.$tweetList.empty();
		this.tweetIds = tweetIds || [];
		
		for(var index in tweetIds){
			var tweetId = tweetIds[index];
			var $tweet = $('<div/>').addClass('tweet loading').attr('data-tweet-id', tweetId).html(""+tweetId);
			this.$tweetList.append($tweet);
			api.Tweet.get(tweetId, function(tweet){
				if(tweet){
					var $tweet = tweetList.$tweetList.find('[data-tweet-id="'+tweet.id+'"]');
					$tweet.data('tweet', tweet);
					$tweet.html(tweet.text);
					$tweet.slideDown(250, function(){
						$tweet.removeClass("loading");
					});
				}
				/*else{
					console.log(tweetId);
					$tweet.html("error retrieving tweet id: "+tweetId);
					$tweet.removeClass("loading");
					$tweet.addClass("error");
				}*/
			});
		}
	}
	
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
		if(this.user){
			callback(this.user);
			return;
		}
		var tweet = this;
		api.User.get(this.user_id, function(user){
			tweet.user = user;
			callback(user);
		});
	}
	
	api.Tweet.get = function(tweetId, callback) {
		var tweet = api.cache.get('api.Tweet', tweetId);
		if(tweet){
			console.log("serving Tweet with id: "+tweetId+" from cache.;")
			callback(tweet);
			return;
		}
		$.jsonRPC.request('load_tweet', {
		  	params: [tweetId],
		  	success: function(result){
		  		var tweet = new api.Tweet(result.result);
		  		api.cache.set('api.Tweet', tweet);
		  		callback(tweet);
		  },
		  error: function(result){
	  		callback(null);
		  },
	  	});
	}
	api.User.get = function(userId, callback) {
		var user = api.cache.get('api.User', userId);
		if(user){
			console.log("serving User with id: "+userId+" from cache.;")
			callback(user);
			return;
		}
		$.jsonRPC.request('load_user', {
		  	params: [userId],
		  	success: function(result){
		  		var user = new api.User(result.result);
		  		api.cache.set('api.User', user);
		  		callback(user);
		  },
		  error: function(result){
		  	console.log(result);
	  		callback(null);
		  },
	  	});
	}
	api.Tweet.search = function(filters, callback) {
		
		$.jsonRPC.request('search_tweet', {
		  	params: [filters],
		  	success: function(result){
		  		var tweetIds = result.result;
		  		callback(tweetIds);
		  },
		  error: function(result){
	  		callback(null);
		  },
	  	});
	}
	
})(jQuery);





