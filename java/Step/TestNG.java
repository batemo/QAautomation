package Step;

import org.testng.annotations.Test;

/**
 * Created by BatEmo on 11/22/2016.
 */
public class TestNG {

    //set priority changer the way things are executed
    @Test(priority = 1)
    public void LogIn(){
        System.out.println("1");
    }

    @Test(priority = 3)
    public void LogOut(){
        System.out.println("3");
    }

    @Test(priority = 2)
    public void Test(){
        System.out.println("2");
    }
}
