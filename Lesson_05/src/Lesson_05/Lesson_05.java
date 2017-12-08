package Lesson_05;

/**
 * Java 1. Home Work 5
 * @author Ilya Lutsevich
 * @version dated Dec 08 2017
 * @link https://github.com/lutsiy/git-repo.git
 */
import java.util.*;

public class Lesson_05 {

    Random rand = new Random();

    public static void main(String[] args) {
        final char DOT_X = 'x';
        final char DOT_O = 'o';
        final int SIZE = 3;
        char[][] map = new char[SIZE][SIZE];
        Human human = new Human(DOT_X, DOT_O);
        AI ai = new AI(DOT_O, DOT_X);
        Game game = new Game(SIZE);

        game.initMap(map);
        game.printMap(map);
        while (true) {
            human.humanTurn(map);
            game.printMap(map);
            if (game.checkWin(map, DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }
            if (game.isMapFull(map)) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            ai.aiTurn(map);
            game.printMap(map);
            if (game.checkWin(map, DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
        }
        System.out.println("GAME OVER.");
    }
}
class Human {
    Scanner sc = new Scanner(System.in);
    char dot;
    char dot_enemy;

    public Human(char dot, char dot_enemy) {
        this.dot = dot;
        this.dot_enemy = dot_enemy;
    }

    public void humanTurn(char map[][]) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y, map));
        map[y][x] = dot;
    }
    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_enemy)
            return false;
        return true;
    }
}
class AI{
    Random rand = new Random();
    char dot;
    char dot_enemy;

    public AI(char dot, char dot_enemy) {
        this.dot = dot;
        this.dot_enemy = dot_enemy;
    }

    void aiTurn(char map[][]) {
        int x, y;
        do {
            x = rand.nextInt(map.length);
            y = rand.nextInt(map.length);
        } while (!isCellValid(x, y, map));
        map[y][x] = dot;
    }

    boolean isCellValid(int x, int y, char map[][]) {
        if (x < 0 || y < 0 || x >= map.length || y >= map.length)
            return false;
        if (map[y][x] == dot_enemy)
            return false;
        return true;
    }

}
class Game{
    final char DOT_EMPTY = '.';
    private int size;

    public Game(int size) {
        this.size = size;
    }
    void initMap(char[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                map[i][j] = DOT_EMPTY;
    }

    boolean isMapFull(char[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    void printMap(char map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
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

