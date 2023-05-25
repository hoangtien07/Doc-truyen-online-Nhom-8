function loadmenu(){
    var menu = '<div class="top-nav">'+
    '<div class="container">'+
        '<div class="row">'+
            '<div class="col-lg-6">'+
                '<ul class="tn-left">'+
                    '<li><i class="fa fa-phone"></i> (+84) 345 67890</li>'+
                    '<li><i class="fa fa-envelope"></i> taitestdoan@gmail.com</li>'+
                '</ul>'+
            '</div>'+
            '<div class="col-lg-6">'+
                '<div class="tn-right">'+
                    '<div class="top-social">'+
                       ' <a href="#"><i class="fa fa-facebook"></i></a>'+
                        '<a href="#"><i class="fa fa-twitter"></i></a>'+
                        '<a href="#"><i class="fa fa-tripadvisor"></i></a>'+
                        '<a href="#"><i class="fa fa-instagram"></i></a>'+
                    '</div>'+
                    '<!-- <a href="#" class="bk-btn">Booking Now</a> -->'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>'+
    '</div>'+
    '<div class="menu-item">'+
    '<div class="container">'+
        '<div class="row">'+
            '<div class="col-lg-2">'+
                '<div class="logo">'+
                    '<a href="./index.html">'+
                        '<h3>Booking</h3>'+
                    '</a>'+
                '</div>'+
            '</div>'+
            '<div class="col-lg-10">'+
                '<div class="nav-menu">'+
                    '<nav class="mainmenu">'+
                        '<ul>'+
                            '<li><a href="./rooms.html">Trang chủ</a></li>'+
                            '<li><a href="./index.html">Khách sạn</a></li>'+
                            '<li><a href="./rooms.html">Thuê Phòng</a></li>'+
                            
                            '<li><a href="./pages.html">Nhà hàng</a>'+
                            '<li><a href="./pages.html">Dịch vụ</a>'+
                            '<li><a href="./pages.html">Chat</a>'+
                            '<li><a>Tài khoản</a>'+
                                '<ul class="dropdown">'+
                                    '<li><a href="">Đăng nhập</a></li>'+
                                    '<li><a href="">Đăng xuất</a></li>'+
                                    '<li><a href="">Các dịch vụ đã đặt</a></li>'+
                                '</ul>'+
                            '</li>'+
                        '</ul>'+
                    '</nav>'+
                    '<div class="nav-right search-switch">'+
                        '<i class="icon_search"></i>'+
                    '</div>'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>'+
    '</div>';
    var me = 'hieu';
    document.getElementById("menu").innerHTML = menu;
}


function loadFooter(){
    var footer = ' <div class="container">'+
    '<div class="footer-text">'+
        '<div class="row">'+
            '<div class="col-lg-4">'+
                '<div class="ft-about">'+
                    '<div class="logo">'+
                        '<a href="#">'+
                            '<h3>Booking</h3>'+
                        '</a>'+
                    '</div>'+
                    '<p>Chúng tôi có hơn 100 đối tác là các nhà hàng, khách sạn<br /></p>'+
                    '<div class="fa-social">'+
                        '<a href="#"><i class="fa fa-facebook"></i></a>'+
                        '<a href="#"><i class="fa fa-twitter"></i></a>'+
                        '<a href="#"><i class="fa fa-tripadvisor"></i></a>'+
                        '<a href="#"><i class="fa fa-instagram"></i></a>'+
                        '<a href="#"><i class="fa fa-youtube-play"></i></a>'+
                    '</div>'+
                '</div>'+
            '</div>'+
            '<div class="col-lg-3 offset-lg-1">'+
                '<div class="ft-contact">'+
                    '<h6>Liên hệ với chúng tôi</h6>'+
                    '<ul>'+
                        '<li>(+84) 345 67890</li>'+
                        '<li>taitestmail@gmail.com</li>'+
                        '<li>Việt Nam</li>'+
                    '</ul>'+
                '</div>'+
            '</div>'+
            '<div class="col-lg-3 offset-lg-1">'+
                '<div class="ft-newslatter">'+
                    '<h6>Để lại lời nhắn của bạn</h6>'+
                    '<form action="#" class="fn-form">'+
                        '<input type="text" placeholder="Email">'+
                        '<button type="submit"><i class="fa fa-send"></i></button>'+
                    '</form>'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>'+
'</div>';

document.getElementById("footer").innerHTML = footer;
}

