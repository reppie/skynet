$("form#keyword-search-form").submit(function(){
	var value = $(this).find("input#searchbar").val();
	console.log(value);
		
	var filters = [{'type':'keyword','value':value}];
	
	api.Tweet.search(filters, function(twitterIds){
		console.log(twitterIds);
		$(".tweets").TweetList(twitterIds);
		
	});
	return false;
})
