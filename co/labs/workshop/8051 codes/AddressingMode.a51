org 00h
	mov a,#55h		;immediate
	mov r0,a		;register
	mov 40h,a		;direct
	mov r1,#41h		
	mov @r1,a		;indirect
	clr a
	mov dptr,#400h
	movc a,@a+dptr	;indexed
here: sjmp here

org 400h
	db "G"
end