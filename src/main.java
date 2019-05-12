import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Test nr 1: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 2: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 3: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 4: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 5: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 6: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 7: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 8: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 9: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 10: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 11: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 12: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 13: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 14: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 15: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
		System.out.println("Test nr 16: " + test("Jan", "Kowalski", "12-12-1999", true, true, "Dorosly"));
	}

	public static String test(String im, String nazw, String wiek, boolean zgoda, boolean badania,
			String oczekiwanyWynik) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver74.exe");
		WebDriver wd = new ChromeDriver();
		wd.get("https://lamp.ii.us.edu.pl/~mtdyd/zawody/");
		Thread.sleep(600);
		WebElement imie = wd.findElement(By.id("inputEmail3"));
		WebElement nazwisko = wd.findElement(By.id("inputPassword3"));
		WebElement data = wd.findElement(By.id("dataU"));
		WebElement zg = wd.findElement(By.id("rodzice"));
		WebElement bad = wd.findElement(By.id("lekarz"));
		WebElement btn = wd.findElement(By.className("btn-default"));
		imie.sendKeys(im);
		nazwisko.sendKeys(nazw);
		data.sendKeys(wiek);
		if (zgoda) {
			zg.click();
		}
		if (badania) {
			bad.click();
		}
		btn.click();
		Thread.sleep(600);

		wd.switchTo().alert().accept();
		Thread.sleep(100);
		wd.switchTo().alert().accept();
		WebElement wynik = wd.findElement(By.id("returnSt"));
		if (wynik.getText().contains(oczekiwanyWynik)) {
			wd.close();
			return "ok";
		}

		return "blad";
	}

}
