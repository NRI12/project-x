package com.nnh.dal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nnh.dal.reposiroty.CityRepository;
import com.nnh.dal.reposiroty.DepartmentRepository;
import com.nnh.dal.service.IDepartmentService;
import com.nnh.model.convert.DepartmentConvert;
import com.nnh.model.dto.DepartmentDTO;
import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.DepartmentEntity;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService{
	@Autowired
	private DepartmentRepository departmentRep;
	
	@Autowired
	private CityRepository cityRep;

	public DepartmentDTO save(DepartmentDTO dto) {
		DepartmentEntity entity = new DepartmentEntity();
		if(dto.getId() != null) {
			entity = departmentRep.findById(dto.getId()).get();
			entity = DepartmentConvert.toEntity(dto, entity);
		}else {
			entity = DepartmentConvert.toEntity(dto);
		}
		entity.setCityDepartment(cityRep.findOneByCode(dto.getCityCode()));
		entity = departmentRep.save(entity);
		dto = DepartmentConvert.toDto(entity);
		dto.setCityCode(cityRep.findById(entity.getCityDepartment().getId()).get().getName());
		
		return dto;
	}

	public void delete(Long[] ids) {
		for(Long id : ids) {
			departmentRep.deleteById(id);
		}
	}

	public Page<DepartmentEntity> departmentPages(Pageable pageAble) {
		return departmentRep.findAll(pageAble);
	}

	public List<DepartmentDTO> findAllToDTO(Page<DepartmentEntity> pages) {
		List<DepartmentDTO> departmentList = new ArrayList<DepartmentDTO>();
		for(DepartmentEntity entity : pages.getContent()) {
			departmentList.add(DepartmentConvert.toDto(entity));
		}
			
		return departmentList;
	}

	public DepartmentDTO findOneById(Long id) {
		
		return DepartmentConvert.toDto(departmentRep.findById(id).get());
	}

	public List<DepartmentDTO> findAllInVietNam() {
		List<DepartmentDTO> departmentList = new ArrayList<DepartmentDTO>();
		for(DepartmentEntity entity : departmentRep.findAll()) {
			if(entity.getCityDepartment().getCountry().getCode().equals("VIETNAM")) {
				departmentList.add(DepartmentConvert.toDto(entity));
			}
			
		}		
		return departmentList;
	}
	
	public List<DepartmentDTO> findAllInForeign() {
		List<DepartmentDTO> departmentList = new ArrayList<DepartmentDTO>();
		for(DepartmentEntity entity : departmentRep.findAll()) {
			if(entity.getCityDepartment().getCountry().getCode().equals("VIETNAM")) {
				
			}else {
				departmentList.add(DepartmentConvert.toDto(entity));
			}
			
		}
			
		return departmentList;
	}

	public List<DepartmentDTO> findAllByCityName(String cityName) {
		List<DepartmentDTO> departmentDTO = new ArrayList<DepartmentDTO>();
		List<CityEntity> cityList = cityRep.findByCityName(cityName);
		for(CityEntity city : cityList) {
			List<DepartmentEntity> departments = departmentRep.findByCityDepartment(city);
			for(DepartmentEntity department : departments) {
				departmentDTO.add(DepartmentConvert.toDto(department));
			}
		}
		return departmentDTO;
	}
        public Map<String, Long> getUniqueCategories() {
            List<DepartmentEntity> departments = departmentRep.findAll();
            return departments.stream()
                              .collect(Collectors.groupingBy(DepartmentEntity::getCatergory, Collectors.counting()));
        }
        public List<DepartmentDTO> findAllDepartments() {
                  List<DepartmentDTO> departmentList = new ArrayList<DepartmentDTO>();
                  for(DepartmentEntity entity : departmentRep.findAll()) {
                      departmentList.add(DepartmentConvert.toDto(entity));			
                  }		
                  return departmentList;
        }
}
