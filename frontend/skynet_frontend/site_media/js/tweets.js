(function($){
	var api = window.api || (window.api = {
		
		'Tweet': function(json){
			if(!(this instanceof 'Tweet')) {
				throw "please use new Tweet(args);";
			}
		},
		'User': function(){
			
			
		},
		cache:{
			'tweets':{},
			'users':{}
		},
		'tweet':{
			'get': function(tweetId, callback) {
				$.jsonRPC.request('load_tweet', {
				  params: [tweetId],
				  success: function(result){
				  	console.log(result);
				  	callback(new api.Tweet(result.result));
				  },
				  error: function(result){
				  	console.log(result);
			  		callback(null);
				  },
			  	});
			}
		},
		
	});
	$.jsonRPC.setup({
	  	endPoint: '/twitter/rpc/'
	});
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
	console.log("loaded");
})(jQuery);





