/*
* Danish Wasif, Evan Woo, Michael Xie, Justin Ye
* August 24, 2021
* ICS4UE-20
* Class that displays the Leaderboard and the functions behind it.
 */
package pkg2048gui;

import java.io.File;
import java.util.Scanner;

public class Leaderboard extends javax.swing.JFrame {
    
    public Leaderboard() {
        super("Leaderboard");
        initComponents();
    }

    public void start() {
        this.setVisible(true);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        menuGame1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        out = new javax.swing.JTextArea();
        showBut = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 680));
        setPreferredSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        lblTitle2.setFont(new java.awt.Font("Clear Sans", 1, 48)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(236, 196, 0));
        lblTitle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2048Logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Clear Sans", 1, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(111, 107, 96));
        jLabel4.setText("LEADERBOARD");

        jLabel5.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(83, 77, 71));
        jLabel5.setText("Check out the people who reached 2048!");

        menuGame1.setBackground(new java.awt.Color(245, 124, 95));
        menuGame1.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        menuGame1.setForeground(new java.awt.Color(255, 255, 255));
        menuGame1.setText("MENU");
        menuGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGame1ActionPerformed(evt);
            }
        });

        out.setColumns(20);
        out.setRows(5);
        jScrollPane1.setViewportView(out);

        showBut.setBackground(new java.awt.Color(245, 124, 95));
        showBut.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        showBut.setForeground(new java.awt.Color(255, 255, 255));
        showBut.setText("Show!");
        showBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(83, 77, 71));
        jLabel6.setText("Click show to show the leaderboard!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showBut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showBut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//When the menu button is clicked, it sends the user to the main menu.
    private void menuGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGame1ActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.start();
    }//GEN-LAST:event_menuGame1ActionPerformed
//When the show button is clicked, it shows the leaderboard from win.txt.
    private void showButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButActionPerformed
        try {
            File file = new File("win.txt");
            Scanner fileReader = new Scanner(file);
            String temp = "";
            while(fileReader.hasNext()){
                fileReader.next();//Skips over the numbers at the beginning of the lines.
                temp = temp+fileReader.nextLine()+ "\n";//Stores the value into the String value
            }
            out.setText(temp);//Output the values on the JTextArea

        } catch (Exception e) {
            out.setText("Looks like no one has gotten a place on the leaderboard yet!\nMaybe it's time for you to get to 2048!");//If no file is detected, it means no one got to 2048. This means someone needs to get to 2048.
        }
        
        showBut.hide();//Hides the show button
        jLabel6.hide();//Hides the label asking them to click the "show" button.

    }//GEN-LAST:event_showButActionPerformed

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JButton menuGame1;
    private javax.swing.JTextArea out;
    private javax.swing.JButton showBut;
    // End of variables declaration//GEN-END:variables
}
