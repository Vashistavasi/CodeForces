#!/bin/bash

read t

for (( int i=0;i<t;i++ )) 
do
	read n,s
	declare -a arr = ()
	sum=0
	for(( int j=0;j<n;j++ )) 
do 
	read next;
	arr+= "$next"
	(( sum+= $next ))
done

if [[ sum - s == 1 ]] 
	z=0
	o=0 
	t=0 
	for i in "$arr[@]"
		switch(i)
			case 0: (( z++ ))
			case 1: (( o++ ))
			case 2: (( t++ )) 
	 	esac
		declare -a ans = () 
		k = 0;
		for (( int i=0;i<z;i++ )) (( ans[((k++))] = 0 ))
			for (( int i=0;i<
else if [[ sum -s == 1 ]]
	echo "$arr[@]"
else echo "-1"
