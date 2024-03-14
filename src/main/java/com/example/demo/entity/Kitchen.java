package com.example.demo.entity;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
//@Table(name="kitchens")
@Data @NoArgsConstructor @AllArgsConstructor
public class Kitchen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(unique = true)
	private String name;
	
	private String email;
	private String password; 
	private String confirm_password;
	
	// DayOfWeek will be stored as integers (0 for Monday, 1 for Tuesday, ..., 6 for Sunday)
	// JSON to send in postman: { "workingDays": ["MONDAY", "TUESDAY", "WEDNESDAY"] }
	@ElementCollection
	private List<DayOfWeek> workingDays;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	@OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL)
	@JsonIgnore
    @ToString.Exclude
    private List<Menu> menuItems;
	
	//@Lob
	// should be adjusted for otther databases
    //@Column(columnDefinition = "BYTEA")
    //private byte[] photo;
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
