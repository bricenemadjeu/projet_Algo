<%@ page import="entite.Forfait" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.parser.ParseException" %><%--
  Created by IntelliJ IDEA.
  User: Brice Dylane
  Date: 30/06/2020
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" type="image/png" href="img/sans_engagement_duree.png"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Mes Forfaits</title>
    <!--

    Template 2102 Constructive

    http://www.tooplate.com/view/2102-constructive

    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/fontawesome-all.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/magnific-popup.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick.css"/>
    <link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
    <link rel="stylesheet" href="css/tooplate-style.css">

    <style>
        input[type="number"], select
        {
            -webkit-transition: all 0.30s ease-in-out;
            -moz-transition: all 0.30s ease-in-out;
            -ms-transition: all 0.30s ease-in-out;
            -o-transition: all 0.30s ease-in-out;
            outline: none;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            width: 100%;
            background: #fff;
            margin-bottom: 4%;
            border: 1px solid #ccc;
            padding: 3%;
            color: #555;
            font: 95% Arial, Helvetica, sans-serif;
        }
        input[type="submit"]{
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            width: 100%;
            padding: 3%;
            background: #43D1AF;
            border-bottom: 2px solid #30C29E;
            border-top-style: none;
            border-right-style: none;
            border-left-style: none;
            color: #fff;
        }
        input[type="submit"]:hover{
            background: #2EBC99;
        }
    </style>

    <script>
        var renderPage = true;

        if(navigator.userAgent.indexOf('MSIE')!==-1
            || navigator.appVersion.indexOf('Trident/') > 0){
            /* Microsoft Internet Explorer detected in. */
            alert("Please view this in a modern browser such as Chrome or Microsoft Edge.");
            renderPage = false;
        }
    </script>
</head>

<body>
<!-- Loader -->
<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>

<!-- Page Content -->
<div class="container-fluid tm-main">
    <div class="row tm-main-row">

        <!-- Sidebar -->
        <div id="tmSideBar" class="col-xl-3 col-lg-4 col-md-12 col-sm-12 sidebar">

            <button id="tmMainNavToggle" class="menu-icon">&#9776;</button>

            <div class="inner">
                <nav id="tmMainNav" class="tm-main-nav">
                    <ul>
                        <li>
                            <a href="#" id="tmNavLink1" class="scrolly active" data-bg-img="mobile-internet.jpg" data-page="#tm-section-1">
                                <i class="fas fa-phone tm-nav-fa-icon"></i>
                                <span>Souscrire</span>
                            </a>
                        </li>
                        <li>
                            <a href="ForfaitMango">
                                <i class="fas fa-list tm-nav-fa-icon"></i>
                                <span>Forfaits Mango</span>
                            </a>
                        </li>
                        <li>
                            <a href="ForfaitHemle">
                                <i class="fas fa-list tm-nav-fa-icon"></i>
                                <span>Forfaits Hemle</span>
                            </a>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>

        <div class="col-xl-9 col-lg-8 col-md-12 col-sm-12 tm-content">

            <!-- section 1 -->
            <section id="tm-section-1" class="tm-section">
                <div class="ml-auto">
                    <header class="mb-4"><h1 class="tm-text-shadow">Souscrire</h1></header>
                    <p class="mb-5 tm-font-big" style="border-radius: 10px;">
                    <form method="post" action="Meilleur-Forfait">
                        <table>
                            <tr>
                                <td>Somme </td>
                                <td><input type="number" name="som" required></td>
                            </tr>
                            <tr>
                                <td>Jour(s)</td>
                                <td><select name="jour" required>
                                    <option>1</option>
                                    <option>3</option>
                                    <option>7</option>
                                    <option>30</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td>Priorité des SMS </td>
                                <td><select name="sms" required>
                                    <option>1</option>
                                    <option>0</option>
                                    <option>2</option>
                                    <option>3</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td>Priorité des Appels </td>
                                <td><select name="appels" required>
                                    <option>2</option>
                                    <option>1</option>
                                    <option>0</option>
                                    <option>3</option>
                                </select></td>
                            <tr>
                                <td>Priorité des Data </td>
                                <td><select name="data" required>
                                    <option>3</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>0</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Souscrire"></td>
                            </tr>
                        </table>
                    </form>

                    </p>
                </div>
            </section>
        </div>	<!-- .tm-content -->

    </div>	<!-- row -->
