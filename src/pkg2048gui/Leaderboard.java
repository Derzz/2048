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

        lbl2048Image = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDescription1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        btnShow = new javax.swing.JButton();
        lblDescription2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl2048Image)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(lblDescription1)
                                    .addComponent(lblDescription2))))))
                .addContainerGap(21, Short.MAX_VALUE))
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

//When the menu button is clicked, it sends the user to the main menu.
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.start();
    }//GEN-LAST:event_btnMenuActionPerformed
//When the show button is clicked, it shows the leaderboard from win.txt.
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        try {
            File file = new File("win.txt");
            Scanner fileReader = new Scanner(file);
            String temp = "";
            while(fileReader.hasNext()){
                fileReader.next();//Skips over the numbers at the beginning of the lines.
                temp = temp+fileReader.nextLine()+ "\n";//Stores the value into the String value
            }
            txtOutput.setText(temp);//Output the values on the JTextArea

        } catch (Exception e) {
            txtOutput.setText("Looks like no one has gotten a place on the leaderboard yet!\nMaybe it's time for you to get to 2048!");//If no file is detected, it means no one got to 2048. This means someone needs to get to 2048.
        }
        
        btnShow.hide();//Hides the show button
        lblDescription2.hide();//Hides the label asking them to click the "show" button.

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
