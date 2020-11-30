
	.text
	.globl main
main:
	addi sp, sp, -4
	sw ra, 0(sp)
	addi sp, sp, -4
	sw fp, 0(sp)
	mv fp, sp
				# copy args:
				# END PROLOGUE

				# # [ir-block] Enter
				# # [ir-decl] Decl
				# const 4096
	addi sp, sp, -4
	li t1, 4096
	sw t1, 0(sp)
				# # [ir-stmt] Expr
				# const 1
	addi sp, sp, -4
	li t1, 1
	sw t1, 0(sp)
				# frame address -4
	addi sp, sp, -4
	addi t1, fp, -4
	sw t1, 0(sp)
				# load
	lw t1, 0(sp)
	lw t1, 0(t1)
	sw t1, 0(sp)
				# const 23
	addi sp, sp, -4
	li t1, 23
	sw t1, 0(sp)
				# const 4
	addi sp, sp, -4
	li t1, 4
	sw t1, 0(sp)
				# Arithmetic operator "*"
	lw t1,0(sp)
	lw t2,4(sp)
	addi sp,sp,4
	mul t1,t2,t1
	sw t1,0(sp)
				# Arithmetic operator "+"
	lw t1,0(sp)
	lw t2,4(sp)
	addi sp,sp,4
	add t1,t2,t1
	sw t1,0(sp)
				# store
	lw t1, 4(sp)
	lw t2, 0(sp)
	addi sp, sp, 4
	sw t1, 0(t2)
				# pop
	addi sp, sp, 4
				# # [ir-stmt] Ret
				# frame address -4
	addi sp, sp, -4
	addi t1, fp, -4
	sw t1, 0(sp)
				# load
	lw t1, 0(sp)
	lw t1, 0(t1)
	sw t1, 0(sp)
				# const 23
	addi sp, sp, -4
	li t1, 23
	sw t1, 0(sp)
				# const 4
	addi sp, sp, -4
	li t1, 4
	sw t1, 0(sp)
				# Arithmetic operator "*"
	lw t1,0(sp)
	lw t2,4(sp)
	addi sp,sp,4
	mul t1,t2,t1
	sw t1,0(sp)
				# Arithmetic operator "+"
	lw t1,0(sp)
	lw t2,4(sp)
	addi sp,sp,4
	add t1,t2,t1
	sw t1,0(sp)
				# load
	lw t1, 0(sp)
	lw t1, 0(t1)
	sw t1, 0(sp)
				# ret
	j main_exit
				# # [ir-block] Exit
				# pop
	addi sp, sp, 4

				# BEGIN EPOLOGUE
	addi sp, sp, -4
	li t1, 0
	sw t1, 0(sp)
main_exit:
	lw a0, 0(sp)
	mv sp, fp
	lw fp, 0(sp)
	addi sp, sp, 4
	lw ra, 0(sp)
	addi sp, sp, 4
	jr ra

