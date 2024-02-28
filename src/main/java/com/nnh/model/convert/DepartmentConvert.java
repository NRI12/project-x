package com.nnh.model.convert;

import org.springframework.stereotype.Component;

import com.nnh.model.dto.DepartmentDTO;
import com.nnh.model.entity.DepartmentEntity;

@Component
public class DepartmentConvert {
	public static DepartmentEntity toEntity(DepartmentDTO dto) {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		
		entity.setRoomType(dto.getRoomType());
                entity.setCapacity(dto.getCapacity());
                entity.setAmenities(dto.getAmenities());
                entity.setRating(dto.getRating());
                entity.setCatergory(dto.getCatergory());
                entity.setUrl_video(dto.getUrl_video());
                entity.setMax_person(dto.getMax_person());
		return entity;
	}
	
	public static DepartmentEntity toEntity(DepartmentDTO dto, DepartmentEntity oldEntity) {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setThumbnail(dto.getThumbnail());
		entity.setPrice(dto.getPrice());
		entity.setCreatedBy(oldEntity.getCreatedBy());
		entity.setCreatedDate(oldEntity.getCreatedDate());

		entity.setRoomType(dto.getRoomType());
                entity.setCapacity(dto.getCapacity());
                entity.setAmenities(dto.getAmenities());
                entity.setRating(dto.getRating());
                entity.setCatergory(dto.getCatergory());
                
                entity.setUrl_video(dto.getUrl_video());
                entity.setMax_person(dto.getMax_person());
		return entity;
	}
	
	public static DepartmentDTO toDto(DepartmentEntity entity) {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setThumbnail(entity.getThumbnail());
		if(entity.getCityDepartment() != null) {
			dto.setCityName(entity.getCityDepartment().getName());
		}
		dto.setPrice(entity.getPrice());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		
		dto.setRoomType(entity.getRoomType());
                dto.setCapacity(entity.getCapacity());
                dto.setAmenities(entity.getAmenities());
                dto.setRating(entity.getRating());
                dto.setCatergory(entity.getCatergory());
                dto.setUrl_video(entity.getUrl_video());
                dto.setMax_person(entity.getMax_person());
		return dto;
	}
}
