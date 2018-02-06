package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {
    public TextField jtf;
    public TextArea jta;


    public void SendMessage(){
        jta.appendText(jtf.getText() + "\n");
        jtf.clear();
        jtf.requestFocus();

    }

}
