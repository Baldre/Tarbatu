var canvas, ctx;
var rect = { x: 40, y: 40, radius: 60, width: 40, height: 40, v: 2 };
var mousepos = { x: 100, y: 100 };

function initMain() {
    canvas = document.querySelector("#backg");  //PEAB LISAMA
    ctx = canvas.getContext("2d");
    window.addEventListener("mousemove", function (evt) { mousepos = getMousePos(canvas, evt); }, false);
    window.addEventListener("resize", resizeCanvas, false);

    resizeCanvas();
    mainloop();

    log("Uus Javascript edukalt lisatud");
    console.log("test");
}

function resizeCanvas() {
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;
}

function mainloop() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    var angle = Math.atan2((rect.y - mousepos.y), (rect.x - mousepos.x));

    rect.x -= rect.v * Math.cos(angle);
    rect.y -= rect.v * Math.sin(angle);

    drawRectangle(angle);
    window.requestAnimationFrame(mainloop);
}

function drawRectangle(angle) {
    ctx.save();
    ctx.translate(rect.x, rect.y);
    ctx.rotate(angle);
    ctx.translate(-rect.width / 2, -rect.height / 2);
    ctx.fillStyle = "dimgray";  //ctx.createPattern(logo, "repeat");
    ctx.fillRect(0, 0, rect.width, rect.height);
    ctx.restore();
}

function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

function log(message) {
    console.log(message);
}