#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/******************************************************************************************
Илья Луцевич
2018-01-11

1. Реализовать простейшую хэш-функцию. На вход функции подается строка, на выходе сумма кодов символов.

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

    char arr[13] = {'g','e','e','k','b','r','a','i','s','n'};
    int i;
    int hash = 0;
    printf("string: ");
    print(10, arr);
    for(i = 0; i < 10; i++)
    {
        hash = hash + (int)arr[i]*i;
    }
    printf ("\nhash: %d\n",hash);

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
    return 0;
}

void solution5()
{
    printf("Solution 5\n\n");
    return 0;
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

