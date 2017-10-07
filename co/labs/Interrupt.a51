org 0000
	
	jmp main
	
	org 0003H
		cpl p0.0
	reti


	main:	
		mov IE, #10000001b
	;	setb p3.2;input
		clr p0.0
		start1: 
			cpl p0.7
			sjmp start1
		end  
	