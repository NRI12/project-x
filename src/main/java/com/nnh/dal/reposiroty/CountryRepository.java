package com.nnh.dal.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>{
	CountryEntity findOneByCities(CityEntity cities);
}
