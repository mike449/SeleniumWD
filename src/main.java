import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {

	public static void main(String[] args) throws InterruptedException {

		
		String wyniki = "";
		wyniki+=("Test nr 1: " + test("Jan", "Kowalski", "10-04-2010", false, false, "Brak kwalifikacji"))+"\n";
		wyniki+=("Test nr 2: " + test("Jan", "Kowalski", "10-02-2009", false, true, "Brak kwalifikacji"))+"\n";
		wyniki+=("Test nr 3: " + test("Jan", "Kowalski", "05-02-2007", true, false, "Brak kwalifikacji"))+"\n";
		wyniki+=("Test nr 4: " + test("Jan", "Kowalski", "21-03-1953", false, false, "Brak kwalifikacji"))+"\n";
		wyniki+=("Test nr 5: " + test("Jan", "Kowalski", "12-03-2008", true, true, "Skrzat"))+"\n";
		wyniki+=("Test nr 6: " + test("Jan", "Kowalski", "21-01-2004", true, true, "Junior"))+"\n";
		wyniki+=("Test nr 7: " + test("Jan", "Kowalski", "11-02-2001", false, false, "Dorosly"))+"\n";
		wyniki+=("Test nr 8: " + test("Jan", "Kowalski", "21-03-1953", false, true, "Senior"))+"\n";
		wyniki+=("Test nr 9: " + test("Jan", "Kowalski", "11-03-1948", true, true, "Blad danych"))+"\n";
		wyniki+=("Test nr 10: " + test("Jan", "Kowalski", "11-01-1998", true, false, "Blad danych"))+"\n";
		wyniki+=("Test nr 11: " + test("Jan", "Kowalski", "11-02-1996", false, true, "Blad danych"))+"\n";
		wyniki+=("Test nr 12: " + test("Jan", "Kowalski", "10-03-1996", true, true, "Blad danych"))+"\n";
		wyniki+=("Test nr 13: " + test("Jan", "Kowalski", "11-02-1954", false, false, "Dorosly"))+"\n";
		wyniki+=("Test nr 14: " + test("Jan", "Kowalski", "13-03-2009", true, true, "Skrzat"))+"\n";
		wyniki+=("Test nr 15: " + test("Jan", "Kowalski", "11-02-2002", true, true, "Junior"))+"\n";
		wyniki+=("Test nr 16: " + test("Jan", "Kowalski", "13-02-1803", false, true, "Blad danych"));
		
		System.out.println(wyniki);
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
		//System.out.println(wynik.getText());
		if (wynik.getText().contains(oczekiwanyWynik)) {
			wd.close();
			return "ok";
		}
		wd.close();
		return "blad";
	}

}
