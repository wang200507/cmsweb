jQuery(function ($) {
    $('.fhcd').on('click', function (e) {
        e.preventDefault();
        $(top.frames['iframeChildPage']).hide();
    });
});