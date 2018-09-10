#include<stdio.h>


#define LOWER 0
#define UPPER 300
#define STEP 20

#define OUT 0
#define IN 1

/**Exercise 1-13. Write a program to print a histogram of the lengths of words in its input. It is easy to
draw the histogram with the bars horizontal; a vertical orientation is more challenging.**/
void histogram(){
    int charset[128]={0};
    // for(int i=0;i<128;i++){
    //     printf("%d",charset[i]);
    // }
    int c,longest=0;
    while((c=getchar())!=EOF){
        charset[c]++;
        if(charset[c]>longest){
            longest=charset[c];
        }
    }

    // int gram[longest][127]={0};
    for(int i=longest-1;i>=0;i--){
        for(int j=0;j<127;j++){
            if(i<charset[j]){
                printf("*");
            }else{
                printf(" ");
            }
            // gram[i][j]=0;
        }
    }

}

/**Exercise 1-12. Write a program that prints its input one word per line.**/
void wordPerLine(){
    int c,status=OUT;
    while((c=getchar())!=EOF){
        if(' '==c||'\t'==c){
            status=OUT;
        }else if(status==OUT){
            status=IN;
            printf("\n");
            printf("%c",c);
        }else{
            printf("%c",c);
        }
        
    }
}

/**Exercise 1-11. How would you test the word count program? What kinds of input are most likely to
uncover bugs if there are any?**/


/**
 * Exercise 1-10. Write a program to copy its input to its output, replacing each tab by \t , each backspace
by \b , and each backslash by \\ . This makes tabs and backspaces visible in an unambiguous way.
**/
void showTab(){
    int c;
    while((c=getchar())!=EOF){
        if('\t'==c){
            printf("\\t");
        }else if(' '==c){
            printf("\\b");
        }else{
            printf("%c",c);
        }
    }
}

/**
 * 
 * Exercise 1-9. Write a program to copy its input to its output, replacing each string of one or more blanks
by a single blank.
 * */
void copyIO(){
    int c;
    int last=0;
    while((c=getchar())!=EOF){
        if((' '==c)&&(' '==last)){
        }else{
            printf("%c",c);
        } 
        last=c;
    }
}

/**
 * Exercise 1-8. Write a program to count blanks, tabs, and newlines.
 * 
 * */
void countBTN(){
    int c,blanks,tabs,nl;
    blanks=tabs=nl=0;
    while((c=getchar())!=EOF){
        if(' '==c)
            blanks++;
        else if('\n'==c)
            nl++;
        else if('\t'==c)
            tabs++;
    }
    printf("\nblanks %d  tabs %d newlines %d",blanks,tabs,nl);
}

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
    // tempConvertionReverse();
    // testEOF();
    // countBTN();
    // copyIO();
    // showTab();
    // wordPerLine();
    histogram();
}