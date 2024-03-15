package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
//@Table(name="kitchens")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Kitchen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password; 
	private String confirm_password;

	@ElementCollection
	private List<DayOfWeek> workingDays;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	@OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL)
	@JsonIgnore
    @ToString.Exclude
    private List<Menu> menuItems;

	@OneToOne(mappedBy = "kitchen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private UploadFile file;

	private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    public void prePersist(){
        updatedAt = createdAt;
    }
    @PreUpdate
    public void preUpdate(){
        updatedAt = new Date();
    }

	

}
