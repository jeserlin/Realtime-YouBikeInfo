# Realtime- YouBike information
<div class="col-sm-12">
  <img class="col-sm-6" src="https://github.com/jeserlin/Realtime-YouBikeInfo/blob/master/img/near-me.png" width="300">
  <img class="col-sm-6" src="https://github.com/jeserlin/Realtime-YouBikeInfo/blob/master/img/youbike.png" width="300">
</div>

Realtime- YouBike information uses Google Map as base.</br>
It shows realtime Youbike data from Data.Taipei.(open data from Taipei government, Taiwan)</br>
* Data.Taipei :</br>
http://data.taipei</br>
* Realtime youbike data:</br>
http://data.taipei/opendata/datalist/datasetMeta?oid=8ef1626a-892a-4218-8344-f7ac46e1aa48

## I'm using:

* Java 8
* Google Map API
* Javascript ES6
* Jquery 3.3.1
* Bootstrap 4.0

## Features:

### 1.Realtime YouBike inforamtion in Taipei City
From this map, you can see all bike stops showing on the map as markers.</br>
Move the mouse on top of the marker will show up an infowindow with realtime YouBike information,
which contains:

* Site Name</br>
* Site Address</br>
* Available Bikes Number</br>
* Residual Space</br>
* Lastest Update Time</br>

### 2.Different colors of marker
On the map, there are two differend colors of markers.</br>
One is green, another is orange.</br>
The former represents there are available Bikes and space in the YouBike site, and vice versa.

### 3.My Position
My Position will change the center of the map to the geographical position of user.</br>
But this does not work in Safari with localhost :(</br>
Use Chrome to try this out!

### 4.Near-Me
Near-ME will take the geographical position of user as center and draw a circle with a radius of 500 meters on the map.</br>
It will only shows the Youbike sites which are in the range and it's draggable.</br>

