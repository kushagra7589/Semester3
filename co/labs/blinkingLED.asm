ORG 0000
	
main:
	setb p0.0
	call DELAY
	clr p0.0
	call DELAY
	sjmp main

DELAY: MOV R6,#250D
       MOV R7,#250D
LABEL1: DJNZ R6,LABEL1
LABEL2: DJNZ R7,LABEL2
        RET
			
end

