import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatrixGUI extends JFrame implements ActionListener {

    JTextField rowsField, colsField;
    JButton createBtn, addBtn, subBtn, mulBtn;

    JPanel matrixPanelA, matrixPanelB, resultPanel;

    JTextField[][] a, b, res;
    int rows, cols;

    MatrixGUI() {
        setTitle("Matrix Operations");
        setSize(800, 600);
        setLayout(new BorderLayout(10,10));

        // 🔹 Top Panel
        JPanel top = new JPanel();
        top.add(new JLabel("Rows:"));
        rowsField = new JTextField(5);
        top.add(rowsField);

        top.add(new JLabel("Columns:"));
        colsField = new JTextField(5);
        top.add(colsField);

        createBtn = new JButton("Create");
        createBtn.addActionListener(this);
        top.add(createBtn);

        add(top, BorderLayout.NORTH);

        // 🔹 Center Panel
        JPanel center = new JPanel(new GridLayout(1,3,10,10));

        matrixPanelA = new JPanel();
        matrixPanelB = new JPanel();
        resultPanel = new JPanel();

        matrixPanelA.setBorder(BorderFactory.createTitledBorder("Matrix A"));
        matrixPanelB.setBorder(BorderFactory.createTitledBorder("Matrix B"));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));

        center.add(matrixPanelA);
        center.add(matrixPanelB);
        center.add(resultPanel);

        add(center, BorderLayout.CENTER);

        // 🔹 Bottom Panel
        JPanel bottom = new JPanel();

        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);

        bottom.add(addBtn);
        bottom.add(subBtn);
        bottom.add(mulBtn);

        add(bottom, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // 🔹 CREATE MATRICES
        if (e.getSource() == createBtn) {
            rows = Integer.parseInt(rowsField.getText());
            cols = Integer.parseInt(colsField.getText());

            matrixPanelA.removeAll();
            matrixPanelB.removeAll();
            resultPanel.removeAll();

            matrixPanelA.setLayout(new GridLayout(rows, cols, 5, 5));
            matrixPanelB.setLayout(new GridLayout(rows, cols, 5, 5));
            resultPanel.setLayout(new GridLayout(rows, cols, 5, 5));

            a = new JTextField[rows][cols];
            b = new JTextField[rows][cols];
            res = new JTextField[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    a[i][j] = new JTextField(2);
                    b[i][j] = new JTextField(2);
                    res[i][j] = new JTextField(2);

                    a[i][j].setHorizontalAlignment(JTextField.CENTER);
                    b[i][j].setHorizontalAlignment(JTextField.CENTER);
                    res[i][j].setHorizontalAlignment(JTextField.CENTER);

                    res[i][j].setEditable(false);

                    matrixPanelA.add(a[i][j]);
                    matrixPanelB.add(b[i][j]);
                    resultPanel.add(res[i][j]);
                }
            }

            revalidate();
            repaint();
        }

        // 🔹 ADDITION
        else if (e.getSource() == addBtn) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int x = Integer.parseInt(a[i][j].getText());
                    int y = Integer.parseInt(b[i][j].getText());
                    res[i][j].setText(String.valueOf(x + y));
                }
            }
        }

        // 🔹 SUBTRACTION
        else if (e.getSource() == subBtn) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int x = Integer.parseInt(a[i][j].getText());
                    int y = Integer.parseInt(b[i][j].getText());
                    res[i][j].setText(String.valueOf(x - y));
                }
            }
        }

        // 🔹 MULTIPLICATION
        else if (e.getSource() == mulBtn) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int sum = 0;
                    for (int k = 0; k < cols; k++) {
                        int x = Integer.parseInt(a[i][k].getText());
                        int y = Integer.parseInt(b[k][j].getText());
                        sum += x * y;
                    }
                    res[i][j].setText(String.valueOf(sum));
                }
            }
        }
    }

    public static void main(String[] args) {
        new MatrixGUI();
    }
}