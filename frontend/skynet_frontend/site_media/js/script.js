var crumblePath = $(".crumble-path").CrumblePath();
$(function(){
	
	var $search = $("form#keyword-search-form").submit(function(){
		
		var filters = [].concat(crumblePath.path());
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
		
		var keyword = $(this).data("keyword");
		var filter = new api.filters.Keyword(keyword);
		crumblePath.add(filter);
		var filters = crumblePath.path();
		
		
		api.Tweet.search(filters, function(twitterIds, cloud){
			$(".tweets").TweetList(twitterIds);
			$(".mini-tag-cloud").TagCloud(cloud);
		});	
		return false;
	});
	$(".crumble-path a").live('click', function(){
		
		var index = $(this).data("index");
		var clicked = crumblePath.path()[index];
		crumblePath.removeAfter(clicked);
		
		$search.submit();
		return false;
	});
});

if(!crumblePath.path().length){
	//$(".tweets").hide();
	api.cloud(function(cloud){
		console.log(cloud);
		$(".main-tag-cloud").TagCloud(cloud);
		
	});
}

