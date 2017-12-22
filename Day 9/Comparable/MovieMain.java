package com.htc.comparable;
import java.util.*;

public class MovieMain {
	public static void main(String[] args)
    {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));
        list.add(new Movie("Prg in Java", 8.2, 1988));
        
     
        Collections.sort(list);
 
        System.out.println("Movies after sorting : ");
        System.out.println(list);
    }
}
