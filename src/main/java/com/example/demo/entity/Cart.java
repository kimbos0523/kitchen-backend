package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kitchen;
    
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    private void prePersist()
    {
        createdAt=new Date();
        updatedAt=createdAt;
    }
    @PreUpdate
    private void preUpdate()
    {
        updatedAt=new Date();
    }

}
