<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Instant Rain Fall</title>

<!-- CSS -->
<link href="css/youBike.css" rel="stylesheet" media="screen">
<!-- Js -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	function initMap() {
		map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 25.0329694,
				lng : 121.5654177
			},
			zoom : 13
		});
		$.ajax({
			url: 'youBike/getYouBikeData',
			success: function(res) {
				console.log(res);
			},
			error: function(){
				console.log('Fail to connect.');
			}
		})
	}
</script>
</head>
<body>
	<div id="map"></div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8ti6B8D8eQxk8ZJhi8Tik0esCjddSvmY&libraries=visualization&callback=initMap"></script>
</body>
</html>