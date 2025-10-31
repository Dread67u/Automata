import java.util.*;

public class NFA {

    static Map<String, Map<Character, Set<String>>> nfa = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nfa.put("q0", new HashMap<>());
        nfa.put("q1", new HashMap<>());
        nfa.put("q2", new HashMap<>());

        nfa.get("q0").put('a', new HashSet<>(Arrays.asList("q0", "q1")));
        nfa.get("q0").put('b', new HashSet<>(Arrays.asList("q0")));

        nfa.get("q1").put('b', new HashSet<>(Arrays.asList("q2")));

        nfa.get("q2").put('a', new HashSet<>(Arrays.asList("q2")));
        nfa.get("q2").put('b', new HashSet<>(Arrays.asList("q2")));

        while (true) {
            System.out.print("Enter string: ");
            String input = sc.nextLine();

            boolean accepted = simulateNFA("q0", input);

            if (accepted) {
                System.out.println("Accepted\n");
            } else {
                System.out.println("Rejected\n");
            }
        }
    }

    static boolean simulateNFA(String startState, String input) {
        Set<String> currentStates = new HashSet<>();
        currentStates.add(startState);

        for (char ch : input.toCharArray()) {
            Set<String> nextStates = new HashSet<>();

            for (String state : currentStates) {
                if (nfa.containsKey(state) && nfa.get(state).containsKey(ch)) {
                    nextStates.addAll(nfa.get(state).get(ch));
                }
            }

            currentStates = nextStates;
        }

        return currentStates.contains("q2");
    }
}
