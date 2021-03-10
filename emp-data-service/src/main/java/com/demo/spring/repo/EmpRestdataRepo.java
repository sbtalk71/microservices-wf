package com.demo.spring.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.spring.entity.Emp;

@RepositoryRestResource(collectionResourceRel = "emprest",itemResourceRel = "empdata",path = "emprest")
public interface EmpRestdataRepo extends PagingAndSortingRepository<Emp, Integer> {

	public Emp findByName(int id);
}
