var crumblePath = $(".crumble-path").CrumblePath();
$(function(){
	
	function getFilters(){
		
		
		var $searchbar = $("form#keyword-search-form").find("input#searchbar");
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
		return filters;
	}
	
	
	var $search = $("form#keyword-search-form").submit(function(){
		
		
		var $searchbar = $(this).find("input#searchbar");
		/*
		$(".main-tag-cloud").hide();
		
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
		for (var index in filters){
			var filter = filters[index];
			if(filter.type=='geo'){
 				$("section#region-name").find("p#current-region").html(filter.label);
 			}
		}*/
		
		var filters = getFilters();
		for (var index in filters){
			var filter = filters[index];
			if(filter.type=='geo'){
 				$("section#region-name").find("p#current-region").html(filter.label);
 			}
		}
		
		api.Tweet.search(filters, function(twitterIds, cloud){
			$(".tweets").TweetList(twitterIds, function(){
				$searchbar.removeClass("loading");
			});
			
			$(".mini-tag-cloud").TagCloud(cloud);
			$("section#tag-cloud").show();
			
		});	
		return false;
	})
	$("div.tag-cloud a").live('click', function(){
		$(".main-tag-cloud").hide();
		
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
			$("section#tag-cloud").show();
		});	
		$search.submit();
		return false;
	});
	$(".crumble-path a").live('click', function(){
		
		var index = $(this).data("index");
		
		
		var clicked = crumblePath.path()[index];
		crumblePath.removeAfter(clicked);
		
		if(index==0){
			$(".tweets").hide().empty();
			$("section#tag-cloud").hide();
			$(".main-tag-cloud").show();
		}else{
			$search.submit();
		}
		
		var filters = getFilters();
		for (var index in filters){
			var filter = filters[index];
			if(filter.type=='geo'){
 				$("section#region-name").find("p#current-region").html(filter.label);
 			}
		}
		
		
		
		return false;
	});
});


api.cloud(function(cloud){
	$(".main-tag-cloud").TagCloud(cloud);
	$("section#tag-cloud").hide();
});


