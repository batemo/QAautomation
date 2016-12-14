package Step;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by BatEmo on 11/22/2016.
 */
public class ReadFromCSV {

    String CSV_PATH="D:\\Downloads\\1.csv";
    WebDriver driver;

    @Test
    public void readCSV() throws Exception {

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String [] csvCell;
        //while loop will be executed till the last line In CSV.
        while ((csvCell = reader.readNext()) != null) {
            String FName = csvCell[0];
            String LName = csvCell[1];
            String Email = csvCell[2];
            String Mob = csvCell[3];
            System.out.println(FName);
        }

    }
}


