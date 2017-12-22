package com.htc.comparator;

import java.util.Comparator;

//Class to compare Movies by name
class NameCompare implements Comparator<Movie>
{
 public int compare(Movie m1, Movie m2)
 {
     return m1.getName().compareTo(m2.getName());
 }
}