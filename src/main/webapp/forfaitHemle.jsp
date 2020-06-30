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

    <title>Forfaits Hemle</title>
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
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: rgb(106,106,255);}

        #customers tr:hover {background-color: rgb(0,0,196);}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: rgb(0,0,187);
            color: white;
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
                            <a href="Souscrire">
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
                            <a href="#" class="scrolly active" data-bg-img="el-mejor.jpg" data-page="#tm-section-2">
                                <i class="fas fa-list tm-nav-fa-icon"></i>
                                <span>Forfaits Hemle</span>
                            </a>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>

        <div class="col-xl-9 col-lg-8 col-md-12 col-sm-12 tm-content">


            <section id="tm-section-3" class="tm-section">
                <div class="ml-auto">
                    <header class="mb-4"><h1 class="tm-text-shadow">Forfaits Hemle</h1></header>
                    <p class="mb-5 tm-font-big">
                    <table id="customers">
                        <tr>
                            <th>Numéro</th>
                            <th>Nom</th>
                            <th>SMS</th>
                            <th>Appels</th>
                            <th>Data (Mo)</th>
                            <th>Validité</th>
                            <th>Prix</th>
                        </tr>
                        <%
                            ArrayList<Forfait> l = (ArrayList<Forfait>) request.getAttribute("listHemle");
                            for (Forfait fo:l){ %>
                        <tr>
                            <td><% out.println(fo.getId()); %></td>
                            <td><% out.println(fo.getNomForfait()); %></td>
                            <td><% out.println(fo.getSms()); %></td>
                            <td><% out.println(fo.getAppel()); %></td>
                            <td><% out.println(fo.getData()); %> Mo</td>
                            <td><% out.println(fo.getValidite()); %> Jour(s)</td>
                            <td><% out.println(fo.getPrix()); %> FCFA</td>
                        </tr>
                        <% } %>
                    </table>
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
    var currentPageID = "#tm-section-3";

    // Setup Carousel
    function setupCarousel() {

        // If current page isn't Carousel page, don't do anything.
        if($('#tm-section-3').css('display') == "none") {
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
        $.backstretch("img/el-mejor.jpg");
    }

    // Setup Nav Toggle Button
    function setupNavToggle() {

        $("#tmMainNavToggle").on("click", function(){
            $(".sidebar").toggleClass("show");
        });
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

            $("#tm-section-3").fadeIn();

            // Set up background first page
            var bgImg = $("#tm-section-2").data("bgImg");

            $.backstretch("img/el-mejor.jpg", {fade: 500});

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
