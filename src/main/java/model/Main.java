package model;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
public class Main {

    public static void main(String[] args) {

       /* try {
            // Create a new Document object
            Document document = new Document();
            // Set the output file name and location
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/giann/Desktop/OSparEinaiArxidi.pdf"));
            // Open the document
            document.open();
            // Add some content
            document.add(new Paragraph("Hello, world!"));
            document.add(new Paragraph("This is some text"));
            Image image = Image.getInstance("C:/Users/giann/Downloads/ΑΣΚΗΣΕΙΣ ΓΙΑΝΝΗ/athens_1.png");
            image.scaleToFit(200, Float.MAX_VALUE);
            document.add(image);
            PdfPTable table = new PdfPTable(3); // 3 columns
            table.addCell("Header 1");
            table.addCell("Header 2");
            table.addCell("Header 3");
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("4");
            table.addCell("5");
            table.addCell("6");
            document.add(table);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED);
            document.add(new Paragraph("This is some bold red text", font));



            // Close the document
            document.close();
            System.out.println("PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        */

        // create a new document
        Document document = new Document();

        try {
            // create a PdfWriter instance to write to the document
            //PdfWriter.getInstance(document, new FileOutputStream("C:/Users/giann/Desktop/transaction_history.pdf"));

            // get the desktop directory
            String desktopPath = System.getProperty("user.home") + "/Desktop";

            // create a new directory called "pdfs" on the desktop if it doesn't exist


            // create a new file with a relative path to the "pdfs" folder
            String pdfPath = desktopPath + "/transaction_history.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

            // open the document
            document.open();

            // set font for the document
            Font font = FontFactory.getFont(FontFactory.COURIER, 12);

            // add the title
            Paragraph title = new Paragraph("Transaction History", font);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // add a table of transactions
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] headers = {"Transaction ID", "Date", "Description", "Amount"};
            String[][] data = {
                    {"000001", dateFormat.format(new Date()), "Payment from John Smith", "$100.00"},
                    {"000002", dateFormat.format(new Date()), "Refund to Jane Doe", "-$50.00"},
                    {"000003", dateFormat.format(new Date()), "Payment from Joe Brown", "$75.00"},
                    {"000004", dateFormat.format(new Date()), "Payment from Sarah Lee", "$200.00"}
            };
            PdfPTable table = new PdfPTable(headers.length);
            table.setWidthPercentage(100f);
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header, font));
                cell.setPadding(5);
                table.addCell(cell);
            }
            for (String[] row : data) {
                for (String cell : row) {
                    table.addCell(new Paragraph(cell, font));
                }
            }
            document.add(table);

            // close the document
            document.close();

            System.out.println("PDF created successfully!");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

    }
}
