package com.htc.comparable;

//A Java program to demonstrate use of Comparable
import java.io.*;
import java.util.*;

//A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie>
{

 private String name;
 private double rating;
 private int year;

 // Used to sort movies by year
 @Override
 public int compareTo(Movie m)
 {
	 return m.year-this.year;
    
 }

 // Constructor
 public Movie(String nm, double rt, int yr)
 {
     this.name = nm;
     this.rating = rt;
     this.year = yr;
 }

 // Getter methods for accessing private data
 public double getRating() { return rating; }
 public String getName()   {  return name; }
 public int getYear()      {  return year;  }

@Override
public String toString() {
	return "Movie [name=" + name + ", rating=" + rating + ", year=" + year + "]";
}
}
