<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
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
<link rel="shortcut icon" type="image/x-icon" href="resources/images/favicon.png" />

<!-- PAGE TITLE HERE -->
<title>JobBoard - HTML Template</title>

<!-- MOBILE SPECIFIC -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--[if lt IE 9]>
	<script src="js/html5shiv.min.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->

<!-- STYLESHEETS -->
<link rel="stylesheet" type="text/css" href="resources/css/plugins.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/css/templete.css">
<link class="skin" rel="stylesheet" type="text/css"
	href="resources/css/skin/skin-1.css">
<link rel="stylesheet"
	href="resources/plugins/datepicker/css/bootstrap-datetimepicker.min.css" />
<!-- Revolution Slider Css -->
<link rel="stylesheet" type="text/css"
	href="resources/plugins/revolution/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="resources/plugins/revolution/revolution/css/settings.css">
<link rel="stylesheet" type="text/css"
	href="resources/plugins/revolution/revolution/css/navigation.css">
<!-- Revolution Navigation Style -->
</head>
<body>
<div class="page-wraper">
<header class="site-header mo-left header fullwidth">
			<!-- main header -->
			<div class="sticky-header main-bar-wraper navbar-expand-lg">
				<div class="main-bar clearfix">
					<div class="container clearfix">
						<!-- website logo -->
						<div class="logo-header mostion">
							<a href="index-2.html"><img src="resources/images/logo.png" class="logo" alt=""></a>
						</div>
						<!-- nav toggle button -->
						<!-- nav toggle button -->
						<button class="navbar-toggler collapsed navicon justify-content-end" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
							<span></span>
							<span></span>
							<span></span>
						</button>
						<!-- extra nav -->


						<!-- Quik search -->
						<div class="dez-quik-search bg-primary">
							<form action="#">
								<input name="search" value="" type="text" class="form-control" placeholder="Type to search">
								<span id="quik-search-remove"><i class="flaticon-close"></i></span>
							</form>
						</div>
						<!-- main nav -->

						<nav class="navbar navbar-inverse">
							<div class="container-fluid header-nav" id="navbarNavDropdown">

								<ul class="nav navbar-nav">
									<li class="active"><a href="loginSuccessPath">User Home <span class="caret"></span></a>
									<li class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#">User Profile <span class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="getJobSeekerPath" class="dez-page">Update Profile</a></li>
											
										</ul>
									</li>
									<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Education<span class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="regEduPath" class="dez-page">Register Education</a></li>
											<li><a href="getEduPath?frmId=${userLogin.loginId}" class="dez-page">View Euducation</a></li>
										</ul>
									</li>					
									<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Experience <span class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="regWorkExpPath" class="dez-page">Register Work Experience</a></li>
											<li><a href="getExpPath?frmId=${userLogin.loginId}" class="dez-page">View Work Experience</a></li>
										</ul>
									</li>	

									<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Jobs <span class="caret"></span></a>
										<ul class="sub-menu"">
											<li><a href="getAllRecruitersPath?frmRole=jobSeeker" class="dez-page">View Companies</a></li>
											<li><a href="viewJobPath" class="dez-page">View Job Posts</a></li>
											<li><a href="getAllAppPath" class="dez-page">View Application</a></li>
										</ul>
									</li>

								</ul>

								<ul class="nav navbar-nav navbar-right">


									<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${userLogin.username } <span class="caret"></span></a>
										<ul class="sub-menu">
											<li><a href="logOutPath" class="dez-page">Logout</a></li>
											<li><a href="deactivatePath" class="dez-page">Deactive</a></li>

										</ul>
									</li>

								</ul>
							</div>
						</nav>

						<!-- main header END -->
					</header>
    <!-- header END -->
	<section id="pricing" class="std-section">

		<div class="container">

			<h2 class="std-title m-b5">Choose Your Best Plan</h2>
			<br> <br> <br> <br>
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-5">
					<sform:form modelAttribute="orderDetail" action="authorize_payment"
						method="post">
						<div class="pricing-box mg-bt">
							<input type="hidden" name="recruiterId" value="${recruiterId}" />

							<div class="main-bg-color price-bar active">

								<span class="price">$100</span> <span class="duration">Per
									Month</span>

							</div>
							<!--main-bg-color-->
							<input type="hidden" name="service" value="monthly" /> <input
								type="hidden" name="subtotal" value="100" /> <input
								type="hidden" name="discount" value="0" /> <input type="hidden"
								name="total" value="100" />


							<ul class="item-wrapper">

								<li>Product/Service-Monthly</li>
								<li>Sub Total-$100</li>
								<li>Discount-$0</li>
								<li>Total Amount-$100</li>
								<li>Developer Care</li>
							</ul>

							<input type="submit" name="save" value="Choose Plan"
								class="btn btn-primary" />
						</div>
						<!--.pricing-box-->
					</sform:form>
				</div>

				<div class="col-md-5">
					<sform:form modelAttribute="orderDetail" action="authorize_payment"
						method="post">
						<div class="pricing-box mg-bt">
						<input type="hidden" name="recruiterId" value="${recruiterId}" />
						
							<div class="main-bg-color price-bar">

								<span class="price">$1200</span> <span class="duration">Per
									Year</span>

							</div>
							<!--main-bg-color-->
							<input type="hidden" name="service" value="yearly" /> <input
								type="hidden" name="subtotal" value="1200" /> <input
								type="hidden" name="discount" value="0" /> <input type="hidden"
								name="total" value="1200" />
							<ul class="item-wrapper">

								<li>Product/Service-Yearly</li>
								<li>Sub Total-$1200</li>
								<li>Discount-$0</li>
								<li>Total Amount-$1200</li>
								<li>Developer Care</li>
							</ul>
							<input type="submit" name="save" value="Choose Plan"
								class="btn btn-primary" />

						</div>
						<!--.pricing-box-->
						<div class="col-md-1"></div>
					</sform:form>
				</div>

			</div>
			<!--row-->

		</div>
		<!--container-->

	</section>
	<!--pricing-->
	<!-- JAVASCRIPT FILES ========================================= -->
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
<script src="<c:url value="resources/js/recaptcha/api.js"/>"></script> <!-- Google API For Recaptcha  -->
<script src="<c:url value="resources/js/dz.ajax.js"/>"></script><!-- CONTACT JS  -->
<script src="<c:url value="resources/plugins/paroller/skrollr.min.js"/>"></script><!-- PAROLLER -->
</body>
</html>