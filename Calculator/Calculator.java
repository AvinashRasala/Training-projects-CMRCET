import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private JFrame frame;
    private JTextField textField;
    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        frame.add(panel, BorderLayout.CENTER);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "C", "+",
                "="
        };

        ActionListener buttonListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                handleAction(command);
            }
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.addActionListener(buttonListener);
            setButtonColors(button, text);
            panel.add(button);
        }

        frame.setVisible(true);
    }

    private void handleAction(String command) {
        switch (command) {
            case "C":
                textField.setText("");
                operand1 = "";
                operand2 = "";
                operator = "";
                break;
            case "=":
                operand2 = textField.getText();
                calculate();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operand1 = textField.getText();
                operator = command;
                textField.setText("");
                break;
            default:
                textField.setText(textField.getText() + command);
                break;
        }
    }

    private void calculate() {
        try {
            double num1 = Double.parseDouble(operand1);
            double num2 = Double.parseDouble(operand2);
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            operand1 = String.valueOf(result);
            operand2 = "";
            operator = "";
        } catch (NumberFormatException e) {
            textField.setText("Error");
        }
    }

    private void setButtonColors(JButton button, String text) {
        if (text.matches("[0-9]")) {
            button.setBackground(Color.GRAY);
            button.setForeground(Color.WHITE);
        } else if (text.equals("C")) {
            button.setBackground(Color.RED);
            button.setForeground(Color.WHITE);
        } else if (text.equals("=")) {
            button.setBackground(Color.GREEN);
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
