(function($){
	var tweets = window.tweets || (window.tweets = {
		load: function(tweetId, callback) {
			$.jsonRPC.request('load_tweet', {
			  params: [tweetId],
			  success: callback,
			  error: callback,
		  	});
		}
	});
	$.jsonRPC.setup({
	  	endPoint: '/twitter/rpc/'
	});
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





