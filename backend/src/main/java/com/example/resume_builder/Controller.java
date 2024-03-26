package com.example.resume_builder;

import com.example.resume_builder.model.ResumeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class Controller {

    private final PdfGenerationService service;

    @Autowired
    public Controller(PdfGenerationService service){
        this.service = service;
    }

    @PostMapping("/generate_pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody ResumeData data){
        try{
            byte[] pdfBytes = service.generatePdf(data);
            if(pdfBytes != null){
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_PDF);
                httpHeaders.setContentDispositionFormData("filename" , "resume.pdf");
                return new ResponseEntity<>(pdfBytes, httpHeaders, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
