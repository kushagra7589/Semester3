ORG 0000
START: 	NOP
		MOV R0, #0FFH;
LB:		MOV R1, #0FFH;
LA:		NOP;
		DJNZ R1, LA;
		DJNZ R0, LB;
		CPL P0.0
		SJMP START
		END
