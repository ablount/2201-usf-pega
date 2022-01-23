package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.revature.accounts.BankAccount;
import com.revature.accounts.UserAccount;
import com.revature.dao.BankAccountDAO;

public class AccountTests {
	
		BankAccount testAccount1 = new BankAccount(1, 10000, true);
		BankAccount testAccount2 = new BankAccount(2, 20000, true);
		BankAccount testAccount3 = new BankAccount(3, 0, false);
		
		UserAccount userAccount1 = new UserAccount("allison", "1234", "1", 1, 1);
		UserAccount userAccount2 = new UserAccount("rozanne", "123", "1", 2, 2);
		UserAccount userAccount3 = new UserAccount("brian", "12", "1", 3, 3);
		UserAccount userAccount4 = new UserAccount("grayson", "12345", "2", 4, 4);
		UserAccount userAccount5 = new UserAccount("liz", "123456", "3", 5, 5);

		
		@Test
		public void testOne() {
			
			assertNotNull(testAccount1);
			
			assertNotNull(testAccount2);
			
			assertNotNull(testAccount3);
		}
		
		@Test
		public void testTwo() {
			
			int x = testAccount1.balance;
			assertTrue(x == 10000);
			
			int y = testAccount2.balance;
			assertTrue(y == 20000);
			
			int z = testAccount3.balance;
			assertTrue(z == 0);
			
			boolean a = testAccount1.isApproved;
			assertTrue(a == true);
			
			boolean b = testAccount2.isApproved;
			assertTrue(b == true);
			
			boolean c = testAccount3.isApproved;
			assertTrue(c == false);
			
			int d = testAccount1.accountID;
			assertTrue(d == 1);
			
			int e = testAccount2.accountID;
			assertTrue(e == 2);
			
			int f = testAccount3.accountID;
			assertTrue(f == 3);
		}
		
		@Test
		public void testThree() {
			
			assertNotNull(userAccount1);
			
			assertNotNull(userAccount2);
			
			assertNotNull(userAccount3);
			
		}
		
		@Test
		public void testFour() {
			
			String x = userAccount1.username;
			assertTrue(x == "allison");
			
			String y = userAccount2.username;
			assertTrue(y == "rozanne");
			
			String z = userAccount3.username;
			assertTrue(z == "brian");
			
			String a = userAccount1.accountType;
			assertTrue(a == "1");
			
			String b = userAccount4.accountType;
			assertTrue(b == "2");
			
			String c = userAccount5.accountType;
			assertTrue(c == "3");
			
			int d = userAccount1.accountID;
			assertTrue(d == 1);
			
			int e = userAccount2.accountID;
			assertTrue(e == 2);
			
			int f = userAccount3.accountID;
			assertTrue(f == 3);

		}
		
		@Test
		public void testFive() {
			
			
			
		}
		
		@Test
		public void testSix() {
		}
		
		@Test
		public void testSeven() {
		}
		
		@Test
		public void testEight() {
		}
		
		@Test
		public void testNine() {
		}
		
		@Test
		public void testTen() {
			
			//assertThrows(ArithmeticException.class, () -> machine.divide(1, 0));

		}
		
		@BeforeEach
		public void setupEachTest() {
			
			testAccount1 = new BankAccount(1, 10000, true);
			testAccount2 = new BankAccount(2, 20000, true);
			testAccount3 = new BankAccount(3, 0, false);
			
			userAccount1 = new UserAccount("allison", "1234", "1", 1, 1);
			userAccount2 = new UserAccount("rozanne", "123", "1", 2, 2);
			userAccount3 = new UserAccount("brian", "12", "1", 3, 3);
			userAccount4 = new UserAccount("grayson", "12345", "2", 4, 4);
			userAccount5 = new UserAccount("liz", "123456", "3", 5, 5);
			
		}
		
}
