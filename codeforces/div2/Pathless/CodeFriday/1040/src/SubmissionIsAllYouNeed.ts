// Optional Interactive (readline) Template
// Usage: npx ts-node src/SubmissionIsAllYouNeed.ts --interactive
// This lets you type input line-by-line instead of piping a whole file.
// Keeps the buffered (fs.readFileSync) approach below unchanged.
//
// To enable, run with --interactive. Example interactive protocol (expects first line T):
//  3                 <-- number of test cases
//  ... test case 1 tokens ...
//  ... test case 2 tokens ...
//  ... test case 3 tokens ...
// Modify parseInteractiveTestCase() for custom per-test parsing.

import * as readline from "readline";

const INTERACTIVE = process.argv.includes("--interactive");

// Shared token helpers (populated differently in interactive vs batch)
let tokens: string[] = [];
let ti = 0;
const next = (): string => tokens[ti++] ?? "";
const ni = (): number => Number(next());
const nl = (): bigint => BigInt(next());
const ns = (): string => next();

// ----- Interactive Mode Implementation -----
function startInteractive() {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    terminal: true,
  });

  let T = -1; // number of test cases
  let currentCase = 0;
  const out: string[] = [];

  // Customize how to decide a test case is fully read.
  function parseInteractiveTestCase(): string | null {
    // Example: each test case is a single line echoed back prefixed by Case#
    // Adjust logic for your real problem (e.g., wait until tokens length >= needed count, etc.)
    if (tokens.length - ti >= 1) {
      const lineToken = next();
      return `Case#${currentCase}: ${lineToken}`;
    }
    return null; // need more data
  }

  rl.setPrompt("> ");
  rl.prompt();

  rl.on("line", (line) => {
    const parts = line.trim().length ? line.trim().split(/\s+/) : [];
    // First line: number of test cases
    if (T < 0) {
      if (parts.length === 0) {
        rl.prompt();
        return;
      }
      T = Number(parts[0]);
      if (!Number.isFinite(T) || T <= 0) {
        console.error("Invalid test count");
        rl.close();
        return;
      }
      tokens = tokens.concat(parts.slice(1));
    } else {
      tokens = tokens.concat(parts);
    }

    while (T >= 0 && currentCase < T) {
      const res = parseInteractiveTestCase();
      if (res === null) break; // need more input
      out.push(res);
      currentCase++;
    }

    if (currentCase >= T && T >= 0) {
      console.log(out.join("\n"));
      rl.close();
      return;
    }

    rl.prompt();
  });

  rl.on("close", () => {
    process.exit(0);
  });
}

if (INTERACTIVE) {
  startInteractive();
  // Prevent batch execution of code below.
  // Return so rest of file (batch mode) is skipped.
  // (Using setImmediate to ensure listener setup completes.)
  setImmediate(() => {});
  // End interactive early
  // @ts-ignore intentionally stopping further execution
  if (true) {
    /* interactive mode engaged */
  }
} else {
  // Batch (original) implementation continues below.
}

// Competitive Programming Template (TypeScript)
// Run with: npx ts-node src/SubmissionIsAllYouNeed.ts < input.txt
// Or compile: npx tsc --target ES2020 --module commonjs src/SubmissionIsAllYouNeed.ts && node dist/SubmissionIsAllYouNeed.js < input.txt

import * as fs from "fs";

// -------- Input Scanner --------
// (Re-declare tokens etc ONLY if not interactive)
if (!INTERACTIVE) {
  tokens = fs.readFileSync(0, "utf8").trim().split(/\s+/);
  ti = 0;
}

// Read an array of length n as numbers
const readArr = (n: number): number[] => Array.from({ length: n }, () => ni());

// -------- Utility Helpers --------
const MOD = 1_000_000_007n;
const addMod = (a: bigint, b: bigint, m: bigint = MOD) => (a + b) % m;
const mulMod = (a: bigint, b: bigint, m: bigint = MOD) => (a * b) % m;
const powMod = (a: bigint, e: bigint, m: bigint = MOD): bigint => {
  let r = 1n,
    x = a % m,
    p = e;
  while (p > 0n) {
    if (p & 1n) r = (r * x) % m;
    x = (x * x) % m;
    p >>= 1n;
  }
  return r;
};

// Fast output collector
const out: string[] = [];

function solveOne(tc: number): void {
  // Example skeleton:
  // const n = ni();
  // const arr = readArr(n);
  // ... compute result ...
  // out.push(result.toString());

  // Placeholder demonstration (echo test case index)
  out.push(`Case#${tc}`);
}

function main() {
  if (tokens.length === 1 && tokens[0] === "") return; // empty input guard
  // If input begins with T test cases:
  // const T = ni();
  // for (let t = 1; t <= T; t++) solveOne(t);
  // console.log(out.join('\n'));

  // If single test (uncomment as needed):
  // solveOne(1);
  // console.log(out.join('\n'));

  // By default, auto-detect: if first token looks like integer count of remaining tokens (common CP style)
  const first = tokens[0];
  if (/^-?\d+$/.test(first)) {
    const possibleT = Number(first);
    // Heuristic: treat as T if enough tokens remain for at least T (not strictly validated)
    if (possibleT >= 1) {
      ti = 1; // consume first as T
      for (let t = 1; t <= possibleT; t++) solveOne(t);
      console.log(out.join("\n"));
      return;
    }
  }
  // Fallback single solve
  solveOne(1);
  console.log(out.join("\n"));
}

main();
