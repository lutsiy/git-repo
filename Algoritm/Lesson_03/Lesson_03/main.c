#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MaxN 100

/******************************************************************************************
Илья Луцевич
2017-12-20

1. Попробовать оптимизировать пузырьковую сортировку. Сравнить количество операций
сравнения оптимизированной и не оптимизированной программы. Написать функции
сортировки, которые возвращают количество операций.
2. *Реализовать шейкерную сортировку.
3. Реализовать бинарный алгоритм поиска в виде функции, которой передается
отсортированный массив. Функция возвращает индекс найденного элемента или -1, если
элемент не найден.
4. *Подсчитать количество операций для каждой из сортировок и сравнить его с
асимптотической сложностью алгоритма.

*******************************************************************************************/

void solution1();
void solution2();
void solution3();
void solution4();



void menu();


void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}
// Распечатываем массив
void print(int N, int *a)
{
    int i;
    for(i = 0; i < N; i++)
        printf("%6i", a[i]);
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

void bubble()
{
    puts("not optimized\n");
    int a[] = {1,2,3,4,5,6,8,7,9,10};
    int n = 0;
    int i;

    puts("Array before sort");
    print(10, a);
    int j = 0;
    for(i = 0; i < 10 ; i++)
    {
        n = n + 1;
        for(j = 0; j < 10 - 1 ; j++)
        {
            if (a[j] > a[j + 1])
            {
                swap(&a[j], &a[j + 1]);
                n = n + 1;
            }

        }
    }

    puts("Array after sort");
    print(10, a);
    printf("number %d\n\n", n);
    return 0;
}

void bubble_optimized()
{
    puts("optimized\n");
    int a[] = {1,2,3,4,5,6,8,7,9,10};
    int n = 0;
    int i;
    int rep = 0;
    int ischange = 0;

    puts("Array before sort");
    print(10, a);
    int j = 0;
    for(i = 0; i < 10 ; i++)
    {
        n = n + 1;
        ischange = 0;
        for(j = 0; j < 10 - 1 ; j++)
        {
            if (a[j] > a[j + 1])
            {
                swap(&a[j], &a[j + 1]);
                n = n + 1;
                ischange = 1;
            }

        }
        if (ischange == 0)
        {
            break;
        }

    }

    rep++;

    puts("Array after sort");
    print(10, a);
    printf("number %d\n\n", n);


    return 0;
}


void solution1()
{
    printf("\nSolution 1\n\n");

    bubble();
    bubble_optimized();
    return 0;
}
void solution2()
{
    printf("\nSolution 2\n");
    int a[] = {5,3,8,11,1,5,7,3,4,10};
    int n;
    int i;

    puts("Array before sort");
    print(10, a);
    int j = 0;
    for(i = 0; i < 10; i++)
    {
        n = n + 1;
        for(j = 0; j < 10 - 1; j++)
            if (a[j] > a[j + 1])
            {
                swap(&a[j], &a[j + 1]);
                n = n + 1;
            }
        for(j = 0; j < 10 - 1; j++)
            if (a[9 - j] < a[9 - j - 1])
            {
                swap(&a[9 - j], &a[9 - j - 1]);
                n = n + 1;
            }

    }
    puts("Array after sort");
    print(10, a);
    printf("number %d\n", n);
    return 0;
}

int binary_Search(int n, int a[], int searchFor)
{
    int first = 0;
    int last = n;

    int mid;

    while (first < last)
    {
        mid = first + (last - first) / 2;

        if (searchFor <= a[mid])
            last = mid;
        else
            first = mid + 1;
    }

    if (a[last] == searchFor)
    {
        return last ;
    }
    else
    {
        return -1;
    }


}

void solution3()
{
    printf("\nSolution 3\n");
    int searchFor = 6;
    int a[] = {1,2,3,4,5,6,7,8,9,10};
    int found;

    found = binary_Search(9, a, searchFor);

    if (found != -1)
    {
        printf("%d Found in", searchFor);
        print(10, a);
        printf("index = %d\n\n", found);
    }
    else
    {
        printf("%d not Found in", searchFor);
        print(10, a);
        printf("\n\n");
    }

}
void solution4()
{

    printf("Solution 4\n\n");

}
void menu()
{
    printf("1 - task1\n");
    printf("2 - task2\n");
    printf("3 - task3\n");
    printf("4 - task4\n");
    printf("0 - exit\n");
}

