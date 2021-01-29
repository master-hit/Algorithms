package searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import util.Queue;

/**
 * This is an implementation of Breadth first search which find the closes mango
 * seller from a graph
 *
 * @author Moises
 */
public class Breadth_first_search {

    public static void main(String[] args) {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("claire", new String[]{"thom", "jonny"});
        graph.put("anuj", new String[]{});
        graph.put("peggy", new String[]{});
        graph.put("thom", new String[]{});
        graph.put("jonny", new String[]{});

        if (!searchMangoSeller(graph, "you")) {
            System.out.println("There is not a mango seller");
        }
    }

    public static boolean searchMangoSeller(Map<String, String[]> graph, String you) {
        Set<String> searched = new HashSet<>();                                 // create a set of person who have been visited
        Queue<String> queue = new Queue();
        addToQueue(queue, searched, graph.get(you));                            // adds all of your neighbors to the search queue
        while (!queue.isEmpty()) {                                              //while the queue isn't empty
            String person = queue.deQueue();                                    //grabs the first person off the queue
            if (isPersonSeller(person)) {                                       //checks whether the person is a mango seller
                System.out.println(person + " is a mango seller");
                return true;
            } else {                                                              // No, They arent. Add all of this person's friends to the search queue.
                addToQueue(queue, searched, graph.get(person));
            }
        }
        return false;                                                           // if you reached here, no one is the queue was a mango seller.
    }

    public static boolean isPersonSeller(String person) {
        return person.endsWith("m");
    }

    public static void addToQueue(Queue<String> queue, Set searched, String[] arr) {
        for (String e : arr) {
            if (!searched.contains(e)) {
                queue.enQueue(e);
                searched.add(e);
            }
        }
        for (Object e : queue.toArray()) {                                      //print the queue
            if (queue.contains(e.toString())) {
                System.out.print(e + " ");
            }
        }
        System.out.println();
    }
}
