import java.util.Scanner;
class Conversation {

  public static void main(String[] arguments) {
    Scanner input= new Scanner(System.in);
    System.out.println("How many rounds?");
    int rounds=input.nextInt();
    input.nextLine(); //consume newline character
    System.out.println("What's up?");
    String response=input.nextLine();
    while (rounds >0){
      rounds-=1;
      String originalResponse=response;
      String modifiedResponse=response;

      if (response.indexOf("I")>=0){
        modifiedResponse=modifiedResponse.replace("I","You");
      }if(response.indexOf("me")>=0){
        modifiedResponse=modifiedResponse.replace("me","you" );
      }if(response.indexOf("am")>=0){
        modifiedResponse=modifiedResponse.replace("am","are");
      }if(response.indexOf("you")>=0){
        modifiedResponse=modifiedResponse.replace("you","I");
      }if(response.indexOf("my")>=0){
        modifiedResponse=modifiedResponse.replace("my","your");
      }if(response.indexOf("your")>=0){
        modifiedResponse=modifiedResponse.replace("your","my")+"?";
      }if(modifiedResponse!=originalResponse){
        System.out.println(modifiedResponse + "?");   
      }else{
        System.out.println(cannedResponse());
      }
      response=input.nextLine();
    }
  }
  
    private static String cannedResponse()
    {
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
