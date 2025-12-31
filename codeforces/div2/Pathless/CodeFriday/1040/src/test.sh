#!/usr/bin/env bash
# Demonstration equivalent to Java test() method
# Reads one line, echoes it, shows basic constructs, sorts an array
set -euo pipefail

# Input / echo
read -r line || line=""
echo "$line"

# "Datatypes" (all vars are strings/integers as needed in bash)
ai=1
small_double=0.001
f=0.1
st="What"
ch="c"

# Loops
n=10
for ((i=0;i<n;i++)); do
  : # no-op
done

a=0
while (( a < n )); do
  ((a++))
done

a=0
# do..while equivalent
until (( a >= n )); do
  ((a++))
done

# if / elif / else
if (( a == 0 )); then
  :
elif (( a == 1 )); then
  :
else
  :
fi

# case (switch)
case $a in
  0) : ;;
  1) : ;;
  2) : ;;
  *) : ;;
esac

# List + sort (simulate ArrayList + Collections.sort)
arr=(5 2 9 1)
IFS=$'\n' sorted=($(sort -n <<<"${arr[*]}"))
unset IFS
printf 'Sorted: %s\n' "${sorted[*]}"
