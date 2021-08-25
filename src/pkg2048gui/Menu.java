/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * Menu.java
 * Class that displays the GUI aspects of the Menu.
 */

package pkg2048gui;

class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Board
     */
    public Menu() {
        super("Main Menu");     // Creates label for the window.
        initComponents();       // Initialize components.

    }
    
    // Function to be called to open the Main Menu.
    public void start() {
        this.setVisible(true);  // Make the Main Menu visible.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // Game method, invokes the game.
    public void game() {
        this.setVisible(false);     // Hide the Main Menu window.
        Game g = new Game();        // Creates an object to be able to call methods from this class.
        g.start();                  // Calls on method to start the Game.
    }

    // Tutorial method, invokes the tutorial.
    public void tutorial() {
        this.setVisible(false);         // Hide the Main Menu window.
        Tutorial t = new Tutorial();    // Creates an object to be able to call methods from this class.
        t.start();                      // Calls on method to open the Tutorial.
    }

    // Leaderboard method, invokes the leaderboard.
    public void leaderboard() {
        this.setVisible(false);                 // Hide the Main Menu window.
        Leaderboard b = new Leaderboard();      // Creates an object to be able to call methods from this class.
        b.start();                              // Calls on method to open the Leaderboard.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2048Image = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnTutorial = new javax.swing.JButton();
        btnLeaderboard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(251, 248, 241));
        setBounds(new java.awt.Rectangle(0, 25, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(500, 680));
        setResizable(false);

        lbl2048Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2048LogoLarge.png"))); // NOI18N
        lbl2048Image.setDoubleBuffered(true);
        lbl2048Image.setPreferredSize(new java.awt.Dimension(470, 620));

        btnExit.setBackground(new java.awt.Color(245, 124, 95));
        btnExit.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnPlay.setBackground(new java.awt.Color(237, 153, 91));
        btnPlay.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("PLAY");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnTutorial.setBackground(new java.awt.Color(236, 141, 83));
        btnTutorial.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnTutorial.setForeground(new java.awt.Color(255, 255, 255));
        btnTutorial.setText("TUTORIAL");
        btnTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorialActionPerformed(evt);
            }
        });

        btnLeaderboard.setBackground(new java.awt.Color(236, 224, 202));
        btnLeaderboard.setFont(new java.awt.Font("Clear Sans", 1, 24)); // NOI18N
        btnLeaderboard.setForeground(new java.awt.Color(119, 110, 101));
        btnLeaderboard.setText("LEADERBOARD");
        btnLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl2048Image, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl2048Image, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnTutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the Exit button is pressed.
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);     // Exit the application.
    }//GEN-LAST:event_btnExitActionPerformed

    //Play button, allows the user to play the game
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        game();
    }//GEN-LAST:event_btnPlayActionPerformed

    //Tutorial button, allows the user to start the tutorial
    private void btnTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorialActionPerformed
        tutorial();
    }//GEN-LAST:event_btnTutorialActionPerformed

    //Leaderboard button, allows the user to access the leaderboard
    private void btnLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderboardActionPerformed
        leaderboard();
    }//GEN-LAST:event_btnLeaderboardActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLeaderboard;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnTutorial;
    private javax.swing.JLabel lbl2048Image;
    // End of variables declaration//GEN-END:variables
}
