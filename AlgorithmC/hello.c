#include<stdio.h>


#define LOWER 0
#define UPPER 300
#define STEP 20


/**
 * Exercsise 1-6. Verify that the expression getchar() != EOF is 0 or 1.
Exercise 1-7. Write a program to print the value of EOF .
 * */
void testEOF(){
    printf("%d\n",getchar()!=EOF);
    printf("%d\n",EOF);
}

/**
 * Exercise 1-5. Modify the temperature conversion program to print the table in reverse order, that is,
from 300 degrees to 0.
 * */
void tempConvertionReverse(){
    float fahr;
    for(fahr=300;fahr>=LOWER;fahr=fahr-STEP){
        printf("%3.0f %6.1f\n",fahr,(5.0/9.0)*(fahr-32));
    }
}

/**
 * Exercise 1-4. Write a program to print the corresponding Celsius to Fahrenheit table.
 * */
void tempConvertionC2F(){
    float fahr,celsius;
    celsius=LOWER;
    printf("Celsius to Fahr\n");
    while(celsius<UPPER){
        fahr=celsius/(5.0/9.0)+32;
        printf("%3.0f %6.1f\n",celsius,fahr);
        celsius=celsius+STEP;
    }
}

/**
 * Exercise 1-3. Modify the temperature conversion program to print a heading above the table.
 * */
void tempConvertion(){
    float fahr,celsius;
    fahr=LOWER;
    printf("Fahr to Celsius\n");
    while(fahr<UPPER){
        celsius=(5.0/9.0)*(fahr-32);
        printf("%3.0f %6.1f\n",fahr,celsius);
        fahr=fahr+STEP;
    }
}

/**
 * Exercise 1-2. Experiment to find out what happens when prints 's argument string contains \c, where c
is some character not listed above.
 * */
void print(){
    // printf("hello world\c");
}

/**
 * Exercise 1-1
 * Run the `` hello, world '' program on your system. Experiment with leaving out parts of
the program, to see what error messages you get.
 * */
void main(){
    // printf("hello world！\n");
    // print();

    // tempConvertion();
    // tempConvertionC2F();
    // tempConvertionReverse();
    testEOF();
}