<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
	
	<!-- FAVICONS ICON -->
	<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" >
	<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.png">
	
	<!-- PAGE TITLE HERE -->
	<title>JobBoard - HTML Template</title>
	
	<!-- MOBILE SPECIFIC -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="js/html5shiv.min.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<!-- STYLESHEETS -->
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/plugins.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/style.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/templete.css"/>">
	<link class="skin" rel="stylesheet" type="text/css" href="<c:url value="resources/css/skin/skin-1.css"/>">
	<link rel="stylesheet" href="<c:url value="resources/plugins/datepicker/css/bootstrap-datetimepicker.min.css"/>">
	<!-- Revolution Slider Css -->
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/plugins/revolution/revolution/css/layers.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/plugins/revolution/revolution/css/settings.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/plugins/revolution/revolution/css/navigation.css"/>">
	<!-- Revolution Navigation Style -->
</head>
<body id="bg">
<div class="page-wraper">
<div id="loading-area"></div>
    <!-- header -->
    <header class="site-header mo-left header fullwidth">
		<!-- main header -->
        <div class="sticky-header main-bar-wraper navbar-expand-lg">
            <div class="main-bar clearfix">
                <div class="container clearfix">

                    <!-- main nav -->
                    <div class="header-nav navbar-collapse collapse justify-content-start" id="navbarNavDropdown">
                        <ul class="nav navbar-nav">
							
							<li><a href="#" class="dez-page">Mya Theint Job Portal</a></li>
								
							<li class="active">
								<a href="#">Register <i class="fa fa-chevron-down"></i></a>
								<ul class="sub-menu">
									<li><a href="regJobSeekerPath" class="dez-page">Job Seeker?</a></li>
									<li><a href="regRecruiterPath" class="dez-page">Recruiter?</a></li>
								</ul>
							</li>								

								
						
						</ul>			
                    </div>
                </div>
            </div>
        </div>
        <!-- main header END -->
    </header>
    <!-- header END -->
    <!-- Content -->
   
        <!-- inner page banner END -->
        <!-- contact area -->
        <div class="section-full content-inner-2 shop-account">
            <!-- Product -->
            <div class="container">
                <!--  <div class="row">
					<div class="col-md-12 text-center">
						<h3 class="font-weight-700 m-t0 m-b20">Login Your Account</h3>
					</div> -->
				</div>
                <div>
					<div class="max-w400 m-auto m-b20">
						<div class="p-a30 border-1 seth">
							<div class="tab-content nav">
								<sform:form id="login" class="tab-pane active col-12 p-a0 " modelAttribute="loginModel" action="loginPath" method="post">
								
									<h4 class="font-weight-700">LOGIN</h4>
									<p class="font-weight-600">If you have an account with us, please log in.</p>
									<div class="form-group">
										<label class="font-weight-700">E-MAIL *</label>
										<sform:input name="dzName" required="" class="form-control" path="frmEmail" placeholder="Your Email Id" type="text" />
										
									</div>
									<div class="form-group">
										<label class="font-weight-700">PASSWORD *</label>
										<sform:input name="dzName" required="" class="form-control " placeholder="Type Password" type="password" path="frmPassword"/>
										
									</div>
									<div class="text-left">
										<button class="site-button m-r5 button-lg">login</button>
						
									</div>
								</sform:form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
            <!-- Product END -->
		</div>
		<!-- contact area  END -->
    </div>
    <!-- Content END-->
    <!-- Footer -->
    <footer class="site-footer">
        <div class="footer-top">
            <div class="container">
                <div class="row">
					<div class="col-xl-5 col-lg-4 col-md-12 col-sm-12">
                        <div class="widget">
                            <img src="images/logo-white.png" width="180" class="m-b15" alt=""/>
							<p class="text-capitalize m-b20">Lorem Ipsum is simply dummy text of the printing and typesetting industry has been the industry's standard dummy text ever since the..</p>
                            <div class="subscribe-form m-b20">
								<form class="dzSubscribe" action="http://job-board.w3itexperts.com/xhtml/script/mailchamp.php" method="post">
									<div class="dzSubscribeMsg"></div>
									<div class="input-group">
										<input name="dzEmail" required="required"  class="form-control" placeholder="Your Email Id" type="email">
										<span class="input-group-btn">
											<button name="submit" value="Submit" type="submit" class="site-button radius-xl">Subscribe</button>
										</span> 
									</div>
								</form>
							</div>
							<ul class="list-inline m-a0">
								<li><a href="#" class="site-button white facebook circle "><i class="fa fa-facebook"></i></a></li>
								<li><a href="#" class="site-button white google-plus circle "><i class="fa fa-google-plus"></i></a></li>
								<li><a href="#" class="site-button white linkedin circle "><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#" class="site-button white instagram circle "><i class="fa fa-instagram"></i></a></li>
								<li><a href="#" class="site-button white twitter circle "><i class="fa fa-twitter"></i></a></li>
							</ul>
                        </div>
                    </div>
					<div class="col-xl-5 col-lg-5 col-md-8 col-sm-8 col-12">
                        <div class="widget border-0">
                            <h5 class="m-b30 text-white">Frequently Asked Questions</h5>
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
                    <div class="col-lg-12 text-center"><span><a target="_blank" href="https://www.templateshub.net">Templates Hub</a></span></div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer END -->
    <button class="scroltop fa fa-chevron-up" ></button>
</div>
<!-- JAVASCRIPT FILES ========================================= -->
<script src="<c:url value="resources/js/jquery.min.js"/>"></script><!-- JQUERY.MIN JS -->
<script src="<c:url value="resources/plugins/wow/wow.js"/>"></script><!-- WOW JS -->
<script src="<c:url value="resources/plugins/bootstrap/js/popper.min.js"/>"></script><!-- BOOTSTRAP.MIN JS -->
<script src="<c:url value="resources/plugins/bootstrap/js/bootstrap.min.js"/>"></script><!-- BOOTSTRAP.MIN JS -->
<script src="<c:url value="resources/plugins/bootstrap-select/bootstrap-select.min.js"/>"></script><!-- FORM JS -->
<script src="<c:url value="resources/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"/>"></script><!-- FORM JS -->
<script src="<c:url value="resources/plugins/magnific-popup/magnific-popup.js"/>"></script><!-- MAGNIFIC POPUP JS -->
<script src="<c:url value="resources/plugins/counter/waypoints-min.js"/>"></script><!-- WAYPOINTS JS -->
<script src="<c:url value="resources/plugins/counter/counterup.min.js"/>"></script><!-- COUNTERUP JS -->
<script src="<c:url value="resources/plugins/imagesloaded/imagesloaded.js"/>"></script><!-- IMAGESLOADED -->
<script src="<c:url value="resources/plugins/masonry/masonry-3.1.4.js"/>"></script><!-- MASONRY -->
<script src="<c:url value="resources/plugins/masonry/masonry.filter.js"/>"></script><!-- MASONRY -->
<script src="<c:url value="resources/plugins/owl-carousel/owl.carousel.js"/>"></script><!-- OWL SLIDER -->
<script src="<c:url value="resources/plugins/rangeslider/rangeslider.js"/>"></script><!-- Rangeslider -->
<script src="<c:url value="resources/js/custom.js"/>"></script><!-- CUSTOM FUCTIONS  -->
<script src="<c:url value="resources/js/dz.carousel.js"/>"></script><!-- SORTCODE FUCTIONS  -->
<script src="<c:url value="resources/js/dz.ajax.js"/>"></script><!-- CONTACT JS  --> 

</body>


</html>
