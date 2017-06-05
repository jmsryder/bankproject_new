package bankproject.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BankStatementThread {

// location of output files on my local machine
final static String FILE_NAME1 = "/Users/James/Desktop/bankproject/output/out_par_country_";
final static String FILE_NAME2 = "/Users/James/Desktop/bankproject/output/out_debtors_";
final static String FILE_NAME3 = "/Users/James/Desktop/bankproject/output/out_creditors_";

	
    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {

            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	
        	
        	// output_par_country
        	
            File logFile1 = new File(FILE_NAME1 + timeLog + ".txt");
            
            writer = new BufferedWriter(new FileWriter(logFile1));
            writer.write("Output per country");
            writer.write("------------------");
            writer.write("Calculations sorted per country will go here");

            writer.close();

       
        	// output_debtors
            
            File logFile2 = new File(FILE_NAME2 + timeLog + ".txt");
            
            writer = new BufferedWriter(new FileWriter(logFile2));
            writer.write("Output of debtors");
            writer.write("------------------");
            writer.write("Calculations sorted per country will go here");            
            writer.close();

            
            
        	// output_creditors
            
            File logFile3 = new File(FILE_NAME3 + timeLog + ".txt");
            
            writer = new BufferedWriter(new FileWriter(logFile3));
            writer.write("Output of creditors");
            writer.write("------------------");
            writer.write("Calculations sorted per country will go here");            
            writer.close();

            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}