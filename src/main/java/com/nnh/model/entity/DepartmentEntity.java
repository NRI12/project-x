package com.nnh.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.Lob;
@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
	@Column(name = "title")
	private String title;
	
        @Lob
	@Column(name = "description")
	private String description;
        
	@ElementCollection(fetch = FetchType.LAZY)
	@Column(name = "thumbnail")
        private Set<String> thumbnail = new HashSet<>();
	
	@Column(name = "price")
	private Integer price;

	@Column(name = "room_type")
	private String roomType;

	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "amenities")
	private String amenities;
	
	@Column(name = "rating")
	private Double rating;
        
	@Column(name = "catergory")
	private String catergory;

               
	@Column(name = "url_video")
	private String url_video;

        @Column(name = "max_person")
	private Integer max_person;
	
        @ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity cityDepartment;
	
	@OneToMany(mappedBy = "department")
	private List<BookingEntity> bookings;
	
	@OneToMany(mappedBy = "departmentComment")
	private List<CommentEntity> comments = new ArrayList<CommentEntity>();
	
	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
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

        public CityEntity getCityDepartment() {
		return cityDepartment;
	}

	public void setCityDepartment(CityEntity cityDepartment) {
		this.cityDepartment = cityDepartment;
	}

	public List<BookingEntity> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingEntity> bookings) {
		this.bookings = bookings;
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
