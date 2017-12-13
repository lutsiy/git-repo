#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/******************************************************************************************
Илья Луцевич
2017-12-13

4.Реализовать алгоритм ускоренного возведения в степень.
3.*Реализовать алгоритм поиска простых чисел "Решето Эратосфена".
    **Вывести самое большое число, найденное с помощью этого алгоритма.
    ***Расчитайте время выполнения нахождения этого числа.
2.*Автоморфные числа. Натуральное число называется автоморфным, если оно равно
    последним цифрам своего квадрата. Например, 25^2 = 625. Напишите программу, которая
    вводит натуральное число N и выводит на экран все автоморфные числа, не превосходящие N.
1.С клавиатуры вводятся числовые координаты двух полей шахматной доски (x1,y1,x2,y2).
    Требуется определить, относятся ли к поля к одному цвету или нет.
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

    int a = 625;
    int b;
    int count;
    int length_number = 10;
    int arr[500000];
    int i;


    for (i = 0; i < 500000; i++)
    {
        arr[i] = i + 1;

    }

    for (i = 0; i < 500000; i++)
    {
        length_number = 10;
        a = arr[i];
        count = 0;
        while(a)
        {
            if (count > 0)
            {
                length_number*= 10;
            }
            a /= 10;
            count++;
        }
        if (length_number > 0)
        {
            b = (arr[i]*arr[i])%(length_number);
            if (b == arr[i])
            {
                printf("%d -> %d\n",arr[i], arr[i]*arr[i]);
            }
        }
    }
    printf("\n");

}
void solution3()
{
    printf("Solution 3\n");

    int i;
    int j;
    int seti = 0;
    int setj = 0;
    int arr[50];
    int arrmax = 0;
    time_t starttime;
    time_t endtime;
    double findtime;
    time (&starttime);

    for (i = 1; i < 50; i++)
    {
        arr[i] = i + 1;
    }

    for (i = 1; i <= 50; i++)
    {
        seti = arr[i];
        for (j = i + 1 ; j <= 50; j++)
        {

            setj = arr[j];
            if (seti != 0 && setj != 0)
            {
                if (setj%seti == 0)
                {
                    arr[j] = 0;
                }
            }
        }
    }

    for (i = 0; i <= 50; i++)
    {
        if (arr[i] != 0)
        {
            printf("%d ", arr[i]);
            if (arr[i] > arrmax)
            {
                arrmax = arr[i];
            }
        }
    }
    time (&endtime);
    findtime = difftime(endtime,starttime);
    printf("\n");
    printf("Max: %d\n", arrmax);
    printf("Time for found: %lf\n\n", findtime);
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

