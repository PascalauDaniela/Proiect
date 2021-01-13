package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
private static JList jList;
private static DefaultListModel model = new DefaultListModel();
private static JLabel nameLabel;
private static JTextField nameTextField;
private static  JLabel ageLabel;
private static JTextField ageTextField;
private static JLabel cnpLabel;
private static JTextField cnpTextField;
private static JButton add;
private static JButton modify;
private static JButton delete;

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(900, 500));
        JPanel jPanel= new JPanel();
        frame.add(jPanel);
        JToolBar toolBar= new JToolBar();

        placeComponentsForToolBar(toolBar);
        placeComponentsForAddNewObject(jPanel);

        placeComponentsForShowAllObjects(jPanel);


        frame.getContentPane().add(toolBar, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.pack();

    }

    private static void placeComponentsForShowAllObjects(JPanel jPanel) {
        jList = new JList(model);
        jPanel.add(jList);
        jList.setCellRenderer(createListRenderer());
        jList.setVisible(false);
         modify = new JButton("Modify");
        jPanel.add(modify);
        modify.setVisible(false);
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        delete = new JButton("Delete");
        jPanel.add(delete);
        delete.setVisible(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(jList.getSelectedIndex() != -1)
                model.remove(jList.getSelectedIndex());

            }
        });
    }

    private static void placeComponentsForAddNewObject(JPanel jPanel) {
         nameLabel= new JLabel("Name");
        jPanel.add(nameLabel);
         nameTextField = new JTextField(20);
        jPanel.add(nameTextField);


         ageLabel= new JLabel("Age");
        jPanel.add(ageLabel);
         ageTextField = new JTextField(20);
        jPanel.add(ageTextField);


         cnpLabel= new JLabel("Cnp");
        jPanel.add(cnpLabel);
         cnpTextField = new JTextField(20);
        jPanel.add(cnpTextField);

         add= new JButton("Add");
        jPanel.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                 String name = nameTextField.getText();
                 int age = Integer.parseInt(ageTextField.getText());
                String cnp = cnpTextField.getText();
                orphanage orphanage =  new orphanage(name,age,cnp);
                model.addElement(orphanage);
                nameTextField.setText("");
                ageTextField.setText("");
                cnpTextField.setText("");
                JOptionPane.showMessageDialog(null, "A new child was added.");

            }
        });
    }

    private static void placeComponentsForToolBar(JToolBar toolBar) {
        JButton addNewObject= new JButton("Add new Object");
        addNewObject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                 jList.setVisible(false);
                 modify.setVisible(false);
                 delete.setVisible(false);
                 nameLabel.setVisible(true);
                 nameTextField.setVisible(true);
                 ageLabel.setVisible(true);
                 ageTextField.setVisible(true);
                 cnpLabel.setVisible(true);
                 cnpTextField.setVisible(true);
                 add.setVisible(true);


                System.out.println("add new object clicked");
            }
        });

        toolBar.add(addNewObject);

        JButton showAllObjects = new JButton("Show all objects");
        showAllObjects.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                jList.setVisible(true);
                delete.setVisible(true);
                modify.setVisible(true);
                nameLabel.setVisible(false);
                nameTextField.setVisible(false);
                ageLabel.setVisible(false);
                ageTextField.setVisible(false);
                cnpLabel.setVisible(false);
                cnpTextField.setVisible(false);
                add.setVisible(false);


                System.out.println("show all pressed ");
            }
        });

        toolBar.add(showAllObjects);
        JButton exit = new JButton("Exit");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("exit clicked");
                System.exit(0);
            }
        });
        toolBar.add(exit);
    }
    private static ListCellRenderer<? super orphanage> createListRenderer(){
        return new DefaultListCellRenderer(){
            private Color background = new Color(0, 100, 255, 15);
            private Color defaultBackground = (Color) UIManager.get("List.background");

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel){
                    JLabel label = (JLabel) c;
                    orphanage orphanage = (orphanage) value;
                    label.setText(orphanage.getName() + ": " + orphanage.getCnp() + " :" + orphanage.getAge());
                    if (!isSelected){
                        label.setBackground(index % 2 == 0? background : defaultBackground);

                    }
                }
                return c;
            }

        };

    }
}
