<%@ page import="entite.Forfait" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%--
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

    <title>Meilleurs Forfaits</title>
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
        .customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        .customers td, .customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        .customers tr:nth-child(even){background-color: rgb(106,106,255);}

        .customers tr {background-color: rgb(0,0,196);}

        .customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: rgb(0,0,187);
            color: white;
        }
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

                    <article>
                        <h3 class="tm-text-shadow">Forfait(s) pour <% out.println(request.getAttribute("jour")); %> Jour(s)</h3>
                        <h3 class="tm-text-shadow">Somme: <% out.println(request.getAttribute("somme")); %> FCFA</h3>
                        <h3 class="tm-text-shadow">Priorité SMS: <% out.println(request.getAttribute("sms")); %>; Priorité Appels: <% out.println(request.getAttribute("appel")); %>; Priorité Data: <% out.println(request.getAttribute("data")); %></h3>
                        <br><h1 class="tm-text-shadow">Pack des meilleurs forfaits Mango</h1>
                        <table>
                            <tr>
                                <td>
                                    <% ArrayList pack = (ArrayList) request.getAttribute("pack_m");
                                        if(pack.isEmpty()){ %>
                                    <h3 class="tm-text-shadow">Aucun Forfait Mango disponible</h3>
                                    <%
                                    }
                                    else {
                                        //for (int j=0;j<=0;j++){
                                        ArrayList<Forfait> l = (ArrayList<Forfait>) pack.get(0);
                                    %>
                                    <table>
                                        <tr>
                                            <td>
                                                <table class="customers">
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
                                                        for (Forfait f:l){ %>
                                                    <tr>
                                                        <td><% out.println(f.getId()); %></td>
                                                        <td><% out.println(f.getNomForfait()); %></td>
                                                        <td><% out.println(f.getSms()); %></td>
                                                        <td><% out.println(f.getAppel()); %></td>
                                                        <td><% out.println(f.getData()); %> Mo</td>
                                                        <td><% out.println(f.getValidite()); %> Jour(s)</td>
                                                        <td><% out.println(f.getPrix()); %> FCFA</td>
                                                    </tr>

                                                    <% } %>
                                                </table>
                                                <br>
                                            </td>
                                        </tr>
                                    </table>
                                    <% } //}%>
                                </td>
                            </tr>
                        </table>
                        <h3 class="tm-text-shadow">Proposition optimal:</h3>
                        <% int[] list_p = (int[]) pack.get(1);
                            for(int i=0; i<list_p.length;i++){
                                if(list_p[i]>0){
                        %>
                        <h2 class="tm-text-shadow" style="color: white; border-radius: 10px; background-color: seagreen; padding: 5px">Souscrire le forfait Mango Numero <% ArrayList<Forfait> l = (ArrayList<Forfait>) pack.get(0); Forfait f = l.get(i); out.println(f.getId()); %> ---> <% out.println(list_p[i]); %> fois</h2>
                        <% } } %>
                        <hr style="background-color: darkblue">
                    </article>

                    <article>
                        <h1 class="tm-text-shadow">Pack des meilleurs forfaits Hemle</h1>
                        <table>
                            <tr>
                                <td>
                                    <%
                                        ArrayList pack1 = (ArrayList) request.getAttribute("pack_h");
                                        if(pack1.isEmpty()){ %>
                                    <h3 class="tm-text-shadow">Aucun Forfait Hemle disponible</h3>
                                    <% }
                                    else {
                                        // for (int j=0;j<pack1.size();j++){
                                        ArrayList<Forfait> l = (ArrayList<Forfait>) pack1.get(0);
                                    %>
                                    <table>
                                        <tr>
                                            <td>
                                                <table class="customers">
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
                                                        for (Forfait f:l){ %>
                                                    <tr>
                                                        <td><% out.println(f.getId()); %></td>
                                                        <td><% out.println(f.getNomForfait()); %></td>
                                                        <td><% out.println(f.getSms()); %></td>
                                                        <td><% out.println(f.getAppel()); %></td>
                                                        <td><% out.println(f.getData()); %> Mo</td>
                                                        <td><% out.println(f.getValidite()); %> Jour(s)</td>
                                                        <td><% out.println(f.getPrix()); %> FCFA</td>
                                                    </tr>

                                                    <% } %>
                                                </table>
                                                <br>
                                            </td>
                                        </tr>
                                    </table>
                                    <% } //}%>
                                </td>
                            </tr>
                        </table>
                        <h3 class="tm-text-shadow">Proposition optimal:</h3>
                        <% int[] list_p1 = (int[]) pack1.get(1);
                            for(int i=0; i<list_p1.length;i++){
                                if(list_p1[i]>0){
                        %>
                        <h2 class="tm-text-shadow" style="color: white; border-radius: 10px; background-color: seagreen; padding: 5px">Souscrire le forfait Hemle Numero <% ArrayList<Forfait> l = (ArrayList<Forfait>) pack1.get(0); Forfait f = l.get(i); out.println(f.getId()); %> ---> <% out.println(list_p1[i]); %> fois</h2>
                        <% } } %>
                    </article>

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
