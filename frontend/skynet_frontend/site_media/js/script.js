$(function(){
	$("form#keyword-search-form").submit(function(){
		
		var filters =[];
		var search = $(this).find("input#searchbar").val();
		
		var query = search.split(' ');
		for(var index in query){
			var value = query[index];
			if(value.length>=2){
				var filter = null;
				if(value.substring(0,1)=='@'){
					filter = new api.filters.User(value.substring(1));
				} else {
					filter = new api.filters.Keyword(value);
				}
				filters.push(filter);
			}
		}
			
		api.Tweet.search(filters, function(twitterIds, cloud){
		
			$(".tweets").TweetList(twitterIds);
			$(".tag-cloud").TagCloud(cloud);
			
		});	
		return false;
	})
	$("div.tag-cloud a").live('click', function(){
		
		var crumblePath = $(".crumble-path").CrumblePath();

		var keyword = $(this).data("keyword");
		
		var keywordFilter = new api.filters.Keyword(keyword);
		
		var filters = crumblePath.path();
		
		filters.push([keywordFilter]);
		
		api.Tweet.search(filters, function(twitterIds, cloud){
		
			$(".tweets").TweetList(twitterIds);
			$(".mini-tag-cloud").TagCloud(cloud);
		});	
		return false;
		
	});
});

var crumblePath = $(".crumble-path").CrumblePath();
if(!crumblePath.path().length){
	//$(".tweets").hide();
	api.cloud(function(cloud){
		console.log(cloud);
		$(".main-tag-cloud").TagCloud(cloud);
		
	});
}

