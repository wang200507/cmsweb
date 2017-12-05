/*! newsMarquee.js v1.0.0 | (c) 2016, author: 50048873@qq.com*/

//消息跑马灯
NewsMarquee.defaults = {
	moveDistance: 2,	//每次移动的距离
	interval: 60		//每次移动间隔的时间
};

function NewsMarquee(opts) { 
	this.opts = $.extend({}, NewsMarquee.defaults, opts);
	
	this.moveDistance = this.opts.moveDistance;
	this.direction = this.opts.direction;

	this.replenish();
	this.move();
}

NewsMarquee.prototype.replenish = function() {
	this.$ul = $('.newsMarquee ul');
	this.$lis = $('.newsMarquee li');

	this.$ul.addClass('horizontal');
	var len = 0;
	$('.horizontal li').each(function (index, item) {
		len += $(item).outerWidth();
	});
	this.$ul.css('width', len);
};

NewsMarquee.prototype.move = function() { 
	var moveUnit = this.moveDistance;
	var _this = this;

	setInterval(function() {
        if (_this.moveDistance >= _this.$ul.width() + window.innerWidth) {
            _this.moveDistance = 0;
        }
		var transform = prefixStyle('transform');
        _this.$ul.css(transform, 'translateX(-' + _this.moveDistance + 'px)');
        _this.moveDistance += moveUnit;
	}, _this.opts.interval);
};

$.prototype.newsMarquee = function(opts) { 
	return this.each(function() { 
		new NewsMarquee(opts);
	});
};