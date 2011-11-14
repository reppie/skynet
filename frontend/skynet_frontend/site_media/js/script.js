var getFilter = window.getFilter = function (value){
		var filter = null;
		value = value + "";
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

var crumblePath = $(".crumble-path").CrumblePath();
$(function(){
	
	
	var pageSize = 15;
	var $search = $("form#keyword-search-form");
	var $searchbar = $search.find("input#searchbar");
	
	var intervalHandler = null;
	var second = 1000;
	var minute = second * 60;
	var hour = minute * 60;
	var liveQueryInterval = 20 * second;
	var sliderTimeSpan = hour * 24 * 30; // 30 dagen in miliseconden
	var nowRange = hour * 2; // 8 hour sweet spot (door beperking in slider implementatie)
	var timezoneOffset = new Date().getTimezoneOffset() * minute;
	
	
	window.setInterval(function(){
		$(".tweets .tweet time").localize(localizedSpan());
	},10*second);
	
	function liveQuery(){
		var last = null;
		$(".tweets .tweet").each(function(){
			var timestamp = $(this).data("timestamp");
			if(last) {
				if(last < timestamp){
					last = timestamp;
				}
			} else {
				last = timestamp;
			}
		});
		
		api.Tweet.checkForUpdate(filters, last, function(twitterIds){
			if(twitterIds&&twitterIds.length){						
				$(".next-tweets").data("twitterIds", twitterIds);
				updateNextTweets(twitterIds.length);
				showNextTweets();
			}else{						
				hideNextTweets();
			}
		});
	}
	
	function getSearchFilters(){
		var filters = [];
		var search = $searchbar.val();
		var query = search.split(' ');
		for(var index in query){
			var value = query[index];
			if(value.length >= 2){
				var filter = getFilter(value);
				filters.push(filter);
			}
		}
		return filters;
	}
	
	function getTimeFilter(){
		var filter = null;
		if($(".time-sliders").is(":visible")){
			var now = new Date();
			var nowTime = now.getTime();
			var from = (new Date(nowTime-sliderTimeSpan+$( ".time-sliders" ).slider( "values", 0 )).getTime() + timezoneOffset)/1000;
			var to = (new Date(nowTime-sliderTimeSpan+$( ".time-sliders" ).slider( "values", 1 )).getTime() + timezoneOffset)/1000;
			var toIsNow = $( ".time-sliders" ).slider( "values", 1 ) > sliderTimeSpan - nowRange;			
			filter = new api.filters.Time(from, toIsNow ? null : to);
		}
		return filter;
	}
	
	function getFilters(){
		var searchFilters = getSearchFilters();
		var filters = [].concat(crumblePath.path(), searchFilters);
		var timeFilter = getTimeFilter();
		if(timeFilter){
			filters.push(timeFilter);
		}
		return filters;
	}
	
	function updateResults(total){
		var results = null;
		if(total > 0){
			results = "Getoond "+$(".tweets>.tweet").length+" van de "+total+" resultaten"
		}else{
			results = "Geen resultaten gevonden";
		}
		$(".search-result-status").html(results + " - <a id='permalink' href='"+getCurrentPermaLink()+"'>directe link</a>").show();
		
	}
	function showNextTweets(){
		$(".next-tweets").show();
		
	}
	function hideNextTweets(){
		$(".next-tweets").hide();
		
	}
	function updateNextTweets(count){
		var result = null;
		if(count>1){
			result = count+" nieuwe tweets gevonden, volgende " + (pageSize < count ? pageSize : count) + " tweets tonen";			
		}else{
			result = "1 nieuwe tweet gevonden, deze tweet tonen";
		}
		$(".next-tweets").html(result);
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
		
		if(intervalHandler){
			window.clearInterval(intervalHandler);
			intervalHandler = null;
		}
		hideNextTweets();
		
		$(".main-tag-cloud").hide();
		$searchbar.addClass("loading");
		updateRegion();
		var filters = getFilters();
		$(".search-result-status").hide();
		$(".tweet-results").show();
		
		api.Tweet.search(filters, function(twitterIds, cloud){
			
			if(twitterIds){
				var tweetList = $(".tweets").TweetList(twitterIds, function(){
					updateResults(twitterIds.length);
					$searchbar.removeClass("loading");
				});
				$(".mini-tag-cloud").TagCloud(cloud);
				$("section#tag-cloud").show();
				$(".more-tweets").toggle(twitterIds.length > tweetList.pageSize);
			}else{				
				updateResults(0);
			}
			intervalHandler = window.setInterval(liveQuery, liveQueryInterval);
			
		});
		return false;
	});
	
	$("div.tag-cloud a").live('click', function(){
		$(".main-tag-cloud").hide();
		var keyword = $(this).data("keyword");
		var filter = getFilter(keyword);
		crumblePath.add(filter);		
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
		if(index==0){
			$searchbar.val("");
			$(".tweet-results").hide();
			$(".tweets").empty();
			$("section#tag-cloud").hide();
			$(".main-tag-cloud").show();
			$(".search-result-status").hide();
		} else {
			$search.submit();
		}
		updateRegion();
		return false;
	});
	
	api.cloud([], function(cloud){
		$(".main-tag-cloud").TagCloud(cloud);
		$("section#tag-cloud").hide();
	});
	
	$(".more-tweets").click(function(){
		var $div = $(this);
		if($div.is('.loading')){
			return;
		}
		$div.addClass('loading');
		$(".tweets").TweetList().more(function(){
			$div.removeClass('loading');
			updateResults(this.tweetIds.length);
			if(this.tweetIds.length==$(".tweets>.tweet").length){
				$(".more-tweets").hide();
			}
		});
	});
	$(".next-tweets").click(function(){
		var $div = $(this);
		if($div.is('.loading')){
			return;
		}
		var twitterIds = $(".next-tweets").data("twitterIds");
		var nextItems = twitterIds.slice();
		nextItems.reverse();
		nextItems = nextItems.slice(0, pageSize);
		nextItems.reverse();
		
		$div.addClass('loading');
		$(".tweets").TweetList().next(nextItems, function(){
			$div.removeClass('loading');
			hideNextTweets();
			liveQuery();
			updateResults(this.tweetIds.length);
			if(this.tweetIds.length==$(".tweets>.tweet").length){
				$(".next-tweets").hide();
			}
		});
	});

	function updateTimeValues(){
		var now = new Date();
		var nowTime = now.getTime();
		var from = new Date(nowTime-sliderTimeSpan+$( ".time-sliders" ).slider( "values", 0 ));
		var fromText = jQuery.localize(from, localizedSpan());
		var to = new Date(nowTime-sliderTimeSpan+$( ".time-sliders" ).slider( "values", 1 ));
		var toIsNow = $( ".time-sliders" ).slider( "values", 1 ) > sliderTimeSpan-nowRange;
		var toText =  toIsNow ? "heden" : jQuery.localize(to, localizedSpan());
		var format = "d-m-yyyy H:MM";
		var fromTitle = jQuery.localize(from, format);
		var toTitle = jQuery.localize(toIsNow ? now : to, format);
		$( ".time-value" ).html('Toon tweets van: <span title="' + fromTitle + '">' + fromText + '</span> tot: <span title="' + toTitle + '">' + toText+'</span>');
	}
	
	$( ".time-sliders" ).slider({
		range: true,
		min: 0,
		max: sliderTimeSpan,
		values: [ 0, sliderTimeSpan ],
		change: function(){
			$search.submit();
			updateTimeValues();
		},
		slide: updateTimeValues
	});
	updateTimeValues();

	$("#searchbar").focusin(function() {
		$("#search-explanation").slideDown();
	});
	$("#searchbar").focusout(function() {
		$("#search-explanation").slideUp();
	});
	
	$("#timebutton").click(function() {
		$("#slider-container").toggle();
		$search.submit();
	});
	
	$("a.tweet-location").live('click',function(){
		var countryId = $(this).data("country-id");
		var place = $(this).data("place-name");
		var path = crumblePath.path();
		for(var i in path){
			var filter = path[i];
			if(filter.type=="geo"&&filter.removable){
				crumblePath.remove(filter);
			}
		}
		var filter = new api.filters.Geo(place, countryId, place);
		crumblePath.add(filter);
		$search.submit();
		return false;
	});
	
	$("a.tweet-screen-name").live('click',function(){
		var userName = $(this).data("user-name");
		var filter = new api.filters.User(userName);
		crumblePath.add(filter);
		$search.submit();
		return false;
	});
	
	$(".crumble-path li").live({
        	mouseenter: function() {
				$(this).nextUntil().find("a").addClass("to-be-removed");
           },
        	mouseleave: function() {
				$(this).nextUntil().find("a").removeClass("to-be-removed");
           }
       }
    );
	
	
	var querystring = $.deparam.querystring(true);
	if(querystring&&querystring.filter) {
		$("#searchbar").addClass("loading");
		var filters = [];
		for (var index in querystring.filter) {
			filters.push(getFilter(querystring.filter[index]));
		}
		for (var index in filters){
			var filter = filters[index];
			crumblePath.add(filter);
		}
		$search.submit();
	}
	
	
	function getCurrentPermaLink() {
		filters = getFilters();
		querystring = "";
		for(var index in filters) {
			value = filters[index].value
			if(value != null) {
				if(querystring == "") {
					querystring = "?";
				} else {
					querystring += "&";
				}
				querystring += "filter[]=" + filters[index].value;
			}
		}
		return window.location.origin + querystring;
	}
});
