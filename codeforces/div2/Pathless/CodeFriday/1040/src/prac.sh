#!/bin/bash

read -r t

echo "the value is $t"

# Collect all elements across all test cases
declare -a all=()

for (( i = 0; i < t; i++ )); do
  read -r n
  sum=0
  z=0
  # Read n numbers (may be provided space-separated on one or more lines)
  declare -a elements=()
  while ((${#elements[@]} < n)); do
    read -r -a chunk
    elements+=("${chunk[@]}")
  done

  for (( j = 0; j < n; j++ )); do
    curr=${elements[j]}
    ((sum += curr))
    if (( curr == 0 )); then
      ((z++))
    fi
    all+=("$curr")
  done

  echo $((sum + z))

done