</div>
<div id="preload-01"></div>
<div id="preload-02"></div>
<div id="preload-03"></div>
<div id="preload-04"></div>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.magnific-popup.min.js"></script>
<script type="text/javascript" src="js/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="slick/slick.min.js"></script> <!-- Slick Carousel -->

<script>

    var sidebarVisible = false;
    var currentPageID = "#tm-section-1";

    // Setup Carousel
    function setupCarousel() {

        // If current page isn't Carousel page, don't do anything.
        if($('#tm-section-1').css('display') == "none") {
        }
        else {	// If current page is Carousel page, set up the Carousel.

            var slider = $('.tm-img-slider');
            var windowWidth = $(window).width();

            if (slider.hasClass('slick-initialized')) {
                slider.slick('destroy');
            }

            if(windowWidth < 640) {
                slider.slick({
                    dots: true,
                    infinite: false,
                    slidesToShow: 1,
                    slidesToScroll: 1
                });
            }
            else if(windowWidth < 992) {
                slider.slick({
                    dots: true,
                    infinite: false,
                    slidesToShow: 2,
                    slidesToScroll: 1
                });
            }
            else {
                // Slick carousel
                slider.slick({
                    dots: true,
                    infinite: false,
                    slidesToShow: 3,
                    slidesToScroll: 2
                });
            }

            // Init Magnific Popup
            $('.tm-img-slider').magnificPopup({
                delegate: 'a', // child items selector, by clicking on it popup will open
                type: 'image',
                gallery: {enabled:true}
                // other options
            });
        }
    }

    // Setup Nav
    function setupNav() {
        // Add Event Listener to each Nav item
        /*$(".tm-main-nav a").click(function(e){
            e.preventDefault();

            var currentNavItem = $(this);
            changePage(currentNavItem);

            setupCarousel();
            setupFooter();

            // Hide the nav on mobile
            $("#tmSideBar").removeClass("show");
        });*/
    }

    function changePage(currentNavItem) {
        // Update Nav items
        //$(".tm-main-nav a").removeClass("active");
        //currentNavItem.addClass("active");

        //$(currentPageID).hide();

        // Show current page
        currentPageID = currentNavItem.data("page");
        $(currentPageID).fadeIn(1000);

        // Change background image
        var bgImg = currentNavItem.data("bgImg");
        $.backstretch("img/" + bgImg);
    }

    // Setup Nav Toggle Button
    function setupNavToggle() {

        //$("#tmMainNavToggle").on("click", function(){
          //  $(".sidebar").toggleClass("show");
       // });
    }

    // If there is enough room, stick the footer at the bottom of page content.
    // If not, place it after the page content
    function setupFooter() {

        var padding = 100;
        var footerPadding = 40;
        var mainContent = $("section"+currentPageID);
        var mainContentHeight = mainContent.outerHeight(true);
        var footer = $(".footer-link");
        var footerHeight = footer.outerHeight(true);
        var totalPageHeight = mainContentHeight + footerHeight + footerPadding + padding;
        var windowHeight = $(window).height();

        if(totalPageHeight > windowHeight){
            $(".tm-content").css("margin-bottom", footerHeight + footerPadding + "px");
            footer.css("bottom", footerHeight + "px");
        }
        else {
            $(".tm-content").css("margin-bottom", "0");
            footer.css("bottom", "20px");
        }
    }

    // Everything is loaded including images.
    $(window).on("load", function(){

        // Render the page on modern browser only.
        if(renderPage) {
            // Remove loader
            $('body').addClass('loaded');

            // Page transition
            var allPages = $(".tm-section");

            // Handle click of "Continue", which changes to next page
            // The link contains data-nav-link attribute, which holds the nav item ID
            // Nav item ID is then used to access and trigger click on the corresponding nav item
            var linkToAnotherPage = $("a.tm-btn[data-nav-link]");

            if(linkToAnotherPage != null) {

                linkToAnotherPage.on("click", function(){
                    var navItemToHighlight = linkToAnotherPage.data("navLink");
                    $("a" + navItemToHighlight).click();
                });
            }

            // Hide all pages
            allPages.hide();

            $("#tm-section-1").fadeIn();

            // Set up background first page
            var bgImg = $("#tmNavLink1").data("bgImg");

            $.backstretch("img/" + bgImg, {fade: 500});

            // Setup Carousel, Nav, and Nav Toggle
            setupCarousel();
            setupNav();
            setupNavToggle();
            setupFooter();

            // Resize Carousel upon window resize
            $(window).resize(function() {
                setupCarousel();
                setupFooter();
            });
        }
    });

</script>
</body>
</html>