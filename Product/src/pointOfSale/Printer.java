package pointOfSale;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;

import pointOfSale.OutputPrinter;

public class Printer {
        public void printToPrinter(String toPrint)
        {
         String printData = toPrint;
         PrinterJob job = PrinterJob.getPrinterJob();
         try {
			job.setPrintable(new OutputPrinter(printData));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         boolean doPrint = job.printDialog();
         if (doPrint)
         {
         try
         {
         job.print();
         }
         catch (PrinterException e)
         {
         System.out.println("No printer found!");
         }
         }
        }
        
}