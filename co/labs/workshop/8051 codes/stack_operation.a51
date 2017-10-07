;Program to push R1 of bank 1 and Accumulator to stack and pop to r0 of bank 0 and rgister b
org 00h
	
mov sp,#3fh
setb psw.3
mov r1,#0ch
mov a,#0ceh

push 9
push 0e0h

pop 0f0h
pop 0
clr psw.3
end