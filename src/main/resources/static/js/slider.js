import slick from 'slick-carousel';

$(document).ready(function(){
    $('.category-carousel').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 1000,
    });
});