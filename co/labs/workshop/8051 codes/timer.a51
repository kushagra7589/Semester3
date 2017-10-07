MOV TMOD, #01
HERE:
	MOV TL0, #0FFH
	MOV TH0, #0FFH
	CPL P0.0
	ACALL DELAY
	SJMP HERE
DELAY:
	MOV R0,#7
LOOP:
	SETB TR0
AGAIN: 
	JNB TF0,AGAIN
	CLR TR0
	CLR TF0
	DJNZ R0,LOOP
	RET
	END