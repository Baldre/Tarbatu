function initMain(){
    var centerpos = new google.maps.LatLng(58.378240, 26.714709);
    var mapProp = {
        center: centerpos,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        disableDefaultUI: true,
        zoom:10
    };
    var map = new google.maps.Map(document.querySelector("#map"), mapProp);
    var marker = new google.maps.Marker({position: centerpos, map: map, title: "Home. At least it used to be."});
}