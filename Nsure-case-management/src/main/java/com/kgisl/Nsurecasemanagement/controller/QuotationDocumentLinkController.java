//package com.kgisl.Nsurecasemanagement.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kgisl.Nsurecasemanagement.model.QuotationDocumentLink;
//import com.kgisl.Nsurecasemanagement.model.QuotationDocumentLinkId;
//import com.kgisl.Nsurecasemanagement.service.QuotationDocumentLinkService;
//
//@RestController
//@RequestMapping("/nsurecase")
////@CrossOrigin("http://localhost:4200/*")
//public class QuotationDocumentLinkController {
//	@Autowired
//	private QuotationDocumentLinkService service;
//
//	@GetMapping("/")
//	public ResponseEntity<List<QuotationDocumentLink>> getAllTableValues() {
//		List<QuotationDocumentLink> l = service.getAll();
//		return new ResponseEntity<>(l, HttpStatus.OK);
//	}
//
//	@GetMapping("/{id}")
//	public Optional<QuotationDocumentLink> getTableValuesById(@PathVariable QuotationDocumentLinkId id) {
//		Optional<QuotationDocumentLink> l = service.getById(id);
//		System.out.println("Get " + l);
//		return l;
//	}
//
//	@PostMapping("/")
//	public ResponseEntity<QuotationDocumentLink> createTableValues(@RequestBody QuotationDocumentLink n) {
//		QuotationDocumentLink l = service.create(n);
//		return new ResponseEntity<>(l, HttpStatus.CREATED);
//	}
//
//	@PutMapping("/{id}")
//	public QuotationDocumentLink updateTableValues(@RequestBody QuotationDocumentLink n, @PathVariable QuotationDocumentLinkId id) {
//		QuotationDocumentLink l = service.update(n, id);
//		System.out.println("update id " + l.getQuotationDocumentLinkId() + "update name " + l.getvDocumentUrl());
//		return l;
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteTableValues(@PathVariable QuotationDocumentLinkId id) {
//		service.delete(id);
//
//	}
//
//
//}
