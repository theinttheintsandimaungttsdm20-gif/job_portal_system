<%@page import="com.jobportal.entity.Login"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="nf"%>
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="" />
<meta name="author" content="" />
<meta name="robots" content="" />
<meta name="description" content="JobBoard - HTML Template" />
<meta property="og:title" content="JobBoard - HTML Template" />
<meta property="og:description" content="JobBoard - HTML Template" />
<meta property="og:image" content="JobBoard - HTML Template" />
<meta name="format-detection" content="telephone=no">

<!-- FAVICONS ICON -->
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" type="image/x-icon"
	href="resources/images/favicon.png" />

<!-- PAGE TITLE HERE -->
<title>JobBoard - HTML Template</title>

<!-- MOBILE SPECIFIC -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--[if lt IE 9]>
	<script src="js/html5shiv.min.js"></script>
	<script src="js/respond.min.js"></script>
<![endif]-->

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/plugins.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/templete.css"/>">
<link class="skin" rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/skin/skin-1.css"/>">
<link rel="stylesheet"
	href="<c:url value="resources/plugins/datepicker/css/bootstrap-datetimepicker.min.css"/>">
<!-- Revolution Slider Css -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/plugins/revolution/revolution/css/layers.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/plugins/revolution/revolution/css/settings.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/plugins/revolution/revolution/css/navigation.css"/>">
<style>
.pagination {
  display: inline-block;
    margin-left: 120px;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  font-size: 22px;

}

.pagination a.active {
  background-color:#3396d1;
  color: white;
  border: 1px solid #3396d1;
}

