package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class QuestionAskerTest {
	
	
	QuestionAsker asker = new QuestionAsker();
	
	@Test
	public void questionAskerTest(){
		
		String result = asker.askQuestions("1", "1", "1", "1");
		
		assertEquals(result, "Human.");
		
	}
	
	@Test
	public void questionAskerTest2(){
		
		String result = asker.askQuestions("1", "1", "2", "2");
		
		assertEquals(result, "Likely human.");

	}
	
	@Test
	public void questionAskerTest3(){
		
		String result = asker.askQuestions("2", "1", "1", "2");
		
		assertEquals(result, "Seemingly human.");

	}
	
	@Test
	public void questionAskerTest4(){
		
		String result = asker.askQuestions("1", "2", "2", "2");
		
		assertEquals(result, "Guess human.");

	}
	
	@Test
	public void questionAskerTest5(){
		
		String result = asker.askQuestions("2", "2", "2", "2");
		
		assertEquals(result, "Not human.");
	}
}
