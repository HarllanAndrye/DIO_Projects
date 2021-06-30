package com.harllan.dio.punchclock.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private UserCategory userCategory;
	
	private String name;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private AccessLevelEntity accessLevel;
	
	@ManyToOne
	private Workday workday;
	
	private BigDecimal tolerance;
	private LocalDateTime startWork;
	private LocalDateTime endWork;

}
