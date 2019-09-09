/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lessons;
import java.util.ArrayList;
/**
 *
 * @author Ishaan
 */
public class Lesson {
     //Variables
    private User obj=null;
    
    private ArrayList<String> arrLModelAnswers=new ArrayList<>();
    private ArrayList<String> arrLUsersAnswers=new ArrayList<>();
    private String username;
    private String password;
    private String lessonNum;
    private  ArrayList<String> arrLIncorrectAns=new ArrayList<>();
    
    //Variables end
    
    public Lesson(String lessonNum,User obj) {
        this.lessonNum=lessonNum;
        this.obj=obj;
        
        this.arrLUsersAnswers=new ArrayList<>();
        this.arrLModelAnswers=new ArrayList<>();
    }
    
    public Lesson(String lessonNum,ArrayList<String> arrLModelAns,ArrayList<String> arrLUserAns) {
        this.lessonNum=lessonNum;
        this.obj=obj;
        
        this.arrLUsersAnswers=arrLUserAns;
        this.arrLModelAnswers=arrLModelAns;
    }
    
    //General use is for checking users answers with the correct answers
    
    public String getIncorrectAnswers(){
        String incorrectAns="";
        int incorrectAnsIndex;
        
        for (int i = 0; i < arrLIncorrectAns.size(); i++) {
            incorrectAnsIndex=Integer.parseInt(arrLIncorrectAns.get(i))+1;
            incorrectAns+=incorrectAnsIndex+"";
            
            if (i<arrLIncorrectAns.size()-1) {
                incorrectAns+=",";
            }
            
        }
        return incorrectAns;
    }
    
    public String numIncorrectAns(){
        int numIncorrectAns;
        int totalNumQ=8;
        numIncorrectAns=totalNumQ-arrLIncorrectAns.size();
        
        return numIncorrectAns+"";
    } 
    
    public boolean evalAnswers(){
        //compare the model answers to user's anwers 
        //will output the incorrect answers
       
        int arrListSize=arrLModelAnswers.size();
        
        boolean ansMatch=false;
        for (int i = 0; i < arrListSize; i++) {
            if(arrLUsersAnswers.get(i).equals(arrLModelAnswers.get(i))){
                ansMatch=true;
            }
            else{
                ansMatch=false;
                arrLIncorrectAns.add(i+"");
            }
        }
        
        
        return ansMatch; //default
    }
    
    public void updateLessonProgress(){
        
    }
    
    public String getPlayer(){
        return username;
    }
    
}
