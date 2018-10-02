var koht;

function initMain(){
    koht = document.querySelector("#pilt");
    var pilt = document.createElement("img");
    pilt.id = "pilt";
    pilt.src = "images/smile.png";
    pilt.style.width = "100px";
    pilt.style.height = "100px";
    pilt.alt = "I'm so happy";
    pilt.setAttribute("onclick", "pildiKlikk();");
    pilt.onclick = function(){
        pildiKlikk();
    }

    koht.appendChild(pilt);
}

function pildiKlikk() {
    document.querySelector("#pilt").remove();
    koht.remove();
}