(function(){
	var tweets = window.tweets || {
		load: function(tweetId, callback) {
			$.jsonRPC.request('load_tweet', {
			  params: params,
			  success: callback,
			  error: callback,
		  	});
		}
	};
	$.jsonRPC.setup({
	  	endPoint: '/twitter/rpc',
	  	namespace: 'twitter',
	});
})();





