var crumblePath = $(".crumble-path").CrumblePath();
$(function(){
	var $search = $("form#keyword-search-form");
	var $searchbar = $search.find("input#searchbar");
	
	function getFilter(value){
		var filter = null;
		if(value.substring(0,1)=='@'){
			filter = new api.filters.User(value.substring(1));
		} else if(value.substring(0,1)=='#'){
			filter = new api.filters.Tag(value.substring(1));
		} else if(value.substring(0,1)=='^'){
			filter = new api.filters.Geo(value.substring(1), "NL", value.substring(1));
		} else {
			filter = new api.filters.Keyword(value);
		}
		return filter;
	}
	
	function getSearchFilters(){
		var filters = [];
		var search = $searchbar.val();
		var query = search.split(' ');
		for(var index in query){
			var value = query[index];
			if(value.length>=2){
				var filter = getFilter(value);
				filters.push(filter);
			}
		}
		return filters;
	}
	
	function getFilters(){
		var searchFilters = getSearchFilters();
		var filters = [].concat(crumblePath.path(), searchFilters);
		
		return filters;
	}
	
	function updateRegion(){
		var filters = getFilters();
		for (var index in filters){
			var filter = filters[index];
			if(filter.type=='geo'){
 				$("section#region-name").find("p#current-region").html(filter.label);
 			}
		}
	}
	
	var $search = $("form#keyword-search-form").submit(function(){
		
		$(".main-tag-cloud").hide();
		$searchbar.addClass("loading");
		updateRegion();
		var filters = getFilters();
		$(".search-result-status").hide();
		api.Tweet.search(filters, function(twitterIds, cloud){
			
			$(".tweets").TweetList(twitterIds, function(){
				$(".search-result-status").html("Getoond "+$(".tweets>.tweet").length+" van de "+twitterIds.length+" resultaten").show();
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
		var filter = getFilter(keyword);
		crumblePath.add(filter);
		var filters = crumblePath.path();
		$(".search-result-status").hide();
		updateRegion();
		api.Tweet.search(filters, function(twitterIds, cloud){
			$(".tweets").TweetList(twitterIds, function(){
				$(".search-result-status").html("Getoond "+$(".tweets>.tweet").length+" van de "+twitterIds.length+" resultaten").show();
				$searchbar.removeClass("loading");
			});
			$(".mini-tag-cloud").TagCloud(cloud);
			$("section#tag-cloud").show();
		});	
		$search.submit();
		return false;
	});
	$("input#crumblebutton").click(function(){
		var filters = getSearchFilters();
		for (var index in filters){
			var filter = filters[index];
			crumblePath.add(filter);
		}
		updateRegion();
		$searchbar.val("");
	});
	$(".crumble-path a").live('click', function(){
		
		var index = $(this).data("index");
		var clicked = crumblePath.path()[index];
		crumblePath.removeAfter(clicked);
		console.log(index);
		if(index==0){
			$searchbar.val("");
			$(".tweets").hide().empty();
			$("section#tag-cloud").hide();
			$(".main-tag-cloud").show();
			$(".search-result-status").hide();
		} else {
			$search.submit();
		}
		updateRegion();
		return false;
	});
});

api.cloud(function(cloud){
	$(".main-tag-cloud").TagCloud(cloud);
	$("section#tag-cloud").hide();
});

