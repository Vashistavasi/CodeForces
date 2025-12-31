"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var fs = require("fs");
// const rl = readline.createInterface({
//   input: process.stdin,
//   output: process.stdout,
//   terminal: true,
// });
// rl.setPrompt(">");
// rl.prompt();
// rl.on("line", (line) => {
//   //console.log("The input is " + line);
// });
// rl.on("exit", () => {
//   process.exit();
// });
// rl.prompt();
var tokens = fs.readFileSync(0, "utf8").trim().split(/\s+/);
//console.log(tokens);
//for(let i=0;i<tokens.length;i++){
////console.log("The current string is "+ i + " tokens: "+ tokens[i]);
//}
var ti = 0;
var t = Number(tokens[ti++]);
//console.log("total test cases " + t);
while (t-- > 0) {
    //console.log("current test case num : " + t);
    var n = Number(tokens[ti++]);
    var array = [];
    var z = 0;
    var sum = 0;
    for (var i = 0; i < n; i++) {
        var val = Number(tokens[ti++]);
        array.push(val);
        sum += val;
        if (val === 0)
            z++;
    }
    //console.log("The array " + array);
    sum += z;
    console.log(sum);
}
