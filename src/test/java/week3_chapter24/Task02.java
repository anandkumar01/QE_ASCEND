package week3_chapter24;

import java.net.SocketException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task02 {
    public static void main(String[] args) throws SocketException {
        handleArithmeticException();
        handleNullPointerException();
        handleTimeoutException();
        handleNoSuchSessionException();
        handleNoSuchFrameException();
        handleNoSuchWindowException();
    }

    public static void handleArithmeticException() {
        try {
            int i = 9 / 0;
            System.out.println(i);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero is not allowed.");
        }
    }

    public static void handleNullPointerException() {
        try {
            ExceptionHandling obj = new ExceptionHandling(); // Creating a reference with null
            obj = null;
            System.out.println(obj.a);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Attempted to access a member of a null object.");
        }
    }

    public static void handleTimeoutException() {
        WebDriver driver = new ChromeDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("abcdefgh")));
        } catch (TimeoutException e) {
            System.out.println("TimeoutException: Element not found within the specified time.");
        }
        driver.close();
    }

    public static void handleNoSuchSessionException() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.close();
            // Attempt to use the driver after closing it
            driver.get("http://example.com");
        } catch (NoSuchSessionException e) {
            System.out.println("NoSuchSessionException: Attempted to use a closed WebDriver session.");
        }
    }

    public static void handleNoSuchFrameException() throws SocketException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.switchTo().frame("Cognizant");
        } catch (NoSuchFrameException e) {
            System.out.println("NoSuchFrameException: Attempted to switch to a non-existent frame.");
        }
        driver.close();
    }

    public static void handleNoSuchWindowException() throws SocketException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.switchTo().window("Cognizant");
        } catch (NoSuchWindowException e) {
            System.out.println("NoSuchWindowException: Attempted to switch to a non-existent window.");
        }
        driver.close();
    }
}

class ExceptionHandling {
    int a = 10;
}
