package com.resume.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.pdfservices.operation.io.FileRef;
import com.resume.exceptions.InternalServerErrorException;
import com.resume.exceptions.TemplateNotFoundException;
import com.resume.request.ResumeRequest;
import com.resume.service.MergeDocumentToPDF;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class apiController {

    @PostMapping(value = "/resume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> apiRequest(
            @RequestHeader("Accept") String acceptHeader,
            @RequestBody ResumeRequest request
    ) {
        validateData(request);
        try {
            FileRef resume = MergeDocumentToPDF.GeneratePDF(request);
            byte[] pdfBytes = getFileBytes(resume);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.set("Content-Disposition", "attachment; filename=\"resume.pdf\"");
            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error.");
        }
    }

    private void validateData(ResumeRequest request) {
        int templateId = Integer.parseInt(request.getTemplate_id());
        if (templateId < 1 || templateId > 3) {
            throw new TemplateNotFoundException("Template not found");
        }
    }

    private byte[] getFileBytes(FileRef fileRef) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        fileRef.saveAs(outputStream);
        return outputStream.toByteArray();
    }
}
