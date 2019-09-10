/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lessons;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishaan
 */
public class User {
    String userName;
    private String password;
    private ArrayList<String> arrLProgress=new ArrayList<>();
    private String fileName="BridgeTutorUpdateUserList.txt";
    private String userLessonFile="LessonProgress.txt";
    
    //Used for storing the data from the textfiles.
    private ArrayList<String> arrLUsers=new ArrayList<>();
    private ArrayList<String> arrLPasswrds=new ArrayList<>();
    //private ArrayList<String> arrLProgress=new ArrayList<>();
    
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public void saveNewUser(){ //Will write a new user to existing players textfile
        
        //File format is username#password#lessonProgress
         //Name of file that has users info
        
        try {
           FileWriter fileWriter=new FileWriter(fileName,true);
           PrintWriter printWriter=new PrintWriter(fileWriter);
           
           printWriter.println(userName+","+password);
            
           
           printWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error writing to file");
        }
        
        //Will create a textfile to track this new user's lesson progress
        
        try {
           FileWriter fileWriter=new FileWriter(userName+userLessonFile,true);
           PrintWriter printWriter=new PrintWriter(fileWriter);
           
           printWriter.println("");//Make a textfile with no contents because user has no lesson progress yet
            
           
           printWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error writing to file");
        }
        
    }
    
    public void upDateLessonProgress(String lessonNumber){ //This method will update a users lesson progress as they successfully complete a lesson.
        
        try {
           FileWriter fileWriter=new FileWriter(userName,true); //Going to write lesson progress to a file named after the user
           PrintWriter printWriter=new PrintWriter(fileWriter);
           
           printWriter.println(lessonNumber); //get the user score from the lesson
            
           
           printWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error writing to file");
        }
        
        
    }
    
    
    public boolean authenticateUser(){ //This is used to check if user already exists 
        //Reading from file
        String value1;//username from textfile
        String value2;//password from textfile
        
        boolean found=false; //Will check if user is found 
        
        try {
            Scanner sc=new Scanner(new File(fileName));
            while (sc.hasNext()) {   
                String line=sc.nextLine();
                
                
                String parts[]=line.split(",");
                value1=parts[0];
                value2=parts[1];
                
                //Read in values from textfile and add to respective arraylists
                arrLUsers.add(value1);
                arrLPasswrds.add(value2);
                
                
                
            }
            sc.close();
            
        } catch (Exception e) {
            System.err.println("Error!");
        }
        
        
        //Once done reading from file,check if inputted username and password can be found in the arraylists
        int arrListSize=arrLUsers.size(); //One arrayList size can be used for both arrayLists since each user has to have a username and corresponding password
        boolean nameFound=false;
        boolean passwordFound=false;
        
        for (int i = 0; i < arrListSize; i++) {
            if (arrLUsers.get(i).equals(userName)) {
                nameFound=true;
                break;
            }
            else{
                nameFound=false;
            }
        }
        
        for (int i = 0; i < arrListSize; i++) {
            if (arrLPasswrds.get(i).equals(password)) {
                passwordFound=true;
                break;
            }
            else{
                passwordFound=false;
            }
        }
        
        if (nameFound==true&&passwordFound==true) {
            found=true;
            
        }
        else{
            found=false;
        }
        
        return found; //returns if a user is found or not
    }
    
    public String getLessonProgress(){
        //use the username of the current player and look at the textfile,that contains their lesson progress, for their username
        
        
        
        return null;//Change this to lesson progress
    }
    
    
}