.pagination a:hover:not(.active) {background-color: #3396d1;}
</style>
</head>
<body>
<body id="bg">
	<div class="page-wraper">
		<!-- header -->
		<header class="site-header mo-left header fullwidth">
			<!-- main header -->
			<div class="sticky-header main-bar-wraper navbar-expand-lg">
				<div class="main-bar clearfix">
					
						<!-- website logo -->
						<div class="logo-header mostion">
							<a href="index-2.html"><img src="resources/images/logo.png"
								class="logo" alt=""></a>
						</div>
						<!-- nav toggle button -->
						<!-- nav toggle button -->
						<button
							class="navbar-toggler collapsed navicon justify-content-end"
							type="button" data-toggle="collapse"
							data-target="#navbarNavDropdown"
							aria-controls="navbarNavDropdown" aria-expanded="false"
							aria-label="Toggle navigation">
							<span></span> <span></span> <span></span>
						</button>
						<!-- extra nav -->


						<!-- Quik search -->
						<div class="dez-quik-search bg-primary">
							<form action="#">
								<input name="search" value="" type="text" class="form-control"
									placeholder="Type to search"> <span
									id="quik-search-remove"><i class="flaticon-close"></i></span>
							</form>
						</div>
						<!-- main nav -->

						<nav class="navbar navbar-inverse">
							<div class="container-fluid header-nav" id="navbarNavDropdown">

								<ul class="nav navbar-nav">
									<li class="active"><a href="loginSuccessPath">User
											Home <span class="caret"></span>
									</a></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">User Profile <span
											class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="getJobSeekerPath" class="dez-page">Update
													Profile</a></li>
										</ul></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">Education<span
											class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="regEduPath" class="dez-page">Register
													Education</a></li>
											<li><a
												href="getEduPath?frmId=${userLogin.loginId}&frmRole=seeker"
												class="dez-page">View Education</a></li>
										</ul></li>
									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">Experience <span
											class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="regWorkExpPath" class="dez-page">Register
													Work Experience</a></li>
											<li><a
												href="getExpPath?frmId=${userLogin.loginId}&frmRole=seeker"
												class="dez-page">View Work Experience</a></li>
										</ul></li>

									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">Jobs <span class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="getAllRecruitersPath?frmRole=jobSeeker"
												class="dez-page">View Companies</a></li>
											<li><a href="viewJobPath" class="dez-page">View Job
													Posts</a></li>
											<li><a href="getAllAppPath" class="dez-page">View
													Application</a></li>
										</ul></li>

								</ul>

								<ul class="nav navbar-nav navbar-right">


									<li class="dropdown"><a class="dropdown-toggle"
										data-toggle="dropdown" href="#">${userLogin.username } <span
											class="caret"></span></a>
										<ul class="sub-menu">
											<li><a href="logOutPath" class="dez-page">Logout</a></li>
											<li><a href="deactivatePath" class="dez-page">Deactive</a></li>

										</ul></li>

								</ul>
							
						</nav>
		</header>
		<!-- inner page banner -->
		<div class="dez-bnr-inr overlay-black-dark"
			style="background-image: url(resources/images/banner/bnr1.jpg);">
			<div class="container">
				<div class="dez-bnr-inr-entry">
					<h1 class="text-white">Job Posts</h1>
					<!-- Breadcrumb row -->
					<div class="breadcrumb-row">
						<ul class="list-inline">
							<li><a href="#">Home</a></li>
							<li>View Job Post</li>
						</ul>
					</div>
					<!-- Breadcrumb row END -->
				</div>
			</div>
		</div>
		<div class="content-block">
			<!-- Browse Jobs -->
			<div class="section-full bg-white browse-job content-inner-2">
			<form id="live-search" action="" class="styled" method="post">
    <fieldset>
        <input type="text" class="text-input form-control form-control-sm ml-3 w-75" id="filter" placeholder="Search" />
        <span id="filter-count"></span>
    </fieldset>

</form>	
				<div class="container">
					<div class="row">
						<div class="col-xl-9 col-lg-8">
							<h5 class="widget-title font-weight-700 text-uppercase">All
								Jobs</h5>

								<ul class="post-job-bx">
								<c:forEach var="at" items="${jobModelList.jobList}" varStatus="s">
								<div class="single-item">
									<li><a href="viewJobDetailPath?frmJobId=${at.jobId}&frmRole=seeker">
											<div class="d-flex m-b30">
												<div class="job-post-company">
													<span><img src="resources/images/logo/icon1.png" /></span>
												</div>
												<div class="job-post-info">
													<h4>${at.jobTitle}</h4>
													<ul>
														<li><i class="fa fa-map-marker"></i>${at.jobLocation}</li>
														<li><i class="fa fa-bookmark-o"></i> ${at.jobCategoryName}</li>
														<li><i class="fa fa-clock-o"></i>${at.jobOpenDate}</li>
														<li><i class="fa fa-clock-o"></i>${at.jobCloseDate}</li>
													</ul>


												</div>
											</div>
											<div class="d-flex">
												<div class="job-time mr-auto">
													<span>View More....</span>
												</div>
												<div class="salary-bx">
													<span>${at.expectedSalary}</span>
												</div>
											</div> 
											<span class="post-like fa fa-heart-o"></span>
									</a></li><br>
									</div>
							</c:forEach>
							</ul>
							</div>
							</div>
							</div>
							</div>


							<!-- Footer -->
							<footer class="site-footer">
								<div class="footer-top">
									<div class="container">
										<div class="row">
											<div class="col-xl-5 col-lg-4 col-md-12 col-sm-12">
												<div class="widget">
													<img src="images/logo-white.png" width="180" class="m-b15"
														alt="" />
													<p class="text-capitalize m-b20">Lorem Ipsum is simply
														dummy text of the printing and typesetting industry has
														been the industry's standard dummy text ever since the..</p>
													<div class="subscribe-form m-b20">
														<form class="dzSubscribe"
															action="http://job-board.w3itexperts.com/xhtml/script/mailchamp.php"
															method="post">
															<div class="dzSubscribeMsg"></div>
															<div class="input-group">
																<input name="dzEmail" required="required"
																	class="form-control" placeholder="Your Email Id"
																	type="email"> <span class="input-group-btn">
																	<button name="submit" value="Submit" type="submit"
																		class="site-button radius-xl">Subscribe</button>
																</span>
															</div>
														</form>
													</div>
													<ul class="list-inline m-a0">
														<li><a href="#"
															class="site-button white facebook circle "><i
																class="fa fa-facebook"></i></a></li>
														<li><a href="#"
															class="site-button white google-plus circle "><i
																class="fa fa-google-plus"></i></a></li>
														<li><a href="#"
															class="site-button white linkedin circle "><i
																class="fa fa-linkedin"></i></a></li>
														<li><a href="#"
															class="site-button white instagram circle "><i
																class="fa fa-instagram"></i></a></li>
														<li><a href="#"
															class="site-button white twitter circle "><i
																class="fa fa-twitter"></i></a></li>
													</ul>
												</div>
											</div>
											<div class="col-xl-5 col-lg-5 col-md-8 col-sm-8 col-12">
												<div class="widget border-0">
													<h5 class="m-b30 text-white">Frequently Asked
														Questions</h5>
													<ul class="list-2 list-line">
														<li><a href="#">Privacy & Seurty</a></li>
														<li><a href="#">Terms of Serice</a></li>
														<li><a href="#">Communications</a></li>
														<li><a href="#">Referral Terms</a></li>
														<li><a href="#">Lending Licnses</a></li>
														<li><a href="#">Support</a></li>
														<li><a href="#">How It Works</a></li>
														<li><a href="#">For Employers</a></li>
														<li><a href="#">Underwriting</a></li>
														<li><a href="#">Contact Us</a></li>
														<li><a href="#">Lending Licnses</a></li>
														<li><a href="#">Support</a></li>
													</ul>
												</div>
											</div>
											<div class="col-xl-2 col-lg-3 col-md-4 col-sm-4 col-12">
												<div class="widget border-0">
													<h5 class="m-b30 text-white">Find Jobs</h5>
													<ul class="list-2 w10 list-line">
														<li><a href="#">US Jobs</a></li>
														<li><a href="#">Canada Jobs</a></li>
														<li><a href="#">UK Jobs</a></li>
														<li><a href="#">Emplois en Fnce</a></li>
														<li><a href="#">Jobs in Deuts</a></li>
														<li><a href="#">Vacatures China</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- footer bottom part -->
								<div class="footer-bottom">
									<div class="container">
										<div class="row">
											<div class="col-lg-12 text-center">
												<span><a target="_blank"
													href="https://www.templateshub.net">Templates Hub</a></span>
											</div>
										</div>
									</div>
								</div>
							</footer>
							<!-- Footer END -->
							<button class="scroltop fa fa-chevron-up"></button>
						</div>
						<!-- JAVASCRIPT FILES ========================================= -->
						<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
						<!-- JQUERY.MIN JS -->
						<script src="<c:url value="resources/plugins/wow/wow.js"/>"></script>
						<!-- WOW JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap/js/popper.min.js"/>"></script>
						<!-- BOOTSTRAP.MIN JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
						<!-- BOOTSTRAP.MIN JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap-select/bootstrap-select.min.js"/>"></script>
						<!-- FORM JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"/>"></script>
						<!-- FORM JS -->
						<script
							src="<c:url value="resources/plugins/magnific-popup/magnific-popup.js"/>"></script>
						<!-- MAGNIFIC POPUP JS -->
						<script
							src="<c:url value="resources/plugins/counter/waypoints-min.js"/>"></script>
						<!-- WAYPOINTS JS -->
						<script
							src="<c:url value="resources/plugins/counter/counterup.min.js"/>"></script>
						<!-- COUNTERUP JS -->
						<script
							src="<c:url value="resources/plugins/imagesloaded/imagesloaded.js"/>"></script>
						<!-- IMAGESLOADED -->
						<script
							src="<c:url value="resources/plugins/masonry/masonry-3.1.4.js"/>"></script>
						<!-- MASONRY -->
						<script
							src="<c:url value="resources/plugins/masonry/masonry.filter.js"/>"></script>
						<!-- MASONRY -->
						<script
							src="<c:url value="resources/plugins/owl-carousel/owl.carousel.js"/>"></script>
						<!-- OWL SLIDER -->
						<script
							src="<c:url value="resources/plugins/rangeslider/rangeslider.js"/>"></script>
						<!-- Rangeslider -->
						<script src="<c:url value="resources/js/custom.js"/>"></script>
						<!-- CUSTOM FUCTIONS  -->
						<script src="<c:url value="resources/js/dz.carousel.js"/>"></script>
						<!-- SORTCODE FUCTIONS  -->
						<script src="<c:url value="resources/js/recaptcha/api.js"/>"></script>
						<!-- Google API For Recaptcha  -->
						<script src="<c:url value="resources/js/dz.ajax.js"/>"></script>
						<!-- CONTACT JS  -->
						<script
							src="<c:url value="resources/plugins/paroller/skrollr.min.js"/>"></script>
						<!-- PAROLLER -->
						<script src="<c:url value="resources/js/jquery.min.js"/>"></script>
						<!-- JQUERY.MIN JS -->
						<script src="<c:url value="resources/plugins/wow/wow.js"/>"></script>
						<!-- WOW JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap/js/popper.min.js"/>"></script>
						<!-- BOOTSTRAP.MIN JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
						<!-- BOOTSTRAP.MIN JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap-select/bootstrap-select.min.js"/>"></script>
						<!-- FORM JS -->
						<script
							src="<c:url value="resources/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"/>"></script>
						<!-- FORM JS -->
						<script
							src="<c:url value="resources/plugins/magnific-popup/magnific-popup.js"/>"></script>
						<!-- MAGNIFIC POPUP JS -->
						<script
							src="<c:url value="resources/plugins/counter/waypoints-min.js"/>"></script>
						<!-- WAYPOINTS JS -->
						<script
							src="<c:url value="resources/plugins/counter/counterup.min.js"/>"></script>
						<!-- COUNTERUP JS -->
						<script
							src="<c:url value="resources/plugins/imagesloaded/imagesloaded.js"/>"></script>
						<!-- IMAGESLOADED -->
						<script
							src="<c:url value="resources/plugins/masonry/masonry-3.1.4.js"/>"></script>
						<!-- MASONRY -->
						<script
							src="<c:url value="resources/plugins/masonry/masonry.filter.js"/>"></script>
						<!-- MASONRY -->
						<script
							src="<c:url value="resources/plugins/owl-carousel/owl.carousel.js"/>"></script>
						<!-- OWL SLIDER -->
						<script
							src="<c:url value="resources/plugins/rangeslider/rangeslider.js"/>"></script>
						<!-- Rangeslider -->
						<script src="<c:url value="resources/js/custom.js"/>"></script>
						<!-- CUSTOM FUCTIONS  -->
						<script src="<c:url value="resources/js/dz.carousel.js"/>"></script>
						<!-- SORTCODE FUCTIONS  -->
						<script src="<c:url value="resources/js/recaptcha/api.js"/>"></script>
						<!-- Google API For Recaptcha  -->
						<script src="<c:url value="resources/js/dz.ajax.js"/>"></script>
						<!-- CONTACT JS  -->
						<script
							src="<c:url value="resources/plugins/paroller/skrollr.min.js"/>"></script>
						<!-- PAROLLER -->
						<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
						<!-- PAROLLER -->
						<script
							src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
						<!-- PAROLLER -->
						<script
							src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
						<script type="text/javascript">

			$("#exp-slider-range").slider({
				range: true,
				min: 0,
				max: 10,
				//values: [0, 10],
				slide: function(event, ui) {
					var min = ui.values[0],
						max = ui.values[1];
					  $('#' + this.id).prev().val( min + " year - " + max + " year");
				}
			});
			
			$("#salary-slider-range").slider({
				range: true,
				min: 10,
				max: 100,
				//values: [10, 1000],
				slide: function(event, ui) {
					var min = ui.values[0],
						max = ui.values[1];
					  $('#' + this.id).prev().val(min + "K - " + max + "K");
				}
			});
		
</script>
  <script>
    $(document).ready(function() {
    $('#example').DataTable();
} );


</script>


						<!-- Go to www.addthis.com/dashboard to customize your tools -->
						<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
</script>
<script>
$(document).ready(function(){
    $("#filter").keyup(function(){
 
        // Retrieve the input field text and reset the count to zero
        var filter = $(this).val(), count = 0;
 
        // Loop through the comment list
        $("div ul li").each(function(){
 
            // If the list item does not contain the text phrase fade it out
            if ($(this).text().search(new RegExp(filter, "i")) < 0) {
                $(this).fadeOut();
 
            // Show the list item if the phrase matches and increase the count by 1
            } else {
                $(this).show();
                count++;
            }
        });
 
        // Update the count
        var numberItems = count;
        $("#filter-count").text("Number of Filter = "+count);
    });
});

</script>

<script>
(function($) {
  var pagify = {
    items: {},
    container: null,
    totalPages: 1,
    perPage: 3,
    currentPage: 0,
    createNavigation: function() {
      this.totalPages = Math.ceil(this.items.length / this.perPage);

      $('.pagination', this.container.parent()).remove();
      var pagination = $('<div class="pagination"></div>').append('<a class="nav prev disabled" data-next="false"><</a>');

      for (var i = 0; i < this.totalPages; i++) {
        var pageElClass = "page";
        if (!i)
          pageElClass = "page current";
        var pageEl = '<a class="' + pageElClass + '" data-page="' + (
        i + 1) + '">' + (
        i + 1) + "</a>";
        pagination.append(pageEl);
      }
      pagination.append('<a class="nav next" data-next="true">></a>');

      this.container.after(pagination);

      var that = this;
      $("body").off("click", ".nav");
      this.navigator = $("body").on("click", ".nav", function() {
        var el = $(this);
        that.navigate(el.data("next"));
      });

      $("body").off("click", ".page");
      this.pageNavigator = $("body").on("click", ".page", function() {
        var el = $(this);
        that.goToPage(el.data("page"));
      });
    },
    navigate: function(next) {
      // default perPage to 5
      if (isNaN(next) || next === undefined) {
        next = true;
      }
      $(".pagination .nav").removeClass("disabled");
      if (next) {
        this.currentPage++;
        if (this.currentPage > (this.totalPages - 1))
          this.currentPage = (this.totalPages - 1);
        if (this.currentPage == (this.totalPages - 1))
          $(".pagination .nav.next").addClass("disabled");
        }
      else {
        this.currentPage--;
        if (this.currentPage < 0)
          this.currentPage = 0;
        if (this.currentPage == 0)
          $(".pagination .nav.prev").addClass("disabled");
        }

      this.showItems();
    },
    updateNavigation: function() {

      var pages = $(".pagination .page");
      pages.removeClass("current");
      $('.pagination .page[data-page="' + (
      this.currentPage + 1) + '"]').addClass("current");
    },
    goToPage: function(page) {

      this.currentPage = page - 1;

      $(".pagination .nav").removeClass("disabled");
      if (this.currentPage == (this.totalPages - 1))
        $(".pagination .nav.next").addClass("disabled");

      if (this.currentPage == 0)
        $(".pagination .nav.prev").addClass("disabled");
      this.showItems();
    },
    showItems: function() {
      this.items.hide();
      var base = this.perPage * this.currentPage;
      this.items.slice(base, base + this.perPage).show();

      this.updateNavigation();
    },
    init: function(container, items, perPage) {
      this.container = container;
      this.currentPage = 0;
      this.totalPages = 1;
      this.perPage = perPage;
      this.items = items;
      this.createNavigation();
      this.showItems();
    }
  };

  // stuff it all into a jQuery method!
  $.fn.pagify = function(perPage, itemSelector) {
    var el = $(this);
    var items = $(itemSelector, el);

    // default perPage to 5
    if (isNaN(perPage) || perPage === undefined) {
      perPage = 3;
    }

    // don't fire if fewer items than perPage
    if (items.length <= perPage) {
      return true;
    }

    pagify.init(el, items, perPage);
  };
})(jQuery);

$(".container").pagify(2, ".single-item");

</script>
</body>
</html>
