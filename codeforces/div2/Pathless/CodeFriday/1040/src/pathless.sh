#!/bin/bash
# Read number of test cases
read t

for ((tc=0; tc<t; tc++)); do
    read n s
    read -a arr

    sum=0
    for i in "${arr[@]}"; do
        ((sum+=i))
    done

    if (( s < sum )); then
        echo "${arr[@]}"
    elif (( s - sum == 1 )); then
        # Count 0s, 1s, 2s
        z=0; o=0; t2=0
        for i in "${arr[@]}"; do
            case $i in
                0) ((z++));;
                1) ((o++));;
                2) ((t2++));;
            esac
        done
        ans=()
        for ((i=0; i<z; i++)); do ans+=(0); done
        for ((i=0; i<t2; i++)); do ans+=(2); done
        for ((i=0; i<o; i++)); do ans+=(1); done
        echo "${ans[@]}"
    else
        echo -1
    fi
done