/**
 * Java 1. Home Work 4
 * @author Ilya Lutsevich
 * @version dated Dec 04 2017
 * @link https://github.com/lutsiy/git-repo.git
 */
import java.util.*;

class Lesson_04 {
    // Для решения четвертой задачи необходимо установить   SIZE = 5 (размер поля), и NUMBER_TO_WIN = 4 (количество фишек)
    // Для решения класической задачи необходимо установить SIZE = 3 (размер поля), и NUMBER_TO_WIN = 3 (количество фишек)
    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    final int NUMBER_TO_WIN = 3;
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new Lesson_04();
    }

    Lesson_04() {
        initMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            /*if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }*/
        }
        System.out.println("GAME OVER.");
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.." + SIZE + "):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        int i;
        int j = 0;
        int win = 0;
        int aii = 0;
        int aij = 0;
        //Проверим главную дагональ, есть ли у игрока есть 2 установленных крестика
        for (i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == DOT_X){
                        win = win + 1;
                        aii = i + 1;
                        aij = j + 1;
                        if(aii >= SIZE){
                            aii = aii - SIZE;
                        }
                        if (aij >= SIZE){
                            aij = aij - SIZE;
                        }
                    }
                }
            }
        }

        // Если есть два крестика , заблокируем
        if (win == NUMBER_TO_WIN - 1){
            if (isCellValid(aij, aii)) {
                map[aii][aij] = DOT_O;
                return;
            }
        } else {
            win = 0;
        }

        //Проверим вторую дагональ, есть ли у игрока есть 2 установленных крестика
        for (i = SIZE - 1, j = 0; i >= 0; i--, j++) {

            if (map[i][j] == DOT_X){
                win = win + 1;
                aii = i - 1;
                aij = j + 1;
                if(aii < 0){
                    aii = aii + SIZE;
                }
                if (aij >= SIZE){
                    aij = aij - SIZE;
                }
            }
        }

        // Если есть два крестика , заблокируем
        if (win == NUMBER_TO_WIN - 1){
            if (isCellValid(aij, aii)) {
                map[aii][aij] = DOT_O;
                return;
            }
        } else {
            win = 0;
        }

        //Проверим горизонтали, есть ли у игрока есть 2 установленных крестика
        for (i = 0; i < SIZE ; i++) {
            for (j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    win = win + 1;
                    aii = i;
                    aij = j + 1;
                    if(aii >= SIZE){
                        aii = aii - SIZE;
                    }
                    if (aij >= SIZE){
                        aij = aij - SIZE;
                    }
                }
            }
            // Если есть два крестика , заблокируем
            if (win == NUMBER_TO_WIN - 1) {
                if (isCellValid(aij, aii)) {
                    map[aii][aij] = DOT_O;
                    return;
                }
            } else {
                win = 0;
            }
        }

        //Проверим вертикали, есть ли у игрока есть 2 установленных крестика
        for (j = 0; j < SIZE ; j++) {
            for (i = 0; i < SIZE; i++) {
                if (map[i][j] == DOT_X) {
                    win = win + 1;
                    aii = i + 1;
                    aij = j;
                }
                if(aii >= SIZE){
                    aii = aii - SIZE;
                }
                if (aij >= SIZE){
                    aij = aij - SIZE;
                }
            }
            // Если есть два крестика , заблокируем
            if (win == NUMBER_TO_WIN - 1) {
                if (isCellValid(aij, aii)) {
                    map[aii][aij] = DOT_O;
                    return;
                }
            } else {
                win = 0;
            }
        }
        //Если перечисленные ситуации не выполнились, установим нолик стандартно, через rand()
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    boolean checkWin(char dot) {
        // Необходимо уточнить, что для поля 5х5 не рассмотрел вариант выигрыша, когда 4 фишки
        // установлены не на главной либо второй диагонали

        int win = 0;
        //Проверим главную дагональ
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == dot){
                        win = win + 1;
                    }
                }
            }
        }

        // Проверим, есть ли выигрышная комбинация
        if (win == NUMBER_TO_WIN){
            return true;
        } else {
            win = 0;
        }

        //Проверим вторую дагональ
        for (int i = SIZE - 1, j = 0; i >= 0; i--, j++) {

            if (map[i][j] == dot){
                win = win + 1;
            }
        }

        // Проверим, есть ли выигрышная комбинация
        if (win == NUMBER_TO_WIN){
            return true;
        } else {
            win = 0;
        }

        //Проверим горизонтали
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    win = win + 1;
                }
            }
            if (win == NUMBER_TO_WIN) {
                return true;
            } else {
                win = 0;
            }
        }

        //Проверим вертикали
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dot) {
                    win = win + 1;
                }
            }
            if (win == NUMBER_TO_WIN) {
                return true;
            } else {
                win = 0;
            }
        }
        return false;

//            // check horizontals
//        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
//        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
//        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
//        // check verticals
//        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
//        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
//        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
//        // check diagonals
//        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
//        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;

    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY)
            return true;
        return false;
    }
}
