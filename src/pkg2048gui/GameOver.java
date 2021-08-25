/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * GameOver.java
 * Class that displays the GUI aspects of the Game Over screen.
 */

package pkg2048gui;

public class GameOver extends javax.swing.JFrame {

    /**
     * Creates new form GameOver
     */
    public GameOver() {
        super("Game Over!");        // Creates label for the window.
        this.setVisible(true);      // Makes the GameOver screen visible.
        initComponents();           // Initializes components.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        lblTitle.setFont(new java.awt.Font("Clear Sans Medium", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(245, 124, 95));
        lblTitle.setText("GAME OVER!");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPlay.setBackground(new java.awt.Color(237, 153, 91));
        btnPlay.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("PLAY AGAIN");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
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
        lblDescription.setForeground(new java.awt.Color(83, 77, 71));
        lblDescription.setText("You ran out of moves and spaces.");
        lblDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDescription)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(lblTitle))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addGap(51, 51, 51)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the Play Again button is pressed.
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        this.setVisible(false);     // Hides the Game Over screen.
        Menu b = new Menu();        // Creates an object to be able to call methods from this class.
        b.game();                   // Calls on method to play again.
    }//GEN-LAST:event_btnPlayActionPerformed

    // When the Exit button is pressed.
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);     // Close the application.
    }//GEN-LAST:event_btnExitActionPerformed

    // When the Main Menu button is pressed.
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);     // Hides the Game Over screen.
        Menu m = new Menu();        // Creates an object to be able to call methods from this class.
        m.start();                  // Calls on method to send user to the Main Menu.
    }//GEN-LAST:event_btnMenuActionPerformed

    // Function to be called to display Game Over screen.
    public void start() {
        this.setVisible(true);      // Displays the Game Over screen.
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
