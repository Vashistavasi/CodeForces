// Pathless/CodeFriday/1040/src/pathless.ts

const readline = require('readline');

function shuffleArray(arr) {
    let z = 0, o = 0, t = 0;
    for (const i of arr) {
        if (i === 0) z++;
        else if (i === 1) o++;
        else if (i === 2) t++;
    }
    const ans = [];
    for (let i = 0; i < z; i++) ans.push(0);
    for (let i = 0; i < t; i++) ans.push(2);
    for (let i = 0; i < o; i++) ans.push(1);
    return ans;
}

function pathless(inputLines) {
    let idx = 0;
    const t = parseInt(inputLines[idx++]);
    for (let tc = 0; tc < t; tc++) {
        const [n, s] = inputLines[idx++].split(' ').map(Number);
        const arr = inputLines[idx++].split(' ').map(Number);
        const sum = arr.reduce((a, b) => a + b, 0);
        if (s < sum) {
            console.log(arr.join(' '));
        } else if (s - sum === 1) {
            const ans = shuffleArray(arr);
            console.log(ans.join(' '));
        } else {
            console.log(-1);
        }
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: false
});

const inputLines = [];
rl.on('line', line => inputLines.push(line));
rl.on('close', () => pathless(inputLines));