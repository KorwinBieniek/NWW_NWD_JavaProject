package view;

import model.NWD;
import model.NWW;
import model.NegativeValuesException;
import model.NotEnoughArgumentsException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIClass extends JFrame {

    private final JTextField numbersField;
    private final JTextField resultField;


    public GUIClass() {

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        Panel firstPanel = new Panel();
        Panel secondButton = new Panel();
        Panel thirdPanel = new Panel();
        firstPanel.setLayout(new FlowLayout());

        JButton nwwButton = new JButton("NWW");
        JButton nwdButton = new JButton("NWD");

        JLabel numberLabel = new JLabel("Numbers");
        JLabel resultLabel = new JLabel("Result");

        numbersField = new JTextField();
        numbersField.setColumns(8);

        resultField = new JTextField();
        resultField.setColumns(8);

        thirdPanel.add(firstPanel);
        thirdPanel.add(secondButton);

        firstPanel.add(numberLabel);
        firstPanel.add(numbersField);
        firstPanel.add(resultLabel);
        firstPanel.add(resultField);

        secondButton.add(nwwButton);
        secondButton.add(nwdButton);

        container.add(firstPanel);
        container.add(secondButton);
        container.add(thirdPanel);

        nwwButton.addActionListener(this::handleNwwButtonClick);
        nwdButton.addActionListener(this::handleNwdButtonClick);
        firstPanel.setLayout(new GridLayout(4, 4));
        nwwButton.setMaximumSize(new Dimension(40, 40));
        nwdButton.setMaximumSize(new Dimension(40, 40));

        setSize(200, 200);
        setVisible(true);
    }

    private ArrayList<Integer> prepareList() {
        String[] preparsedList = numbersField.getText().split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : preparsedList) {
            arrayList.add(Integer.parseInt(s));
        }
        return arrayList;
    }

    private void handleNwwButtonClick(ActionEvent e) {
        NWW nww = new NWW();
        ArrayList<Integer> arrayList = prepareList();

        try {
            this.resultField.setText(Integer.toString(nww.leastCommonMultiplier(1, 1, arrayList)));
        } catch (NegativeValuesException | NotEnoughArgumentsException negativeValuesException) {
            negativeValuesException.printStackTrace();
        }

    }

    private void handleNwdButtonClick(ActionEvent e) {
        NWD nwd = new NWD();
        ArrayList<Integer> arrayList = prepareList();

        try {
            this.resultField.setText(Integer.toString(nwd.greatestCommonDivisorForArray(1, 1, arrayList)));
        } catch (NegativeValuesException | NotEnoughArgumentsException negativeValuesException) {
            negativeValuesException.printStackTrace();
        }

    }
}