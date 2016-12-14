package Step;

import com.github.javafaker.Faker;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by BatEmo on 12/14/2016.
 */
public class SikuliX extends Autocomplete {

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
    }

    @AfterClass
    @Override
    public void tearDown() {
        super.tearDown();
    }


    @Test
    public void sikuliX(){

        Faker f = new Faker();
        Screen s = new Screen();

        System.out.println(f.country());

    }
}
