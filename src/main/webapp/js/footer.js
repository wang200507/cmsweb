jQuery(function($){
    var getHtml = function(href) {
        $('.iframe').attr('src', href);
    };
    var defaultHref = 'iframe/qyzl/index.html';
    getHtml(defaultHref);
    $('.footer').on('click', '> a:not(".fhcd")', function(e) {
        e.preventDefault();
        var $this = $(this);
        var index = $this.index();
        var $biaoJi = $('.biaoJi');
        var offsetWidth = $this.width();
        var ORIGIN_OFFSET = 1;

        $this.addClass('xz').siblings().removeClass('xz');
        $biaoJi.css('left', offsetWidth * index + ORIGIN_OFFSET);

        getHtml($this.attr('href'));
    });
});