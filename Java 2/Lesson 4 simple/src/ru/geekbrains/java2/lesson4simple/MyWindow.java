package ru.geekbrains.java2.lesson4simple;

import javax.swing.*;
import java.awt.*;


public class MyWindow extends JFrame{
    private JTextField jtf;
    private JTextArea jta;


    public MyWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Chat");
        setBounds(300,500,400,400);
        JButton jb1 = new JButton("Отправить");


        add(jb1);

        jtf = new JTextField(20);
        jta = new JTextArea(10,20);
        jta.setLineWrap(true);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        jb1.addActionListener(e -> sendMessage());

        jtf.addActionListener(e -> sendMessage());

        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.add(jb1, BorderLayout.EAST);
        lowerPanel.add(jtf, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);
        add(jsp);

        Font font = new Font("Arial", Font.ITALIC, 24);
        jta.setFont(font);

        setVisible(true);

    }

    public void sendMessage(){
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
