package com.SaavedraMoscosoCristopher.sisincidencias.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="incidencias")
@EntityListeners(AuditingEntityListener	.class)
public class Incidencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="denunciante",  nullable = false, length = 100)
	private String denunciante;
	
	@Column(name ="urbanizacion",  nullable = false, length = 100)
	private String urbanizacion;
	
	@Column(name ="calle",  nullable = false, length = 100)
	private String calle;
	
	@Column(name ="referencia",  nullable = false, length = 255)
	private String referencia;
	
	@Column(name ="descripcion",  nullable = false, length = 255)
	private String descripcion;
	
	@Column(name ="fecha", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fecha;
	
}



