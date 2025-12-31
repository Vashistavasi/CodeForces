AGENTS quick guide for this repo

Build/lint/test
- Java solutions: compile and run with JDK 17+
  - Compile: javac -encoding UTF-8 -Xlint:all src/**/*.java
  - Run (example): java -cp src Pathless.CodeFriday._1040.src.Main (or run the specific class with main)
- TypeScript/Node snippets under this folder
  - Install: npm ci
  - Build TS: npx tsc (tsconfig inferred); outputs to same dir if no outDir
  - Tests: no framework configured; current script fails by design. To run a single file: node test.js, node pathless.js, or npx ts-node file.ts
- Shell helpers exist (e.g., pathless.sh, test.sh): bash ./test.sh

Code style
- Keep competitive-programming style self-contained per problem. Avoid repo-wide dependencies unless requested.
- Imports/IO (Java): prefer custom FastScanner + PrintWriter; avoid java.util.Scanner. See *$FastScanner.java classes.
- Formatting: 2 spaces or tabs consistently per file; <=120 cols; no trailing spaces; newline at EOF.
- TypeScript: strict typing, avoid any; use const, readonly, explicit function returns; ES module or commonjs consistent with package.json (currently commonjs).
- Naming: Main.java or Solve.java entry point; camelCase for vars/functions; PascalCase for classes/types; files named per problem.
- Errors: predictable exits over exceptions; minimize logging; in Java, catch top-level and print one message if needed.
- Tests: sample IO in .txt files nearby; run programs via stdin redirection: java ... < input.txt or node file.js < input.txt.
- Linting: none configured; if adding, prefer ESLint + prettier (TS) with minimal rules; do not break existing contest code.
- Cursor/Copilot: No .cursor/rules, .cursorrules, or .github/copilot-instructions.md found; if added later, mirror key rules here.

Agent tips
- Check package.json here before adding packages. Keep fast, no heavy installs.
- If introducing a test runner (vitest/jest), add scripts and document single-test invocation (e.g., npm test -- file.spec.ts) here.
