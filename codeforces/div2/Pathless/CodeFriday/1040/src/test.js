#!/usr/bin/env node
// Demonstration equivalent to Java test() method
// Reads one tokenized line (first whitespace-separated piece), echoes it, shows basics, sorts list
const fs = require('fs');

const data = fs.readFileSync(0, 'utf8').trim().split(/\n/);
const line = data.length ? data[0] : '';
console.log(line);

// "Datatypes"
let ai = 1;
let d = 0.001;
let f = 0.1;
let st = 'What';
let ch = 'c';

// Loops
let n = 10;
for (let i = 0; i < n; i++) {
  // no-op
}

let a = 0;
while (a < n) a++;

a = 0;
do {
  a++;
} while (a < n);

// if/else
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

// List + sort (simulate ArrayList + Collections.sort)
let arr = [5, 2, 9, 1];
arr.sort((x, y) => x - y);
console.log('Sorted:', arr.join(' '));
