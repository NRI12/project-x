package com.nnh.model.dto;

import java.util.Set;

public class DepartmentDTO extends AbstractDTO<DepartmentDTO>{
	private String title;
	private String description;
	private Set<String> thumbnail;
	private Integer price;
	private String cityCode;
	private String cityName;
	private Integer cPage;
	private Integer dPage = 7;
	private Integer tPage;

        private String roomType;
        private Integer capacity;
        private String amenities;
        private Double rating;
        private String catergory;
	private String url_video;
	private Integer max_person;
  
	
	public Integer getcPage() {
		return cPage;
	}
	public void setcPage(Integer cPage) {
		this.cPage = cPage;
	}
	public Integer getdPage() {
		return dPage;
	}
	public void setdPage(Integer dPage) {
		this.dPage = dPage;
	}
	public Integer gettPage() {
		return tPage;
	}
	public void settPage(Integer tPage) {
		this.tPage = tPage;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<String> getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Set<String> thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

        public String getAmenities() {
            return amenities;
        }
             public void setAmenities(String amenities) {
            this.amenities = amenities;
        }
            public Double getRating() {
            return rating;
        }
        public void setRating(Double rating) {
            this.rating = rating;
        }
        public String getCatergory() {
            return catergory;
        }
        public void setCatergory(String catergory) {
                this.catergory = catergory;
        }
         public String getUrl_video() {
                return url_video;
        }

        public void setUrl_video(String url_video) {
            this.url_video = url_video;
        }

        public Integer getMax_person() {
            return max_person;
        }

        public void setMax_person(Integer max_person) {
            this.max_person = max_person;
        }
}
