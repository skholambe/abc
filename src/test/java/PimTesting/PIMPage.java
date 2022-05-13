package PimTesting;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PIMPage extends BaseClass{

	

		String EmployeeId;

		@BeforeTest
		public void setUp() {
			BaseClass.initialize();
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
		}

		@Test(priority = 1, groups = "PIM")
		public void validatePimPage() {
			driver.findElement(By.xpath("//b[text()='PIM']")).click();
			boolean pim = driver.getCurrentUrl().contains("pim");
			Assert.assertEquals(pim, true);
		}

		@Test(priority = 2, groups = "PIM")
		public void AddEmployeeInPIMPage() {
			driver.findElement(By.id("btnAdd")).click();
			driver.findElement(By.id("firstName")).sendKeys("abc");
			driver.findElement(By.id("lastName")).sendKeys("xyz");
			EmployeeId = driver.findElement(By.id("employeeId")).getAttribute("value");
			driver.findElement(By.id("btnSave")).click();
		}

		@Test(priority = 3, groups = "PIM")
		public void deleteNewlycreatedUser() {
			driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
			driver.findElement(By.id("empsearch_id")).sendKeys(EmployeeId);
			driver.findElement(By.id("searchBtn")).click();
			driver.findElement(By.xpath("//table[@id='resultTable']//td[1]")).click();
			driver.findElement(By.id("btnDelete")).click();

			boolean a = driver.findElement(By.xpath("//p[text()='Delete records?']")).getText().contains("Delete");
			Assert.assertEquals(a, true);

			driver.findElement(By.id("dialogDeleteBtn")).click();
		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		
	}

}
