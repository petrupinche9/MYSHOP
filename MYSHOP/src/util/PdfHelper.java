package util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.ArrayList;

public class PdfHelper {

    private static PdfHelper instance;

    public static synchronized PdfHelper getInstance() {
        if(instance == null)
            instance = new PdfHelper();
        return instance;
    }

    public void creaPdf(ArrayList<String> testo) {
        //Creating PDF document object
        PDDocument document = new PDDocument();

        PDPage page = new PDPage();

        //Adding the blank page to the document
        document.addPage(page);

        try {

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            //Begin the Content stream
            contentStream.beginText();

            //Setting the font to the Content stream

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

            //Setting the position for the line
            contentStream.newLineAtOffset(25, 700);

            //String text = "This is the sample document and we are adding content to it.";

            for(String text : testo) {
                //Adding text in the form of string
                contentStream.showText(text);
                contentStream.newLineAtOffset(0, -25);
            }

            //Ending the content stream
            contentStream.endText();

            System.out.println("Content added");

            //Closing the content stream
            contentStream.close();

            //Saving the document
            document.save("/Users/roberto/Desktop/my_doc.pdf");

            //Closing the document
            document.close();

            System.out.println("PDF created");
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("PDF NOT created");
        }
    }

}
