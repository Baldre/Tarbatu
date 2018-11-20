var ajaxHoidja = document.getElementById("ajax");
var btn = document.getElementById("btn");

btn.addEventListener("click", function () {
    var request = new XMLHttpRequest();
    request.open("GET", "https://raw.githubusercontent.com/Baldre/Tarbatu/master/src/main/resources/static/js/loojad.json");
    request.onload = function () {
        var data = JSON.parse(request.responseText);
        renderHTML(data);
    };
    request.send();
    btn.classList.add("hide-me");
});

function renderHTML(info) {
    var htmlString = "";

    for(i = 0; i < info.length; i++){
        htmlString += "<p>" + info[i].nimi;
    }

    ajaxHoidja.insertAdjacentHTML("beforeend", htmlString );
}
