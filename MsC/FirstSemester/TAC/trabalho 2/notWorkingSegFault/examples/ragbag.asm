	.data
global1:	.word 32
global2:	.space 4
gbool:	.word 1

	# print an integer
	.macro i_print$ (%int)
	or    $a0, $0, %int
	ori   $v0, $0, 1
	syscall
	ori   $a0, $0, '\n'
	ori   $v0, $0, 11
	syscall
	.end_macro

	.data
true:	.asciiz "true\n"
false:	.asciiz "false\n"
bool$:	.word false true

	# print a boolean value
	.macro b_print$ (%bool)
	la    $a0, bool$
	sll   $v0, %bool, 2
	addu  $a0, $a0, $v0
	lw    $a0, 0($a0)
	ori   $v0, $0, 4
	syscall
	.end_macro

	.text
p:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	lw    $t0, 4($fp)
	i_print$ $t0
	lw    $t0, 4($fp)
	ori   $t1, $0, 1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$1
	j     l$0
l$0:	ori   $t0, $0, 1
	b_print$ $t0
	ori   $t0, $0, 1
	ori   $t1, $0, 1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 1
	ori   $t1, $0, 2
	subu  $t0, $t0, $t1
	sltu  $t0, $0, $t0
	b_print$ $t0
	ori   $t0, $0, 1
	ori   $t1, $0, 2
	slt   $t0, $t0, $t1
	b_print$ $t0
	ori   $t0, $0, 4
	ori   $t1, $0, 5
	slt   $t0, $t1, $t0
	xori  $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 3
	ori   $t1, $0, 4
	subu  $t1, $0, $t1
	slt   $t0, $t1, $t0
	b_print$ $t0
	ori   $t0, $0, 9
	ori   $t1, $0, 9
	slt   $t0, $t0, $t1
	xori  $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 1
	ori   $t1, $0, 2
	slt   $t0, $t1, $t0
	xori  $t0, $t0, 1
	b_print$ $t0
	j     l$3
l$3:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$5
l$4:	ori   $t0, $0, 0
	b_print$ $t0
l$5:	ori   $t0, $0, 1
	ori   $t1, $0, 1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$7
	j     l$6
l$6:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$8
l$7:	ori   $t0, $0, 0
	b_print$ $t0
l$8:	ori   $t0, $0, 1
	ori   $t1, $0, 2
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$9
	j     l$10
l$9:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$11
l$10:	ori   $t0, $0, 0
	b_print$ $t0
l$11:	ori   $t0, $0, 1
	ori   $t1, $0, 2
	slt   $t0, $t0, $t1
	beq   $t0, $0, l$13
	j     l$12
l$12:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$14
l$13:	ori   $t0, $0, 0
	b_print$ $t0
l$14:	ori   $t0, $0, 4
	ori   $t1, $0, 5
	slt   $t0, $t1, $t0
	beq   $t0, $0, l$15
	j     l$16
l$15:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$17
l$16:	ori   $t0, $0, 0
	b_print$ $t0
l$17:	ori   $t0, $0, 3
	ori   $t1, $0, 4
	subu  $t1, $0, $t1
	slt   $t0, $t1, $t0
	beq   $t0, $0, l$19
	j     l$18
l$18:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$20
l$19:	ori   $t0, $0, 0
	b_print$ $t0
l$20:	ori   $t0, $0, 9
	ori   $t1, $0, 9
	slt   $t0, $t0, $t1
	beq   $t0, $0, l$21
	j     l$22
l$21:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$23
l$22:	ori   $t0, $0, 0
	b_print$ $t0
l$23:	ori   $t0, $0, 1
	ori   $t1, $0, 2
	slt   $t0, $t1, $t0
	beq   $t0, $0, l$24
	j     l$25
l$24:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$26
l$25:	ori   $t0, $0, 0
	b_print$ $t0
