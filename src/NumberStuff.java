public class NumberStuff {

    public static void main(String[] args) {
        // BITS and BYTES
        // computers can only understand 0s and 1s at lowest possible level
        // all other data has to be converted into a 0 or 1
        // ACSII encoding (i.e. A = 65), even that number 65 has to be translated before it can be stored in computer
        // the lowest level = Bits
        // the smallest number of bits that we can put together on modern computers typically is refered to as a BYTE
        // 1 Byte = 8 Bits put together
        // A = 1000001 - binary encoding
        // 1,2,4,8,16,32,64,128,etc - each of places is power of 2 (doubling themselves)

        // HEXADECIMAL
        // Decimal is based on 10s (base 10 ) digits between 0 - 9
        // Binary = base 2, 0 or 1
        // Hexadecimal = base 16, so in each place can be 16 different values
        // first 10 values use the same values as exist in the decimal system, 0 and 9
        // but after we run out of numbers then we start using letters as the additional symbols for base 16 - A-F
        // 0 - 9 + A - F = 16
        // Decimal number 15 requires 4 bits (1,1,1,1) to encode that number - which is a lot
        // in hexadecimal you can encode 15 with 1
        // hexadecimal allows us to have a compressed representation of numbers from base 10 or base 2
        // also hexadecimal allows us to line up really well with bytes
        // 4 bits = a 'nibble'
        // 1 hexadecimal digit can very nicely represnet 1 nibble (or 4 bits)
        // 1 hexadecimal number 3E8 (still a number despite letter)
        // 1111101000 = 3E8 (Hex)
        // 1111101011001110 = FACE (Hex)

        // Where in memory does this object reside - every object in java takes up some mount of space in the form of some amount of bytes, every byte in memory has an address
        //ClassName@5acf9800 = (returned when instantiating new instance of class = className + haxadecimal memory address

        ////////
        // NUMERIC DATA TYPES
        // All data in the computer gets stored as binary and that means that all data needs space in the computer, and that's where RAM comes into play
        // RAM not to be confused with storage
        // 4,8,16gb of RAM common
        // Greek prefixes -
        // 1000 bytes = 1 kilobyte, meca, giga, terra (greek prefixes)
        // memory in computers tends to be based on powers of 2
        // number 1000 is not a power of 2
        // closest number to 1000 that would be power of 2 is 1024
        // and so if we were to say a computer has 1 kilobyte of ram we would liely mean that it has 1024 bytes, not 1000 bytes
        // that explains why weird numbers instead of nice even whole numbers, is because memory in computers tends to be measured in powers of 2
        // find some unused space in computer in wich to store this new thing
        //
        byte myByte = 13; //@23F3N4123 - address in memory
        System.out.println(myByte);

        // computer has 8gb of RAM so 8 billion roughly (power of 2)
        // 1 of those bytes will be assigned number 13

        // BOOLEANS
        // smallest data type is a boolean - only requires 1 bit
        // operating sysmte and java  working together may just use a byte as that is the smallest thing that can be addressed (is a 1 byte) or if Java has a tricky way so that for every bits that we allocate it sotres it in 1 byte,
        // but this could be wasteful if working with trillions of bits
        // a bit is 1 or 0 - if it's 0 (false) 1 = true - boolean

        // Byte (-128 to 127)
        // by default most of basic numerical types in Java are signed numbers - meaning can be negative or positive
        // however, if didnt need to store negative numbers with smething like a bte (unsigned) then you could store a number in a byte up to 0 to 255
        // 128+64+32+16+8+4+2+1 = 255
        // however, reason why range is -128 to 127 - simplification :
        // 'Most significant bit'
        // important concept: combination of the amount of space that we take up in the computer vs the largest range of numbers that we need to represnet, that helps up to decide what data type we shoudl use
        // why not use the largest data type? because it would be wasteful of memory
       // typically we want to use the smallest data type that would enable us to achieve what we want to do

        // After Booleans and bytes, a SHORT is a the next smallest type
        // SHORT (-32,768 to 32,767) = 16 bits (2 bytes)
        // Also data type of CHAR is represneted with 2 bytes
        // alphabet - 26 letters (not 32,000 chars?!?)
        // Java wanted to be compatiable with all languages on earth
        // to represnet all languages you need a really big range
        // in CHAR no longer need - minus numbers.

        // Java's default encoding scheme isn't ACSII it's Unicode, but creators of Unicode did for latin letters was to start off with ACSII
        // and so all of the characters that are known to acsii actually have the same values in unicode as well
        // Korean works differently to latin - unicode econdes entire syllables
        // korene chars clustered together in a single char 0 and so it makes more sense to tthem to econde eaehc and every syllanble of the korean language as its own speerate character
        // so imagine how many chars would you need inorder to represnet every syllable in a language especially a anguage like korean - thousands
        // so that's why CHAR type is so big to accomodate all lagnuages and all syllalables and chars in all languages!

        short myBigShort = 45;
        char myChar = '강'; //gang
        char myA = 'A'; // in essence storing number 65


        // INT (-2,147,483,648 to 2,147,483,647) - 32 bits
        // most common numerical data type used by default in Java
        // basic math
        // good for loops up 2,1 billion
        // may be overkill for lots of things - why need to know about all data types
        // why bother with int if only need to loop 20 times, use a byte
        // however, even using 100's of int is not going to put much of a dent in RAM
        // programmers today have become quite wasteful because computers today have so much RAM

        // LONG
        // long	8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // 64 bits
        // used to store records to a database, each record in the database requires it's own ID
        // type long to ensure that pretty much impossible to run out of ids for those records
        // INT could be exhausted (2 billion) in some apps - spacecraft apps
        // safety sake programmers do sokmetimes defualt to LONG
        // What is it I need to count? What do i think the upper limit will ever be on whatever it is i need to count in my programme? And then what datat type will comformtably fit with that assumed upper limit?

//        byte myByte2 = 128; // error - exceeded number of bits that are allocated to a byte
//        short myShort2 = 32767; // happy
//        short myShort3 = 32768; // unhappy

        char biggerShort = 32767; // allowed
        char biggerShort2 = 64000; // allowed - as char has no negative (unsigned)

        // In order to allow for negative nad positive what thesee data tpyes will genreally do is they will take the last bit and use that just to idiciate whether that number is negaitve or psoitive,
        // but if you dont need that last bit to indicatethe sign of that number then you have effectively doubled the range, and so a char is a not signed  it is unsigned meaning all the values in it are positive, and therefore it has a psotive range that is twice that of a SHORT.
        // Same number of values but shifted to positive, rather than a short which is roughly half negative half psoitive.

// FLOATING POINT NUMBER
        // FLOAT and DOUBLE
        // float shares same number of bits as Int (32) and double is 64
        // float and double store values differently
        // 'exponent' | 'mantisa'
        // store fractional values in binary
        // 1/10 1/100 1/1000 for decimal
        // instead of 2,4,8,16, etc we have 1/2, 1/4, 1/8, 1/16, 1/32, 1/64 - instead of base 10 its base2
        // 0.5 in binary = 0.1, 0.75 in binary = 0.11, 3.141592 in binary =
        // find the largest fraction that would fit in
        // . 1/2 1/4 1/8 1/16 1/32 1/64 1/128
        // . 0 0 1 0 0 1 0 0 0 1 = approximation of .141592
        // representing fractions in binary - for fractions whose decimal equivlent is never ending like Pi, or whose decimal equiveltn is so long that it would exceed all of the bits you are willing to allocate in your computer, the best you can ever do when trying to represnet such numbers in binary is to approximate those numebrs.
        // this is usually ok for scientific and engineering calulcations, but when it comes to money, where calculations need to be fairly precise, it wont do at all!
        // 32 bits allocated for float
        // there are a lot of fractional numbers that cannot be adequately represnted by these 23 bits to right of decimal, decimal itself takes up 8 (hence floating point)
        //
        // when the computer repsents a number like 3.11592 in float or double, the steps it will go through are: it will not attempt to store the number directly, instead it will try to get hte number to a format that is more compatible with the way that it internally sotres things.
        // it will take the number and determine wheter it is bigger than 2, and keep dviiding the number until it is less than 2, in this case ti would only have to do it 1 time, and it would also keep track of the number of times it has to divide it by 2, that number of times would then be added to the number 127, so in this case 128 becaus it would only have to dvide once, would be econded here in the exponent area, and so this dividision by 2 is the equivalent to moving the decimal place.
        // So once the number has been divided enough times to get it less than 2 then it can be as we did before.
        // not exactly as we did, there are proper mathematical means, but basic gist
        // this is standard that goes beyond Java

        double myDouble = 3.141592;
//        float myFloat = 3.141592; // error Required type float Provided double
        float myFloat2 = 3.141592f; // f or F after number otherwise java assumes you want double by default

        // Issues that can arise from perfomring calculations with floating-point data types
        double num1 = 2.15;
        double num2 = 1.10;
        System.out.println(num1 - num2); // should be 1.5 but get 1.0499999999999998
        // why? these decimal values ave to approximated when being stored in binary, with the number of bits we have available to us
        float num3 = 2.15F;
        float num4 = 1.10F;
        System.out.println(num3 - num4);// should be 1.5 but get 1.0500001
        // still receiving an approximation and not exact value
        // floats and doubles best results you can get are very very close approximations - so be very careful especially when it comes to money!

    }






}
