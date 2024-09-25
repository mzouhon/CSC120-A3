/**
 * imported to allow for the collection of user input
 */
import java.util.Scanner;

/**
 * conversation class allows for an interaction between the user and computer that simulates an actual conversation
 */
class Conversation {

  public static void main(String[] arguments) {
    Scanner input= new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds=input.nextInt();
    input.nextLine(); //consumes newline character to avoid problems getting input later
    
    //creates array that will store transcript and sets index to 0
    String[] transcript=new String[2*rounds];
    int arrayIndex=0;

    System.out.println("What's up?");
    transcript[arrayIndex]="Computer: What's up";
    
    String response=input.nextLine();
    transcript[arrayIndex++] = "You: " + response;
    
    //loop that checks for and replaces mirror words + records computer and user responses
    //runs for the number of times user enters
    while (rounds >1){
      
      String originalResponse=response;
      String modifiedResponse=response;

      if (response.indexOf("I")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\bI\\b","You");
      }if(response.indexOf("me")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\bme\\b","you" );
      }if(response.indexOf("am")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\bam\\b","are");
      }if(response.indexOf("you")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\byou\\b","I");
      }if(response.indexOf("my")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\bmy\\b","your");
      }if(response.indexOf("your")>=0){
        modifiedResponse=modifiedResponse.replaceAll("\\byour\\b","my")+"?";
      }if(!modifiedResponse.equals(originalResponse)){
        System.out.println(modifiedResponse + "?"); 
        transcript[arrayIndex++]="Computer: "+modifiedResponse+"?";  
      }else{
        String cannedResponse=cannedResponse();
        System.out.println(cannedResponse);
        transcript[arrayIndex++]="Computer: "+ cannedResponse;
      }
      response=input.nextLine();
      transcript[arrayIndex++]="You: " + response;
      rounds--;
    }
    
    //prints logoff message and transcript+ closes scanner
    String logOffMessage=("It was nice chatting with you, bye!");
    System.out.println(logOffMessage);
    transcript[arrayIndex++]="Computer: "+ logOffMessage;
    System.out.println("");
    System.out.println("TRANSCRIPT:");
    for (String element: transcript){
      System.out.println(element);
    }
    input.close();
  }

 /**
  * method used to generate a random response when a 
  * mirror word is not detected
  * @return a String object that is a generated response
  */
  private static String cannedResponse(){
      String[] responses = {
        "Very, very cool!",
        "You don't say?",
        "Um...interesting.",
        "Can we talk about something else?",
        "Booooring. Oh sorry, did I say that out loud?",
        "You really like to talk, don't you?"
      };

      int randomIndex=(int)(Math.random()*responses.length);
      return responses[randomIndex];
  }
}
