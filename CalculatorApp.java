import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame
{
    JLabel operand1Label = new JLabel();
    JLabel operatorLabel = new JLabel();
    JLabel operand2Label = new JLabel();
    JLabel resultLabel = new JLabel();
    
    JTextField operand1TextField = new JTextField();
    JTextField operatorTextField = new JTextField();
    JTextField operand2TextField = new JTextField();
    JLabel resultValueLabel = new JLabel();
    
    JButton calculateButton = new JButton();
    JButton exitButton = new JButton();
    
    public CalculatorApp()
    {
        setTitle("Simple Calculator");
        setSize(250, 150);
        
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                exitForm(e);
            }
        });
        
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        
        operand1Label.setText("Operand 1");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        getContentPane().add(operand1Label, gridConstraints);
        
        operatorLabel.setText("Operator");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane().add(operatorLabel, gridConstraints);
        
        operand2Label.setText("Operand 2");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(operand2Label, gridConstraints);
        
        operand1TextField.setText("");
        operand1TextField.setColumns(10);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        getContentPane().add(operand1TextField, gridConstraints);
        
        operatorTextField.setText("");
        operatorTextField.setColumns(10);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(operatorTextField, gridConstraints);
        
        operand2TextField.setText("");
        operand2TextField.setColumns(10);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(operand2TextField, gridConstraints);
        
        calculateButton.setText("Calculate");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        getContentPane().add(calculateButton, gridConstraints);
        
        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                calculateButtonActionPerformed(e);
            }
        });
        
        exitButton.setText("Exit");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        getContentPane().add(exitButton, gridConstraints);
        
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);
            }
        });
    }
    
    private void exitForm(WindowEvent e)
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Closing Calculator App . . . ");
    }
    
    private void calculateButtonActionPerformed(ActionEvent e)
    {
        JFrame f = new JFrame();        
        String operator = operatorTextField.getText();
        String error = "Error";
        float operand1 = Float.parseFloat(operand1TextField.getText());
        float operand2 = Float.parseFloat(operand2TextField.getText());
        float result;
        
        switch(operator)
        {
            case("+"):
                result = operand1 + operand2;
                JOptionPane.showMessageDialog(f, "The result is " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case("-"):
                result = operand1 - operand2;
                JOptionPane.showMessageDialog(f, "The result is " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case("*"):
                result = operand1 * operand2;
                JOptionPane.showMessageDialog(f, "The result is " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            case("/"):
                result = operand1 / operand2;
                JOptionPane.showMessageDialog(f, "The result is " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(f, "Invalid operator. Please use any of the following:\n+, -, *, /");
                break;
        }
    }
    
    private void exitButtonActionPerformed(ActionEvent e)
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Exiting Calculator App . . . ");
        System.exit(0);
    }
    
    public static void main(String[] args)
    {
        new CalculatorApp().show();
    }
}