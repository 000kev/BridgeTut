/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import gui.lessons.lessonsScreen;
import cards.lib.Card;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class lesson7 implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
    }

    @Override
    public void run() {
       /*
         * This lesson teaches the user bidding.They can only bid if they have 13 or more high card points.
         * The player will be given the option to bid or to pass,after having looked at their cards.
         * Each time the lesson is ran,the cards are shuffled.This will allow for the posssibilty of the
         * player having to pass making a bid.
         * 
         * Player will get immediate feedback on which of the players can bid and which players must pass.
         */
        
         //variables
        final int lessonNum=7;//this lesson number
        int cardSuit=0; //Can randomly generate this so that each time you open the lesson,there is a different suit to follow during the lesson
        String suit; //Will hold the string value of the suit value
        
        String arrBids[]=new String[4];//Will hold the bidding values for each player according to format [W,N,E,S]
        
        String difficulty=""; //Will store the selected user difficulty
        

        
        ArrayList<Integer> arrLIncorrect=new ArrayList<>();//hold index positions of the incorrect answers
        
        
        
        int westHighCardVal=0;
        int northHighCardVal=0;
        int eastHighCardVal=0;
        int southHighCardVal=0;
        
        boolean validInput=false;//checks if the user has entered a valid  input
        boolean validInput2=false;
        boolean validInputBid=false;
        boolean hasBid[]={false,false,false,false}; //Tracks if each player is allowed to bid
        
        String correctBid="";
        //variables end
        
      //generating a random number that corresponds to a suit value.This number will represent the suit to follow throughout the round.
        Random random=new Random();
        cardSuit=random.nextInt(4);
        
        //Making a card object
        Card c=new Card();
        //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
        suit=c.getGivenSuitAsString(cardSuit);
       
        
        //New gameboard object created
        GameBoard game=new GameBoard(lessonNum,cardSuit);
        game.setVisible(true);
        
        
         JOptionPane.showMessageDialog(null, "We will learn how to bid", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "In order to bid,you must follow the card points system.\nEach high card is assigned points as follows:\n\nAce-4 points\nKing-3 points\nQueen-3 points\nJack-1 point\n\nYou must have 13 or more high card points to make a bid.\nIf you do not have 13 high card points,then you must pass.", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "When you bid you must state:\n-You start with one\n-The suit of the cards that you have the most of.", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "West starts the bidding first.", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        

                //This will run the lesson
           /*
            * It will look at the cards in the players hand.It will calculate the high card score.It will check if the player's high card score is 
            * 13 or more.If the player's high card score is 13 or more,then the player can bid.Else,the player will have to pass.
            */
        
        
        /*
         * The player will be prompted to state that they want to bid or pass.A method will be used to evaluate the decision they make.
         * The player's choice can be incorrect-trying to bid when they do not have enough high card points-or be correct.
         * 
         */
        
        String userAns="";//This will hold the user answer 
        
        //This can be used as a short cut for the player.
        
        game.calcHighCardValues();//high card values for each player is calculated
        
        
        
        //Difficulty setting
        while (validInput==false) {    
                difficulty=JOptionPane.showInputDialog("Select your difficulty:\n1=Please Assist\n 2=No Assistance Required");
                difficulty=difficulty.trim();//removes white space on end
                if (difficulty.equalsIgnoreCase("1")||difficulty.equalsIgnoreCase("2")) {
                    validInput=true;
            }
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid Difficulty input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        
        
        if (difficulty.equalsIgnoreCase("1")) { //Help is given,user has access to Quick High card calculation for bidding and best play is given
            validInput=false;
            while (validInputBid==false) {            
                        userAns=JOptionPane.showInputDialog("Quick Bidding Feature:\nDo you want to see the high card values for all hands?\nY=Yes\nN=No");
                    if (userAns.equalsIgnoreCase("Y")||userAns.equalsIgnoreCase("Yes")) {
                        JOptionPane.showMessageDialog(null, game.getHighCardValues(), "High Card Values", JOptionPane.INFORMATION_MESSAGE);
                        validInputBid=true;
                    }
                    else if(userAns.equalsIgnoreCase("N")||userAns.equalsIgnoreCase("No")){
                        JOptionPane.showMessageDialog(null, "Looks like you want to calculate high card values the old fashion way.\nNice.", "High Card Values", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter valid input ", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
        }
        
        
        
        
        
        
        
        
        
        //checking if each player can bid or not:
        
        
        westHighCardVal=game.getHighCardValW();
        northHighCardVal=game.getHighCardValN();
        eastHighCardVal=game.getHighCardValE();
        southHighCardVal=game.getHighCardValS();
        
        validInput=false;
        while (validInput==false) {            
                    userAns=JOptionPane.showInputDialog("Look at cards in the West hand.\nCan West Bid?\nReminder:High card value must be 13 or more to bid.\nB=Bid\nP=Pass");
                if (userAns.equalsIgnoreCase("B")) {
                    
                    if (westHighCardVal==13||westHighCardVal>13) {
                        
                        //Take user bid input
                        
                        while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[0]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[0]=arrBids[0].trim();
                            
                            if (arrBids[0].equalsIgnoreCase("1H")||arrBids[0].equalsIgnoreCase("1S")||arrBids[0].equalsIgnoreCase("1C")||arrBids[0].equalsIgnoreCase("1D")) { //if open
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("West",arrBids[0]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                                
                                
                                //Check the output of correctBid method
                                if (arrBids[0].equalsIgnoreCase(correctBidParts[0])||arrBids[0].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid to output
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                                
                            }//if close
                            
                            
                        }//inner while closing bracket
                        
                        hasBid[0]=true;
                        validInput=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "West does not have a high card value of 13 or more.\nTherefore,West must Pass.", "Cannot Bid", JOptionPane.INFORMATION_MESSAGE);
                        validInput=true;
                    }
                }
                
                    else if(userAns.equalsIgnoreCase("P")){
                        if (westHighCardVal<13) {
                            
                            validInput=true;
                        }
                        
                        else if(westHighCardVal==13||westHighCardVal>13){
                            JOptionPane.showMessageDialog(null, "West has enough high card points to bid.", "Bid", JOptionPane.INFORMATION_MESSAGE);
                            while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[0]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[0]=arrBids[0].trim();
                            
                            if (arrBids[0].equalsIgnoreCase("1H")||arrBids[0].equalsIgnoreCase("1S")||arrBids[0].equalsIgnoreCase("1C")||arrBids[0].equalsIgnoreCase("1D")) { //if open
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("West",arrBids[0]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                                
                                
                                //Check the output of correctBid method
                                if (arrBids[0].equalsIgnoreCase(correctBidParts[0])||arrBids[0].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid to output
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                                
                            }//if close
                            
                            
                        }//inner while closing bracket
                        
                        hasBid[0]=true;
                        validInput=true;
                        }
                        
                        else{
                            
                            validInput=true;
                        }
                        
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
                
        }//While closing bracket
        
        
        
        //Player North
        validInput=false;
        validInput2=false;
         while (validInput==false) {            
                    userAns=JOptionPane.showInputDialog("Look at cards in the North hand.\nCan North Bid?\nReminder:High card value must be 13 or more to bid.\nB=Bid\nP=Pass");
                if (userAns.equalsIgnoreCase("B")) {
                    if (northHighCardVal==13||northHighCardVal>13) {
                        
                      
                      //Take user bid input
                        
                        while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[1]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[1]=arrBids[1].trim();
                            
                            if (arrBids[1].equalsIgnoreCase("1H")||arrBids[1].equalsIgnoreCase("1S")||arrBids[1].equalsIgnoreCase("1C")||arrBids[1].equalsIgnoreCase("1D")) {
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("North",arrBids[1]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                                
                                
                                //Check the output of correctBid method
                                if (arrBids[1].equalsIgnoreCase(correctBidParts[0])||arrBids[1].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                            }//if close
                            
                            
                        }//inner while closing bracket
                        hasBid[1]=true;
                        validInput=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "North does not have a high card value of 13 or more.\nTherefore,North must Pass.", "Cannot Bid", JOptionPane.INFORMATION_MESSAGE);
                        validInput=true;
                    }
                }
                
                    else if(userAns.equalsIgnoreCase("P")){
                        if (northHighCardVal<13) {
                            
                            validInput=true;
                        }
                        
                        else if(northHighCardVal==13||northHighCardVal>13){
                            JOptionPane.showMessageDialog(null, "North has enough high card points to bid.", "Bid", JOptionPane.INFORMATION_MESSAGE);
                            
                            while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[1]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[1]=arrBids[1].trim();
                            
                            if (arrBids[1].equalsIgnoreCase("1H")||arrBids[1].equalsIgnoreCase("1S")||arrBids[1].equalsIgnoreCase("1C")||arrBids[1].equalsIgnoreCase("1D")) {
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("North",arrBids[1]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                                
                                
                                //Check the output of correctBid method
                                if (arrBids[1].equalsIgnoreCase(correctBidParts[0])||arrBids[1].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                            }//if close
                            
                            
                        }//inner while closing bracket
                        hasBid[1]=true;
                        validInput=true;
                        }
                        
                        else{
                            
                            validInput=true;
                        }
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
                
        }//While closing bracket
         
         
         //Player East
         validInput=false;
         validInput2=false;
          while (validInput==false) {            
                    userAns=JOptionPane.showInputDialog("Look at cards in the East hand.\nCan East Bid?\nReminder:High card value must be 13 or more to bid.\nB=Bid\nP=Pass");
                if (userAns.equalsIgnoreCase("B")) {
                    if (eastHighCardVal==13||eastHighCardVal>13) {
                        
                        //Take user bid input
                        
                        while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[2]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[2]=arrBids[2].trim();
                            
                            if (arrBids[2].equalsIgnoreCase("1H")||arrBids[2].equalsIgnoreCase("1S")||arrBids[2].equalsIgnoreCase("1C")||arrBids[2].equalsIgnoreCase("1D")) {
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("East",arrBids[2]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                               
                                
                                //Check the output of correctBid method
                                if (arrBids[2].equalsIgnoreCase(correctBidParts[0])||arrBids[2].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                            }//if close
                            
                            
                        }//inner while closing bracket
                        hasBid[2]=true;
                        validInput=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "East does not have a high card value of 13 or more.\nTherefore,East must Pass.", "Cannot Bid", JOptionPane.INFORMATION_MESSAGE);
                        validInput=true;
                    }
                }
                
                    else if(userAns.equalsIgnoreCase("P")){
                        if (eastHighCardVal<13) {
                            
                            validInput=true;
                        }
                        
                        else if(eastHighCardVal==13||eastHighCardVal>13){
                            JOptionPane.showMessageDialog(null, "East has enough high card points to bid.", "Bid", JOptionPane.INFORMATION_MESSAGE);
                            
                            while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[2]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[2]=arrBids[2].trim();
                            
                            if (arrBids[2].equalsIgnoreCase("1H")||arrBids[2].equalsIgnoreCase("1S")||arrBids[2].equalsIgnoreCase("1C")||arrBids[2].equalsIgnoreCase("1D")) {
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("East",arrBids[2]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                               
                                
                                //Check the output of correctBid method
                                if (arrBids[2].equalsIgnoreCase(correctBidParts[0])||arrBids[2].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                            }//if close
                            
                            
                        }//inner while closing bracket
                        hasBid[2]=true;
                        validInput=true;
                        }
                        else{
                            
                            validInput=true;
                        }
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
                
        }//While closing bracket
        
          
          
          //Player South
          validInput=false;
          validInput2=false;
         while (validInput==false) {            
                    userAns=JOptionPane.showInputDialog("Look at cards in the South hand.\nCan South Bid?\nReminder:High card value must be 13 or more to bid.\nB=Bid\nP=Pass");
                if (userAns.equalsIgnoreCase("B")) {
                    
                    //User is asked to enter a bid for that player
                    
                    
                    if (southHighCardVal==13||southHighCardVal>13) {
                        
                      //Take user bid input
                        
                        while (validInput2==false) {  //checking that user bid input is valid                          
                            arrBids[3]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                            //Trim out excess spaces
                            arrBids[3]=arrBids[3].trim();
                            
                            if (arrBids[3].equalsIgnoreCase("1H")||arrBids[3].equalsIgnoreCase("1S")||arrBids[3].equalsIgnoreCase("1C")||arrBids[3].equalsIgnoreCase("1D")) {
                                
                                //Compare the user input bid against the computed correct bid
                                correctBid=game.correctBid("South",arrBids[3]);
                                
                                //Breaking into parts
                                String correctBidParts[]=correctBid.split(",");
                                
                                
                                
                                //Check the output of correctBid method
                                if (arrBids[3].equalsIgnoreCase(correctBidParts[0])||arrBids[3].equalsIgnoreCase(correctBidParts[1])){
                                    JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    
                                }
                                validInput2=true;
                            }//if close
                            
                            
                        }//inner while closing bracket
                        hasBid[3]=true;
                        validInput=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "South does not have a high card value of 13 or more.\nTherefore,South must Pass.", "Cannot Bid", JOptionPane.INFORMATION_MESSAGE);
                        validInput=true;
                    }
                }
                
                    else if(userAns.equalsIgnoreCase("P")){
                        if (southHighCardVal<13) {
                            
                            validInput=true;
                        }
                        else if(southHighCardVal==13||southHighCardVal>13){
                                JOptionPane.showMessageDialog(null, "South has enough high card points to bid.", "Bid", JOptionPane.INFORMATION_MESSAGE);
                                while (validInput2==false) {  //checking that user bid input is valid                          
                                arrBids[3]=JOptionPane.showInputDialog("Enter your bid as one of the following:\n1H\n1S\n1C\n1D\n\nIf more than one suit can be bid,select only one of them as your bid.");
                                //Trim out excess spaces
                                arrBids[3]=arrBids[3].trim();

                                if (arrBids[3].equalsIgnoreCase("1H")||arrBids[3].equalsIgnoreCase("1S")||arrBids[3].equalsIgnoreCase("1C")||arrBids[3].equalsIgnoreCase("1D")) {

                                    //Compare the user input bid against the computed correct bid
                                    correctBid=game.correctBid("South",arrBids[3]);

                                    //Breaking into parts
                                    String correctBidParts[]=correctBid.split(",");



                                    //Check the output of correctBid method
                                    if (arrBids[3].equalsIgnoreCase(correctBidParts[0])||arrBids[3].equalsIgnoreCase(correctBidParts[1])){
                                        JOptionPane.showMessageDialog(null, "That Bid was correct!", "Correct Bid", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    else{
                                        if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                            JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        }

                                    }
                                    validInput2=true;
                                }//if close


                            }//inner while closing bracket
                            hasBid[3]=true;
                            validInput=true;
                            
                        }
                        else{
                            
                            validInput=true;
                        }
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
                
        }//While closing bracket
         
         
         if (hasBid[0]==false&&hasBid[1]==false&&hasBid[2]==false&&hasBid[3]==false) {
            JOptionPane.showMessageDialog(null, "No player could make a bid.\nThis is because No player had high card value of 13 or higher", "No Bids Made", JOptionPane.INFORMATION_MESSAGE);
        }
         
         //Closing Output
         JOptionPane.showMessageDialog(null, "You have completed the bidding lesson!", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
         JOptionPane.showMessageDialog(null, "Don't forget to come back and replay the lesson.\nThe shuffling of the cards each time you come back to this lesson can yield some different outcomes!", "Bidding Lesson", JOptionPane.INFORMATION_MESSAGE);
         new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose();
    }
    
}
