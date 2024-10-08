package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic_04_Random {

    // Java Builtin
    // Java Libraries

    public static void main(String[] args) {

        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt());

        System.out.println(random.nextDouble());
        System.out.println(random.nextFloat());
        System.out.println(random.nextBoolean());

        System.out.println("automation" +random.nextInt(9999) + "gmail.net");
        System.out.println("automation" +Math.round(Math.random()*1000) + "gmail.com");


    }


}
