/*
* Danish Wasif, Evan Woo, Michael Xie, Justin Ye
* August 24, 2021
* ICS4UE-20
* Class that displays the GUI aspects of the game over screen.
 */
package pkg2048gui;

public class GameOver extends javax.swing.JFrame {

    /**
     * Creates new form GameOver
     */
    
    public GameOver() {
        super("Game Over!");
        this.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playBut = new javax.swing.JButton();
        exitBut = new javax.swing.JButton();
        mainMenuBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 680));
        setPreferredSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        jLabel1.setFont(new java.awt.Font("Clear Sans Medium", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 124, 95));
        jLabel1.setText("GAME OVER!");
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

        mainMenuBut.setBackground(new java.awt.Color(236, 141, 83));
        mainMenuBut.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        mainMenuBut.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuBut.setText("MAIN MENU");
        mainMenuBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Clear Sans Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 77, 71));
        jLabel2.setText("You ran out of spaces and moves.");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(playBut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mainMenuBut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jLabel1))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addComponent(playBut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(mainMenuBut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When the play again button is clicked, it will restart the game and let the user play again.
    private void playButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButActionPerformed
        this.setVisible(false);
        Menu b = new Menu();
        b.game(); 
    }//GEN-LAST:event_playButActionPerformed

    //When the exit button is clicked, it will exit the game.
    private void exitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButActionPerformed

    //When the main menu button is clicked, it will send the user back to the main menu.
    private void mainMenuButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButActionPerformed
      this.setVisible(false);
        Menu m = new Menu();
        m.start(); 
    }//GEN-LAST:event_mainMenuButActionPerformed
    
    public void start() {
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
    private javax.swing.JButton exitBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mainMenuBut;
    private javax.swing.JButton playBut;
    // End of variables declaration//GEN-END:variables
}
