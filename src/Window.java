import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Window {

    private JFrame frame = new JFrame("Window");
    private JTextArea textArea = new JTextArea();

    private JPanel panelAttack = new JPanel();
    private JButton baseAttack = new JButton("BaseAttack");
    private JButton strongAttack = new JButton("StrongAttack");
    private JButton baseAbility = new JButton("BaseAbility");
    private JButton specialAbility = new JButton("SpecialAbility");
    private JButton heal = new JButton("Heal");

    private JPanel panelText = new JPanel();
    private JLabel label = new JLabel("Enter text");
    private JTextField textField = new JTextField(10);
    private JButton send = new JButton("Send");

    private JPanel panelClass = new JPanel();
    private JButton warrior = new JButton("Warrior");
    private JButton mage = new JButton("Mage");
    private JButton assassin = new JButton("Assassin");

    private JPanel panelRace = new JPanel();
    private JButton human = new JButton("Human");
    private JButton orc = new JButton("Orc");
    private JButton elf = new JButton("Elf");

    private JPanel panelYesNo = new JPanel();
    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");

    private String result;
    private int resultInt;

    public void Open() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        panelAttack.add(baseAttack);
        panelAttack.add(strongAttack);
        panelAttack.add(baseAbility);
        panelAttack.add(specialAbility);
        panelAttack.add(heal);
        baseAttack.addActionListener(e -> setResult("BaseAttack"));
        strongAttack.addActionListener(a -> setResult("StrongAttack"));
        baseAbility.addActionListener(b -> setResult("BaseAbility"));
        specialAbility.addActionListener(c -> setResult("SpecialAbility"));
        heal.addActionListener(d -> setResult("Heal"));

        panelText.add(label);
        panelText.add(textField);
        send.addActionListener(a -> setResult(textField.getText()));

        panelClass.add(warrior);
        panelClass.add(mage);
        panelClass.add(assassin);
        warrior.addActionListener(a -> setResult("Warrior"));
        mage.addActionListener(b -> setResult("Mage"));
        assassin.addActionListener(c -> setResult("Assassin"));

        panelRace.add(human);
        panelRace.add(orc);
        panelRace.add(elf);
        human.addActionListener(a -> setResult("Human"));
        orc.addActionListener(b -> setResult("Orc"));
        elf.addActionListener(c -> setResult("Elf"));

        panelYesNo.add(yes);
        panelYesNo.add(no);
        yes.addActionListener(a -> setResult("Yes"));
        no.addActionListener(b -> setResult("No"));

        frame.getContentPane().add(BorderLayout.SOUTH, panelText);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }

    public void setPanelAttack() {
        frame.getContentPane().add(BorderLayout.SOUTH, panelAttack);
    }

    public void setPanelText() {
        frame.getContentPane().add(BorderLayout.SOUTH, panelText);
    }

    public void setPanelClass() {
        frame.getContentPane().add(BorderLayout.SOUTH, panelClass);
    }

    public void setPanelRace() {
        frame.getContentPane().add(BorderLayout.SOUTH, panelRace);
    }

    public void setPanelYesNo() {
        frame.getContentPane().add(BorderLayout.SOUTH, panelYesNo);
    }

    public void removePanelAttack() {
        frame.getContentPane().remove(panelAttack);
    }
    public void removePanelText() {
        frame.getContentPane().remove(panelText);
    }
    public void removePanelClass() {
        frame.getContentPane().remove(panelClass);
    }
    public void removePanelRace() {
        frame.getContentPane().remove(panelRace);
    }
    public void removePanelYesNo() {
        frame.getContentPane().remove(panelYesNo);
    }


    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void Print(String text) {
        textArea.append(text + "\n");
    }

    public void resetTextField() {
        textField.setText("");
    }

    public void resetTextArea() {
        textArea.setText("");
    }
}
