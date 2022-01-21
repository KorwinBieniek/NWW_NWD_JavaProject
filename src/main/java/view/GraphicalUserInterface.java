package view;

import controller.Controller;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GraphicalUserInterface extends JFrame {

    private final JTextField numbersField;
    private final JTextField resultField;
    private static Container container = new Container();
    private final GuiExceptions exceptions = new GuiExceptions();
    JTable results;
    DefaultTableModel model;
    ArrayList<Integer> args = Controller.values;
    int listLength = Controller.listLength;


    public static Container getContainer() {
        return container;
    }

    public GraphicalUserInterface() {

        container = getContentPane();
        container.setLayout(new FlowLayout());

        String values = args.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

        Panel firstPanel = new Panel();
        Panel secondButton = new Panel();
        Panel thirdPanel = new Panel();
        firstPanel.setLayout(new FlowLayout());

        JButton nwwButton = new JButton("NWW");
        JButton nwdButton = new JButton("NWD");
        model = new DefaultTableModel();
        results = new JTable(model);

        model.addColumn("Numbers");
        model.addColumn("Result");

        model.addRow(new Object[]{model.getColumnName(0), model.getColumnName(1)});

        JLabel numberLabel = new JLabel("Numbers");
        JLabel resultLabel = new JLabel("Result");

        numbersField = new JTextField();
        numbersField.setColumns(8);

        resultField = new JTextField();
        resultField.setColumns(8);
        resultField.setEditable(false);

        thirdPanel.add(firstPanel);
        thirdPanel.add(secondButton);

        firstPanel.add(numberLabel);
        firstPanel.add(numbersField);
        firstPanel.add(resultLabel);
        firstPanel.add(resultField);


        numbersField.setText(values);

        secondButton.add(nwwButton);
        secondButton.add(nwdButton);

        container.add(firstPanel);
        container.add(secondButton);
        container.add(thirdPanel);
        container.add(results);

        nwwButton.addActionListener(this::handleNwwButtonClick);
        nwdButton.addActionListener(this::handleNwdButtonClick);
        firstPanel.setLayout(new GridLayout(4, 4));
        nwwButton.setMaximumSize(new Dimension(40, 40));
        nwdButton.setMaximumSize(new Dimension(40, 40));

        setSize(500, 500);
        setVisible(true);
    }


    private ArrayList<Integer> prepareList() {
        String[] preparsedList = numbersField.getText().split(", ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            for (String s : preparsedList) {
                arrayList.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException numberFormatException) {
            exceptions.showNumberFormatExceptionDialog();
            System.exit(0);
        }
        return arrayList;
    }

    private void handleNwwButtonClick(ActionEvent e) {
        NWW nww = new NWW();
        ArrayList<Integer> arrayList = prepareList();

        try {
            String values = arrayList.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            int result = nww.leastCommonMultiplier(listLength, args.size(), arrayList);
            this.resultField.setText(String.valueOf(result));
            model.addRow(new Object[]{"NWW " + values, result});
        } catch (NegativeValuesException | NotEnoughArgumentsException negativeValuesException) {
            exceptions.showNotEnoughArgumentsException();
            System.exit(0);
        }

    }

    private void handleNwdButtonClick(ActionEvent e) {
        NWD nwd = new NWD();
        ArrayList<Integer> arrayList = prepareList();

        try {
            int result = nwd.greatestCommonDivisorForArray(listLength, args.size(), arrayList);
            System.out.println(arrayList);
            this.resultField.setText(String.valueOf(result));
            String values = arrayList.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            model.addRow(new Object[]{"NWD " + values, result});
        } catch (NegativeValuesException | NotEnoughArgumentsException negativeValuesException) {
            exceptions.showNotEnoughArgumentsException();
            System.exit(0);
        }

    }


}