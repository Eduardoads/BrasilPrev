package com.aeon.brasilprev.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidades implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7913587106411279864L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCidade;
	
	@Column(length = 150,nullable = false)
    private String nome;    

    @Column(name = "cod_ibge",nullable = false)
	private Integer codIbge;

	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estados estado;

}
