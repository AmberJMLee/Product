package pointOfSale;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.imageio.ImageIO;
public class OutputPrinter implements Printable
        {
    private BufferedImage barcode, logo;
         private String printData;
         
        public OutputPrinter(String printDataIn) throws IOException {
        	try
        	{
                this.printData = printDataIn;
                logo = ImageIO.read(new File("C:/Users/Owner/Desktop/crayons.jpg"));
        	}
        	catch (IOException ex)
        	{
        		ex.printStackTrace();
        	}
        	}

        @Override
        public int print(Graphics g, PageFormat pf, int page) throws PrinterException
        {
         // Should only have one page, and page # is zero-based.
         if (page > 0)
         {
         return NO_SUCH_PAGE;
         }

         // Adding the "Imageable" to the x and y puts the margins on the page.
         // To make it safe for printing.
         Graphics2D g2d = (Graphics2D)g;
         int x = (int) pf.getImageableX();
         int y = (int) pf.getImageableY();
         Font font = new Font("Adobe Garamond Pro Bold", Font.BOLD, 10);
         g2d.translate(x, y);
         g.setFont(font);

         // Calculate the line height
         FontMetrics metrics = g.getFontMetrics(font);
         int lineHeight = metrics.getHeight();

         BufferedReader br = new BufferedReader(new StringReader(printData));

         // Draw the page:
         try
         {
         String line;
         // Just a safety net in case no margin was added.
         x += 50;
         y += 50;
         g2d.drawImage(logo,  x+75, y, null);
         while ((line = br.readLine()) != null)
         {
         y += lineHeight;
         g2d.drawString(line, x, y);
         }
         }
         catch (IOException e)
         {
         //
         }

         return PAGE_EXISTS;
        }
        }