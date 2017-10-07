# /bin/bash

gcc -o lcd fourbit.c -lwiringPi -lwiringPiDev
while true 
do
	sudo python Read.py > file1.txt
	TEXT=`cat file1.txt`
	if [ "$TEXT" == "exiting" ]
	then 
		break
	fi
	sudo ./lcd
done
