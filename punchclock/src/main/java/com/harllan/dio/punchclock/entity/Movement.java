package com.harllan.dio.punchclock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
public class Movement {
	
	@SuppressWarnings("serial")
	@Data
	@Embeddable
	public class MovementId implements Serializable {
		private Long id;
		private Long userId;
	}
	 
	@Id
	@EmbeddedId
	private MovementId movementId;
	
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	
	@ManyToOne
	private Occurrence occurrence;
	
	@ManyToOne
	private Calendar calendar;

}
