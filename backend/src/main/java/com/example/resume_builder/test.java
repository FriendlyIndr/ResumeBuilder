package com.example.resume_builder;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "test.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);


        float twocol = 285f;
        float twocol150 = twocol + 150f;
        float[] twocolumnWidth = {twocol150, twocol};
        float[] fullwidth = {twocol*2};
        Paragraph onesp = new Paragraph("\n");

        Table nestedTable1 = new Table(new float[]{twocol150});

        Table table = new Table(twocolumnWidth);
        nestedTable1.addCell(new Cell().add("Name").setBold().setBorder(Border.NO_BORDER).setFontSize(20));
        nestedTable1.addCell(new Cell().add("Title").setBold().setBorder(Border.NO_BORDER));
        nestedTable1.addCell(new Cell().add(new Paragraph("Description")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(nestedTable1).setBorder(Border.NO_BORDER));
        Table nestedTable = new Table(new float[]{twocol});

        nestedTable.addCell(new Cell().add("xyz@g.com").setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));

        nestedTable.addCell(new Cell().add("8080808080").setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));
        nestedTable.addCell(new Cell().add("Pune").setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));

        document.add(table);

        Border gb = new SolidBorder(Color.GRAY, 1f/2f);
        Table divider = new Table(fullwidth);
        divider.setBorder(gb);
        document.add(divider);
        document.add(onesp);

        Table body = new Table(twocolumnWidth);
        Table leftbody = new Table(new float[]{twocol150});
        Table workexp = new Table(new float[]{twocol150});

        workexp.addCell(new Cell().add("Work Experience").setBold().setFontSize(18).setBorder(Border.NO_BORDER));

        //repetitive workexps
        workexp.addCell(new Cell().add("Title1").setBold().setFontSize(15).setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add("Company1").setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add("tenure").setBorder(Border.NO_BORDER).setFontSize(10));
        workexp.addCell(new Cell().add(new Paragraph("Description")).setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add(onesp).setBorder(Border.NO_BORDER));

        workexp.addCell(new Cell().add("Title2").setBold().setFontSize(15).setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add("Company2").setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add("tenure").setBorder(Border.NO_BORDER).setFontSize(10));
        workexp.addCell(new Cell().add(new Paragraph("Description")).setBorder(Border.NO_BORDER));
        workexp.addCell(new Cell().add(onesp).setBorder(Border.NO_BORDER));

        leftbody.addCell(new Cell().add(workexp));

        Table projects = new Table(new float[]{twocol150});
        projects.addCell(new Cell().add("Projects").setBold().setFontSize(18).setBorder(Border.NO_BORDER));
        projects.addCell(new Cell().add("Project1").setBold().setFontSize(15).setBorder(Border.NO_BORDER));
        projects.addCell(new Cell().add("Tools").setBorder(Border.NO_BORDER));
        projects.addCell(new Cell().add(new Paragraph("Description")).setBorder(Border.NO_BORDER));

        leftbody.addCell(new Cell().add(projects));

        body.addCell(new Cell().add(leftbody));

        Table rightbody = new Table(new float[]{twocol});
        Table skills = new Table(new float[]{twocol});
        skills.addCell(new Cell().add("Skills").setBold().setFontSize(18).setBorder(Border.NO_BORDER));

        Table educations = new Table(new float[]{twocol});
        educations.addCell(new Cell().add("Education").setBold().setFontSize(18).setBorder(Border.NO_BORDER));

        //repetitive educations
        educations.addCell(new Cell().add("DegreeName1").setBold().setFontSize(15).setBorder(Border.NO_BORDER));
        educations.addCell(new Cell().add("Period").setBorder(Border.NO_BORDER));

        rightbody.addCell(new Cell().add(educations));

        rightbody.addCell(new Cell().add(skills));
        body.addCell(new Cell().add(rightbody));


        document.add(body);


        document.close();
    }
}
