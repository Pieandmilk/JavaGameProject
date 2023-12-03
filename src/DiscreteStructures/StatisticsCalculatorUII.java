package DiscreteStructures;//LAWRENCE MADE THIS CLASS FOR DISCRETE
//ONE MORE THING, I ADDED SOME BACKGROUND IMAGES SA RES > BACKGROUND, DONT FORGET TO MERGE IT AS WELL
//ALSO I PROVIDED A FOLDER WHERE IT CONTAINS 2 .JAR FILES, AND NEED NIYO ILAGAY SA DEPENDENCIES NG INTELLIJ IDEA.

//STEPS ON HOW TO DO IT:
//IN INTELLI IDEA, OPEN OUR PROJECT, THEN SA TOP LEFT CORNER,
//GO TO FILE > PROJECT STRUCTURE > MODULES > DEPENDENCIES > CLICK "+" > ADD JARS OR DIRECTORIES
//NOW SELECT THE TWO JARS I PROVIDED.
// IT WILL WORK FINE RIGHT AFTER.



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.io.File;
import javax.swing.UIManager.LookAndFeelInfo;

public class StatisticsCalculatorUII extends JFrame {

    /**
     * Creates new form StatisticsCalculatorUI
     */
    private static int elementCount,num = 50,index = 0;
    ;
    private static double[] dataSet = new double[num];
    private static double[] newdataSet;
    private static double elements,sum = 0,mean,var,dev;;
    private static String displayInfo = "";
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public StatisticsCalculatorUII() {

        setTitle("PROFESSOR'S STATISTICS CALCULATOR");


        initComponents();
        doDesignComponents();

        fieldElements.setEnabled(false);
        buttonEnterElement.setEnabled(false);
        infoDisplay.setEditable(false);
        getMean.setEnabled(false);
        getDev.setEnabled(false);
        getVar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new JPanel();
        buttonEnterCountElement = new JButton();
        countElement = new JSpinner();
        labelElementCount = new JLabel();
        labelElements = new JLabel();
        fieldElements = new JTextField();
        buttonEnterElement = new JButton();
        labelElementList = new JLabel();
        jScrollPane1 = new JScrollPane();
        infoDisplay = new JTextArea();
        getMean = new JButton();
        getVar = new JButton();
        getDev = new JButton();
        buttonClear = new JButton();
        buttonQuit = new JButton();
        elementCountError = new JLabel();
        Background = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550,630 ));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new Dimension(550, 630));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEnterCountElement.setBackground(new Color(0, 154, 152));
        buttonEnterCountElement.setFont(new Font("sansserif", 0, 17)); // NOI18N
        buttonEnterCountElement.setForeground(new Color(255, 234, 0));
        buttonEnterCountElement.setText("GO");
        buttonEnterCountElement.setAlignmentX(0.1F);
        buttonEnterCountElement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onEnterCountElement();
            }
        });
        jPanel1.add(buttonEnterCountElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 20, -1, -1));


        countElement.setFont(new Font("sansserif", 0, 17)); // NOI18N
        jPanel1.add(countElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 20, 134, -1));

        labelElementCount.setFont(new Font("sansserif", 0, 17)); // NOI18N
        labelElementCount.setForeground(new Color(255, 234, 0));
        labelElementCount.setText("ELEMENT COUNT:");
        jPanel1.add(labelElementCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        labelElements.setFont(new Font("sansserif", 0, 17)); // NOI18N
        labelElements.setForeground(new Color(255, 234, 0));
        labelElements.setText("ENTER ELEMENT #1:");
        jPanel1.add(labelElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        fieldElements.setBackground(new Color(51, 47, 0));
        fieldElements.setFont(new Font("sansserif", 0, 17)); // NOI18N
        jPanel1.add(fieldElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 69, 127, -1));

        buttonEnterElement.setBackground(new Color(0, 154, 152));
        buttonEnterElement.setFont(new Font("sansserif", 0, 17)); // NOI18N
        buttonEnterElement.setForeground(new Color(255, 234, 0));
        buttonEnterElement.setText("ADD");
        buttonEnterElement.setAlignmentX(0.1F);
        buttonEnterElement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onAppendData();
            }
        });
        jPanel1.add(buttonEnterElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 69, -1, -1));


        labelElementList.setFont(new Font("sansserif", 0, 17)); // NOI18N
        labelElementList.setForeground(new Color(255, 234, 0));
        labelElementList.setText("ELEMENTS LIST");
        jPanel1.add(labelElementList, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 111, -1, -1));

        infoDisplay.setBackground(new Color(51, 47, 0));
        infoDisplay.setColumns(20);
        infoDisplay.setFont(new Font("sansserif", 0, 14)); // NOI18N
        infoDisplay.setForeground(new Color(255, 234, 0));
        infoDisplay.setRows(5);
        jScrollPane1.setViewportView(infoDisplay);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 140, 403, 234));

        getMean.setBackground(new Color(0, 154, 152));
        getMean.setFont(new Font("sansserif", 0, 17)); // NOI18N
        getMean.setForeground(new Color(255, 234, 0));
        getMean.setText("GET MEAN");
        getMean.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onMean();
            }
        });
        jPanel1.add(getMean, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 190, 40));

        getVar.setBackground(new Color(0, 154, 152));
        getVar.setFont(new Font("sansserif", 0, 17)); // NOI18N
        getVar.setForeground(new Color(255, 234, 0));
        getVar.setText("GET VARIANCE");
        getVar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onVar();
            }
        });
        jPanel1.add(getVar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 190, 40));

        getDev.setBackground(new Color(0, 154, 152));
        getDev.setFont(new Font("sansserif", 0, 17)); // NOI18N
        getDev.setForeground(new Color(255, 234, 0));
        getDev.setText("GET DEVIATION");
        getDev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onDev();
            }
        });
        jPanel1.add(getDev, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, -1, 40));


        buttonClear.setBackground(new Color(0, 154, 152));
        buttonClear.setFont(new Font("sansserif", 0, 17)); // NOI18N
        buttonClear.setForeground(new Color(255, 234, 0));
        buttonClear.setText("CLEAR");
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onClear();
            }
        });
        jPanel1.add(buttonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 156, 40));

        buttonQuit.setBackground(new Color(0, 154, 152));
        buttonQuit.setFont(new Font("sansserif", 0, 17)); // NOI18N
        buttonQuit.setForeground(new Color(255, 234, 0));
        buttonQuit.setText("QUIT");
        buttonQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        jPanel1.add(buttonQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 156, 40));
        jPanel1.add(elementCountError, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 150, -1));

        Background.setIcon(new ImageIcon("E:\\code\\Java scripts\\JavaGame\\res\\background\\GameBG2.jpg")); // NOI18N
        Background.setText("jLabel1");
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 680, 860));

        jPanel1.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAppendData();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 632));

        pack();
    }// </editor-fold>


    private void doDesignComponents(){
        try {
            InputStream fontFile = getClass().getResourceAsStream("/font/MinimalPixel v2.ttf"); // Adjust the font file name
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, 14);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            String fontname = customFont.getFontName();
            ge.registerFont(customFont);

            labelElementCount.setFont(new Font(fontname, Font.BOLD, 17));
            getMean.setFont(new Font(fontname, Font.BOLD, 17));
            getVar.setFont(new Font(fontname, Font.BOLD, 17));
            getDev.setFont(new Font(fontname, Font.BOLD, 17));
            countElement.setFont(new Font(fontname, Font.PLAIN, 17));
            fieldElements.setFont(new Font(fontname, Font.PLAIN, 17));
            infoDisplay.setFont(new Font(fontname, Font.PLAIN, 17));
            infoDisplay.setForeground(Color.WHITE);
            buttonClear.setFont(new Font(fontname, Font.PLAIN, 17));
            buttonEnterElement.setFont(new Font(fontname, Font.BOLD, 17));
            buttonQuit.setFont(new Font(fontname, Font.BOLD, 17));
            buttonEnterCountElement.setFont(new Font(fontname, Font.BOLD, 17));
            elementCountError.setFont(new Font(fontname, Font.PLAIN, 17));
            labelElementList.setFont(new Font(fontname, Font.BOLD, 17));
            labelElements.setFont(new Font(fontname, Font.BOLD, 17));
            labelElementList.setForeground(Color.WHITE);
            fieldElements.setForeground(new Color(255,234,0));
            fieldElements.setHorizontalAlignment(SwingConstants.RIGHT);
            countElement.setOpaque(true);
            countElement.setBackground(new Color(51,47,0));
            jScrollPane1.setBackground(new Color(51,47,0));
            jScrollPane1.setForeground(new Color(51,47,0));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEnterCountElement(){
        elementCount = (int) countElement.getValue();
        if (elementCount != 0) {
            fieldElements.setEnabled(true);
            fieldElements.setEditable(true);
            buttonEnterElement.setEnabled(true);

            countElement.setEnabled(false);
            buttonEnterCountElement.setEnabled(false);

            elementCountError.setText("");
            elementCountError.setEnabled(false);
        } else {
            elementCountError.setEnabled(true);
            elementCountError.setText("Element Count must be > 0");
            elementCountError.setForeground(Color.RED);
        }
    }

    public void onAppendData(){
        elementCount = (int) countElement.getValue();
        try {
            elements = Double.parseDouble(fieldElements.getText());

            if (index >= dataSet.length){
                double[] newdataSet = new double[dataSet.length * 2];
                System.arraycopy(dataSet,0,newdataSet,0,dataSet.length);
                dataSet = newdataSet;
            }
            dataSet[index] = elements;
            index++;

        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }

        int elementsInt = (int) elements;
        displayInfo = displayInfo + "Element #" + index + ": " + elementsInt + "\n";
        labelElements.setText("ENTER ELEMENT #" + (index + 1) + ": ");
        infoDisplay.setText(displayInfo);
        fieldElements.setText("");

        if (index == elementCount){
            fieldElements.setEnabled(false);
            buttonEnterElement.setEnabled(false);
            getMean.setEnabled(true);
        }
    }


    public void onMean() {
        //MAKING A NEW ARRAY, WHERE THE PREVIOUS ARRAY'S ELEMENTS (WHERE THE INPUTTED ELEMENTS ARE STORED) WILL BE STORED TO.
        newdataSet = new double[elementCount];

        //STORING FROM PREVIOUS ARRAY, TO NEW ARRAY.
        for (int h = 0; h < elementCount; h++){
            newdataSet[h] = dataSet[h];
        }

        //GETTING THE SUM OF ALL THE ELEMENTS IN THE ARRAY.
        for (int i = 0; i < newdataSet.length; i++) {
            sum += newdataSet[i];
        }

        //DIVIDING SUM BY THE NEW ARRAY'S LENGTH.
        //FOR EXAMPLE, {90,95}.
        //SUM IS 185
        //185 / 2
        //THEREFORE, MEAN IS 92.5
        mean =  sum / newdataSet.length;

        //SETTTING DECIMAL POINTS TO 2.
        String forMean = decimalFormat.format(mean);
        displayInfo = infoDisplay.getText() + "\nMEAN: " + forMean;
        infoDisplay.setText(displayInfo);

        getMean.setEnabled(false);
        getVar.setEnabled(true);
    }

    public void onVar() {
        //THIS VARIABLE WILL BE USE TO ACCUMULATE THE SUM OF SQUARED DIFFERENCE BETWEEN EACH ELEMENT OF THE ARRAY AND THE MEAN.
        double sumSquaredDiff = 0;

        //THIS ITERATION IS TO GET THE SQUARED DIFFERENCE OF MEAN AND EVERY ELEMENTS.
        //FOR EXAMPLE, {90,95} WITH A MEAN OF 92.5, FIRST IS (90 - 92.5)^2 = 6.25, WHILE (95 - 92.5)^2 = 6.25
        for (int i = 0; i < newdataSet.length; i++) {
            sumSquaredDiff += Math.pow(newdataSet[i] - mean, 2);
        }
        //SUMSQUAREDDIFF = 12.5
        //12.5 / 2
        // VARIANCE IS 6.25
        var = sumSquaredDiff / newdataSet.length;
        String forVar = decimalFormat.format(var);
        displayInfo = infoDisplay.getText() + "\nVARIANCE: " + forVar;
        infoDisplay.setText(displayInfo);

        getVar.setEnabled(false);
        getDev.setEnabled(true);

    }

    private void onDev(){
        //SIMPLY GETTING THE SQUAREROOT OF THE VARIANCE.
        //FOR EXAMPLE, VARIANCE IS 6.25
        //THEREFORE, DEVIATION IS 2.5
        dev = Math.sqrt(var);
        String forDev = decimalFormat.format(dev);
        displayInfo = infoDisplay.getText() + "\nSTANDARD DEVIATION: " + forDev;
        infoDisplay.setText(displayInfo);
        getDev.setEnabled(false);

    }

    public void onClear(){
        displayInfo = "";
        index = 0;
        sum = 0;
        infoDisplay.setText("");
        fieldElements.setText("");
        countElement.setValue(0);
        labelElements.setText("ENTER ELEMENT #1:");
        countElement.setEnabled(true);
        buttonEnterCountElement.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Set Nimbus look and feel
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("FlatLaf".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Handle exceptions gracefully
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                StatisticsCalculatorUII frame = new StatisticsCalculatorUII();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel Background;
    private JButton buttonClear;
    private JButton buttonEnterCountElement;
    private JButton buttonEnterElement;
    private JButton buttonQuit;
    private JSpinner countElement;
    private JLabel elementCountError;
    private JTextField fieldElements;
    private JButton getDev;
    private JButton getMean;
    private JButton getVar;
    private JTextArea infoDisplay;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JLabel labelElementCount;
    private JLabel labelElementList;
    private JLabel labelElements;
    // End of variables declaration
}
