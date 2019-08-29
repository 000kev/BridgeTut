/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BrgtutPkage;

import java.util.ArrayList;

/**
 *
 * @author Ishaan
 */
public class Lesson {
    
    //Variables
    private ArrayList<String> arrLModelAnswers;
    private ArrayList<String> arrLUsersAnswers;
    //Variables end
    
    public Lesson() {
        this.arrLUsersAnswers=new ArrayList<>();
        this.arrLModelAnswers=new ArrayList<>();
    }
    //General use is for checking users answers with the correct answers
    
    public void getAnswer(){
        //Everytime a user selects answer from combo box we update answer array
        //Concern: Need to get the index of combo box selected to store in arraylist
    }
    
    public boolean evalAnswers(){
        //compare the model answers to user's anwers 
        //will output the incorrect answers
        return false; //default
    }
    
}