l$26:	j     l$2
l$1:	ori   $t0, $0, 0
	b_print$ $t0
	ori   $t0, $0, 1
	ori   $t1, $0, 0
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 3
	ori   $t1, $0, 3
	subu  $t0, $t0, $t1
	sltu  $t0, $0, $t0
	b_print$ $t0
	ori   $t0, $0, 3
	ori   $t1, $0, 1
	slt   $t0, $t0, $t1
	b_print$ $t0
	ori   $t0, $0, 8
	ori   $t1, $0, 3
	slt   $t0, $t1, $t0
	xori  $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 3
	ori   $t1, $0, 3
	slt   $t0, $t1, $t0
	b_print$ $t0
	ori   $t0, $0, 4
	ori   $t1, $0, 8
	slt   $t0, $t0, $t1
	xori  $t0, $t0, 1
	b_print$ $t0
	j     l$28
l$27:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$29
l$28:	ori   $t0, $0, 0
	b_print$ $t0
l$29:	ori   $t0, $0, 1
	ori   $t1, $0, 0
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$31
	j     l$30
l$30:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$32
l$31:	ori   $t0, $0, 0
	b_print$ $t0
l$32:	ori   $t0, $0, 3
	ori   $t1, $0, 3
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$33
	j     l$34
l$33:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$35
l$34:	ori   $t0, $0, 0
	b_print$ $t0
l$35:	ori   $t0, $0, 3
	ori   $t1, $0, 1
	slt   $t0, $t0, $t1
	beq   $t0, $0, l$37
	j     l$36
l$36:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$38
l$37:	ori   $t0, $0, 0
	b_print$ $t0
l$38:	ori   $t0, $0, 8
	ori   $t1, $0, 3
	slt   $t0, $t1, $t0
	beq   $t0, $0, l$39
	j     l$40
l$39:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$41
l$40:	ori   $t0, $0, 0
	b_print$ $t0
l$41:	ori   $t0, $0, 3
	ori   $t1, $0, 3
	slt   $t0, $t1, $t0
	beq   $t0, $0, l$43
	j     l$42
l$42:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$44
l$43:	ori   $t0, $0, 0
	b_print$ $t0
l$44:	ori   $t0, $0, 4
	ori   $t1, $0, 8
	slt   $t0, $t0, $t1
	beq   $t0, $0, l$45
	j     l$46
l$45:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$47
l$46:	ori   $t0, $0, 0
	b_print$ $t0
l$47:
l$2:	lw    $ra, -4($fp)
	addiu $sp, $fp, 8
	lw    $fp, 0($fp)
	jr    $ra

	.text
or:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	j     l$51
l$51:	j     l$49
l$48:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$50
l$49:	ori   $t0, $0, 0
	b_print$ $t0
l$50:	j     l$55
l$55:	j     l$52
l$52:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$54
l$53:	ori   $t0, $0, 0
	b_print$ $t0
l$54:	j     l$56
l$59:	j     l$57
l$56:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$58
l$57:	ori   $t0, $0, 0
	b_print$ $t0
l$58:	j     l$60
l$63:	j     l$60
l$60:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$62
l$61:	ori   $t0, $0, 0
	b_print$ $t0
l$62:	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

	.text
and:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	j     l$65
l$67:	j     l$65
l$64:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$66
l$65:	ori   $t0, $0, 0
	b_print$ $t0
l$66:	j     l$69
l$71:	j     l$68
l$68:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$70
l$69:	ori   $t0, $0, 0
	b_print$ $t0
l$70:	j     l$75
l$75:	j     l$73
l$72:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$74
l$73:	ori   $t0, $0, 0
	b_print$ $t0
l$74:	j     l$79
l$79:	j     l$76
l$76:	ori   $t0, $0, 1
	b_print$ $t0
	j     l$78
l$77:	ori   $t0, $0, 0
	b_print$ $t0
l$78:	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

	.text
f:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	lw    $t0, 4($fp)
	ori   $t1, $0, 1
	addu  $t0, $t0, $t1
	or    $v0, $0, $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 8
	lw    $fp, 0($fp)
	jr    $ra

	.text
q:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -8
	ori   $t0, $0, 0
	sw    $t0, -8($fp)
l$80:	lw    $t0, -8($fp)
	ori   $t1, $0, 2
	slt   $t0, $t0, $t1
	beq   $t0, $0, l$82
	j     l$81
