/* Author:

*/

api.Tweet.get(1, function(tweet){
	
	console.log(tweet);
	
	if(tweet) {
		tweet.getUser(function(user){
			console.log(user);
			api.Tweet.get(1, function(tweet){
				if(tweet) {
					tweet.getUser(function(user){
						console.log(user);
						
					});
				
				}
			});
		});
	}
});






