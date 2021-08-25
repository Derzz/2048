/*
 * Danish Wasif, Evan Woo, Michael Xie, Justin Ye
 * August 24, 2021
 * ICS4UE-20
 * Game.java
 * This program is the mainframe of the game mechanics and GUI.
 */
package pkg2048gui;

// Imports.
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends javax.swing.JFrame {

    stopwatch w = new stopwatch();  // Creates an object to be able to call methods from this class.

    javax.swing.JLabel[][] tiles = new javax.swing.JLabel[4][4];    // Generate a 2D array to display the tile images.
    int[][] board = new int[4][4];                                  // Generate a 2D array to store the value of the tiles.
    int count = 2;                  // Initialize the counter variable for the number of tiles.
    // Set the board to generate 2 tiles at the beginning.

    /**
     * Creates new form Game
     */
    public Game() {
        super("2048!");             // Creates label for the window.
        initComponents();           // Initialize components.
        tiles[0][0] = Tile1;        // Assigns each tile in the grid to its corresponding spot in the array.
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

        for (int j = 0; j < 4; j++) {    // Loop goes through every value in 2D array
            for (int i = 0; i < 4; i++) {
                tiles[j][i].setIcon(new ImageIcon("0.png"));    // Makes all tiles blank for the start.
            }
        }

        // Randomly selects 2 different spots on the grid and generates either a 2 or a 4 tile.
        int rand = (int) (Math.random() * 16);
        int rand2 = (int) (Math.random() * 16);
        while (rand2 == rand) {                     // If both variables happen to be the same, randomize again.
            rand2 = (int) (Math.random() * 16);
        }

        board[(int) (rand / 4)][rand % 4] = ((int) (Math.random() * 2) + 1) * 2;    // Choose a random tile to generate a 2 or 4 tile.
        board[(int) (rand2 / 4)][rand2 % 4] = ((int) (Math.random() * 2) + 1) * 2;  // Choose a second random tile to generate a 2 or 4 tile.
        tiles[(int) (rand / 4)][rand % 4].setIcon(new ImageIcon(board[(int) (rand / 4)][rand % 4] + ".png"));       // Display  2 or 4  on the random tile.
        tiles[(int) (rand2 / 4)][rand2 % 4].setIcon(new ImageIcon(board[(int) (rand2 / 4)][rand2 % 4] + ".png"));   // Display  2 or 4 on the other random tile.
    }

    // Slide function, slides tiles based on the user's input.
    public void slide(int dir) {
        String values = "";              // Initializes the array entered.
        for (int a = 0; a < 4; a++) {    // Goes through entire array, combines all values into a String.
            for (int b = 0; b < 4; b++) {
                values += String.valueOf(board[a][b]);  // Add the value of the specific tile to the String.
                if (b != 16) {
                    values += " ";       // Add a space in between each value until all 16 tiles are added to String.
                }
            }
        }

        boolean moves;  // Initialize the boolean variable to track if a tile has moved.

        switch (dir) {  // Switch cases used for arrow key directions. x and y variables are used, respective to a 2D coordinate.
            case 0: // UP Key.
                for (int x = 0; x < 4; x++) {       // Loop through all array values.
                    moves = false;                  // Reset the tracking boolean variable as false.
                    for (int y = 1; y < 4; y++) {
                        for (int i = y; i > 0; i--) {
                            if (board[i - 1][x] == 0) {          // If the tile above is empty (value 0).
                                board[i - 1][x] = board[i][x];   // Move the tile up one space.
                                board[i][x] = 0;                 // Set the tile's old place as 0.
                            } else if (moves == false && board[i - 1][x] == board[i][x]) {   // If the tile above is the same and the column has not had a merge yet.
                                board[i - 1][x] *= 2;   // Multiply the tile above by 2.
                                board[i][x] = 0;        // Set the tile's old place as 0.
                                count--;                // Remove 1 from number of tiles on board.
                                moves = true;           // Set the move boolean variable to true. This will prevent more than 1 merge per column.
                            }
                        }
                    }
                }
                break;

            case 1: // RIGHT Key.
                for (int y = 0; y < 4; y++) {       // Loop through all array values.
                    moves = false;                  // Reset the tracking boolean variable as false.
                    for (int x = 2; x >= 0; x--) {
                        for (int i = x; i < 3; i++) {
                            if (board[y][i + 1] == 0) {         // If the tile to the right is empty (value 0).
                                board[y][i + 1] = board[y][i];  // Move the tile right one space.
                                board[y][i] = 0;                // Set the tile's old place as 0.
                            } else if (moves == false && board[y][i + 1] == board[y][i]) {    // If the tile to the right is the same and the row has not had a merge yet.
                                board[y][i + 1] *= 2;   // Multiply the tile to the right by 2.
                                board[y][i] = 0;        // Set the tile's old place as 0.
                                count--;                // Remove 1 from number of tiles on board.
                                moves = true;           // Set the move boolean variable to true. This will prevent more than 1 merge per row.
                            }
                        }
                    }
                }
                break;

            case 2: // DOWN Key.
                for (int x = 0; x < 4; x++) {       // Loop through all array values.
                    moves = false;                  // Reset the tracking boolean variable as false.
                    for (int y = 2; y >= 0; y--) {
                        for (int i = y; i < 3; i++) {
                            if (board[i + 1][x] == 0) {         // If the tile below is empty (value 0).
                                board[i + 1][x] = board[i][x];  // Move the tile down one space.
                                board[i][x] = 0;                // Set the tile's old place as 0.
                            } else if (moves == false && board[i + 1][x] == board[i][x]) {    // If the tile below is the same and the column has not had a merge yet.
                                board[i + 1][x] *= 2;   // Multiply the tile below by 2.
                                board[i][x] = 0;        // Set the tile's old place as 0.
                                count--;                // Remove 1 from number of tiles on board.
                                moves = true;           // Set the move boolean variable to true. This will prevent more than 1 merge per column.
                            }
                        }
                    }
                }
                break;

            case 3: // LEFT Key.
                for (int y = 0; y < 4; y++) {       // Loop through all array values.
                    moves = false;                  // Reset the tracking boolean variable as false.
                    for (int x = 1; x < 4; x++) {
                        for (int i = x; i > 0; i--) {
                            if (board[y][i - 1] == 0) {         // If the tile to the right is empty (value 0).
                                board[y][i - 1] = board[y][i];  // Move the tile left one space.
                                board[y][i] = 0;                // Set the tile's old place as 0.
                            } else if (moves == false && board[y][i - 1] == board[y][i]) {   // If the tile to the right is the same and the row has not had a merge yet.
                                board[y][i - 1] *= 2;   // Multiply the tile to the left by 2.
                                board[y][i] = 0;        // Set the tile's old place as 0.
                                count--;                // Remove 1 from number of tiles on board.
                                moves = true;           // Set the move boolean variable to true. This will prevent more than 1 merge per row.
                            }
                        }
                    }
                }
                break;

            default:    // If no arrow key input is detected.
                break;
        }

        String newValues = "";           // Initialize String variable to contain new values.

        for (int j = 0; j < 4; j++) {    // Goes through entire array, combines all values into a String.
            for (int i = 0; i < 4; i++) {

                newValues += String.valueOf(board[j][i]);   // Add the value of the specific tile to the String.
                if (i != 16) {
                    newValues += " ";                       // Add a space in between each value until all 16 tiles are added to String.
                }
            }
        }

        // While loop ensures that a tile is only generated when there is an empty space and the user has moved at least one tile on the board.
        while (count < 16 && !values.equals(newValues)) {
            int rand = (int) (Math.random() * 16);          // Generates a random number between 1-16.

            if (board[(int) (rand / 4)][rand % 4] == 0) {   // Only allows a tile to generate when space is empty.
                board[(int) (rand / 4)][rand % 4] = ((int) (Math.random() * 2) + 1) * 2;    // Randomly assigns 2 or 4 to an open tile.
                count++;    // Add one to the number of tiles on board.
                break;
            }
        }

        if (count == 16 && values.equals(newValues) && availableMoveCheck()) {  // If statement that checks when there are 16 tiles and the user cannot make another move.
                this.setVisible(false);         // Close the game window.
                w.stopwatchStop();              // Stop the stopwatch.
                GameOver m = new GameOver();    // Creates an object to be able to call methods from this class.
                m.start();                      // Run the method in the GameOver file to display the GameOver screen.
        }

        long time;      // Initialize a long variable to store the user's time.
        long temp = 0;  // Initialize a long variable to store the user's time.

        for (int j = 0; j < 4; j++) {           // Goes through every value in the array
            for (int i = 0; i < 4; i++) {
                if (board[j][i] == 2048) {      // Checks if any value is equal to 2048.
                    try {
                        temp = w.stopwatchReturn();     // Imports the time from the stopwatch.
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    time = temp;                // Sets the temporary String as the time value.
                    this.setVisible(false);     // Closes the game window.
                    Winner w;                   // Create an object.
                    try {
                        w = new Winner();       // Imports object.
                        w.start(time);          // Stores and prints amount of time along with winner screen.
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        for (int j = 0; j < 4; j++) {           // Goes through all values in the array.
            for (int i = 0; i < 4; i++) {
                tiles[j][i].setIcon(new ImageIcon(board[j][i] + ".png"));     // Displays every icon as their value (refresh).
            }
        }
    }   // End of slide method.

    //Method used to check if any available moves are left.
    public boolean availableMoveCheck() {
        boolean noMoves = true;//Boolean value used to check if there are any moves. If it's false, it means there are moves available, if true, it means there are no moves available.

        for (int x = 0; x < 4; x++) {       // Loop through all array values.
            for (int y = 1; y < 4; y++) {
                for (int i = y; i > 0; i--) {
                    if (board[i - 1][x] == board[i][x]) {
                        noMoves = false;
                    }
                }
            }
        }
        for (int x = 0; x < 4; x++) {       // Loop through all array values.
            for (int y = 2; y >= 0; y--) {
                for (int i = y; i < 3; i++) {
                    if (board[i + 1][x] == board[i][x]) {
                        noMoves = false;
                    }
                }
            }
        }

         for (int x = 0; x < 4; x++) {       // Loop through all array values.
                    for (int y = 2; y >= 0; y--) {
                        for (int i = y; i < 3; i++) {
                    if (board[i + 1][x] == board[i][x]) {
                        noMoves = false;
                    }
                }
            }
        }
        for (int y = 0; y < 4; y++) {       // Loop through all array values.
            for (int x = 1; x < 4; x++) {
                for (int i = x; i > 0; i--) {
                    if (board[y][i - 1] == board[y][i]) {
                        noMoves = false;
                    }
                }
            }
        }
        return noMoves;
    }

    public void start() {
        w.stopwatchStart();         // Method that resets and starts stopwatch.
        this.setVisible(true);      // Displays the game screen.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2048Image = new javax.swing.JLabel();
        lblDescription2 = new javax.swing.JLabel();
        lblDescription1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
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

        lbl2048Image.setFont(new java.awt.Font("Clear Sans", 1, 48)); // NOI18N
        lbl2048Image.setForeground(new java.awt.Color(236, 196, 0));
        lbl2048Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2048Logo.png"))); // NOI18N
        lbl2048Image.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        lblDescription2.setFont(new java.awt.Font("Clear Sans", 1, 18)); // NOI18N
        lblDescription2.setForeground(new java.awt.Color(111, 107, 96));
        lblDescription2.setText("Get to 2048 as fast as you can!");
        lblDescription2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        lblDescription1.setFont(new java.awt.Font("Clear Sans Light", 0, 14)); // NOI18N
        lblDescription1.setForeground(new java.awt.Color(83, 77, 71));
        lblDescription1.setText("Use the Arrow Keys to move the tiles.");
        lblDescription1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(245, 124, 95));
        btnMenu.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        btnMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Game.this.keyPressed(evt);
            }
        });

        btnRestart.setBackground(new java.awt.Color(237, 153, 91));
        btnRestart.setFont(new java.awt.Font("Clear Sans", 1, 20)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("RESTART");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });
        btnRestart.addKeyListener(new java.awt.event.KeyAdapter() {
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
                        .addComponent(lbl2048Image)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescription1)
                                    .addComponent(lblDescription2)))))
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
                    .addComponent(lbl2048Image)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblDescription1)
                        .addGap(0, 0, 0)
                        .addComponent(lblDescription2)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    // When the Menu button is pressed.
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.setVisible(false);     // Hide the game screen.
        Menu m = new Menu();        // Creates an object to be able to call methods from this class.
        m.start();                  // Run the start method to display the menu.
    }//GEN-LAST:event_btnMenuActionPerformed

    // Reads and calls on functions depending on user key presses.
    private void keyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:     // If the user presses the UP key.
                slide(0);            // Run the slide function indicating the up direction.
                break;

            case KeyEvent.VK_RIGHT:  // If the user presses the RIGHT key.
                slide(1);            // Run the slide function indicating the right direction.
                break;

            case KeyEvent.VK_DOWN:   // If the user presses the DOWN key.
                slide(2);            // Run the slide function indicating the down direction.
                break;

            case KeyEvent.VK_LEFT:   // If the user presses the LEFT key.
                slide(3);            // Run the slide function indicating the left direction.
                break;

            default:                 // If the user does not press any key.
                break;
        }
    }//GEN-LAST:event_keyPressed

    // When the Restart button is pressed.
    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        this.setVisible(false);      // Hide the game window.
        Menu b = new Menu();         // Creates an object to be able to call methods from this class.
        b.game();                    // Calls on method to start a new game.
    }//GEN-LAST:event_btnRestartActionPerformed

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
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRestart;
    private javax.swing.JLabel lbl2048Image;
    private javax.swing.JLabel lblDescription1;
    private javax.swing.JLabel lblDescription2;
    // End of variables declaration//GEN-END:variables

}
