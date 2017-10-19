xpto:
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	li $v0, 1
	beq $a0, $zero, RETURN
	nop
	
	addi $a0, $a0, -1
	jal xpto
	nop
	sll $v0, $v0, 1

RETURN:
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	jr $ra
	nop