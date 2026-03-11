import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorTool extends JFrame implements ActionListener {

    JTextField display;
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JButton add,sub,mul,div,eq,clear;

    double num1, num2, result;
    char operator;

    CalculatorTool() {

        setTitle("Calculator");
        setSize(300,350);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial",Font.BOLD,20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4,5,5));

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        eq = new JButton("=");
        clear = new JButton("C");

        panel.add(b7); panel.add(b8); panel.add(b9); panel.add(div);
        panel.add(b4); panel.add(b5); panel.add(b6); panel.add(mul);
        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(sub);
        panel.add(b0); panel.add(clear); panel.add(eq); panel.add(add);

        add(panel,BorderLayout.CENTER);

        JButton buttons[] = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,add,sub,mul,div,eq,clear};

        for(JButton b:buttons)
            b.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        // Numbers
        if(cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }

        // Operators
        else if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {

            num1 = Double.parseDouble(display.getText());
            operator = cmd.charAt(0);
            display.setText(display.getText() + cmd);
        }

        // Equal
        else if(cmd.equals("=")) {

            String text = display.getText();
            String parts[] = text.split("[+\\-*/]");
            num2 = Double.parseDouble(parts[1]);

            switch(operator) {

                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;
            }

            display.setText(num1 + "" + operator + "" + num2 + "=" + result);
        }

        // Clear
        else if(cmd.equals("C")) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorTool();
    }
}