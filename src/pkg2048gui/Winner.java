/*
* Danish Wasif, Evan Woo, Michael Xie, Justin Ye
* August 24, 2021
* ICS4UE-20
* Class that displays the GUI aspects and the components of the winner screen.
 */
package pkg2048gui;

//Imported files
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Winner extends javax.swing.JFrame {

    public Winner() throws IOException {
        this.setVisible(true);
    }

    //Variable declaration
    String name = "";//Temporary name input
    File file;//File variable initalized
    long time;//Time variable initialized

    //Method used to print out file information
    public void fileIn(long time) throws IOException {
        name = nameIn.getText();
        int secTotal = (int) time;//Changed the time to be an integer value
        File file = new File("win.txt");
        PrintWriter print = new PrintWriter(new FileWriter("win.txt", true));
        int minutes = secTotal/60;//Minutes the user took
        int seconds = secTotal-minutes*60;//How many seconds the user took(excluding seconds)
        print.println(time+" "+name+ " took "+ minutes+ " minutes and "+seconds+" seconds to reach 2048!");
        sort(file, print);//Moves to the sorting method
    }
    
    //Sorting method
    public void sort(File file, PrintWriter out) throws FileNotFoundException, IOException{//Takes File and Printwriter as parameters
        //Below reads the values, sorts them, and reprints them onto the file.
        Scanner fileReader = new Scanner(file);
         ArrayList<String> ar = new ArrayList<String>();
         int counter = 0;
         while(fileReader.hasNext()){
             ar.add(fileReader.nextLine());
         }
         Collections.sort(ar);//Collections used to sort the ArrayList values.
         for(int i = 0; i < counter; i++){
             out.println(ar.get(i));
         }
         out.close();//Closes PrintWriter
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playBut = new javax.swing.JButton();
        exitBut = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameIn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        enter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        jLabel1.setFont(new java.awt.Font("Clear Sans Medium", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 192, 42));
        jLabel1.setText("WINNER!");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        playBut.setBackground(new java.awt.Color(237, 153, 91));
        playBut.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        playBut.setForeground(new java.awt.Color(255, 255, 255));
        playBut.setText("PLAY AGAIN");
        playBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButActionPerformed(evt);
            }
        });

        exitBut.setBackground(new java.awt.Color(245, 124, 95));
        exitBut.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        exitBut.setForeground(new java.awt.Color(255, 255, 255));
        exitBut.setText("EXIT");
        exitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButActionPerformed(evt);
            }
        });

        mainMenu.setBackground(new java.awt.Color(236, 141, 83));
        mainMenu.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        mainMenu.setForeground(new java.awt.Color(255, 255, 255));
        mainMenu.setText("MAIN MENU");
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Clear Sans Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 141, 83));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Clear Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(83, 77, 71));
        jLabel3.setText("Enter a Username to Join the Leaderboard:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameIn.setFont(new java.awt.Font("Clear Sans", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(83, 77, 71));
        jLabel4.setText("Score will not be saved if blank.");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        enter.setBackground(new java.awt.Color(237, 153, 91));
        enter.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        enter.setForeground(new java.awt.Color(255, 255, 255));
        enter.setText("Enter");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameIn, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(jLabel4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playBut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playBut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When the play button is clicked, it restarts the game and allows the user to replay the game
    private void playButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButActionPerformed
        this.setVisible(false);
        Menu b = new Menu();
        b.game();
    }//GEN-LAST:event_playButActionPerformed

    //Exit button, closes the game.
    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButActionPerformed

    //Goes back to the main menu when this button is clicked
    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.start();
    }//GEN-LAST:event_mainMenuActionPerformed

    //When enter is clicked, it stores the user's time and name into win.txt. 
    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        name = nameIn.getText();
        if (!name.equals("")) {
            try {
                fileIn(time);
                enter.hide();
            } catch (IOException ex) {
                Logger.getLogger(Winner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_enterActionPerformed

    public void start(long temp) {
        time = temp;
        initComponents();
        jLabel2.setText("You reached 2048 in " + time + " seconds!");
        this.setVisible(true);
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
    private javax.swing.JButton enter;
    private javax.swing.JButton exitBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton mainMenu;
    private javax.swing.JTextField nameIn;
    private javax.swing.JButton playBut;
    // End of variables declaration//GEN-END:variables

}
