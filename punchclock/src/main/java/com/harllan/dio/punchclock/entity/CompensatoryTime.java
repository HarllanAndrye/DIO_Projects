package com.harllan.dio.punchclock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompensatoryTime {
	
	@SuppressWarnings("serial")
	@Data
	@Embeddable
	public class CompensatoryTimeId implements Serializable {
		private Long id;
		private Long movementId;
		private Long userId;
	}
	
	@EmbeddedId
    private CompensatoryTimeId compTimeId;
	
    private LocalDateTime dateWorked;
    private BigDecimal amountOfHours;
    private BigDecimal hoursBalance;

}
