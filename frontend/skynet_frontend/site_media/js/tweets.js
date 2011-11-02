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
		'CrumblePath': function(element){
			this.$path = element;
			this.chain = [];
			this.build();
		},
		'TweetList': function(element, tweets){
			this.$tweetList = element;
			this.reset(tweets);
		},
		'cache':{
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
		'cloud': function(callback){
			var This = this;
			$.jsonRPC.request('cloud', {
			  	params: [],
			  	success: function(result){
			  		callback.call(This, result.result);
			  },
			  error: function(result){
		  		callback.call(This, null);
			  },
		  	});
			
			
		}
		
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
    var crumblePathKey = "__TweetList";
	$.fn.CrumblePath = function() {
		var path = this.data(crumblePathKey);
		if(!path){
			path = new api.CrumblePath(this);
			this.data(crumblePathKey, path);
		}
		return path;
    };
    
    $.fn.TagCloud = function(cloud) {
    	this.empty();
    	for(var index in cloud){
			var tag = cloud[index];
	    	var $tag = $("#tagTemplate").tmpl(tag);
	    	$tag.appendTo(this).data('tag', tag);
    	}
		return this;
    };
	
	api.TweetList.prototype.reset = function(tweetIds){
		
		var tweetList = this;
		this.$tweetList.empty();
		this.tweetIds = tweetIds || [];
		
		for(var index in tweetIds){
			var tweetId = tweetIds[index];
			//var $tweet = $('<div/>').addClass('tweet loading').attr('data-tweet-id', tweetId).html(""+tweetId);
			//this.$tweetList.append($tweet);
			api.Tweet.get(tweetId, function(tweet){
				
				//var $tweet = this;
				if(tweet){
					console.log(tweet);
					tweet.getUser(function(user){
						console.log(user);
						if(user){
							console.log("yey");
							var $tweet = $("#tweetTemplate").tmpl(tweet);
							$tweet.appendTo(tweetList.$tweetList).data('tweet', tweet);
							
							$tweet.find('time').localize(function () {
							  var s = 1, m = 60 * s, h = 60 * m, d = 24 * h,
							    units = [s, m, h, d, 7 * d, 30 * d, 365 * d],
							    names = 'seconde minuut uur dag week maand jaar'.split(' '),
							    namesPlural = 'seconden minuten uren dagen weken maanden jaren'.split(' '),
							    round = Math.round;
							
							  return function (date) {
							    var
							      delta = round((date - new Date) / 1000) || -1,
							      suffix = delta < 0 ? (delta = Math.abs(delta), 'geleden') : 'van nu',
							      i = units.length, n, seconds;
							
							    while (i--) {
							      seconds = units[i];
							      if (!i || delta > seconds) {
							        n = round(delta / seconds);
							        return [n, n === 1 ? names[i] : namesPlural[i], suffix].join(' ');
							      }
							    }
							  };
							}());
							$tweet.slideDown(250, function(){
								$tweet.removeClass("loading");
							});
						}
					});
						
				} else {
					/*
					var tweetId = $tweet.data("tweetId");
					$tweet.html("error retrieving tweet id: "+tweetId);
					$tweet.addClass("error");
					$tweet.slideDown(250, function(){
						$tweet.removeClass("loading");
					});
					*/
				}
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
 	api.CrumblePath.prototype.path = function(){
 		
 		return this.chain;
 	}
 	api.CrumblePath.prototype.build = function(){
 		
 		//return this.chain;
 	}
 	
	api.Tweet.prototype.getUser = function(callback){
		
		var This = this;
		if(this.user){
			callback.call(This, this.user);
			return;
		}
		var tweet = this;
		api.User.get(this.user_id, function(user){
			tweet.user = user;
			callback.call(This, user);
		});
	}
	
	api.Tweet.get = function(tweetId, callback) {
		var This = this;
		var tweet = api.cache.get('api.Tweet', tweetId);
		if(tweet){
			console.log("serving Tweet with id: "+tweetId+" from cache");
			callback.call(This,tweet);
			return;
		}
		$.jsonRPC.request('load_tweet', {
		  	params: [tweetId],
		  	success: function(result){
		  		var tweet = new api.Tweet(result.result);
		  		api.cache.set('api.Tweet', tweet);
		  		callback.call(This, tweet);
		  },
		  error: function(result){
	  		callback.call(This, null);
		  },
	  	});
	}
	api.User.get = function(userId, callback) {
		var This = this;
		var user = api.cache.get('api.User', userId);
		if(user){
			console.log("serving User with id: "+userId+" from cache");
			callback.call(This, user);
			return;
		}
		$.jsonRPC.request('load_user', {
		  	params: [userId],
		  	success: function(result){
		  		var user = new api.User(result.result);
		  		api.cache.set('api.User', user);
		  		callback.call(This, user);
		  },
		  error: function(result){
	  		callback.call(This, null);
		  },
	  	});
	}
	api.Tweet.search = function(filters, callback) {
		var This = this;
		$.jsonRPC.request('search_tweets', {
		  	params: [filters],
		  	success: function(result){
		  		var tweetIds = result.result.tweet_ids;
		  		var cloud = result.result.cloud;
		  		callback.call(This, tweetIds,cloud);
		  },
		  error: function(result){
	  		callback.call(This, null);
		  },
	  	});
	}
	
})(jQuery);





