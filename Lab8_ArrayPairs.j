;boiler Plate
;Lab8_ArrayPairs.j

.class public Lab8_ArrayPairs
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava.lang.String;)V
    .limit stack 10

    .limit locals 8

    ;holds the limit counter
    aload_0
    iconst_0
    aaload
    invokestatic java/lang/Integer.parseInt(Ljava/lang/String;)I
    istore_1

;hold the 1,2,3,4
    iload_1
    newarray int
    astore_2

;holds the objects
    iload_1
    anewarray Ljava/lang/String;
    astore_3

;is the counter
    iconst_0
    istore 4

;holds the sum

    iconst_1
    istore 5
;hold product
    iconst_1
    istore 6

    new Pair
    dup
    invokespecial Pair/<init>()V
    astore 7

Loop:
    aload_2     ; load the array
    iload 4     ;load the location
    iload 4     ;load the value (which is the same as the location)
    iastore     ;set array[location] = value

    aload 7
    iload 5
    putfield Pair/fst I

    aload 7
    iload 6
    putfield Pair/snd I

    aload_3
    iload 4
    aload 7
    aastore

    goto PrintArray
Loop2:

 ;intcrements the counter
    iload 4
    iconst_1
    iadd
    istore 4
;adds to the sum
    iload 4
    iload 5
    iadd
    istore 5
;adds to the product
    iload 4
    iload 6
    imul
    istore 6

    iload 1     ;are we done yet (is location >= n)
    iload 4
    if_icmplt Loop
return

PrintArray:
;prints both current array values
;   getstatic java/lang/System/out Ljava/io/PrintStream;

;   aload_2
;   iload 4
;   iaload
;   invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;

;print fst
    aload 7
    getfield Pair/fst I
    invokevirtual java/io/PrintStream/println(I)V
;print snd
    getstatic java/lang/System/out Ljava/io/PrintStream;

    aload 7
    getfield Pair/snd I
    invokevirtual java/io/PrintStream/println(I)V
    goto Loop2
.end method



