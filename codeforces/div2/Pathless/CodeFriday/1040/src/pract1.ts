const fs = require("fs");

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

let tokens = fs.readFileSync(0, "utf8").trim().split(/\s+/);
//console.log(tokens);

//for(let i=0;i<tokens.length;i++){
////console.log("The current string is "+ i + " tokens: "+ tokens[i]);
//}
let ti = 0;
let t = Number(tokens[ti++]);
//console.log("total test cases " + t);

while (t-- > 0) {
  //console.log("current test case num : " + t);
  let n = Number(tokens[ti++]);
  let array = [];
  let z = 0;
  let sum = 0;
  for (let i = 0; i < n; i++) {
    let val = Number(tokens[ti++]);
    array.push(val);
    sum += val;
    if (val === 0) z++;
  }
  //console.log("The array " + array);
  sum += z;
  console.log(sum);
}