l$81:	lw    $t0, -8($fp)
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   p
	lw    $t0, -8($fp)
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   f
	or    $t0, $0, $v0
	sw    $t0, -8($fp)
	j     l$80
l$82:	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

	.text
r:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	lw    $t0, 4($fp)
	la    $t1, global2
	lw    $t1, 0($t1)
	addu  $t0, $t0, $t1
	sw    $t0, 4($fp)
	lw    $t0, 4($fp)
	la    $at, global1
	sw    $t0, 0($at)
	lw    $ra, -4($fp)
	addiu $sp, $fp, 8
	lw    $fp, 0($fp)
	jr    $ra

	.text
arith:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	ori   $t0, $0, 33
	ori   $t1, $0, 3
	ori   $t2, $0, 30
	addu  $t1, $t1, $t2
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 33
	ori   $t1, $0, 3
	ori   $t2, $0, 11
	mult  $t1, $t2
	mflo  $t1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 33
	ori   $t1, $0, 40
	ori   $t2, $0, 7
	subu  $t1, $t1, $t2
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 33
	ori   $t1, $0, 99
	ori   $t2, $0, 3
	div   $t1, $t2
	mflo  $t1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 33
	ori   $t1, $0, 67
	ori   $t2, $0, 34
	div   $t1, $t2
	mfhi  $t1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 33
	ori   $t1, $0, 33
	subu  $t1, $0, $t1
	subu  $t1, $0, $t1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

	.text
	.globl main
main:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -8
	ori   $t0, $0, 34
	sw    $t0, -8($fp)
	jal   q
	ori   $t0, $0, 2
	i_print$ $t0
	jal   or
	ori   $t0, $0, 3
	i_print$ $t0
	jal   and
	ori   $t0, $0, 4
	i_print$ $t0
	jal   arith
	ori   $t0, $0, 5
	i_print$ $t0
	ori   $t0, $0, 33
	la    $at, global2
	sw    $t0, 0($at)
	la    $t0, global1
	lw    $t0, 0($t0)
	ori   $t1, $0, 1
	addu  $t0, $t0, $t1
	la    $t1, global2
	lw    $t1, 0($t1)
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	la    $t0, global1
	lw    $t0, 0($t0)
	lw    $t1, -8($fp)
	addu  $t0, $t0, $t1
	ori   $t1, $0, 2
	la    $t2, global2
	lw    $t2, 0($t2)
	mult  $t1, $t2
	mflo  $t1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	la    $t0, global2
	lw    $t0, 0($t0)
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   r
	la    $t0, global2
	lw    $t0, 0($t0)
	ori   $t1, $0, 2
	mult  $t0, $t1
	mflo  $t0
	la    $t1, global1
	lw    $t1, 0($t1)
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	ori   $t0, $0, 14
	ori   $t1, $0, 1
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	jal   f
	or    $t1, $0, $v0
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	ori   $t2, $0, 2
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	addiu $sp, $sp, -4
	sw    $t2, 0($sp)
	jal   f
	or    $t2, $0, $v0
	lw    $t1, 0($sp)
	addiu $sp, $sp, 4
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	ori   $t3, $0, 3
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	addiu $sp, $sp, -4
	sw    $t2, 0($sp)
	addiu $sp, $sp, -4
	sw    $t3, 0($sp)
	jal   f
	or    $t3, $0, $v0
	lw    $t2, 0($sp)
	addiu $sp, $sp, 4
	lw    $t1, 0($sp)
	addiu $sp, $sp, 4
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	ori   $t4, $0, 4
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	addiu $sp, $sp, -4
	sw    $t2, 0($sp)
	addiu $sp, $sp, -4
	sw    $t3, 0($sp)
	addiu $sp, $sp, -4
	sw    $t4, 0($sp)
	jal   f
	or    $t4, $0, $v0
	lw    $t3, 0($sp)
	addiu $sp, $sp, 4
	lw    $t2, 0($sp)
	addiu $sp, $sp, 4
	lw    $t1, 0($sp)
	addiu $sp, $sp, 4
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	addu  $t3, $t3, $t4
	addu  $t2, $t2, $t3
	addu  $t1, $t1, $t2
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	b_print$ $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

