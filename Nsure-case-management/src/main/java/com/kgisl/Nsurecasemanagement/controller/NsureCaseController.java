package com.kgisl.Nsurecasemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kgisl.Nsurecasemanagement.model.EmailNotificationModel;
import com.kgisl.Nsurecasemanagement.model.NsureCase;
import com.kgisl.Nsurecasemanagement.service.EmailNotificationService;
import com.kgisl.Nsurecasemanagement.service.NsureCaseService;
import com.kgisl.Nsurecasemanagement.service.UploadDocToDMSService;

@RestController
@RequestMapping("/nsurecase")
//@CrossOrigin("http://localhost:4200/*")
public class NsureCaseController {
	
	@Autowired
	private NsureCaseService nsureCaseService;

	@GetMapping("/")
	public ResponseEntity<List<NsureCase>> getAllMachine() {
		List<NsureCase> l = nsureCaseService.getAll();
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Optional<NsureCase> getMachineById(@PathVariable Integer id) {
		Optional<NsureCase> l = nsureCaseService.getById(id);
		System.out.println("Get employee " + l);
		return l;
	}

	@PostMapping("/")
	public ResponseEntity<NsureCase> createMachine(@RequestBody NsureCase n) {
		NsureCase l = nsureCaseService.create(n);
		return new ResponseEntity<>(l, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public NsureCase updateMachine(@RequestBody NsureCase n, @PathVariable int id) {
		NsureCase l = nsureCaseService.update(n, id);
		System.out.println("update id " + l.getId() + "update name " + l.getDocumentName());
		return l;
	}

	@DeleteMapping("/{id}")
	public void deleteMachine(@PathVariable Integer id) {
		nsureCaseService.delete(id);
	}

	
	@Autowired
	private UploadDocToDMSService uploadDocToDMSService;

	public NsureCaseController(UploadDocToDMSService uploadDocToDMSService) {
		this.uploadDocToDMSService = uploadDocToDMSService;
	}

 
	@Autowired
	private EmailNotificationService emailSender;


	@PostMapping("/upload")
	public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
			@RequestParam("companyId") String companyId, @RequestParam("companyName") String companyName,
			@RequestParam("actualFilename") String actualFilename) {
		try {
//            byte[] documentData = file.getBytes();
			String originalFilename = file.getOriginalFilename();
			ResponseEntity<String> result = uploadDocToDMSService.processDocument(file, originalFilename, companyId,
					companyName, actualFilename);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("Error uploading document.");
		}

	}


	@PostMapping("/send-email-notification")
	public ResponseEntity<String> sendEmailNotification(@RequestBody EmailNotificationModel email) {
		
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("Java_COE_Team@kgisl.com");
//		message.setSubject("Documents are Due!!");
//		message.setText("Dear User,"
//				+ ",\n\n Please upload the below mentioned documents that are required for your policy approval.");

//		emailSender.send(message);

		emailSender.sendEmail(email);
		return ResponseEntity.ok("Email NOtification sent successfully to the user");

	}
}
