<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Realtime YouBike Info.</title>
	
	<!-- CSS -->
	<link href="plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/youBike.css" rel="stylesheet" media="screen">
	<!-- Js -->
	<script src="plugin/jquery/js/jquery-3.3.1.min.js"></script>
	<script src="plugin/bootstrap/js/bootstrap.min.js"></script>
	<script defer src="plugin/fontawsome-5.0.6/fontawesome-all.min.js"></script>
	<script src="js/youBike.js"></script>
</head>
<body>
	<nav class="navbar sticky-top text-white bg-info">
		<a class="navbar-brand">
			<i class="fas fa-bicycle"></i>
			Real-time YouBike Info.
		</a>
	</nav>
	<div style="position:absolute;z-index: 1;right:2%;top: 100px;">
		<div class="fa-2x pointer" onclick="toMyPosition()">
			<button type="button" class="btn btn-deepPink btn-lg">
				<i class="fas fa-crosshairs"></i>
			</button>
		</div>
		<div class="pt-3 fa-2x pointer">
			<button type="button" class="btn btn-deepPink btn-lg" style="width:54px;">
				<i class="fa-invers fas fa-bicycle"></i>
			</button>
		</div>
		<div class="pt-3 fa-2x pointer">
			<button type="button" class="btn btn-deepPink btn-lg">
				<i class="fab fa-product-hunt"></i>
			</button>
		</div>
	</div>
	<div id="map"></div>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8ti6B8D8eQxk8ZJhi8Tik0esCjddSvmY&libraries=visualization&callback=initMap"></script>
</body>
</html>