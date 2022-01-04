package com.revature.corejavaassignment;

	public class Q5 {

		static String Substring(String str, int idx) {
			
			// Set up input array and output array
			char[] charArray = str.toCharArray();
			char[] substringArray = new char[idx];
			
			// Copy over substring
			for (int i = 0; i < idx; ++i) {
				substringArray[i] = charArray[i];
			}
			
			// Turn the substring into a String
			return new String(substringArray);
		}
		
		static String testString = "My Test String";
		
		public static void TestSubstring(int idx) {
			System.out.println(Substring(testString, idx));
		}
	}
		
	
