package EVENTDRIVEN2.copy;

import javax.swing.*;
import oop.*; // Import your logic classes
import java.awt.event.*;

public class GUI2 {

    private UserAcount account;

    public GUI2() {
        // create account with initial balance, max transactions, and PIN
        account = new UserAcount(1000, 100, 12345);
    }

    public void start() {
        JFrame frame = new JFrame("ARAB BANK ATM");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel atmLabel = new JLabel("ATM");
        atmLabel.setBounds(170, 10, 100, 25);
        frame.add(atmLabel);

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(20, 40, 100, 25);
        frame.add(pinLabel);

        JPasswordField pinField = new JPasswordField();
        pinField.setBounds(100, 40, 100, 25);
        frame.add(pinField);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(20, 70, 350, 25);
        frame.add(messageLabel);

        JLabel balanceLabel = new JLabel("Balance: " + account.getbalance() + " JD");
        balanceLabel.setBounds(20, 100, 300, 25);
        frame.add(balanceLabel);

        JButton checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(20, 140, 150, 30);
        frame.add(checkBalance);

        JButton deposit = new JButton("Deposit");
        deposit.setBounds(200, 140, 150, 30);
        frame.add(deposit);

        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(20, 190, 150, 30);
        frame.add(withdraw);

        JButton search = new JButton("Sentinel Search");
        search.setBounds(200, 190, 150, 30);
        frame.add(search);

        JButton exit = new JButton("Exit");
        exit.setBounds(110, 240, 150, 30);
        frame.add(exit);

        // disable buttons until PIN is validated
        checkBalance.setEnabled(false);
        deposit.setEnabled(false);
        withdraw.setEnabled(false);
        search.setEnabled(false);

        // PIN validation
        pinField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPin = new String(pinField.getPassword());
                if (account.validationpin(Integer.parseInt(enteredPin))) {
                    messageLabel.setText("PIN accepted!");
                    pinField.setEnabled(false);
                    checkBalance.setEnabled(true);
                    deposit.setEnabled(true);
                    withdraw.setEnabled(true);
                    search.setEnabled(true);
                } else {
                    messageLabel.setText("Wrong PIN, try again!");
                }
            }
        });

        // check balance
        checkBalance.addActionListener(e -> {
            balanceLabel.setText("Balance: " + account.getbalance() + " JD");
            messageLabel.setText("Balance checked.");
        });

        // deposit
        deposit.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            if (input != null && !input.isEmpty()) {
                int amount = Integer.parseInt(input);
                account.depositmoney(amount);
                balanceLabel.setText("Balance: " + account.getbalance() + " JD");
                messageLabel.setText("Deposited " + amount + " JD.");
            }
        });

        // withdraw
        withdraw.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            if (input != null && !input.isEmpty()) {
                int amount = Integer.parseInt(input);
                account.wethdrawmoney(amount);
                balanceLabel.setText("Balance: " + account.getbalance() + " JD");
                messageLabel.setText("Tried withdrawing " + amount + " JD.");
            }
        });

        // sentinel search
        search.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter transaction amount to search:");
            if (input != null && !input.isEmpty()) {
                int amount = Integer.parseInt(input);
                int result = account.sentinalsearch(amount);
                if (result != -1) {
                    JOptionPane.showMessageDialog(frame, "Transaction " + amount + " JD found at index " + result);
                } else {
                    JOptionPane.showMessageDialog(frame, "Transaction not found");
                }
            }
        });

        // exit
        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Thank you for using ARAB BANK ATM!");
            frame.dispose();
        });

        frame.setVisible(true);
    }}

  