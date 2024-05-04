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

        ///////////////////
        // STANDARD MATH FUNCTIONS (Math methods in Java)
        ///////////////////
        System.out.println(Math.abs(-5)); // = 5: gives us absolute value = taking that number and stripping any negative value from it, so absolute value of -5 should be +5 or 5;
        System.out.println(Math.ceil(5.0)); // 5.0: Math.ceil wants to round up to an integer, anything even infinitesimally larger than 5.0 will get rounded up to 6
        System.out.println(Math.ceil(5.01)); // 6.0: Math.ceil wants to round up to an integer, anything even infinitesimally larger than 5.0 will get rounded up to 6
        System.out.println(Math.ceil(5.4)); // 6.0
        System.out.println(Math.ceil(5.6)); // 6.0
        System.out.println(Math.floor(5.0)); // 5.0 : Math.floor wants to go down to the floor
        System.out.println(Math.floor(5.999)); // 5.0
        System.out.println(Math.floor(5.6)); // 5.0
        int num11 = 3;
        int num22 = 5;
        System.out.println(Math.min(num11, num22)); // =3: Will return whichever value is the smaller one, the minimum one. You may not know what the input might be so you don't know which is smaller.
        System.out.println(Math.max(num11, num22)); // =5: Gives us the larger value

        System.out.println(Math.pow(2, 3)); // = 8.0: 2 to the power of 3. Returns doubles

        System.out.println(Math.random()); //0.6357803354604953: Very useful function. Pseudo random. Computers are not good at generating random numbers at all. How can a computer generate anything random? So this random function is good for simple use cases like a card game, but not for security cases.
        System.out.println(Math.random()); //0.655405942598385
        System.out.println(Math.random()); //0.7094378378209619
        // typically to use this random function in a useful way you need to multiply its output times whatever your upper range is
        // s if want numbers between 0 and 10 you need to multiply by 10
        // you're never going to actually get the value of 10 out of this, the highest it will go is something less than 10, like 9.0123
        // this function never returns 1.02 it returns something greater than 0 but less than 1
        System.out.println(Math.random() * 10); //4.9342167869635
        // whole numbers:
        System.out.println((int)(Math.random() * 10)); //0
        System.out.println((int)(Math.random() * 10)); //6
        System.out.println((int)(Math.random() * 10)); //9
        // notice how we are casting this to int we are able to now get 0
        // the math.random function will never return 0, always greater than 0
        // however it is possible for values that are less than 1 to become a 0 when they are case to an integer
        System.out.println(Math.round(5.0)); // 5
        System.out.println(Math.round(5.2)); // 5
        System.out.println(Math.round(5.4)); // 5
        System.out.println(Math.round(5.5)); // 6
        System.out.println(Math.round(5.999)); // 6

        //
        // MATH CONSTANTS
        System.out.println(Math.PI);
        System.out.println(Math.E);

    }
}
