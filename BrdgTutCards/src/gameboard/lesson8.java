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
public class lesson8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         * This lesson makes use of Sonia's example lesson input file
         */
        
        
        //Variables
        final int lessonNum=8;
        String difficulty=""; //Will store the selected user difficulty
        boolean validInput=false;//checks if the user has entered a valid difficulty input
        String quickBid="";
        
        int trump=0;//Will store the suit for trump card.
        
        
        int cardSuit=0; //Can randomly generate this so that each time you open the lesson,there is a different suit to follow during the lesson
        String suit; //Will hold the string value of the suit value
        
        String arrBids[]=new String[4];//Will hold the bidding values for each player according to format [W,N,E,S]
        

        
        ArrayList<Integer> arrLIncorrect=new ArrayList<>();//hold index positions of the incorrect answers
        
        
        
        int westHighCardVal=0;
        int northHighCardVal=0;
        int eastHighCardVal=0;
        int southHighCardVal=0;
        
        
        boolean validInput2=false;
        boolean validInputBid=false;
        boolean hasBid[]={false,false,false,false}; //Keeps track of each player that could bid
        
        String correctBid="";
        //variables end
        
      //generating a random number that corresponds to a suit value.This number will represent the suit to follow throughout the round.
        Random random=new Random();
        cardSuit=random.nextInt(4);
        
        //Making a card object
        Card c=new Card();
        //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
        suit=c.getGivenSuitAsString(cardSuit);
        String userAns="";//This will hold the user answer 
        
        //Variables end
        
        boolean quickBiddingHelp=false; //This is used to know if quick bidding help must be given.
        boolean bestPlayHelp=false; //This is used to know if bestPlay help must be given.
        
        GameBoard game=new GameBoard(lessonNum,cardSuit);
        game.setVisible(true); 
        
        
        JOptionPane.showMessageDialog(null, "This lesson will make use of the previous tutorial lessons that you have completed.", "Practical Lesson", JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
        
        
        while (validInput==false) {    
                difficulty=JOptionPane.showInputDialog("Select your difficulty:\n1=Basic, 2=Intermediate, 3=Advanced");
                difficulty=difficulty.trim();//removes white space on end
                if (difficulty.equalsIgnoreCase("1")||difficulty.equalsIgnoreCase("2")||difficulty.equalsIgnoreCase("3")) {
                    validInput=true;
            }
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid Difficulty input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        
        //Different lesson based on the difficulty inputted.
        
        if (difficulty.equalsIgnoreCase("1")) { //Help is given,user has access to Quick High card calculation for bidding and best play is given
            quickBiddingHelp=true;
            bestPlayHelp=true;
        }
        else if(difficulty.equalsIgnoreCase("2")){//No help for bidding,you can still view best play during the game
            bestPlayHelp=true;
            quickBiddingHelp=true;
        }
        else if(difficulty.equalsIgnoreCase("3")){//No help given at all.Best Play is displayed at end of the round.
            bestPlayHelp=false;
            quickBiddingHelp=false;
        }
        
        
        
        //Bidding
        game.calcHighCardValues();//high card values for each player is calculated
        
        validInput=false;
        if (quickBiddingHelp==true) { //Allow the player the option to use quick bidding
                while (validInput==false) {            
                        quickBid=JOptionPane.showInputDialog("Quick Bidding Feature:\nDo you want to see the high card values for all hands?\nY=Yes\nN=No");
                    if (quickBid.equalsIgnoreCase("Y")||quickBid.equalsIgnoreCase("Yes")) {
                        JOptionPane.showMessageDialog(null, game.getHighCardValues(), "High Card Values", JOptionPane.INFORMATION_MESSAGE);
                        validInput=true;
                    }
                    
                    else if(quickBid.equalsIgnoreCase("N")||quickBid.equalsIgnoreCase("No")){
                        JOptionPane.showMessageDialog(null, "Looks like you want to calculate high card values the old fashion way.\nNice.", "High Card Values", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter valid input ", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
        }
        else{ //No quick bidding for player to use
            JOptionPane.showMessageDialog(null, "On this level of Difficulty,you cannot use the\nquick high card values feature to help you with bidding.", "High Card Values", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        //Bidding start-Winner of the bid will set trump
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
                                    //trump=c.getGivenStringAsSuit(correctBidParts[0].substring(1));
                                }
                                else{
                                    
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid to output
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0].substring(1));
                                    }   
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0].substring(1));
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
                                    //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0]);
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
                                    //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0]);
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
                                    //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                }
                                else{
                                    if (correctBidParts[1].equals("")) { //checking that there is no alternate bid
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                        //trump=c.getGivenStringAsSuit(correctBidParts[0]);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "That bid is incorrect.\nThe correct bid was "+correctBidParts[0]+" or "+correctBidParts[1], "Incorrect Bid", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showMessageDialog(null, "Will will set the bid to "+correctBidParts[0], "Setting Bid", JOptionPane.INFORMATION_MESSAGE);
                                       // trump=c.getGivenStringAsSuit(correctBidParts[0]);
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
                        else{
                            
                            validInput=true;
                        }
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Enter a Valid input.", "Input not valid", JOptionPane.INFORMATION_MESSAGE);
                }
                
        }//While closing bracket
         
         
         if (hasBid[0]==false&&hasBid[1]==false&&hasBid[2]==false&&hasBid[3]==false) {
            JOptionPane.showMessageDialog(null, "No player could make a bid", "No Bids Made", JOptionPane.INFORMATION_MESSAGE);
            
            
        }
            JOptionPane.showMessageDialog(null, "We will choose a trump card at random", "Random Trump", JOptionPane.INFORMATION_MESSAGE);
         //generating a random number that corresponds to a suit value.This number will represent the suit to follow throughout the round.
            
            Random random2=new Random();
            
            trump=random2.nextInt(4); //random trump card generated
            
            //Making use of the method from the card object that converts a given int value for suit to its corresponding Suit value as a String
            String suitTrump=c.getGivenSuitAsString(trump);
            
            
            
            JOptionPane.showMessageDialog(null, "Trump is set to "+suitTrump, "Setting Trump", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, suit+" is the generated suit of choice for each of the 4 rounds.\nNorth plays first.", "Random Suit to Follow", JOptionPane.INFORMATION_MESSAGE);
            
            //Set trump value
            game.setTrumpStates(trump);
            
            
            //This is the int value for the trump card
           //JOptionPane.showMessageDialog(null, "Will set trump to "+trump, "Setting Trump", JOptionPane.INFORMATION_MESSAGE);
         
            //Need a hint that states what trump is
            
        //Bidding end
        
        
        
        
        //Can player make use of bestPlay Help
        if(bestPlayHelp==true){//Player has the option available to view the best play
            
        }
        else{//Player cannot view best play
            
        }
        
        
        
        //Computer will compute the best play for each player
        
        
        
        
        
        
        //The computer asks the user for a Claim.This is done the 1st time North will play
        
        
        
        //Ask user what their plan is.Display the best play for South user at end of the game
        
        JOptionPane.showMessageDialog(null, "North will play first.", "Round Start", JOptionPane.INFORMATION_MESSAGE);
        game.setTrumpStates(trump);
        
        while (game.roundComplete()==false) { //While a round has not finished
            game.setState(game.getNorthState());
            
            if (game.getNorthState().hasPlayed()==true) {
                game.setState(game.getEastState());
                
                if (game.getEastState().hasPlayed()==true) {
                    game.setState(game.getSouthState());
                    
                    
                        if (game.getSouthState().hasPlayed()==true) {
                            game.setState(game.getWestState());
                            
                            
                                if (game.getWestState().hasPlayed()==true) {
                                   
                                    game.roundComplete();
                                    //break;
                                }
                            
                        }
                    
                }
            }
            
        
        
        
    }
        
        
        JOptionPane.showMessageDialog(null, game.evalTrickWinner(trump), "Trick Winner", JOptionPane.INFORMATION_MESSAGE);
        
       /* 
        //Take user back to lesson screen
        new lessonsScreen().setVisible(true);
                
                
                game.setVisible(false);
                game.dispose(); 
        
       */ 
      //after the cards are dealt and trump has been set,a method will evaluate the best play for South player to win tricks.
                
                
    }
}
