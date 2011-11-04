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
			
			var nl = new api.filters.Geo("Nederland", "NL", null);
			nl.removable = false;
			this.add(nl);
			
		},
		'TweetList': function(element, tweets, callback){
			this.$tweetList = element;
			this.reset(tweets, callback);
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
			  }
		  	});
				
		},
		'filters': {
			'Base': function(type, label, value){
				var base = this;
				this.type = type;
				this.label = label;
				this.removable = true;
				this.value = value;
				this.equals = function(filter){
					return this.type == filter.type && this.value == filter.value;
				}
				
			},
			'Keyword': function(keyword){
				api.filters.Base.prototype.constructor.call(this, 'keyword', keyword, keyword);
				
			},
			'User': function(user){
				api.filters.Base.prototype.constructor.call(this, 'user', "@" + user, user);
				
			},
			'Geo': function(label, country, place){
				api.filters.Base.prototype.constructor.call(this, 'geo', label, place);
				this.equals = function(filter){
					return this.type == filter.type && this.value == filter.value && this.country == filter.country;
				}
				this.country = country;
			}
		}
	});
	
	Array.prototype.shuffle = function() {
		var s = [];
		while (this.length) s.push(this.splice(Math.random() * this.length, 1)[0]);
		while (s.length) this.push(s.pop());
		return this;
	}
	
	var tweetListKey = "__TweetList";
	$.fn.TweetList = function(tweetIds, callback) {
		var tweetList = this.data(tweetListKey);
		this.show();
		if(!tweetList){
			tweetList = new api.TweetList(this, tweetIds, callback);
			this.data(tweetListKey, tweetList);
		}else if (tweetIds){
			tweetList.reset(tweetIds, callback);
		}
		return tweetList;
    };
    var crumblePathKey = "__CrumbleList";
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
    	cloud = cloud.shuffle();
    	for(var index in cloud){
			var tag = cloud[index];
	    	var $tag = $("#tagTemplate").tmpl(tag);
	    	$tag.appendTo(this).data('tag', tag);
    	}
		return this;
    };
	
	api.TweetList.prototype.reset = function(tweetIds, callback){
		
		var tweetList = this;
		this.$tweetList.empty();
		this.tweetIds = tweetIds || [];
		this.loaded = 0;
		this.callback = callback;
		if(tweetIds.length==0){
			if(callback){
				callback.call(this);
			}
		}
		
		for(var index in tweetIds){
			var tweetId = tweetIds[index];
			api.Tweet.get(tweetId, function(tweet){
				if(tweet){
					tweet.getUser(function(user){
						if(user){
							if(tweetList.tweetIds.indexOf(this.id)>-1){
								tweetList.loaded++;
								var $tweet = $("#tweetTemplate").tmpl(tweet);
								if(!$('.tweets .tweet[data-tweet-id="'+this.id+'"]').length){
									$tweet.appendTo(tweetList.$tweetList).data('tweet', tweet);
								}
								
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
								if(tweetList.loaded>=tweetList.tweetIds.length){
									if(tweetList.callback){
										tweetList.callback.call(tweetList);
									}
								}
							}
						}
					});
						
				}
			});
			
		}
		
	}
	
	$.jsonRPC.setup({
	  	endPoint: '/twitter/rpc/'
	});
	
	api.Tweet.prototype = api.Base;
	api.User.prototype = api.Base;
	
	
	api.filters.Keyword.prototype = api.filters.Base;
	api.filters.User.prototype = api.filters.Base;
	api.filters.Geo.prototype = api.filters.Base;
	
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
 	api.CrumblePath.prototype.add = function(filter){
 		for(var index in this.chain){
 			var f = this.chain[index];
 			if(filter.equals(f)){
 				return;
 			}
 		}
 		this.chain.push(filter);
 		this.build();
 	}
 	api.CrumblePath.prototype.removeAfter = function(filter){
 		var after = false;
 		var newChain = [];
 		for(var index in this.chain){
 			var f = this.chain[index];
 			if(!after){
 				newChain.push(f);
 			}
 			if(filter.equals(f)){
 				after = true;
 			}
 		}
 		this.chain = newChain;
 		this.build();
 		
 	}
 	api.CrumblePath.prototype.remove = function(filter){
 		var newChain = [];
 		for(var index in this.chain){
 			var f = this.chain[index];
 			if(!filter.equals(f)||!f.removable){
 				newChain.push(f);
 			}
 		}
 		this.chain = newChain;
 		this.build();
 	}
 	
 	api.CrumblePath.prototype.build = function(){
 		this.$path.empty();
 		var $crumblePath = $("#crumblePathTemplate").tmpl(this);
 		$crumblePath.appendTo(this.$path);
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
			//console.log("serving Tweet with id: "+tweetId+" from cache");
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
			//console.log("serving User with id: "+userId+" from cache");
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





