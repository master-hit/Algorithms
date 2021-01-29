package interview;

import java.util.*;

/**
 * Given a list of people with their birth and death years find the year with
 * the highest population
 *
 * @author Moises
 */
class Person {
    int birth;
    int death;
    Person(int birth, int death) {
        this.birth = birth;
        this.death = death;
    }
}
public class Facebook {
    // record all the years of each person
    // compute population for each year -> population = birth - death
    // find the highest;
    public static void main(String[] args) {
        
        Person person1 = new Person(2000,2010);
        Person person2 = new Person(1975,2005);
        Person person3 = new Person(1975,2003);
        Person person4 = new Person(1803,1809);
        Person person5 = new Person(1750,1869);
        Person person6 = new Person(1840,1935);
        Person person7 = new Person(1803,1921);
        Person person8 = new Person(1894,1921);
        
        Person[] arr = {person1, person2, person3, person4, 
                        person5, person6, person7, person8 };
        
        HashSet<Integer> set = new HashSet<Integer>(); 
        
        for (Person e : arr ) {
            set.add(e.birth);
            set.add(e.death);
        }
        
        int numberOfYears = set.size();
        System.out.println("number of Years: " + numberOfYears);
    }
}
