//////////////////////////////\\\
//The New and Improved////////\\\
//Assignment4_4///////////////\\\
//////////////////////////////\\\

import javax.swing.JOptionPane;

//import the random util
import java.util.Random;
public class Assignment4_5HARD
//guess the number
{
   public static void main(String args[])
   {
     
      //declarations
      //defines the randomGenerator as a new random function
      Random randomGenerator = new Random();
      double guess = -1;
      
      String n = (". .10 Chances .. ." );   //PROGRAM TITLE BAR NAME
      
      //comeOn exits to the title menue , users who select no on continue return to title menue and may press quit to exit
      //makes user have to confirm that they want to exit so that they do not have to reopen game
      String comeOn = "true";
     while(comeOn.equals("true"))
     {guess = -1;
      //title menue
      Object[] options1 = {"Play",
                          "Quit"};
      int play = JOptionPane.showOptionDialog(null,n + "\n The number game.", 
                                              n, JOptionPane.OK_CANCEL_OPTION, 
                                              JOptionPane.PLAIN_MESSAGE,
                                              null,
                                              options1,
                                              options1[1]);
      
      //defines play options and creates Play                                        
      String Play = "false";                              
      if(play == JOptionPane.OK_OPTION)
        Play = "true";         
      else 
            System.exit(0);
        
      
      
      //Initalize replay here with the loop so when it repeats everything is random is re-selected  
      String selectDificulty = Play;
    while (selectDificulty.equals("true"))
       {
        guess = -1;
      //dificulty is now a variable, controles the range of the game by selecting:
      //  *easy, medium, or hard
      Object[] options = {"easy",
                          "medium",
                          "hard"};
      final int DIFICULTY_OPTION = JOptionPane.showOptionDialog(null, "Please select a difficulty:", n, 
                                                                JOptionPane.YES_NO_CANCEL_OPTION,
                                                                JOptionPane.QUESTION_MESSAGE,
                                                                null,
                                                                options,
                                                                options[2]);
                                                  
                       
            //translates easy, medium, and hard into an option, and sets range
        int dificulty = 0;                                                
        int dificultyOptions = 0;   //decides hot and cold numbers based on dificulty

           if(DIFICULTY_OPTION == JOptionPane.YES_OPTION)   //easy
              {dificulty = 100;
               dificultyOptions = 0; }
           else
            if(DIFICULTY_OPTION == JOptionPane.NO_OPTION)   //medium
              {dificulty = 500;
               dificultyOptions = 1;}
            else
               if(DIFICULTY_OPTION == JOptionPane.CANCEL_OPTION)  //hard
                  {dificulty = 1000;
                   dificultyOptions = 2;}  
                   
                       
                   
         int DIFICULTY = dificulty;        
         
            
          String replay = "true"; //replay bypass
      //replay game                                                      
      while(replay.equals("true"))                                                    
       {    
        guess = -1;                        
       //make the final variable NUMBER equal to the random generator with whole numbers between 0 and DIFICULTY   
      final int NUMBER = randomGenerator.nextInt(dificulty);    
      int count = 0;
      
      
      //FINAL RANDOMISED STRING ARRAYS *sorted by type:hotCold control, win, loose, hint            
      
      //array for hot cold hint numbers
      //hotCold numbers [] = easy, medium, hard
      //                [] = hot, hotter, on fire
                      
      final int[][] hotCold ={{5, 10, 15},
                              {5, 25, 50},
                              {5, 25, 50}};
      
      //win feedback string
      int WIN_COUNT = 5; //number of win statements
      final int WinCount = WIN_COUNT - 1;
      final int WIN_NUM = randomGenerator.nextInt(WinCount);
      String [] win = {("Keep Up the Good Work!!!"), 
                       ("Great Job!!"),
                       ("Sweet Success! "),
                       ("Isn't winning fun!"),
                       ("Your the best!!")};
            
     //loose feedback string
     int LOOSE_COUNT = 6; //number of loose strings
     final int LooseCount = LOOSE_COUNT - 1;
     final int LOOSE_NUM = randomGenerator.nextInt(LooseCount);
     String [] loose = {("Pick Up The Slack!"),
                        ("Are you ok?"),
                        ("Your not too good at this."),
                        ("Only loosers give up!!"),
                        ("So 10 chances isnt enough for you??"),
                        ("You've got to do better then that!!")};
      
      //give random hints
      int HINT_COUNT = 6;  //the total number of hints
      final int HintCount = HINT_COUNT - 1;
      final int HINT_NUM = randomGenerator.nextInt(HintCount);
      
      String [] hint = {("HINT \n Try starting with " + (dificulty / 2) + "."), 
                        ("HINT \n Try dividing your number by 2 \n until you get the answer."), 
                        ("HINT \n Try to take a deep breath and relax."),
                        ("HINT \n If your on fire, then your less \n then 5 numbers away from the answer."),
                        ("HINT \n dont give up now!!"),
                        ("HINT \n Try to analyze the prpblem logicaly"),
                        ("HINT \n ")} ; 
                        
    //BEGIN GAME
   while(guess != NUMBER)                     
    {  
            
         if( count == 0 )  
      guess = 
      Double.parseDouble(JOptionPane.showInputDialog(null, "Guess a number between 0 and " + DIFICULTY + ": \n*To WIN, guess in under 10 attempts*",
                                                     n, JOptionPane.INFORMATION_MESSAGE));
    else  
      //while guess is NOT equal to the number, give hints and take input 
      
         if(guess < 0 || guess > DIFICULTY)
            guess = Double.parseDouble(JOptionPane.showInputDialog(null, guess +
                                                                   " is NOT between 0 and " + DIFICULTY + ", try again: \n attempt:" + count,
                                                                   n, JOptionPane.WARNING_MESSAGE));
         else 
            if(guess < NUMBER + hotCold[dificultyOptions][0] && guess > NUMBER) 
             guess = Double.parseDouble(JOptionPane.showInputDialog(null,"Your On FIRE!!! \n " + guess +
                                                                    " is too HI, try again: \n attempt:" + count,
                                                                    n, JOptionPane.ERROR_MESSAGE));  
            else
            if(guess > NUMBER - hotCold[dificultyOptions][0] && guess < NUMBER)
                guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your On FIRE!!! \n " + guess +
                                                                       " is too low, try again: \n attempt:" + count,
                                                                       n, JOptionPane.ERROR_MESSAGE)); 
            else
               if(guess < NUMBER + hotCold[dificultyOptions][1] && guess > NUMBER)
                guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your Getting HOTTER!! \n " + guess +
                                                                       " is too HI, try again: \n attempt:" + count,
                                                                       n, JOptionPane.ERROR_MESSAGE)); 
               else 
               if(guess > NUMBER - hotCold[dificultyOptions][1] && guess < NUMBER)
               guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your Getting HOTTER!! \n " + guess +
                                                                      " is too low, try again: \n attempt:" + count,
                                                                      n, JOptionPane.ERROR_MESSAGE));
               else
                  if(guess < NUMBER + hotCold[dificultyOptions][2] && guess > NUMBER)
                   guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your Getting hot \n " + guess +
                                                                          " is too HI, try again: \n attempt:" + count,
                                                                          n, JOptionPane.ERROR_MESSAGE)); 
                  else
                  if (guess > NUMBER - hotCold[dificultyOptions][2] && guess < NUMBER)
                     guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your Getting hot \n " + guess +
                                                                            " is too low, try again: \n attempt:" + count,
                                                                            n, JOptionPane.ERROR_MESSAGE));
                  else
                     if(guess < NUMBER)
                     guess = Double.parseDouble(JOptionPane.showInputDialog(null, "Your COLD \n " + guess +
                                                                            " is too low, try again: \n attempt:" + count,
                                                                            n, JOptionPane.ERROR_MESSAGE));                      
                     else
                        guess = Double.parseDouble(JOptionPane.showInputDialog(null ,"Your COLD \n " + guess +
                                                                               " is too HI, try again: \n attempt:" + count,
                                                                               n, JOptionPane.ERROR_MESSAGE));            
          
          count = count + 1;
          
        }
        
        //Display results based on the number of times it took to reach the goal
        if(count < 2)
         JOptionPane.showMessageDialog(null, "YOUR A WINNER \n " + guess + " is correct, and it only took you " + count +
                                       " attempt to guess correctly!!\n " + "Lucky Guess, Your Number 1!!! ",
                                       n, JOptionPane.PLAIN_MESSAGE);
        else
          if(count < 11)
             JOptionPane.showMessageDialog(null, "YOUR A WINNER \n " + guess + " is correct, and it only took you " + count +
                                           " attempts to guess correctly!!!\n " + win[WIN_NUM],
                                           n, JOptionPane.PLAIN_MESSAGE);
          else
                  if(count < 25)
                     {JOptionPane.showMessageDialog(null, "YOU FAIL \n " + guess + " is correct, but it took you " + count + 
                                                    " attempts to guess correctly.\n " + loose[LOOSE_NUM],
                                                    n, JOptionPane.PLAIN_MESSAGE);
                     JOptionPane.showMessageDialog(null, hint[HINT_NUM], n,
                                                   JOptionPane.PLAIN_MESSAGE);
                     }   
                  else
                     if(count < 30)
                        {JOptionPane.showMessageDialog(null, "EPIC FAIL \n " + guess + " is correct, but it took you " + count + 
                                                       " attempts to guess correctly.\n " + "You Have the IQ of a Rock!!",
                                                       n, JOptionPane.PLAIN_MESSAGE);
                         JOptionPane.showMessageDialog(null, hint[HINT_NUM],
                                                       n, JOptionPane.PLAIN_MESSAGE);
                         }
                     else
                        {JOptionPane.showMessageDialog(null, "EPIC EPIC FAIL \n " + guess + " is correct, but it took you " + count + 
                                                       " attempts to guess correctly.\n " + "Why Do You Even Bother Playing? ",
                                                       n, JOptionPane.PLAIN_MESSAGE);
                         JOptionPane.showMessageDialog(null, hint[HINT_NUM], n, 
                                                       JOptionPane.PLAIN_MESSAGE );
                         }
         //ask to continue?                
         Object[] dialogButton ={"Replay",
                                 "Dificulty",
                                 "exit"} ;
         int dialogResult = JOptionPane.showOptionDialog(null, "Wana continue?", n , 
                                                          JOptionPane.YES_NO_CANCEL_OPTION,
                                                          JOptionPane.PLAIN_MESSAGE, 
                                                          null,
                                                          dialogButton,
                                                          dialogButton[2]);     
         if (dialogResult == JOptionPane.YES_OPTION)
            {replay = "true";
            selectDificulty = "true";
            comeOn = "true";}
         else
           if (dialogResult == JOptionPane.NO_OPTION)
           { replay = "false";
            selectDificulty = "true";
            comeOn = "true";}
           else
            {replay = "false";
            selectDificulty = "false";
            comeOn = "true";}
        
       }    
       }
       }
   }
}                                                                                                                                                                  