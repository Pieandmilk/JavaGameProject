package GUI;

import Entity.Entity;
import Main.GamePanel;
import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class GUI extends JDialog {
    static GamePanel gp;
    private JPanel contentPane;
    private JButton cartButton;
    private JButton deleteButton;
    private JLabel label3;
    private JComboBox itemCMB;
    private JButton payButton;

    private JTextArea panelView;

    private JLabel label1;
    private JList list1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField panelView2;
    private JLabel label7;
    private JScrollPane jScroll1;
    private JSpinner iQTY;
    private JLabel labelTitle;
    int reverse;

    String itemSelect, newEntry, cost;
    int qty, itemValue, sum,increments, addCount = 1;
    boolean ifFirstInstance = true;
    ArrayList<Entity> listOfPurchase = new ArrayList<>();


    public GUI(GamePanel gp) {
        this.gp=gp;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(cartButton);

        //resize and changing font
        try {
            InputStream fontFile = getClass().getResourceAsStream("/font/MinimalPixel v2.ttf"); // Adjust the font file name
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 14);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            String fontname = customFont.getFontName();
            ge.registerFont(customFont);

            labelTitle.setFont(new Font(fontname, Font.PLAIN, 22));
            itemCMB.setFont(new Font(fontname, Font.PLAIN, 17));
            panelView2.setFont(new Font(fontname, Font.PLAIN, 17));
            contentPane.setFont(new Font(fontname, Font.PLAIN, 17));
            panelView.setFont(new Font(fontname, Font.PLAIN, 17));
            cartButton.setFont(new Font(fontname, Font.PLAIN, 17));
            deleteButton.setFont(new Font(fontname, Font.PLAIN, 17));
            payButton.setFont(new Font(fontname, Font.PLAIN, 17));
            label3.setFont(new Font(fontname, Font.BOLD, 17));
            label1.setFont(new Font(fontname, Font.BOLD, 17));
            label6.setFont(new Font(fontname, Font.BOLD, 17));
            label4.setFont(new Font(fontname, Font.BOLD, 17));
            list1.setFont(new Font(fontname, Font.PLAIN, 17));
            jScroll1.setFont(new Font(fontname, Font.PLAIN, 17));

        } catch (Exception e) {
            e.printStackTrace();
        }

        cartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddToCart();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onPay();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onClose();
            }
        });
    }



    public void onAddToCart() {
        itemSelect = itemCMB.getSelectedItem().toString();
        qty = (int) iQTY.getValue();

        //values assigned
        if(itemSelect == "Normal Sword"){
            itemValue = 25;
            listOfPurchase.add(new OBJ_SWORD_Wooden(gp));
        }
        else if(itemSelect == "Advanced Sword"){
            itemValue = 78;
            listOfPurchase.add(new OBJ_SWORD_Steel(gp));
        }
        else if(itemSelect == "Silver Sword"){
            itemValue = 178;
            listOfPurchase.add(new OBJ_SWORD_Silver(gp));
        }
        else if(itemSelect == "Diamond Sword"){
            itemValue = 221;
        }
        else if(itemSelect == "Platinum Sword"){
            itemValue = 411;
        }
        else if(itemSelect == "Enchanted Sword"){
            itemValue = 450;
            listOfPurchase.add(new OBJ_SWORD_Enchanted(gp));
        }
        //shields
        if(itemSelect == "Normal Shield"){
            itemValue = 50;
        }
        else if(itemSelect == "Advanced Shield"){
            itemValue = 87;
        }
        else if(itemSelect == "Iron Shield"){
            itemValue = 120;
        }
        else if(itemSelect == "Gold Shield"){
            itemValue = 170;
        }
        else if(itemSelect == "Diamond Shield"){
            itemValue =190;
        }
        else if(itemSelect == "Enchanted Shield"){
            itemValue = 225;
        }
        else if(itemSelect == "Vibranium Shield"){
            itemValue=300;
        }
        else if(itemSelect == "Basic Potion"){
            itemValue=15;
            listOfPurchase.add(new OBJ_POTION_Healing_Small(gp));

        }
        else if(itemSelect == "Advanced Potion"){
            itemValue=35;
            listOfPurchase.add(new OBJ_POTION_Healing_Big(gp));
        }
        else if(itemSelect=="Super Potion"){
            itemValue=68;
        }

        calculations sets = new calculations(qty,itemValue);

        if (ifFirstInstance) {
            newEntry = "\n          PAYA MAYA" + "\n\n  " + itemSelect + "\n      Qty: " + qty +"........C" + itemValue + "\n";
            panelView.setText(panelView.getText() + newEntry);
            ifFirstInstance = false;
        } else {
            newEntry = "\n  "+ itemSelect + "\n      Qty: " + qty +"........C" + itemValue + "\n";
            panelView.setText(panelView.getText() + newEntry);
        }
        increments = (sets.math()*addCount);
        cost = "   Total: C" + increments + "\n\n";
        panelView2.setText(cost);
        addCount++;

        System.out.println(sum);

    }

    private void onPay(){
        gp.player.coin-=increments;
        for (int i=0; i <listOfPurchase.size();i++){
            gp.player.inventory.add(listOfPurchase.get(i));
        }
        listOfPurchase.clear();
       String pay = panelView.getText() + "\nTotal: C" + String.valueOf(increments);
        JOptionPane.showMessageDialog(null, pay , "Pay Maya",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(pay);
        increments=0;
        panelView.setText("");
        panelView2.setText("");
    }

    private void onClose(){
        dispose();
    }

    public static void main(String[] args) {
        GUI dialog = new GUI(gp);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
