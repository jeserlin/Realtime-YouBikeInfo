//======parameter======
var map;
var myPosition = {
	lat : 25.0329694,
	lng : 121.5654177
};
var myPositionCycle;
var mode = mode || "all";
var infowindow;
var markerMap = new Map();
var infowindowMap = new Map();
// ======functions======
$(function () {
	$('[data-toggle="tooltip"]').tooltip()
})
function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : 25.0329694,
			lng : 121.5654177
		},
		fullscreenControl : false,
		mapTypeControlOptions : false,
		streetViewControl: false,
		zoom : 15
	});
	getData();
}
function getData() {
	if(markerMap.size != 0) {
		for (var [key, value] of markerMap) {
			value.setMap(null);
		}
	}
	$.ajax({
		url : 'youBike/getYouBikeData',
		type : 'POST',
		success : function(res) {
			if (!res.success) {
				console.log("ajax success, status failed.");
				return;
			}
			createMarkers(res.data);
		},
		error : function(qXHR, textStatus, errorThrown) {
			console.log(textStatus, errorThrown);
		}
	})
}
function createMarkers(data) {
	for (i in data) {
		var marker = new google.maps.Marker({
			icon : {
				url : 'images/bike.png',
				scaledSize : new google.maps.Size(32, 32)
			},
			position : {
				lat : data[i].lat,
				lng : data[i].lng
			},
			map : map,
			site : data[i].sna,
			ar : data[i].ar,
			tot : data[i].tot,
			sbi : data[i].sbi,
			bemp : data[i].bemp,
			mday : data[i].mday,
			bStatus : Number(data[i].sbi) < 0 ? 0 : 1,
			rStatus :Number(data[i].bemp) < 0 ? 0 : 1
		});
		//change icon by status
		for (var [key, value] of markerMap) {
			if(value.bStatus == 0 || value.rStatus == 0) {
				value.setIcon({
					url : 'images/bike_org.png',
					scaledSize : new google.maps.Size(32, 32)
				});
			}
		}
		// listener
		google.maps.event.addListener(marker, 'mouseover', function() {
			infowindow = new google.maps.InfoWindow();
			infowindow.setContent("<div>場站名稱 : " + this.site + "</div>"
					+ "<div>地址 : " + this.ar + "</div>"
					+ "<div>可借車數 : " + this.sbi + "/" + this.tot + "</div>"
					+ "<div>可停空位 : " + this.bemp + "/" + this.tot + "</div>"
					+ "<div>更新時間 : " + convertDate(this.mday) + "</div>"
					);
			infowindow.open(map, this);
		});
		google.maps.event.addListener(marker, 'mouseout', function() {
			infowindow.close(map, this);
		});
		markerMap.set(data[i].sno, marker);
		infowindowMap.set(data[i].sno, infowindow);
	}
	if(mode == "near") {
		updateCircle();
	}
}
function toMyPosition() {
	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			myPosition = {
					lat: position.coords.latitude,
					lng: position.coords.longitude
			};
			map.setCenter(myPosition);
			map.setZoom(17);
		}, function() {
			alert("Sorry, Geolocation is not supported by your browser.");
		});
	} else {
		// Browser doesn't support Geolocation
		alert("Sorry, Geolocation is not supported by your browser.");
	}
}
function nearMyPosition() {
	if(myPositionCycle) {
		myPositionCycle.setMap(null);
	}
	//toMyPosition();
	if(myPosition) {
		mode = "near";
		map.panTo(myPosition);
		myPositionCycle = new google.maps.Circle({
			draggable: true,
			strokeColor: '#FF0000',
			strokeOpacity: 0.8,
			strokeWeight: 2,
			fillColor: '#FF0000',
			fillOpacity: 0.35,
			center: myPosition,
			radius: 500,
			map: map
		});
		updateCircle();
		myPositionCycle.addListener('dragend', function() {
			map.panTo(myPositionCycle.center);
			updateCircle();
		});
	}
}
function updateCircle() {
	for (var [key, value] of markerMap) {
		var markPosition = {lat:value.position.lat(), lng:value.position.lng()};
		var isInCircle = myPositionCycle.getBounds().contains(markPosition);
		if(isInCircle) {
			value.setMap(map);
		} else {
			value.setMap(null);
		}
	}
}
function reset() {
	mode = "all";
	if(myPositionCycle) {
		myPositionCycle.setMap(null);
		for (var [key, value] of markerMap) {
			value.setMap(map);
		}
	}
}
function convertDate(date) {
	var year = date.substring(0, 4);
	var month = date.substring(4, 6);
	var day = date.substring(6, 8);
	var hour = date.substring(8, 10);
	var min = date.substring(10, 12);
	var sec = date.substring(12, 14);
	return year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;
}
// update data every 5 minute.
setInterval(function() {
	var d = new Date();
	var minute = d.getMinutes();
	var second = d.getSeconds();
	if (minute % 5 == "0" && second == "0") {
		getData();
	}
}, 1000);