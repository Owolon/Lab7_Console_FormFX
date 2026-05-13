package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("C# Analyzer - Java 21");

        setSize(1200, 700);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        add(new MainPanel(), BorderLayout.CENTER);
    }
}