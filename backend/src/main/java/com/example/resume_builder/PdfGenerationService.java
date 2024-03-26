package com.example.resume_builder;

import com.example.resume_builder.model.Project;
import com.example.resume_builder.model.ResumeData;
import com.example.resume_builder.model.WorkExp;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class PdfGenerationService {
    public byte[] generatePdf(@RequestBody ResumeData data) throws IOException{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PdfWriter pdfWriter = new PdfWriter(outputStream);) {


            //read json file data into userData
            //use userData to populate the pdf
            //make a template below with various commands



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
            String name = data.getName();
            nestedTable1.addCell(new Cell().add(name).setBold().setBorder(Border.NO_BORDER).setFontSize(20));
            String title = data.getTitle();
            nestedTable1.addCell(new Cell().add(title).setBold().setBorder(Border.NO_BORDER));
            String description = data.getDescription();
            nestedTable1.addCell(new Cell().add(new Paragraph(description)).setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(nestedTable1).setBorder(Border.NO_BORDER));
            Table nestedTable = new Table(new float[]{twocol});

            String email = data.getEmail();
            nestedTable.addCell(new Cell().add(email).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));

            String phone_number = data.getPhone();
            nestedTable.addCell(new Cell().add(phone_number).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));
            String location = data.getLocation();
            nestedTable.addCell(new Cell().add(location).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));
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

            List<WorkExp> workExps = data.getWorkExps();

            //repetitive workexps
            for(int i = 0; i < workExps.size(); i++){
                WorkExp workExp = workExps.get(i)
                String we_title = workExp.getWE_title();
                String we_company = workExp.getWE_company();
                String we_tenure = workExp.getWE_tenure();
                Paragraph we_description = new Paragraph(workExp.getWE_description());
                workexp.addCell(new Cell().add(we_title).setBold().setFontSize(15).setBorder(Border.NO_BORDER));
                workexp.addCell(new Cell().add(we_company).setBorder(Border.NO_BORDER));
                workexp.addCell(new Cell().add(we_tenure).setBorder(Border.NO_BORDER).setFontSize(10));
                workexp.addCell(new Cell().add(we_description).setBorder(Border.NO_BORDER));
                workexp.addCell(new Cell().add(onesp).setBorder(Border.NO_BORDER));
            }

            leftbody.addCell(new Cell().add(workexp));



            Table projects = new Table(new float[]{twocol150});
            projects.addCell(new Cell().add("Projects").setBold().setFontSize(18).setBorder(Border.NO_BORDER));

            List<Project> Projects = data.getProjects();

            for(int i = 0; i < Projects.size(); i++){
                Project pr = Projects.get(i);
                String pr_name = pr.getProj_name();
                String pr_tools = pr.getTools();
                Paragraph pr_description = new Paragraph(pr.getDescription());
                projects.addCell(new Cell().add(pr_name).setBold().setFontSize(15).setBorder(Border.NO_BORDER));
                projects.addCell(new Cell().add(pr_tools).setBorder(Border.NO_BORDER));
                projects.addCell(new Cell().add(pr_description).setBorder(Border.NO_BORDER));
            }


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

            return outputStream.toByteArray();
        }
    }
}
