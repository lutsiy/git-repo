#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/******************************************************************************************
Илья Луцевич
2017-12-28

5. **Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.

*******************************************************************************************/

void solution1();
void solution2();
void solution3();
void solution4();
void solution5();



void menu();



// Распечатываем массив
void print(int N, char *a)
{
    int i;
    for(i = 0; i < N; i++)
        printf("%2c", a[i]);
    printf("\n");
}


int main()
{
    int sel = 0;
    do
    {
        menu();
        scanf("%i", &sel);
        switch (sel)
        {
        case 1:
            solution1();
            break;
        case 2:
            solution2();
            break;
        case 3:
            solution3();
            break;
        case 4:
            solution4();
            break;
        case 5:
            solution5();
            break;
        case 0:
            printf("Bye-bye");
            break;
        default:
            printf("Wrong selected\n");
        }
    }
    while (sel != 0);
    return 0;
}


void solution1()
{
    printf("\nSolution 1\n\n");

    return 0;
}
void solution2()
{
    printf("\nSolution 2\n");

    return 0;
}

void solution3()
{
    printf("\nSolution 3\n");
    return 0;

}

void solution4()
{

    printf("Solution 4\n\n");

}

void solution5()
{

    char arr[13] = {'3','+','4','x','2','/','(','1','-','5',')','^','2'};
    char out[6];
    char stack[7];
    int i;
    int j = 0;
    int s = 0;

    printf("Solution 5\n\n");

   printf("infix: 3+4*2/(1 - 5)^2\n\n");


    for (i = 0; i < 13; i++)
    {
        if  (isdigit(arr[i]))
    {

        out[j] = arr [i];
        j++;
        }
        else
        {
            stack[s] = arr[i];
            s++;
        }


    }
    print(6, out);
    print(7,stack);
}


void menu()
{
    printf("1 - task1\n");
    printf("2 - task2\n");
    printf("3 - task3\n");
    printf("4 - task4\n");
    printf("5 - task5\n");
    printf("0 - exit\n");
}

