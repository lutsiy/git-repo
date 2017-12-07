package Lesson_05;

/**
 * Java 1. Home Work 5
 * @author Ilya Lutsevich
 * @version dated Dec 06 2017
 * @link https://github.com/lutsiy/git-repo.git
 */
import java.util.*;

public class Lesson_05 {


    Random rand = new Random();

    public static void main(String[] args) {
        final char DOT_X = 'x';
        final char DOT_O = 'o';
        final int SIZE = 3;

        Map map = new Map(SIZE);
        Human human = new Human(DOT_X);
        AI ai = new AI(DOT_O);
        Game game = new Game(SIZE);

        map.initMap(SIZE);

        while (true) {
            human.humanTurn(map.field);
            map.printMap(map.field);
            if (game.checkWin(map.field, DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (map.isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            ai.aiTurn(map.field);
            map.printMap(map.field);
            if (game.checkWin(map.field, DOT_O)) {
                System.out.println("AI WON!");
                break;
            }

        }
        System.out.println("GAME OVER.");


    }


}

class Map{
    final char DOT_EMPTY = '.';
    private int size;
    char[][] field = new char[size][size];

    public Map(int size) {
        this.size = size;
    }

    void initMap(int size) {
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                field[i][j] = DOT_EMPTY;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (field[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    void printMap(char map[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}//
class Human {
    Scanner sc = new Scanner(System.in);
    char dot_x;

    public Human(char dot_x) {
        this.dot_x = dot_x;
    }

    public void humanTurn(char map[][]) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y, map));
        map[y][x] = dot_x;
    }
    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_x)
            return true;
        return false;
    }
}
class AI{
    Scanner sc = new Scanner(System.in);
    char dot_x;

    public AI(char dot_x) {
        this.dot_x = dot_x;
    }

    void aiTurn(char map[][]) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y, map));
        map[y][x] = dot_x;
    }

    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_x)
            return true;
        return false;
    }

}
class Game{
    final char DOT_EMPTY = '.';
    private int size;

    public Game(int size) {
        this.size = size;
    }

    public boolean checkWin(char[][] map, char dot) {
        // check horizontals
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
        // check verticals
        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
        // check diagonals
        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
        return false;
    }



}



//class TicTacToe {
//


//
//

//
//    public static void main(String[] args) {
//        new TicTacToe();
//    }
//
//    TicTacToe() {

//    }
//

//
//
//

//
//    void aiTurn() {
//        int x, y;
//        do {
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//        map[y][x] = DOT_O;
//    }
//

//

//

//}