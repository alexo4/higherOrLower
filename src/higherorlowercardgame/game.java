package higherorlowercardgame;


import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collections;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ao200044
 */
public final class game extends javax.swing.JFrame {

    static Random rand = new Random();
    int lives = 5;
    int card = 0;
    int cardnum = 0;
    int score = 0;
    static File fullDir = new File ("leaderboard.txt");
    static ArrayList<String> scores = new ArrayList<>();
    
    public game() {
        initComponents();
        lostLabel.setVisible(false);
        wonLabel.setVisible(false);
        cardImage1.setVisible(false);
        cardImage2.setVisible(false);
        drawLabel.setVisible(false);
        userField.setText("");
        yesButton.setVisible(false);
        noButton.setVisible(false);
        playAgainLabel.setVisible(false);
        jscrossPanel.setVisible(false);
        scoresField.setVisible(false);
        userField.setVisible(false);
        userDetails();
    }
    public void midGame(){
        lostLabel.setVisible(false);
        wonLabel.setVisible(false);
        drawLabel.setVisible(false);
        cardImage2.setVisible(false);
        higherButton.setVisible(true);
        lowerButton.setVisible(true);
        card = cardnum;
        if(cardnum == 1){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/AC.png")));
        }
        else if (cardnum == 2){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/2C.png")));
        }
        else if (cardnum == 3){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/3C.png")));
        }
        else if (cardnum == 4){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/4C.png")));
        }
        else if (cardnum == 5){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/5C.png")));
        }
        else if (cardnum == 6){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/6C.png")));
        }
        else if (cardnum == 7){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/7C.png")));
        }
        else if (cardnum == 8){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/8C.png")));
        }
        else if (cardnum == 9){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/9C.png")));
        }
        else if (cardnum == 10){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/10C.png")));
        }
        else if (cardnum == 11){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/JC.png")));
        }
        else if (cardnum == 12){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/QC.png")));
        }
        else if (cardnum == 13){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/KC.png")));
        }
    }
    public void startGame(){
        score = 0;
        lives = 5;
        
        card = rand.nextInt(13)+1;
        
        if(card == 1){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/AC.png")));
        }
        else if (card == 2){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/2C.png")));
        }
        else if (card == 3){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/3C.png")));
        }
        else if (card == 4){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/4C.png")));
        }
        else if (card == 5){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/5C.png")));
        }
        else if (card == 6){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/6C.png")));
        }
        else if (card == 7){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/7C.png")));
        }
        else if (card == 8){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/8C.png")));
        }
        else if (card == 9){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/9C.png")));
        }
        else if (card == 10){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/10C.png")));
        }
        else if (card == 11){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/JC.png")));
        }
        else if (card == 12){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/QC.png")));
        }
        else if (card == 13){
            cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/KC.png")));
        }
        cardImage1.setVisible(true);
    }
    public void endGame(){
        String user = userField.getText();
        try{
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            if(score>9){
                printToFile.println(score+"         "+ user);
            }
            else if (score<10){
                printToFile.println(score+"          "+ user);
            }
            printToFile.close();
            writeToFile.close();  
        }
        catch(Exception e){
            
        }
        try (Scanner sc = new Scanner(fullDir, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()){
                scores.add(sc.nextLine());
            }
        }
        catch (Exception e) {
            
        }
        
        Collections.sort(scores, Collections.reverseOrder());
        String tempScores;
        for (int i = 0; i < scores.size(); i++) {
            tempScores = scores.get(i);
            int check = 0;
            for (int j = i-1; j >= 0; j--){    
                if(scores.get(j).equals(tempScores)){
                    check = 1;
                }
                    
            }
            if(check == 0){     
                scoresField.append("\n"+tempScores);
            }
        }
        
        leaderBoard details = new leaderBoard();        
        Toolkit tk = Toolkit.getDefaultToolkit();
        details.setSize(1920,1080);
        leaderBoard.scoresField.setText(this.scoresField.getText());
        details.setVisible(true);
        playAgain();
    }
    public void playAgain(){
        lostLabel.setVisible(false);
        wonLabel.setVisible(false);
        cardImage1.setVisible(false);
        cardImage2.setVisible(false);
        drawLabel.setVisible(false);
        yesButton.setVisible(true);
        noButton.setVisible(true);
        playAgainLabel.setVisible(true);
        userField.setText("");
        continueButton.setVisible(false);
        livesLabel.setVisible(false);
        scoreLabel.setVisible(false);
        
    }
    public void userDetails(){
        userDetails details = new userDetails();        
        Toolkit tk = Toolkit.getDefaultToolkit();
        details.setSize(600,250);
        details.setVisible(true);
        
        while(userField.getText().equals("")){
            System.out.println("");
        }
        startGame();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardImage1 = new javax.swing.JLabel();
        noButton = new javax.swing.JButton();
        yesButton = new javax.swing.JButton();
        playAgainLabel = new javax.swing.JLabel();
        drawLabel = new javax.swing.JLabel();
        higherButton = new javax.swing.JButton();
        lowerButton = new javax.swing.JButton();
        cardImage2 = new javax.swing.JLabel();
        continueButton = new javax.swing.JButton();
        lostLabel = new javax.swing.JLabel();
        wonLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        livesLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jscrossPanel = new javax.swing.JScrollPane();
        scoresField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/AC.png"))); // NOI18N
        getContentPane().add(cardImage1);
        cardImage1.setBounds(50, 100, 569, 730);

        noButton.setText("NO");
        noButton.setToolTipText("");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });
        getContentPane().add(noButton);
        noButton.setBounds(810, 400, 150, 70);

        yesButton.setText("YES");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(yesButton);
        yesButton.setBounds(660, 400, 150, 70);

        playAgainLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        playAgainLabel.setText("Would you like to play again?");
        getContentPane().add(playAgainLabel);
        playAgainLabel.setBounds(650, 300, 350, 90);

        drawLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        drawLabel.setText("You Drew");
        getContentPane().add(drawLabel);
        drawLabel.setBounds(770, 540, 120, 130);

        higherButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        higherButton.setText("HIGHER");
        higherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                higherButtonMouseClicked(evt);
            }
        });
        higherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                higherButtonActionPerformed(evt);
            }
        });
        getContentPane().add(higherButton);
        higherButton.setBounds(640, 220, 350, 150);

        lowerButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lowerButton.setText("LOWER");
        lowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(lowerButton);
        lowerButton.setBounds(640, 390, 350, 150);

        cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/2C.png"))); // NOI18N
        getContentPane().add(cardImage2);
        cardImage2.setBounds(1080, 100, 540, 726);

        continueButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        continueButton.setText("CONTINUE");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });
        getContentPane().add(continueButton);
        continueButton.setBounds(640, 660, 350, 150);

        lostLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lostLabel.setText("You Lost");
        getContentPane().add(lostLabel);
        lostLabel.setBounds(770, 540, 100, 130);

        wonLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        wonLabel.setText("You Won!");
        getContentPane().add(wonLabel);
        wonLabel.setBounds(770, 540, 120, 130);

        scoreLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        scoreLabel.setText("Score: ");
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(150, 30, 150, 50);

        livesLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        livesLabel.setText("Lives:");
        getContentPane().add(livesLabel);
        livesLabel.setBounds(50, 30, 150, 50);

        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });
        getContentPane().add(userField);
        userField.setBounds(690, 100, 270, 70);

        scoresField.setColumns(20);
        scoresField.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        scoresField.setRows(5);
        scoresField.setText("Scores:    Name:");
        jscrossPanel.setViewportView(scoresField);

        getContentPane().add(jscrossPanel);
        jscrossPanel.setBounds(1190, 400, 260, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void higherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_higherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_higherButtonActionPerformed

    private void higherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_higherButtonMouseClicked
        cardnum = rand.nextInt(13)+1;
        
        if(cardnum == 1){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/AC.png")));
        }
        else if (cardnum == 2){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/2C.png")));
        }
        else if (cardnum == 3){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/3C.png")));
        }
        else if (cardnum == 4){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/4C.png")));
        }
        else if (cardnum == 5){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/5C.png")));
        }
        else if (cardnum == 6){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/6C.png")));
        }
        else if (cardnum == 7){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/7C.png")));
        }
        else if (cardnum == 8){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/8C.png")));
        }
        else if (cardnum == 9){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/9C.png")));
        }
        else if (cardnum == 10){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/10C.png")));
        }
        else if (cardnum == 11){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/JC.png")));
        }
        else if (cardnum == 12){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/QC.png")));
        }
        else if (cardnum == 13){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/KC.png")));
        }
        cardImage2.setVisible(true);
        higherButton.setVisible(false);
        lowerButton.setVisible(false);
        
        if(cardnum<card){
            lostLabel.setVisible(true);
            lives--;
            livesLabel.setText("Lives: "+lives);
        }
        else if(cardnum>card){
            wonLabel.setVisible(true);
            score++;
            scoreLabel.setText("Score: "+score);
        }
        else{
            drawLabel.setVisible(true);
        }
    }//GEN-LAST:event_higherButtonMouseClicked

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        if(lives!=0){
            midGame();
        }
        else{
            endGame();
        }
    }//GEN-LAST:event_continueButtonActionPerformed

    private void lowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowerButtonActionPerformed
        cardnum = rand.nextInt(13)+1;
        
        if(cardnum == 1){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/AC.png")));
        }
        else if (cardnum == 2){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/2C.png")));
        }
        else if (cardnum == 3){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/3C.png")));
        }
        else if (cardnum == 4){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/4C.png")));
        }
        else if (cardnum == 5){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/5C.png")));
        }
        else if (cardnum == 6){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/6C.png")));
        }
        else if (cardnum == 7){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/7C.png")));
        }
        else if (cardnum == 8){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/8C.png")));
        }
        else if (cardnum == 9){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/9C.png")));
        }
        else if (cardnum == 10){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/10C.png")));
        }
        else if (cardnum == 11){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/JC.png")));
        }
        else if (cardnum == 12){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/QC.png")));
        }
        else if (cardnum == 13){
            cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/higherorlowercardgame/KC.png")));
        }
        cardImage2.setVisible(true);
        higherButton.setVisible(false);
        lowerButton.setVisible(false);
        
        if(cardnum>card){
            lostLabel.setVisible(true);
            lives--;
            livesLabel.setText("Lives: "+lives);
        }
        else if(cardnum<card){
            wonLabel.setVisible(true);
            score++;
            scoreLabel.setText("Score: "+score);
        }
        else{
            drawLabel.setVisible(true);
        }
    }//GEN-LAST:event_lowerButtonActionPerformed

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_noButtonActionPerformed

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        
        game game = new game();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int)tk.getScreenSize().getWidth();
        int ySize = (int)tk.getScreenSize().getHeight();
        game.setSize(xSize,ySize);
        game.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_yesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardImage1;
    private javax.swing.JLabel cardImage2;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JButton higherButton;
    private javax.swing.JScrollPane jscrossPanel;
    private javax.swing.JLabel livesLabel;
    private javax.swing.JLabel lostLabel;
    private javax.swing.JButton lowerButton;
    private javax.swing.JButton noButton;
    private javax.swing.JLabel playAgainLabel;
    private javax.swing.JLabel scoreLabel;
    public static javax.swing.JTextArea scoresField;
    public static javax.swing.JTextField userField;
    private javax.swing.JLabel wonLabel;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables

}
