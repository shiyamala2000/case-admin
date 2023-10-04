package com.kgisl.Nsurecasemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.Nsurecasemanagement.model.NsureCase;
import com.kgisl.Nsurecasemanagement.repository.NsureCaseRepository;


@Service
public class NsureCaseService {

	@Autowired
	private NsureCaseRepository nsureCaseRepository;


	public List<NsureCase> getAll() {
		return nsureCaseRepository.findAll();
	}

	public Optional<NsureCase> getById(Integer id) {
		return nsureCaseRepository.findById(id);
	}

	public NsureCase create(NsureCase n) {
		return nsureCaseRepository.save(n);
	}

	public NsureCase update(NsureCase n, Integer id) {
		return nsureCaseRepository.save(n);
	}

	public void delete(Integer id) {
		nsureCaseRepository.deleteById(id);
	}
}
