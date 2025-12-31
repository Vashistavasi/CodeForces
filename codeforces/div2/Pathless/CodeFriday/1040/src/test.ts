#!/usr/bin/env ts-node
// Demonstration equivalent to Java test() method, written in TypeScript
// To run:  npx ts-node src/test.ts < input.txt   (or compile with tsc)

import * as fs from "fs";

const raw: string = fs.readFileSync(0, "utf8");
const lines: string[] = raw.split(/\n/);
const line: string = lines[0] ?? "";
console.log(line);

// "Datatypes"
let ai: number = 1;
let d: number = 0.001;
let f: number = 0.1;
let st: string = "What";
let ch: string = "c";

// Loops
let n: number = 10;
for (let i = 0; i < n; i++) {
  // no-op
}

let a: number = 0;
while (a < n) a++;

a = 0;
do {
  a++;
} while (a < n);

// if / else
if (a === 0) {
} else if (a === 1) {
} else {
}

// switch
switch (a) {
  case 0:
    break;
  case 1:
    break;
  case 2:
    break;
  default:
    break;
}

// Array + sort (simulate ArrayList + Collections.sort)
const arr: number[] = [5, 2, 9, 1];
arr.sort((x, y) => x - y);
console.log("Sorted:", arr.join(" "));

// Example generic function (just to showcase TS generics similar to Java)
function first<T>(xs: T[]): T | undefined {
  return xs[0];
}
console.log("First element:", first(arr));
