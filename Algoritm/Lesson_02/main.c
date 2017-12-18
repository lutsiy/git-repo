#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/******************************************************************************************
Илья Луцевич
2017-12-13

1. Реализовать функцию перевода из 10 системы в двоичную используя рекурсию.

2. Реализовать функцию возведения числа a в степень b:
a. без рекурсии;
b. рекурсивно;
c. *рекурсивно, используя свойство чётности степени.

3. Исполнитель Калькулятор преобразует целое число, записанное на экране. У исполнителя две команды, каждой команде присвоен номер:
    1.Прибавь 1
    2.Умножь на 2
Первая команда увеличивает число на экране на 1, вторая увеличивает это число в 2 раза. Сколько существует программ,
которые число 3 преобразуют в число 20?
    а) с использованием массива;
    б) с использованием рекурсии.
*******************************************************************************************/

void solution1();
void solution2();
void solution3();
void solution4();



void menu();


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

    int chess[8][8];
    int i;
    int j;
    int x1;
    int x2;
    int y1;
    int y2;


    for (i = 0; i < 8; i++)
    {
        for (j = 0; j < 8; j++)
        {
            chess[i][j] = (i+j)%2;
        }
    }

    for (i = 0; i < 8; i++)
    {
        for (j = 0; j < 8; j++)
        {
            printf("%d ", chess[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    printf("Input X1:");
    scanf("%d", &x1);

    printf("Input X2:");
    scanf("%d", &x2);

    printf("Input Y1:");
    scanf("%d", &y1);

    printf("Input Y2:");
    scanf("%d", &y2);

    if (chess[x1][y1] == chess[x2][y2])
    {
        printf("\nThe same color!\n\n");
    }
    else
    {
        printf("\nNot the same color!\n\n");
    }
}
void solution2()
{
    printf("\nSolution 2\n");

}
void solution3()
{
    printf("Solution 3\n");

    int i;
    int number;
    int resplus = 0;
    int resinc = 0;
    int arr[20];
    int arrmax = 0;

    for (i = 1; i < 21; i++)
    {
        arr[i] + 1;
    }

    for (i = 1; i <= 50; i++)
    {
        resplus = arr[i] + 1;
        resinc = arr[i]*2;

        if ((20 - resplus) > 0)
        {
            number = number + 1;
        }

        if ((20 - resinc) > 0)
        {
            number = number + 1;
        }
    }


    printf("\n");
    printf("Max: %d\n", number);

}
void solution4()
{
    int a = 2, b = 8;
    long p = 1;
    printf("Solution 4\n");
    while (b)
    {
        if (b%2)
        {
            p = p*a;
            b--;
        }
        else
        {
            a = a*a;
            b = b/2;
        }

    }

    printf("%d\n", p);

}
void menu()
{
    printf("1 - task1\n");
    printf("2 - task2\n");
    printf("3 - task3\n");
    printf("4 - task4\n");
    printf("0 - exit\n");
}

