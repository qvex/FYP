package me.saac.i;
import java.util.regex.*;

public class RegexTest {
    public static void main(String[] args) {
	Pattern p = Pattern.compile("your move?");
	String s = "Java, your move?";
	System.out.println("Matches: " + p.matcher(s).find() + " ");
    }

}