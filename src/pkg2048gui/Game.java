/*
* Danish Wasif, Evan Woo, Michael Xie, Justin Ye
* August 24, 2021
* ICS4UE-20
* Code that is the mainframe of the various aspects on how the game works, it does not show the gui aspects.
 */
package pkg2048gui;

//Imports
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends javax.swing.JFrame {

    stopwatch w = new stopwatch();

    javax.swing.JLabel[][] tiles = new javax.swing.JLabel[4][4];
    int[][] board = new int[4][4];//Creates the 2D array for the board
    int count = 2;//counter for the amount of empty elements on the board

    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        tiles[0][0] = Tile1;    // Set tiles to array
        tiles[0][1] = Tile2;
        tiles[0][2] = Tile3;
        tiles[0][3] = Tile4;
        tiles[1][0] = Tile5;
        tiles[1][1] = Tile6;
        tiles[1][2] = Tile7;
        tiles[1][3] = Tile8;
        tiles[2][0] = Tile9;
        tiles[2][1] = Tile10;
        tiles[2][2] = Tile11;
        tiles[2][3] = Tile12;
        tiles[3][0] = Tile13;
        tiles[3][1] = Tile14;
        tiles[3][2] = Tile15;
        tiles[3][3] = Tile16;
        for (int j = 0; j < 4; j++) {    // Goes through entire array, assigns all tiles as 0(For start)
            for (int i = 0; i < 4; i++) {
                tiles[j][i].setIcon(new ImageIcon("0.png"));
            }
        }
        // Randomly selects 2 different spots on the grid and generates either a 2 or a 4 tile
        int rand = (int) (Math.random() * 16);
        int rand2 = (int) (Math.random() * 16);
        while (rand2 == rand) {
            rand2 = (int) (Math.random() * 16);
        }
        board[(int) (rand / 4)][rand % 4] = ((int) (Math.random() * 2) + 1) * 2;
        board[(int) (rand2 / 4)][rand2 % 4] = ((int) (Math.random() * 2) + 1) * 2;
        tiles[(int) (rand / 4)][rand % 4].setIcon(new ImageIcon(board[(int) (rand / 4)][rand % 4] + ".png"));
        tiles[(int) (rand2 / 4)][rand2 % 4].setIcon(new ImageIcon(board[(int) (rand2 / 4)][rand2 % 4] + ".png"));
    }

    //Slide function, based on user input it will slide the tiles.
    public void slide(int dir) {
        String values = "";
        for (int a = 0; a < 4; a++) {    // Goes through entire array, adds array values as a String
            for (int b = 0; b < 4; b++) {
                values += String.valueOf(board[a][b]);
                if (b != 16) {
                    values += " ";
                }
            }
        }

        
                            boolean moved = false;
        //Switch cases used for arrow key directions.
        switch (dir) {
            case 0: // UP
                for (int x = 0; x < 4; x++) {
                    for (int y = 1; y < 4; y++) {
                        for (int i = y; i > 0; i--) {
                            if (board[i - 1][x] == 0) {    // If tile beside is empty/different, move and set tiles as 0
                                board[i - 1][x] = board[i][x];
                                board[i][x] = 0;
                            } else if (board[i - 1][x] == board[i][x] && moved == false) {   // If tile beside is the same, multiply tile value * 2
                                board[i - 1][x] *= 2;
                                board[i][x] = 0;
                                count--;    // Remove 1 from number of tiles on board
                                moved = true;
                            }
                        }
                    }
                }
                break;
            case 1: // RIGHT
                for (int y = 0; y < 4; y++) {
                    for (int x = 2; x >= 0; x--) {
                        for (int i = x; i < 3; i++) {
                            if (board[y][i + 1] == 0) {
                                board[y][i + 1] = board[y][i];
                                board[y][i] = 0;
                            } else if (board[y][i + 1] == board[y][i] && moved == false) {
                                board[y][i + 1] *= 2;
                                board[y][i] = 0;
                                count--;
                                moved = true;
                            }
                        }
                    }
                }
                break;
            case 2: // DOWN
                for (int x = 0; x < 4; x++) {
                    for (int y = 2; y >= 0; y--) {
                        for (int i = y; i < 3; i++) {
                            if (board[i + 1][x] == 0) {
                                board[i + 1][x] = board[i][x];
                                board[i][x] = 0;
                            } else if (board[i + 1][x] == board[i][x] && moved == false) {
                                board[i + 1][x] *= 2;
                                board[i][x] = 0;
                                count--;
                                moved = true;
                            }
                        }
                    }
                }
                break;
            case 3: // LEFT
                for (int y = 0; y < 4; y++) {
                    for (int x = 1; x < 4; x++) {
                        for (int i = x; i > 0; i--) {
                            if (board[y][i - 1] == 0) {
                                board[y][i - 1] = board[y][i];
                                board[y][i] = 0;
                            } else if (board[y][i - 1] == board[y][i] && moved == false) {
                                board[y][i - 1] *= 2;
                                board[y][i] = 0;
                                count--;
                                moved = true;
                            }
                        }
                    }
                }
                break;
            default://Runs if there is no case value
                break;
        }

        String newValues = "";

        for (int j = 0; j < 4; j++) {    // Goes through entire array, adds array values as a String
            for (int i = 0; i < 4; i++) {

                newValues += String.valueOf(board[j][i]);
                if (i != 16) {
                    newValues += " ";
                }
            }
        }

        while (count < 16 && !values.equals(newValues)) {     // As long as there is an empty space and the tiles have moved
            int rand = (int) (Math.random() * 16);       // Only complete 1 operation at a time
            if (board[(int) (rand / 4)][rand % 4] == 0) {
                board[(int) (rand / 4)][rand % 4] = ((int) (Math.random() * 2) + 1) * 2;    // Assign new value to open tile
                count++;
                break;
            }
        }

        if (count == 16 && values.equals(newValues)) {  // Find a way to revert this check if there are still options, this still needs work
            String temp = newValues;

            if (temp.equals(newValues)) {
                this.setVisible(false);
                w.stopwatchStop();
                GameOver m = new GameOver();
                m.start();
            }
        }
        long temp = 0;
        long time;
        for (int j = 0; j < 4; j++) {   //Go through array, checks if any of the values are equal to 2048.
            for (int i = 0; i < 4; i++) {
                if (board[j][i] == 8) {
                    try {
                        temp = w.stopwatchReturn();
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    time = temp;
                    this.setVisible(false);
                    Winner w;
                    try {
                        w = new Winner();
                        w.start(time);
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                tiles[j][i].setIcon(new ImageIcon(board[j][i] + ".png"));     // Go through array, set all the icons as their value (refresh)
            }
        }
    }

    public void start() {
        w.stopwatchStart();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuGame = new javax.swing.JButton();
        restartGame = new javax.swing.JButton();
        Tile2 = new javax.swing.JLabel();
        Tile1 = new javax.swing.JLabel();
        Tile4 = new javax.swing.JLabel();
        Tile3 = new javax.swing.JLabel();
        Tile5 = new javax.swing.JLabel();
        Tile8 = new javax.swing.JLabel();
        Tile7 = new javax.swing.JLabel();
        Tile6 = new javax.swing.JLabel();
        Tile9 = new javax.swing.JLabel();
        Tile12 = new javax.swing.JLabel();
        Tile11 = new javax.swing.JLabel();
        Tile10 = new javax.swing.JLabel();
        Tile13 = new javax.swing.JLabel();
        Tile16 = new javax.swing.JLabel();
        Tile15 = new javax.swing.JLabel();
        Tile14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 680));
        setSize(new java.awt.Dimension(500, 680));

        lblTitle1.setFont(new java.awt.Font("Clear Sans", 1, 48)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(236, 196, 0));
        lblTitle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2048Logo.png"))); // NOI18N
        lblTitle1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Clear Sans", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(111, 107, 96));
        jLabel2.setText("Get to 2048 as fast as you can!");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(83, 77, 71));
        jLabel3.setText("Use the Arrow Keys to move the tiles.");
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        menuGame.setBackground(new java.awt.Color(245, 124, 95));
        menuGame.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        menuGame.setForeground(new java.awt.Color(255, 255, 255));
        menuGame.setText("MENU");
        menuGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGameActionPerformed(evt);
            }
        });
        menuGame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        restartGame.setBackground(new java.awt.Color(237, 153, 91));
        restartGame.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        restartGame.setForeground(new java.awt.Color(255, 255, 255));
        restartGame.setText("RESTART");
        restartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartGameActionPerformed(evt);
            }
        });
        restartGame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        Tile14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblTitle1)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(restartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(menuGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Tile5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Tile9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tile16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuGame, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGameActionPerformed
        this.setVisible(false);
        Menu m = new Menu();
        m.start();
    }//GEN-LAST:event_menuGameActionPerformed

    //Key pressed methods to print out the key presses.
    private void keyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            slide(0);
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            slide(1);
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            slide(2);
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            slide(3);
        }
    }//GEN-LAST:event_keyPressed

    private void restartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameActionPerformed
        this.setVisible(false);
        Menu b = new Menu();
        b.game();
    }//GEN-LAST:event_restartGameActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tile1;
    private javax.swing.JLabel Tile10;
    private javax.swing.JLabel Tile11;
    private javax.swing.JLabel Tile12;
    private javax.swing.JLabel Tile13;
    private javax.swing.JLabel Tile14;
    private javax.swing.JLabel Tile15;
    private javax.swing.JLabel Tile16;
    private javax.swing.JLabel Tile2;
    private javax.swing.JLabel Tile3;
    private javax.swing.JLabel Tile4;
    private javax.swing.JLabel Tile5;
    private javax.swing.JLabel Tile6;
    private javax.swing.JLabel Tile7;
    private javax.swing.JLabel Tile8;
    private javax.swing.JLabel Tile9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JButton menuGame;
    private javax.swing.JButton restartGame;
    // End of variables declaration//GEN-END:variables

}
