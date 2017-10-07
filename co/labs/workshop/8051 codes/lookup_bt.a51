ORG 00H
	MOV TMOD, #20H
	MOV TH1, #-3
	MOV SCON, #50H
	SETB TR1
MAIN1:
	MOV R3,#6
	mov dptr,#400h
MAIN:
	CLR a
	movc a,@a+dptr	;indexed
	ACALL SEND
	INC DPTR
	DJNZ R3, MAIN
	
		MOV R0, #0FFH;
LB:		MOV R1, #0FFH;
LA:		NOP;
		DJNZ R1, LA;
		DJNZ R0, LB;
		
	SJMP MAIN1
	
	
SEND:
	MOV SBUF, A
HERE1: 
	JNB TI,HERE1
	CLR TI
	RET
org 400h
	db "IGDTUW"
end
