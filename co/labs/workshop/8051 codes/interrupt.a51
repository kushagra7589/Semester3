org 00h
	jmp main
org 03h
	clr p0.7
	reti
	
main:
	mov ie,#85h
	loop:
	setb p3.7
	jmp loop
end