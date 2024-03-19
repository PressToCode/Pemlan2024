package GUI.Classes.GUI_Template;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class redirectOutput extends OutputStream {
    private JTextArea textArea;

    public redirectOutput(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        textArea.setText(textArea.getText() + String.valueOf((char)b));
    }
}
