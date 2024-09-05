package com.restaurant.restaurant.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
public class Hotel {

    @Id
    private String id; // ID field for MongoDB

    private String name;
    private String hotelid;
    private String location;
    private String ownerId;
    private Double ratings;
    private Integer capacity;
    private Boolean status;
    private String imageName;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }
    public String getHotelid() {
        return hotelid;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", ownerId=" + ownerId
                + ", ratings=" + ratings + ", capacity=" + capacity + ", status=" + status + ", imageName=" + imageName + "]";
    }
}
