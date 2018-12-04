package ee.ut.cs.wad2018.tarbatu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjaxTest {
    public static void main(String[] args) {
        // Teiseks "property"ks lisa kus sul asub chrome'i draiver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karl Jaagup Kask\\Documents\\TÜ AASTA 2\\Veebirakendused\\Projekt\\Tarbatu\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tarbatu.herokuapp.com/users");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.id("btn"));
        button.click();

        // Testin, kas nupp peidetakse ära
        if (button.getAttribute("class").equals("hide-me")) {
            System.out.println("Test completed: nupp peidetakse");
        } else {
            System.out.println("Test failed: nupp jääb nähtavale");
        }
        WebElement omanikud = driver.findElement(By.id("ajax"));
        WebElement omanik1 = omanikud.findElements(By.tagName("p")).get(0);
        WebElement omanik2 = omanikud.findElements(By.tagName("p")).get(1);
        WebElement omanik3 = omanikud.findElements(By.tagName("p")).get(2);

        // Testin, kas omanike nimed on õiged
        if (omanik1.getText().equals("Karl Jaagup Kask") && omanik2.getText().equals("Karl Johannes Balder") && omanik3.getText().equals("Karl Erik Karindi")) {
            System.out.println("Test completed: omanikude nimed on õiged");
        } else {
            System.out.println("Test failed: omaniku nimed ei kattu");

        }

        driver.close();
    }
}
