	.data
n:	.word 26

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
sub:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -4
	lw    $t0, 4($fp)
	lw    $t1, 8($fp)
	subu  $t0, $t0, $t1
	or    $v0, $0, $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 12
	lw    $fp, 0($fp)
	jr    $ra

	.text
fibonacci:
	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -8
	lw    $t0, 4($fp)
	ori   $t1, $0, 0
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$3
	j     l$0
l$3:	lw    $t0, 4($fp)
	ori   $t1, $0, 1
	subu  $t0, $t0, $t1
	sltiu $t0, $t0, 1
	beq   $t0, $0, l$1
	j     l$0
l$0:	lw    $t0, 4($fp)
	sw    $t0, -8($fp)
	j     l$2
l$1:	lw    $t0, 4($fp)
	ori   $t1, $0, 1
	subu  $t0, $t0, $t1
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   fibonacci
	or    $t0, $0, $v0
	lw    $t1, 4($fp)
	ori   $t2, $0, 2
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t2, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	jal   sub
	or    $t1, $0, $v0
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	addiu $sp, $sp, -4
	sw    $t1, 0($sp)
	jal   fibonacci
	or    $t1, $0, $v0
	lw    $t0, 0($sp)
	addiu $sp, $sp, 4
	addu  $t0, $t0, $t1
	sw    $t0, -8($fp)
l$2:	lw    $t0, -8($fp)
	or    $v0, $0, $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 8
	lw    $fp, 0($fp)
	jr    $ra

	.text
	.globl main
main:	sw    $fp, -4($sp)
	addiu $fp, $sp, -4
	sw    $ra, -4($fp)
	addiu $sp, $fp, -8
	la    $t0, n
	lw    $t0, 0($t0)
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   fibonacci
	or    $t0, $0, $v0
	sw    $t0, -8($fp)
	lw    $t0, -8($fp)
	i_print$ $t0
	ori   $t0, $0, 14
	ori   $t1, $0, 3
	ori   $t2, $0, 4
	mult  $t1, $t2
	mflo  $t1
	addu  $t0, $t0, $t1
	addiu $sp, $sp, -4
	sw    $t0, 0($sp)
	jal   fibonacci
	or    $t0, $0, $v0
	i_print$ $t0
	lui   $t0, 1
	ori   $t0, $t0, 55857
	i_print$ $t0
	ori   $t0, $0, 0
	or    $v0, $0, $t0
	lw    $ra, -4($fp)
	addiu $sp, $fp, 4
	lw    $fp, 0($fp)
	jr    $ra

