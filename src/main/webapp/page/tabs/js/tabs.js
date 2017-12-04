(function($){ 
	var $moveW = $('#moveW');
	var moveW = $moveW.outerWidth();
	$('.navs').on('click', '.nav', function(e) { 
		e.preventDefault();
		var $this = $(this);
		var index = $this.index();
		$this.addClass('on').siblings().removeClass('on');
		$('.content').eq(index).fadeIn(400).siblings().hide();
		$moveW.animate({ 
			left: moveW * index
		}, 200);
	});
})(jQuery);