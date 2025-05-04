import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class ShoppingCartTest {

    @Test
    public void checkDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&" +
                "last_name=test&email=test%40test.test&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=8");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("18");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath("//table" +
                "/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount$ = driver.findElement(By.xpath("//table" +
                "/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String total$ = driver.findElement(By.xpath("//table" +
                "/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "0");
        softAssert.assertEquals(discount$, "0");
        softAssert.assertEquals(total$, "130");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=Polina" +
                "&last_name=Ivanov&email=test%40tes.com&password1=test1&password2=test1");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=8");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("30");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalSum = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "6");
        softAssert.assertEquals(discountDollar, "12");
        softAssert.assertEquals(totalSum, "322");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount5() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=Polina" +
                "&last_name=Ivanov&email=test%40tes.com&password1=test1&password2=test1");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=8");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("550");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalSum = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "9");
        softAssert.assertEquals(discountDollar, "333");
        softAssert.assertEquals(totalSum, "8888");

        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount7() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=Polina" +
                "&last_name=Ivanov&email=test%40tes.com&password1=test1&password2=test1");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=8");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("4555");
        driver.findElement(By.cssSelector("[value=Update]")).click();

        String discountPercent = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalSum = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();

        softAssert.assertEquals(discountPercent, "9");
        softAssert.assertEquals(discountDollar, "6542");
        softAssert.assertEquals(totalSum, "78550");

        driver.quit();
        softAssert.assertAll();
    }
}
