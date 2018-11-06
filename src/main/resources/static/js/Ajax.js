var ajaxHoidja = document.getElementById("ajax");
var btn = document.getElementById("btn");

btn.addEventListener("click", function () {
    var request = new XMLHttpRequest();
    request.open("GET", "https://learnwebcode.github.io/json-example/animals-1.json");
    request.onload = function () {
        var data = JSON.parse(request.responseText);
        renderHTML(data);
    };
    request.send();
});

function renderHTML(info) {
    var htmlString = "";

    for(i = 0; i < info.length; i++){
        htmlString += "<p>" + info[i];
    }

    ajaxHoidja.insertAdjacentHTML("beforeend", htmlString );
}
