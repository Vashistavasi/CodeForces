//import *  as readline from "readline";
//
//const rl = readline.createInterface(
//{
//input: process.stdin,
//output: process.stdout,
//terminal: true
//});
//
//rl.setPrompt("> ");
//rl.prompt();
//rl.on("line", (line) => {
//console.log(" Give input is " + line)
//rl.setPrompt("> ");
//rl.prompt();
//});
//rl.on("close", () => process.exit(0));
//
import * as fs from "fs";

let tokens: string[] = fs.readFileSync(0, "utf8").trim().split(/\s+/);

let ti = 0;

while (ti < tokens.length) {
  console.log(" the tokens at pos " + ti + " : is " + tokens[ti++]);
}
