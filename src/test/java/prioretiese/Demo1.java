package prioretiese;

import org.testng.annotations.Test;

public class Demo1 {

	 
		@Test(groups = "Regression Testing")
		public void login() {
			System.out.println("Regression Testing: Login Page");
		}

		@Test(groups = "Sanity Testing")
		public void home() {
			System.out.println("Sanity Testing Home Page");
		}

		@Test(groups = "System Testing")
		public void search() {
			System.out.println("System Testing Search Page");
		}

		@Test(groups = "Regression Testing")
		public void admin() {
			System.out.println("Regression Testing Admin Page");
		}

	}


