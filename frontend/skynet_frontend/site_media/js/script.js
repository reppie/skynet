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
	var $search = $("form#keyword-search-form");
	var $searchbar = $search.find("input#searchbar");
	
	var milisInMinute = 1000 * 60;
	var sliderTimeSpan = milisInMinute * 60* 24 * 30; // 30 dagen in miliseconden
	var nowRange = milisInMinute * 60 * 2; // 8 hour sweet spot (door beperking in slider implementatie)
	var timezoneOffset = new Date().getTimezoneOffset() * milisInMinute;
	
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
		
		$(".search-result-status").html("Getoond "+$(".tweets>.tweet").length+" van de "+total+" resultaten").show();
		
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
		$(".tweet-results").show();
		api.Tweet.search(filters, function(twitterIds, cloud){
			if(twitterIds){
				var tweetList = $(".tweets").TweetList(twitterIds, function(){
					updateResults(twitterIds.length);
					$searchbar.removeClass("loading");
				});
				$(".mini-tag-cloud").TagCloud(cloud);
				$("section#tag-cloud").show();
				
				$(".more-tweets").toggle(twitterIds.length>tweetList.pageSize);
			}
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
		$(".tweet-results").show();
		api.Tweet.search(filters, function(twitterIds, cloud){
			if(twitterIds){
				var tweetList = $(".tweets").TweetList(twitterIds, function(){
					updateResults(twitterIds.length);
					$searchbar.removeClass("loading");
				});
				$(".mini-tag-cloud").TagCloud(cloud);
				$("section#tag-cloud").show();
				$(".more-tweets").toggle(twitterIds.length>tweetList.pageSize);
			}
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
	api.cloud(function(cloud){
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
		});
	});
	
	$(function() {
	
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
	});
	
	$("#searchbar").focusin(function() {
		$("#search-explanation").slideDown();
	});
	$("#searchbar").focusout(function() {
		$("#search-explanation").slideUp();
	});

		
});






