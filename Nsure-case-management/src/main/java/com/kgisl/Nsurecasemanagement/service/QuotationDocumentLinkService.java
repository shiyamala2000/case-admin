//package com.kgisl.Nsurecasemanagement.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kgisl.Nsurecasemanagement.model.QuotationDocumentLink;
//import com.kgisl.Nsurecasemanagement.model.QuotationDocumentLinkId;
//import com.kgisl.Nsurecasemanagement.repository.QuotationDocumentLinkRepository;
//
//@Service
//public class QuotationDocumentLinkService {
//
//	@Autowired
//	private QuotationDocumentLinkRepository repository;
//
//
//	public List<QuotationDocumentLink> getAll() {
//		return repository.findAll();
//	}
//
//	public Optional<QuotationDocumentLink> getById(QuotationDocumentLinkId id) {
//		return repository.findById(id);
//	}
//
//	public QuotationDocumentLink create(QuotationDocumentLink n) {
//		return repository.save(n);
//	}
//
//	public QuotationDocumentLink update(QuotationDocumentLink n, QuotationDocumentLinkId id) {
//		return repository.save(n);
//	}
//
//	public void delete(QuotationDocumentLinkId id) {
//		repository.deleteById(id);
//	}
//}
