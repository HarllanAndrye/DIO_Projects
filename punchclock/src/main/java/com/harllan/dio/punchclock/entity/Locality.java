package com.harllan.dio.punchclock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Locality {
	
	@Id
    private Long id;
	
    @ManyToOne
    private AccessLevelEntity accessLevel;
    
    private String description;

}
