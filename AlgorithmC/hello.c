#include<stdio.h>

#define LOWER 0
#define UPPER 300
#define STEP 20

#define OUT 0
#define IN 1

#define TS 4

#define LineLength 5

/**
 * Exercise 1-24. Write a program to check a C program for rudimentary syntax errors like unmatched
parentheses, brackets and braces. Don't forget about quotes, both single and double, escape sequences,and comments. (This program is hard if you do it in full generality.)
思路：
判断大小括号、引号是否为偶数
*/
void check(){
    
}

/**
 * Exercise 1-23. Write a program to remove all comments from a C program. Don't forget to handle
quoted strings and character constants properly. C comments don't nest.
*/
void rmComments(){
    int c,last,status=OUT;
    while((c=getchar())!=EOF){
        
        if(status==IN){
            printf("%c",c);
        }

        if(c=='\\'&&last=='\\'){
            status=IN;
        }else if('\n'==status){//发现换行，改变status
            status=OUT;
        }else if(last=='/'&&c=='*'){
            status=IN;
        }else if(last=='*'&&c=='/'){
            status=OUT;
        }
        last=c;
    }
}

/**
 * Exercise 1-22. Write a program to ``fold'' long input lines into two or more shorter lines after the last
non-blank character that occurs before the n-th column of input. Make sure your program does
something intelligent with very long lines, and if there are no blanks or tabs before the specified column.
*/
void fold(){
    int c,sum=0;
    while((c=getchar())!=EOF){
        if(sum>=LineLength){
            sum=0;
            printf("\n");
        }
        printf("%c",c);
        sum++;
    }
}

/**Exercise 1-20. Write a program detab that replaces tabs in the input with the proper number of blanks
to space to the next tab stop. Assume a fixed set of tab stops, say every n columns. Should n be a
variable or a symbolic parameter?**/
void detab(){
    // printf("a\taa\taaa\ta");
    // printf("%d",TS-1%TS);
    int c,index=0;
    while((c=getchar())!=EOF){
        int left = TS-index%TS;
        if(c=='\t'){
            // if(left==0)
            //     left=4;

            while(left>0){
                printf(" ");
                left--;
                index++;
            }
        }else{
            printf("%c",c);
            index++;
        }

        if('\n'==c)
            index=0;
    }
}

/**Exercise 1-19. Write a function reverse(s) that reverses the character string s . Use it to write a
program that reverses its input a line at a time.**/
void pinrtInputReverse(){
    int line[1000];
    int c=0,cursor=0;
    while((c=getchar())!=EOF){
        if(c!='\n'){
            line[cursor++]=c;
        }else if(c=='\n'){
            line[cursor++]=c;
        
            while(cursor>=0){
                printf("%c",line[cursor]);
                cursor--;
            }   
            cursor=0;
        }
    }
}

/**Exercise 1-18. Write a program to remove trailing blanks and tabs from each line of input, and to delete
entirely blank lines.
abcdefg    \n\n\n

idea:just find from end to start,if get sth not blank or newline,then print things out from start to end
**/
void pinrtInputRmBlank(){
    int line[1000];
    int c=0,cursor=0;
    while((c=getchar())!=EOF){
        if(c!='\n'){
            line[cursor++]=c;
        }else if(c=='\n'){
            line[cursor]=c;

            int last=0,status=OUT;
            while(cursor>=0){

                if((line[cursor]!=' ')&&(line[cursor]!='\n')){
                    status=IN;
                    break;
                }

                // if((' '==line[cursor])&&status==OUT){
                    
                // }else if(('\n'==line[cursor])&&('\n'==last)){
                    
                // }else if(status==OUT){
                    
                // }else{
                    
                // }

                last=line[cursor];
                cursor--;
            }
            int start=0;
            while(start<=cursor){
                printf("%c",line[start]);
                start++;
            }
            cursor=0;
            last=0;
            status=OUT;
        }
    }
}

/**Exercise 1-17. Write a program to print all input lines that are longer than 80 characters.**/
void pinrtInput80(){
    int line[1000];
    int c=0,cursor=0;
    while((c=getchar())!=EOF){
        if(c!='\n'){
            line[cursor++]=c;
        }else if(c=='\n'){
            line[cursor++]=c;
            
            if(cursor>8){
                int start=0;
                while(start<=cursor){
                    printf("%c",line[start]);
                    start++;
                } 
            }
              
            cursor=0;
        }
    }
}


/**Exercise 1-16. Revise the main routine of the longest-line program so it will correctly print the length of
arbitrary long input lines, and as much as possible of the text.**/


/**Exercise 1-14. Write a program to print a histogram of the frequencies of different characters in its
input.
idea: characters are no more than 128, this is important! Keep a Grid in mind.
**/
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

    printf("\n");
    // int gram[longest][127]={0};
    int i=0,j=0;
    for(i=longest-1;i>=-1;i--){
        for(j=97;j<128;j++){
            if(i==-1){
                printf("%c",j);
            }else if(i<charset[j]){
                printf("*");
            }else{
                printf(" ");
            }
            // gram[i][j]=0;
        }
        printf("\n");
    }
    for(i=0;i<128;i++){
        printf("%c",i);
    }

    printf("%d",'a');
}

/**Exercise 1-13. Write a program to print a histogram of the lengths of words in its input. It is easy to
draw the histogram with the bars horizontal; a vertical orientation is more challenging.**/
void histogramWords(){
    int c=0,status=OUT,len=0;
    while((c=getchar())){

        if(c==EOF){
            while(len>0){
                printf("*");
                len--;
            }
            break;
        }

        if(' '==c||'\t'==c){
            status=OUT;
        }else if(status==OUT){
            status=IN;

            while(len>0){
                printf("*");
                len--;
            }
            printf("\n");

            len=1;
            printf("%c",c);

        }else{
            len++;
            printf("%c",c);
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
    // histogram();
    // histogramWords();
    // pinrtInput();
    // pinrtInput80();
    // pinrtInputRmBlank();
    // detab();
    fold();
}