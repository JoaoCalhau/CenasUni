M:
	slt $t2,$t0,$t1
	beq $t2,$zero,L
	nop

L:
	j M
	nop