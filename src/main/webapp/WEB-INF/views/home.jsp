<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Travelify - Your friend while travelling...</title>

<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700'
	rel='stylesheet' type='text/css'>
<link href="resources/css/bootplus.css" rel="stylesheet">
<link href="resources/css/bootplus-responsive.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/indx.css" rel="stylesheet">
</head>

<body>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=616758735053201";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<!-- Side Menu -->
	<a id="menu-toggle" href="#" class="btn btn-primary btn-lg toggle"><i
		class="icon-bars"></i></a>
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#"
				class="btn btn-default btn-lg pull-right toggle"><i
				class="icon-times"></i></a>
			<li class="sidebar-brand"><a href="/home">Travelify</a></li>
			<li><a href="#travelicity">TraveliCity</a></li>
		</ul>
	</div>
	<!-- /Side Menu -->

	<!-- Full Page Image Header Area -->
	<div id="top" class="header">
		<div class="vert-text">
			<h1>Travelify - Your friend while Traveling</h1>
			<h2>
				<em>The complete Social Travel solutions to discover new
					places, explore your neighborhood</em> <a href="quickguide.htm"
					class="btn btn-primary">Quick Guide</a>
			</h2>
			<a href="/Travelify/travelicity" class="btn btn-large btn-success">Find
				Out More</a>
			<p>
				<a href="https://plus.google.com/105290147585059896473"
					rel="publisher"><b>Google+</b></a>
			</p>
		</div>
	</div>
	<!-- /Full Page Image Header Area -->

	<div id="travelicity" class="intro">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<h2>Don't get lost while traveling... Find the best places and
						explore new cities...</h2>
					<p class="lead">
						With TraveliCity you can explore new cities, find popular places
						and clip it for future travel <a class="btn btn-primary btn-large"
							href="/travelicity/">TraveliCity &raquo;</a>
					</p>
					<p class="lead">
						With TraveliNearby quickly find your location and find popular
						places, restaurants easily <a class="btn btn-warning btn-large"
							href="/travelinearby/">TraveliNearby &raquo;</a>
					</p>

					<p>
						<img src="resources/img/cityguide.png"
							class="img-polaroid guide-img" /> &nbsp;&nbsp;&nbsp;&nbsp;<img
							src="resources/img/travelinearby.png"
							class="img-polaroid guide-img" />
					</p>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer ======================================================================================================================================================================= -->
	<footer class="footer">
		<div class="container">
			<p>
				<b>Nearby, City and Location place data is powered by <a
					href="https://developers.google.com/places/">Google Places API</a></b>
			</p>
			<p>
				<b>Location Map by <a href="https://developers.google.com/maps/">Google
						Maps API V3</a>, Street View is powered by <a
					href="https://developers.google.com/maps/documentation/javascript/streetview">Google
						Street View API</a>, Static Map image is powered by <a
					href="https://developers.google.com/maps/documentation/staticmaps/">Google
						Static Maps API</a> Data store by <a
					href="https://developers.google.com/appengine/docs/java/datastore/">Google
						App Engine Datastore API</a></b>
			</p>
			<p>
				<b>Technology Stack: <a
					href="https://developers.google.com/appengine/">Google App
						Engine</a>, <a href="https://code.google.com/p/google-gson/">Google
						GSON Parsing library</a>, <a
					href="http://projects.spring.io/spring-framework/">Spring 3 MVC
						Framework</a></b>
			</p>
		</div>
	</footer>

	<!-- JavaScript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>

	<!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->
	<script>
		$("#menu-close").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	</script>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#sidebar-wrapper").toggleClass("active");
		});
	</script>
	<script>
		$(function() {
			$('a[href*=#]:not([href=#])')
					.click(
							function() {
								if (location.pathname.replace(/^\//, '') == this.pathname
										.replace(/^\//, '')
										|| location.hostname == this.hostname) {

									var target = $(this.hash);
									target = target.length ? target
											: $('[name=' + this.hash.slice(1)
													+ ']');
									if (target.length) {
										$('html,body').animate({
											scrollTop : target.offset().top
										}, 1000);
										return false;
									}
								}
							});
		});
	</script>

</body>

</html>