public class MathStuff {
    public static void main(String[] args) {
        System.out.println(3 + 5 + 2 + 7);
        System.out.println(10 - 7); // all integers
        System.out.println(7 - 10);
        System.out.println(7 - 10 + 3 - 9); // addition and subtraction are of equal precedence
        System.out.println(7 * 4);
        System.out.println(8 / 4);
        System.out.println(64 / 8 / 4);
        System.out.println(7 /4); // = 1 # without decimal since both numbers are integers the result will be an int too
        // Integers cannot handle fractions both algebraically and in java
        // if you don't use a decimal point the default number type will be integer
        // if you do use a decimal point the default number type will be double
        System.out.println(7f / 4); // = 1.75
        System.out.println(7 / 4f); // java says 'oh, one of them is a float' = 1.75
        System.out.println((double)7 / 4); // 'cast' as double = 1.75
        System.out.println((float)7 / 4); // 'cast' as float = 1.75
        System.out.println(7 / (double)4); // 'cast' as float = 1.75
        System.out.println(7 / (float)4); // 'cast' as float = 1.75
        System.out.println((double)(7 / 4)); // 1.0!? only after this evaulates to a 1 as an integer will it be case to a double 1.0

        int num1 = 7;
        int num2 = 4;
        System.out.println(num1 / num2);

        System.out.println(2 + 3 * 5); // = 17 # in order of operations multiplication and division take higher priority over addition and subtraction
        System.out.println(2 + (3 * 5)); // = 17
        System.out.println((2 + 3) * 5); // = 25
        System.out.println(5 * ((3 + 2) / 10)); // = 0
        System.out.println(5 * ((3d + 2) / 10)); // = 2.5
        System.out.println(5 * ((3d + 2d) / 10d)); // = 2.5

        // Most programming languages follow these general rules of mathematics

        System.out.println(4 % 2); // = 0, % modulo: returns the remainder of the division of the two numbers: 4 divided by 2 and also what is remainder of that calculation? returns remainder
        System.out.println(5 % 2); // = 1, 5 divided by 2 = 2, and then we have 1 left, so modulo = 1;
        System.out.println(1 % 2); // 1 if you have a sequence that is in order but you want an output to alternate in some way you can use the modulo.
        System.out.println(2 % 2); // 0
        System.out.println(3 % 2); // 1
        System.out.println(4 % 2); // 0
        System.out.println(5 % 2); // 1
        System.out.println(6 % 2); // 0
        System.out.println(7 % 2); // 1
        System.out.println(8 % 2); // 0
        System.out.println(9 % 2); // 1
        System.out.println(10 % 2); // 0

        // You can use the modulo any time you want to impose a pattern on a sequence of things.
        // below: every third do something
        // useful say for alternating the colour of a row in a table
        System.out.println(1 % 3); // 1 
        System.out.println(2 % 3); // 2
        System.out.println(3 % 3); // 0
        System.out.println(4 % 3); // 1
        System.out.println(5 % 3); // 2
        System.out.println(6 % 3); // 0
        System.out.println(7 % 3); // 1
        System.out.println(8 % 3); // 2
        System.out.println(9 % 3); // 0
        System.out.println(10 % 3); // 1

        // INCREMENT
        int x = 1;
        System.out.println(x);
        x = x + 1;
        System.out.println(x);
        x+=4;// add 4 each time
        x+=4;
        x+=4;
        x++; // x = x+1;
        System.out.println(x++); // 15: embed x++, ++ come after x meaning the increment does not get printed this time around
        System.out.println(x); // 16
        System.out.println(++x); // increment occurs on same line as increment comes before x, first thing that happens is incrementing x by 1

        // DECREMENT
        x-=1;
        System.out.println(x);
        System.out.println(x--);
        System.out.println(--x); // prefix or postfix

        //
        boolean myFlag = true;
        System.out.println(!myFlag); // negates or flips the value of the boolean to the opposite
        myFlag = !myFlag;
        System.out.println(myFlag);
        myFlag = !myFlag;
        System.out.println(myFlag);

    }
}
