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

Исполнитель Калькулятор преобразует целое число, записанное на экране. У исполнителя две команды, каждой команде присвоен номер:
    1.Прибавь 1
    2.Умножь на 2
Первая команда увеличивает число на экране на 1, вторая увеличивает это число в 2 раза.
Сколько существует программ, которые число 3 преобразуют в число 20?
    3. C использованием массива;
    4. C использованием рекурсии.
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
}
void solution2()
{
    printf("\nSolution 2\n");
}
void solution3()
{
    printf("Solution 3\n");

    int i;
    int number = 0;
    int resplus = 0;
    int resinc = 0;
    int arr[20];
    int arrmax = 0;

    for (i = 0; i < 22; i++)
    {
        arr[i] = i + 3;
    }

resplus = 3;
resinc = 3;
    for (i = 1; i <= 22; i++)
    {
        resplus = resplus + 1;
        resinc = resinc*2;

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
    printf("Number: %d\n\n", number);

}
void solution4()
{


}
void menu()
{
    printf("1 - task1\n");
    printf("2 - task2\n");
    printf("3 - task3\n");
    printf("4 - task4\n");
    printf("0 - exit\n");
}

