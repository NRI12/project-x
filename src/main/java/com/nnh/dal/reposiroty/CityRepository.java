package com.nnh.dal.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nnh.model.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long>{
	CityEntity findOneByName(String name);
	CityEntity findOneByCode(String code);
	
	@Query("FROM CityEntity c WHERE c.name = :cityName")
	List<CityEntity> findByCityName(@Param("cityName") String cityName);
}
