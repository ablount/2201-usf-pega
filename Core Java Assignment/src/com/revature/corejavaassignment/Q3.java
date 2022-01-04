package com.revature.corejavaassignment;

public class Q3 {
	
	public static String reverse(String str)
    {
        // return if the string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }
 
        // create a character array and initialize it with the given string
        char[] c = str.toCharArray();
 
        for (int l = 0, h = str.length() - 1; l < h; l++, h--)
        {
            // swap values at `l` and `h`
            char temp = c[l];
            c[l] = c[h];
            c[h] = temp;
        }
 
        // convert character array to string and return
        return String.copyValueOf(c);
    }

}
