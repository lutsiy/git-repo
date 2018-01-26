package Lesson_07_star;
/**
 * Java 1. Home Work 7 star
 * @author Ilya Lutsevich
 * @version dated Dec 16 2017
 * @link https://github.com/lutsiy/git-repo.git
 */

/*
1. Добавить графический иньеофейс в задачу про котов и тарелки с едой
*/

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;

class Figure extends JComponent
{
    private static final long serialVersionUID = 1L;
    private Color color;
    private int x;
    private int y;
    private int width;
    private int height;
    private int type;

    // параметры: цвет и тип фигуры
    Figure(Color color, int x, int y, int width, int height, int type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.type = type;

        //setOpaque(false);
    }
    public void paintComponent(Graphics g) {
        // прорисовка фигуры
        g.setColor(color);
        switch (type) {
            case 0: g.drawRect(x, y, width, height); break;
            case 1: g.fillRect(x, y, width, height); break;
        }
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        int app;
        Cat[] cat = new Cat[10];
        Plate plate = new Plate(50);


        setBounds(500, 500, 400, 400);
        setTitle("Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);


        for (int i = 0; i<10; i++){
            Random rand = new Random();
            app = rand.nextInt(10) + 1;
            cat[i] = new Cat("cat " + (i+1), app);
            Figure figure1 = new Figure(Color.red , 5, 40, 10*app, 15, 0);
            figure1.setBounds(5, 30*i, 160, 180);
            add(figure1, JLayeredPane.MODAL_LAYER);
        }

        JButton button = new JButton("Добавить корм");
        setLayout(null);
        add(button);

        JButton button1 = new JButton("Покормить");
        setLayout(null);
        add(button1);

        JButton button2 = new JButton("Очистить");
        setLayout(null);
        add(button2);

        JLabel label = new JLabel();
        add(label);
        label.setBounds(300,5,200,50);
        label.setText(String.valueOf(plate));


        button.setBounds(150,50,150,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plate.increaseFood(30);
                label.setText(String.valueOf(plate));
                //System.out.println(plate);
            }

        });

        button1.setBounds(150,100,150,25);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0;i < 10; i++) {
                    if (plate.balance(cat[i]) >= 0) {
                        cat[i].eat(plate);
                        //System.out.println(cat[i].name + " eat " + cat[i].appetite + " (full = " + cat[i].full + ")");
                        Figure figure2 = new Figure(Color.red , 5, 40, 10*cat[i].appetite, 15, 1);
                        figure2.setBounds(5, 30*i, 160, 180);
                        add(figure2, JLayeredPane.MODAL_LAYER);
                        setVisible(true);
                        repaint();
                        label.setText(String.valueOf(plate));
                    } else {
                        //System.out.println(cat[i].name + " eat " + cat[i].appetite + " (not enough food!)" + " full = " + cat[i].full);
                    }
                    //System.out.println(plate);
                }
            }

        });

        button2.setBounds(150,150,150,25);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<10; i++){
                    Figure figure2 = new Figure(Color.blue , 5, 40, 10*cat[i].appetite, 15, 0);
                    figure2.setBounds(5, 30*i, 160, 180);
                    remove(findComponentAt(5, 30*i));
                    add(figure2, JLayeredPane.FRAME_CONTENT_LAYER);
                    repaint();

                }
                //System.out.println(plate);
            }
        });

        setVisible(true);
    }

    public static class Lesson_07_star {

        public static void main(String[] args) {
            MyWindow myWindow = new MyWindow();

        }
    }
    static class Cat {
        String name;
        int appetite;
        boolean full;

        Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
        }

        void eat(Plate plate) {
            plate.decreaseFood(appetite);
            this.full = true;
        }
    }

    static class Plate {
        private int food;

        Plate(int food) {
            this.food = food;
        }

        void decreaseFood(int food) {
            this.food -= food;
        }

        void increaseFood(int food) {
            this.food += food;
        }

        int balance(Cat cat) {
            return this.food - cat.appetite;
        }

        @Override
        public String toString() {
            return "Plate: " + food;
        }
    }
}