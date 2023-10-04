package com.kgisl.Nsurecasemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.Nsurecasemanagement.model.NsureCase;

@Repository
public interface NsureCaseRepository extends JpaRepository<NsureCase, Integer>{

}
