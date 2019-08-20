import java.util.Scanner;

public class GreetEchoExit {
    public static void main(String[] args) {
        System.out.println(
                "   ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "   ____________________________________________________________\n");

        Scanner input = new Scanner(System.in);
        String userString = input.next();

        while(true){
            if(!userString.equals("bye")){
                System.out.println(
                        "   ____________________________________________________________\n" +
                        "     " + userString + "\n" +
                        "   ____________________________________________________________\n"
                );
                userString = input.next();
            }else{
                System.out.println(
                        "   ____________________________________________________________\n" +
                        "     Bye. Hope to see you again soon!\n" +
                        "   ____________________________________________________________\n"
                );
                System.exit(1);
            }
        }
    }
}
