$(function(){
	$("form#keyword-search-form").submit(function(){
		var value = $(this).find("input#searchbar").val();
		console.log(value);
			
		var filters = [{'type':'keyword','value':value}];
		
		api.Tweet.search(filters, function(twitterIds, cloud){
		
			$(".tweets").TweetList(twitterIds);
			$(".tag-cloud").TagCloud(cloud);
			
		});	
		return false;
	})
	$("div.tag-cloud a").live('click', function(){

		var keyword = $(this).data("keyword");
		
		var filters = [{'type':'keyword','value':""+keyword}];
		api.Tweet.search(filters, function(twitterIds, cloud){
		
			$(".tweets").TweetList(twitterIds);
			$(".tag-cloud").TagCloud(cloud);
		});	
		return false;
		
	});
});