package com.nnh.dal.service;

import java.util.List;

import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.CountryEntity;

public interface ICityService {
	List<CityEntity> findAll();
	CountryEntity findCountryByCity(CityEntity cities);
}
