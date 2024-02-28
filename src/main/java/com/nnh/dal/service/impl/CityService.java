package com.nnh.dal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnh.dal.reposiroty.CityRepository;
import com.nnh.dal.reposiroty.CountryRepository;
import com.nnh.dal.service.ICityService;
import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.CountryEntity;

@Service
public class CityService implements ICityService{
	@Autowired
	private CityRepository cityRep;
	
	@Autowired
	private CountryRepository countryRep;

	public List<CityEntity> findAll() {
		
		return cityRep.findAll();
	}

	public CountryEntity findCountryByCity(CityEntity cities) {
		
		
		return countryRep.findOneByCities(cities);
	}

}
