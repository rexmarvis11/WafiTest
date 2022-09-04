
package main.java.testdata;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

public interface dataFile {

    // Generate random integers in range 0 to 999
    int rand_int1 = ThreadLocalRandom.current().nextInt();
    int rand_int2 = ThreadLocalRandom.current().nextInt();

    static String randomestring()
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(8);
        return (generatedString2);
    }

    //Usage
    String email = randomestring()+"@gmail.com";
    String RanDigit = Integer.toString(rand_int1);

    String employeeID = randomeNum();
    String name = "admtest";
    String employee_email = email;
    String contact = randomeNum();
}
