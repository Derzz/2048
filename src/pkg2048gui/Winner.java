/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * Winner.java
 * Class that displays the GUI aspects of the Winner screen and contains functions behind it.
 */

package pkg2048gui;

// Imports.
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Winner extends javax.swing.JFrame {

    public Winner() throws IOException {
        super("Winner!");           // Creates label for the window.
        this.setVisible(true);      // Make the Winner screen visible.
    }

    // Variable declaration.
    String name = "";   // Initialize temporary name input.
    File file;          // Initialize file variable.
    long time;          // Initialize time variable.

    // Method used to print out file information.
    public void fileIn(long time) throws IOException {
        name = txtUsername.getText();        // Store user input as the String varaible.
        int secTotal = (int) time;           // Change the number of seconds to be an integer value.
        File file = new File("win.txt");     // Creates an object to be able to call methods from this class.
        PrintWriter print = new PrintWriter(new FileWriter("win.txt", true));   // Creates an object to be able to call methods from this class.
        int minutes = secTotal / 60;         // Determines the number of minutes the user took.
        int seconds = secTotal % 60;         // Determines the number of seconds the user took in addition to the minutes.
        print.println(time + " " + name + " took " + minutes + " minutes and " + seconds + " seconds to reach 2048!");
        sort(file, print);                   // Moves to the sorting method.
    }

    // Method that sorts scores on the leaderboard. Reads the values, sorts them, and reprints them onto the file.
    public void sort(File file, PrintWriter out) throws FileNotFoundException, IOException {    //Takes File and Printwriter as parameters.
        Scanner fileReader = new Scanner(file);         // Creates an object to be able to call methods from this class.
        ArrayList<String> ar = new ArrayList<String>(); // Creates ArrayList so .txt components can be sorted
        int counter = 0;
        while (fileReader.hasNext()) {
            ar.add(fileReader.nextLine());     
        }
        Collections.sort(ar);       // Collections used to sort the ArrayList values.
        for (int i = 0; i < counter; i++) {
            out.println(ar.get(i)); // Prints out the sorted values onto the .txt file.
        }
        out.close();                // Closes PrintWriter.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnPlayAgain = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblNotice = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        lblTitle.setFont(new java.awt.Font("Clear Sans Medium", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(228, 192, 42));
        lblTitle.setText("WINNER!");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPlayAgain.setBackground(new java.awt.Color(237, 153, 91));
        btnPlayAgain.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnPlayAgain.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayAgain.setText("PLAY AGAIN");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(245, 124, 95));
        btnExit.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(236, 141, 83));
        btnMenu.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("MAIN MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblDescription.setFont(new java.awt.Font("Clear Sans Light", 1, 24)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(236, 141, 83));
        lblDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblUsername.setFont(new java.awt.Font("Clear Sans", 0, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(83, 77, 71));
        lblUsername.setText("Enter a Username to Join the Leaderboard:");
        lblUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtUsername.setFont(new java.awt.Font("Clear Sans", 0, 24)); // NOI18N

        lblNotice.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        lblNotice.setForeground(new java.awt.Color(83, 77, 71));
        lblNotice.setText("Score will not be saved if blank.");
        lblNotice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEnter.setBackground(new java.awt.Color(237, 153, 91));
        btnEnter.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("ENTER");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblUsername))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNotice)
                        .addGap(103, 103, 103)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lblTitle)
                .addGap(6, 6, 6)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsername)
                .addGap(12, 12, 12)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotice)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(btnPlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the Play Again button is pressed.
    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        this.setVisible(false);     // Hides the Winner screen.
        Menu b = new Menu();        // Creates an object to be able to call methods from this class.
        b.game();                   // Calls on method to play again.
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    // When the Exit button is pressed.
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);             // Exit the application.
    }//GEN-LAST:event_btnExitActionPerformed

    // When the Menu button is pressed.
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);     // Closes the Leaderboard window.
        Menu m = new Menu();        // Creates an object to be able to call methods from this class.
        m.start();                  // Calls on method to open the Main Menu.
    }//GEN-LAST:event_btnMenuActionPerformed

    // When the Enter button is pressed.
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        name = txtUsername.getText();   // Store the username from user input.
        if (!name.equals("")) {         // Check if the person's name is empty.
            try {
                fileIn(time);           // Method that prints the file information.
                btnEnter.hide();        // Hide the enter button.
            } catch (IOException ex) {
                Logger.getLogger(Winner.class.getName()).log(Level.SEVERE, null, ex);   // Catch in case of error.
            }
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    // This method stores the amount of time passed until user wins.
    public void start(long temp) {
        time = temp;        // Store the time to a temporary value.
        initComponents();   // Initialize components.
        lblDescription.setText("You reached 2048 in " + time + " seconds!");    // Sets the congradulatory text with a time.
        this.setVisible(true);  // Display the Winner screen.
    }

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
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblNotice;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
