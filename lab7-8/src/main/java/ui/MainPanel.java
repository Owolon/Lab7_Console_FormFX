package ui;

import logic.service.ProgramAnalyzerService;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainPanel extends JPanel {
    private JTextArea inputArea;
    private JTextArea outputArea;

    private final DefaultListModel<String> listModel;
    private final JList<String> keywordList;

    private JButton openButton;
    private JButton keywordButton;
    private JButton optimizeButton;
    private JButton clearButton;

    private ProgramAnalyzerService service;

    public MainPanel() {

        service = new ProgramAnalyzerService();

        setLayout(new BorderLayout());

        inputArea = new JTextArea();
        outputArea = new JTextArea();

        inputArea.setFont(
                new Font("Monospaced",
                        Font.PLAIN,
                        16)
        );

        outputArea.setFont(
                new Font("Monospaced",
                        Font.PLAIN,
                        16)
        );

        listModel = new DefaultListModel<>();

        keywordList = new JList<>(listModel);

        openButton = new JButton("Открыть файл");

        keywordButton =
                new JButton("Ключевые слова");

        optimizeButton =
                new JButton("Оптимизация ++");

        clearButton =
                new JButton("Очистить");

        JPanel topPanel = new JPanel();

        topPanel.add(openButton);

        topPanel.add(keywordButton);

        topPanel.add(optimizeButton);

        topPanel.add(clearButton);

        add(topPanel, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(inputArea),
                new JScrollPane(outputArea)
        );

        splitPane.setDividerLocation(550);

        add(splitPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(
                new BorderLayout()
        );

        bottomPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Ключевые слова"
                )
        );

        bottomPanel.add(
                new JScrollPane(keywordList),
                BorderLayout.CENTER
        );

        bottomPanel.setPreferredSize(
                new Dimension(100, 180)
        );

        add(bottomPanel, BorderLayout.SOUTH);

        initListeners();
    }

    private void initListeners() {

        openButton.addActionListener(e -> openFile());

        keywordButton.addActionListener(
                e -> analyzeKeywords()
        );

        optimizeButton.addActionListener(
                e -> optimizeCode()
        );

        clearButton.addActionListener(
                e -> clearAll()
        );
    }

    private void openFile() {

        JFileChooser chooser = new JFileChooser();

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            try {

                String content =
                        Files.readString(file.toPath());

                inputArea.setText(content);

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка чтения файла",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void analyzeKeywords() {

        String code = inputArea.getText();

        if (code.isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Введите код программы",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        listModel.clear();

        for (String keyword :
                service.findKeywords(code)) {

            listModel.addElement(keyword);
        }
    }

    private void optimizeCode() {

        String code = inputArea.getText();

        if (code.isBlank()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Введите код программы",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String optimized =
                service.optimizeCode(code);

        outputArea.setText(optimized);
    }

    private void clearAll() {

        inputArea.setText("");

        outputArea.setText("");

        listModel.clear();
    }
}
