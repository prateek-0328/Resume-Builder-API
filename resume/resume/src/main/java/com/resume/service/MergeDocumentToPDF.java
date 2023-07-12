package com.resume.service;

import com.adobe.pdfservices.operation.ExecutionContext;
import com.adobe.pdfservices.operation.auth.Credentials;
import com.adobe.pdfservices.operation.io.FileRef;
import com.adobe.pdfservices.operation.pdfops.DocumentMergeOperation;
import com.adobe.pdfservices.operation.pdfops.options.documentmerge.DocumentMergeOptions;
import com.adobe.pdfservices.operation.pdfops.options.documentmerge.OutputFormat;
import com.resume.exceptions.InternalServerErrorException;
import com.resume.request.ResumeRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

//@Service
public class MergeDocumentToPDF {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeDocumentToPDF.class);
    private static String CLIENT_ID="066973b6590a4421a7b40418099e8824";
    private static String CLIENT_SECRET="p8e-CvyF4HkpkUJc_0jsCTX3QSbsn2pTjoNu";

    public static void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}

	public static void setCLIENT_SECRET(String cLIENT_SECRET) {
		CLIENT_SECRET = cLIENT_SECRET;
	}

	public static FileRef GeneratePDF(ResumeRequest request) {

        try {
        	String TemplateLocation=DecideTemplate(request.getTemplate_id());
            // Create a ValidatorFactory and Validator
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            // Validate the request object
            Set<ConstraintViolation<ResumeRequest>> violations = validator.validate(request);
            if (!violations.isEmpty()) {
                for (ConstraintViolation<ResumeRequest> violation : violations) {
                    LOGGER.error("Validation error: {}", violation.getMessage());
                }
                throw new InternalServerErrorException(); //  if there are validation errors
            }            

            // Initial setup, create credentials instance.
            Credentials credentials = Credentials.servicePrincipalCredentialsBuilder()
                    .withClientId(CLIENT_ID)
                    .withClientSecret(CLIENT_SECRET)
                    .build();

            // Setup input data for the document merge process
            String content = request.toString();
            JSONObject jsonDataForMerge = new JSONObject(content);

            // Create an ExecutionContext using credentials.
            ExecutionContext executionContext = ExecutionContext.create(credentials);

            // Create a new DocumentMergeOptions instance
            DocumentMergeOptions documentMergeOptions = new DocumentMergeOptions(jsonDataForMerge, OutputFormat.PDF);

            // Create a new DocumentMergeOperation instance with the DocumentMergeOptions instance
            DocumentMergeOperation documentMergeOperation = DocumentMergeOperation.createNew(documentMergeOptions);

            // Set the operation input document template from a source file.
            FileRef documentTemplate = FileRef.createFromLocalFile(TemplateLocation);
            documentMergeOperation.setInput(documentTemplate);

            // Execute the operation
            FileRef result = documentMergeOperation.execute(executionContext);

//            // Save the result to the specified location.
//            String outputFilePath = createOutputFilePath();
//            result.saveAs(outputFilePath);
            return result;

        } catch (Exception ex) {		//ServiceApiException | IOException | SdkException | ServiceUsage
            LOGGER.error("Exception encountered while executing operation", ex);
            throw new InternalServerErrorException();
        }
    }

    private static String DecideTemplate(String template_id) { 		//Choosing the Template
    	int id=Integer.parseInt(template_id);
    	String docxlocation="";
		if(id==1) {
			docxlocation="./src/main/resources/static/1.docx";
		}
		else if(id == 2) {
			docxlocation="./src/main/resources/static/2.docx";
		}
		else {
			docxlocation="./src/main/resources/static/3.docx";
		}
		return docxlocation;
		
	}

	// Generates a string containing a directory structure and file name for the output file.
    private static String createOutputFilePath(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dateTimeFormatter.format(now);
        return("output/Resume" + timeStamp + ".pdf");
    }
}
