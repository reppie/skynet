var crumblePath = $(".crumble-path").CrumblePath();
$(function(){
	
	var $search = $("form#keyword-search-form").submit(function(){
		
		var $searchbar = $(this).find("input#searchbar");
		$searchbar.addClass("loading");
		var filters = [].concat(crumblePath.path());
		var search = $searchbar.val();
		var query = search.split(' ');
		for(var index in query){
			var value = query[index];
			if(value.length>=2){
				var filter = null;
				if(value.substring(0,1)=='@'){
					filter = new api.filters.User(value.substring(1));
				} if(value.substring(0,1)=='^'){
					filter = new api.filters.Geo(value.substring(1), "NL", value.substring(1));
				} else {
					filter = new api.filters.Keyword(value);
				}
				filters.push(filter);
			}
		}
		
		api.Tweet.search(filters, function(twitterIds, cloud){
		
			console.log(cloud);
			$(".tweets").TweetList(twitterIds, function(){
				$searchbar.removeClass("loading");
			});
			
			$(".mini-tag-cloud").TagCloud(cloud);
			
		});	
		return false;
	})
	$("div.tag-cloud a").live('click', function(){
		
		var $searchbar = $(this).find("input#searchbar");
		$searchbar.addClass("loading");
		
		var keyword = $(this).data("keyword");
		var filter = new api.filters.Keyword(keyword);
		crumblePath.add(filter);
		var filters = crumblePath.path();
		
		api.Tweet.search(filters, function(twitterIds, cloud){
			$(".tweets").TweetList(twitterIds, function(){
				$searchbar.removeClass("loading");
			});
			$(".mini-tag-cloud").TagCloud(cloud);
		});	
		$search.submit();
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


api.cloud(function(cloud){
	$(".main-tag-cloud").TagCloud(cloud);
	
});


