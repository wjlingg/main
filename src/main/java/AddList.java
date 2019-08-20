import java.util.ArrayList;
import java.util.Scanner;

public class AddList {
    private static final ArrayList<String> myList = new ArrayList<>();
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    public static void main(String[] args) {
        System.out.println(
            "   ____________________________________________________________\n" +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            "   ____________________________________________________________\n");

        Scanner input = new Scanner(System.in);
        String userString = input.nextLine();

        while(true){
            if(!userString.equals("list")){
                if (!userString.equals("bye")) {
                    myList.add(userString);
                    System.out.println(
                        "   ____________________________________________________________\n" +
                        "     added: " + userString + "\n" +
                        "   ____________________________________________________________\n"
                    );
                    userString = input.nextLine();
                }else{
                    System.out.println(
                        "   ____________________________________________________________\n" +
                        "     Bye. Hope to see you again soon!\n" +
                        "   ____________________________________________________________\n"
                    );
                    System.exit(1);
                }
            }else{
                System.out.println(
                    "   ____________________________________________________________"
                );
                for (int i = 0; i < myList.size(); i++){
                    final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
                    System.out.println(
                            "     " + displayIndex + ". " + myList.get(i)
                    );
                }
                System.out.println(
                    "   ____________________________________________________________"
                );
            }
        }
    }
}
