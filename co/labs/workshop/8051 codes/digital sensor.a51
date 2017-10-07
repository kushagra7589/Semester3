org 00h
main:
	jb p1.0, notbit
		setb p0.7
		jmp main
	notbit:
		clr p0.7
		jmp main
end