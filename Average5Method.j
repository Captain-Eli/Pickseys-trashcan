.class public Lab4_Average5Method
.super java/lang/Object
; boiler plate
.method public <init>()V
	aload_0
	invokespecial java/lang/Object/<init>()V
        return
.end method

; average is a method that takes five ints and returns one int
.method public Average(IIIII)I
; we need 5 stack elements for averaging out
.limit stack 5
.limit locals 5
; load all the ints from java
	iload_1
	iload_2
	iload_3
	iload 4
	iload 5
	iadd
	iadd
	iadd
	iadd
	iconst_5
	swap
	idiv 
	return
.end method
