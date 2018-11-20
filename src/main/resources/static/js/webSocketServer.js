var ws = require("node.js-websocket");

var server = ws_createServer(function (conn) {
    console.log("New connection");
    conn.on("text", function (str) {
        console.log("Received " +str);
        conn.sendText(str.toUpperCase())
    });
    conn.on("close", function (code, reason) {
        console.log("Connection closed")
    })
}).listen(8090);