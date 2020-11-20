package lab.mirea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileOpener implements ActionListener {
    JFileChooser fileChooser;
    UI mainApp;

    public FileOpener(UI mainApp){
        this.fileChooser = new JFileChooser();
        this.mainApp = mainApp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showOpenDialog(null);

        if (result==JFileChooser.APPROVE_OPTION){
            File readFile = fileChooser.getSelectedFile();

            try {
                FileReader fileReader = new FileReader(readFile);

                int c;
                String resultString = "";
                String readLine;

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((readLine=bufferedReader.readLine())!=null){
                    resultString = resultString.concat(readLine);
                }
                mainApp.textEditorTextArea.setText(resultString);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
