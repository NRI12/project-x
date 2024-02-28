package com.nnh.dal.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.nnh.model.dto.DepartmentDTO;
import com.nnh.model.entity.DepartmentEntity;
import java.util.Map;

public interface IDepartmentService {
	DepartmentDTO save(DepartmentDTO dto);
	void delete(Long[] ids);
	Page<DepartmentEntity> departmentPages(Pageable pageAble);
	List<DepartmentDTO> findAllInVietNam();
	List<DepartmentDTO> findAllInForeign();
	List<DepartmentDTO> findAllToDTO(Page<DepartmentEntity> pages);
	DepartmentDTO findOneById(Long id);
	List<DepartmentDTO> findAllByCityName(String cityName);	
        Map<String,Long> getUniqueCategories();
        List<DepartmentDTO>findAllDepartments();

}
