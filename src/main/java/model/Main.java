package model;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import files.CreatePDFS;
import org.example.User;

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

        CreatePDFS pdf = new CreatePDFS(2);





        /*
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
*/

//        // create client
//        Client c1 = new Client("Skour", "Akis", "6097846767", "giannakiss@gmail.com",
//                "akala den menw", "malaka", "tsapou");
//
//        Client c2 = new Client("Giannis", "Sfyrakis", "6097846767", "ppp@.cokm",
//                "Papafi", "fariggas", "tsapou");

    }  }
