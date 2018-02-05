package ru.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyWindow extends JFrame{
    private JTextField jtf;
    private JTextArea jta;

    class MyHintTextField extends JTextField{
        String hint;

        public MyHintTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()){
                g.drawString(hint,4, 16);
            }
        }
    }

    public MyWindow(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Application");
        setBounds(300,500,400,400);
//        setLayout(new FlowLayout());
        JButton jb1 = new JButton("Button #1");
        JButton jb2 = new JButton("Button #2");
//        jb1.setPreferredSize(new Dimension(1, 200));

//        jb1.setBounds(10,10,50,50);
//        jb2.setBounds(20,20,100,20);

        add(jb1);
        add(jb2);

        jb1.addActionListener(e -> System.out.println("Clicked"));


//        for (int i = 0; i < 50; i++){
//            JButton jb = new JButton("#" + i);
//            add(jb);
//            jb.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    System.out.println("X");
//                                    }
//            });
//        }

        jtf = new JTextField(20);
        jta = new JTextArea(10,20);
        jtf = new MyHintTextField("Напишите сообщение");
        jta.setLineWrap(true);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        jb2.addActionListener(e -> sendMessage());

        jtf.addActionListener(e -> sendMessage());

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(jb1, BorderLayout.WEST);
        upperPanel.add(jb2, BorderLayout.EAST);
        upperPanel.add(jtf, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);
        add(jsp);

        JButton jbWarning = new JButton("Warning");
        jbWarning.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Warning!!!");
            JOptionPane.showInputDialog(null, "Here is your value", 10);
        });
        add(jbWarning, BorderLayout.SOUTH);
        jbWarning.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                jbWarning.setBackground(new Color((int)((float) e.getX()/(float)jbWarning.getWidth()*240f), 100,50));
            }
        });
        Font font = new Font("Arial", Font.ITALIC, 24);
        jta.setFont(font);
        JList<String> jls = new JList<>(new DefaultListModel<>());
        add(jls, BorderLayout.EAST);
        jls.setPreferredSize(new Dimension(100,1));
        ((DefaultListModel<String>)jls.getModel()).addElement("AAA");
        ((DefaultListModel<String>)jls.getModel()).addElement("BBB");
        ((DefaultListModel<String>)jls.getModel()).addElement("CCC");

        setVisible(true);

    }

    public void sendMessage(){
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
