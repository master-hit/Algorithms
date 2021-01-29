package util;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * This class includes static methods in sets
 *
 * @author Moises
 */
public class Sets {

    /**
     * @return returns a set with all the elements in A and B
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> c = new HashSet<>();
        for (T e : a) {
            c.add(e);
        }
        for (T e : b) {
            c.add(e);
        }
        return c;
    }

    /**
     * @return returns a set with the common elements in A and B
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> c = new HashSet<>();
        for (T e : a) {
            if (b.contains(e)) {
                c.add(e);
            }
        }
        return c;
    }

    /**
     * set difference
     *
     * @retuhe a set of all elements in A, but no in B
     */
    public static <T> Set<T> minus(Set<T> A, Set<T> B) {
        Set<T> c = new HashSet<>();
        for (T e : A) {
            if (B.contains(e)) {
                continue;
            }
            c.add(e);
        }
        return c;
    }

    /**
     * @return returns all the elements that are not in A but are in U
     */
    public static <T> Set<T> complement(Set<T> U, Set<T> A) {
        Set<T> c = new HashSet<>();
        for (T e : U) {
            if (A.contains(e)) {
                continue;
            }
            c.add(e);
        }
        return c;
    }
    
    /**
     * @return all the sets of the cartitian product 
     */
    public static <T> Set<T> CartitianProduct(Set<T> A, Set<T> B) {
        HashSet<Set> c = new LinkedHashSet<>();
        Set<T> temp;
        for (T e1 : A) {
            for (T e2 : B) {
                temp = new HashSet();
                temp.add(e1);
                temp.add(e2);
                c.add(temp);
            }
        }
        return (Set) c;
    }
}
