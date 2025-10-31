import java.util.Scanner;

public class DFA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.print("Enter a binary string: ");
            String input = sc.nextLine();

            String state = "q0"; 

            for (char c : input.toCharArray()) {
                if (c != '0' && c != '1') {
                    System.out.println("Invalid input! Please enter only 0s and 1s.\n");
                    state = "invalid";
                    break;
                }

                switch (state) {
                    case "q0":
                        state = (c == '0') ? "q1" : "q0";
                        break;
                    case "q1":
                        state = (c == '0') ? "q1" : "q2";
                        break;
                    case "q2":
                        state = (c == '0') ? "q1" : "q0";
                        break;
                }
            }

            if (!state.equals("invalid")) {
                if (state.equals("q2")) {
                    System.out.println("Result:  Accepted\n");
                } else {
                    System.out.println("Result:  Rejected\n");
                }
            }
        }     
    }
}