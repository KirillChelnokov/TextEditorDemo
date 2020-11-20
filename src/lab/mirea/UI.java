package lab.mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class UI extends JFrame {
    JTextArea textEditorTextArea = new JTextArea("String",10,20);
    JButton someButton = new JButton("TestLayout");

    JMenuBar appMenuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Файл");
    JMenuItem openItem = new JMenuItem("Открыть...");

    FileOpener fileOpener = new FileOpener(this);

    public UI(String appName){
        super(appName);
        //setTitle(appName);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // System.setProperty("apple.laf.useScreenMenuBar", "true");

        appMenuBar.add(fileMenu);
        fileMenu.add(openItem);
        setJMenuBar(appMenuBar);

        openItem.addActionListener(fileOpener);

//        setLayout(new FlowLayout(FlowLayout.LEFT));
//        JPanel contents = (JPanel) getContentPane();
//        contents.add(textEditorTextArea);
//        contents.add(someButton);

        JPanel contents = (JPanel) getContentPane();
        contents.add(textEditorTextArea);

        //contents.add(someButton);
        //contents.add(someButton,BorderLayout.NORTH);
        JPanel buttonGroup = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonGroup.add(someButton);
        contents.add(buttonGroup,BorderLayout.NORTH);

//        add(someButton,BorderLayout.NORTH);
//        add(textEditorTextArea);

        //setSize(400,400);
        pack();
        //setMinimumSize(new Dimension(100,100));
        setVisible(true);
    }
}