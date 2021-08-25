/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * Leaderboard.java
 * Class that displays the GUI aspects of the Leaderboard and contains functions behind it.
 */

package pkg2048gui;

// Imports.
import java.io.File;
import java.util.Scanner;

public class Leaderboard extends javax.swing.JFrame {

    public Leaderboard() {
        super("Leaderboard");   // Creates label for the window.
        initComponents();       // Initializes components.
    }

    // Function to be called to open the Leaderboard.
    public void start() {
        this.setVisible(true);  // Make the Leaderboard visible.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2048Image = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDescription1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnShow = new javax.swing.JButton();
        lblDescription2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 680));
        setPreferredSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        lbl2048Image.setFont(new java.awt.Font("Clear Sans", 1, 48)); // NOI18N
        lbl2048Image.setForeground(new java.awt.Color(236, 196, 0));
        lbl2048Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2048Logo.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Clear Sans", 1, 40)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(111, 107, 96));
        lblTitle.setText("LEADERBOARD");

        lblDescription1.setFont(new java.awt.Font("Clear Sans Medium", 0, 14)); // NOI18N
        lblDescription1.setForeground(new java.awt.Color(83, 77, 71));
        lblDescription1.setText("Check out the people who reached 2048!");

        btnMenu.setBackground(new java.awt.Color(245, 124, 95));
        btnMenu.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        txtOutput.setColumns(20);
        txtOutput.setFont(new java.awt.Font("Clear Sans Medium", 0, 12)); // NOI18N
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        btnShow.setBackground(new java.awt.Color(245, 124, 95));
        btnShow.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setText("SHOW");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        lblDescription2.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        lblDescription2.setForeground(new java.awt.Color(83, 77, 71));
        lblDescription2.setText("Click Show to see the Leaderboard.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl2048Image)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblDescription1)
                    .addComponent(lblDescription2))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2048Image)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(lblDescription1)))
                        .addComponent(lblDescription2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the Menu Button is pressed. 
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);     // Closes the Leaderboard window.
        Menu m = new Menu();        // Creates an object to be able to call methods from this class.
        m.start();                  // Calls on method to open the Main Menu.
    }//GEN-LAST:event_btnMenuActionPerformed

    // When the Show Button is pressed.
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        try {
            File file = new File("win.txt");        // Try to create an object from the win.txt file.
            Scanner fileReader = new Scanner(file); // Use the Scanner to read the file.
            String temp = "";                       // Initialize a String value to store the win.txt file.
            while (fileReader.hasNext()) {          // While the file still has text after, the loop will continue.
                fileReader.next();                  // Skips over the numbers at the beginning of each line.
                temp = temp + fileReader.nextLine() + "\n"; // Stores the text into the String value and generates a new line.
            }
            txtOutput.setText(temp);    // Output the values on the txtOutput JTextArea.

        } catch (Exception e) {     // If no win.txt file can be found (no one reached 2048).
            txtOutput.setText("Looks like no one has gotten a place on the leaderboard yet!\nMaybe it's time for you to get to 2048!"); // Print loser message.
        }

        btnShow.hide();         // Hides the Show button.
        lblDescription2.hide(); // Hides the label asking the user to click the Show button.

    }//GEN-LAST:event_btnShowActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnShow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl2048Image;
    private javax.swing.JLabel lblDescription1;
    private javax.swing.JLabel lblDescription2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
}
