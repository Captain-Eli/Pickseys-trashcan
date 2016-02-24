
public class Hangperson{
  public static void main(String args[]){
    String name1="", name2="";
    System.out.println("ENTER IN PLAYER ONE NAME");
    name1=Keyboard.readString();
    System.out.println("ENTER IN PLAYER TWO NAME");
    name2=Keyboard.readString();
    playerName(name1,name2);
    play(name1,name2);
  }
  public static void play(String player1,String player2){
    String word="", answer=""; 
    char guess;
    char[] guessedLetters = new char[6];
    int i=0, x=0;
    boolean flag=true;
    System.out.println("Enter the secret word"); 
    word= Keyboard.readString();
    System.out.println("The word is " + word.length() + " charaters long");
    //This loop is the game playing for 6 turns
    //------------------------------------------------
    //creates a blank char array the size of the word
    char[] sheet = new char[word.length()];
    for(i=0;i<=6;i++){
      System.out.println("You have " + (6-i) + " guesses left");
      System.out.println("Do you wanna guess the word? Yes or No");   
      answer = Keyboard.readString();
      if(answer.equalsIgnoreCase("Yes")){
        System.out.println("THE WHEEL OF FATE IS TURNING GUESS NOW");
//let's player guess the word
        if(Keyboard.readString().equalsIgnoreCase(word)){
          break;
        }
        System.out.println("Incorrect answer -1 turn");
      }
      else{
        x = 0;
          System.out.println(player1 +" Enter in ONE letter");
          guess=Keyboard.readChar();
          while(x<6 && flag){
            if(guessedLetters[x]== guess){System.out.println("already geussed that try again!");
              guess = Keyboard.readChar();
              x = -1;
            }
            x++;
          }
          if(word.indexOf(guess)<0)System.out.println("There is no " + guess + "'s in the word");
          else{ x = 0;
            while(x<word.length()){
              if(word.charAt(x)== guess){
              sheet[x]= guess;
              }
              x++;
            }
            System.out.println(sheet);
          }
          guessedLetters[i]=guess;
      }
    }
    //Tells player the outcome
    if(i<6){
      System.out.println("KONGRADURASINS KIDDO YOU WON");
    }
    else System.out.println("The word was "+ word +" you lost tough luck");
    System.out.println("Do you wanna play again? Yes or No");
    if(Keyboard.readString().equalsIgnoreCase("yes")) play(player1,player2);
    else return;
  }
  public static void playerName(String player1, String player2){
    System.out.println("The players are "+ player1 + " and "+ player2);
  }
}

