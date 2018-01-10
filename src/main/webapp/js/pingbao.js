/*
!(function(timeout) {
	
	var current = new Date().getTime();
	document.body.addEventListener("contextmenu",function(event){
//		event.preventDefault();
//		event.stopPropagation();
	});
	document.body.addEventListener("mousedown", function(event) {
		current = new Date().getTime();
	});

	setInterval(function() {
		var tempCurrent = new Date().getTime();
		if(tempCurrent >= (current + timeout)) {
			var currentURL = window.location.href;
			window.location.href = "/cmsweb/page/pb/index.html?id="+currentURL;
		}
	}, 1000)
})(1000*60*2);
*/
