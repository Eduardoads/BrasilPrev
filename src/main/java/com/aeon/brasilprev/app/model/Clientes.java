package com.aeon.brasilprev.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572384925159598456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;

	@NotNull(message="Informe o campo: Nome")
	@NotBlank(message="Informe o campo: Nome")
    @Column(length = 100, nullable = false)
    private String nome;
	
	@NotNull(message="Informe o campo: Email")
	@NotBlank(message="Informe o campo: Email")
	@Email(message="Informe um email válido")
    @Column(length = 255, nullable = false,unique = true)
    private String email;
	
	@Column(length=100)
	private String rua;
	
	@Column(length=100)
	private String bairro;
	
	@Column(length=10)
	private String cep;

	@ManyToOne
	@JoinColumn(name="idCidade")
	private Cidades cidade;

	@Enumerated(EnumType.STRING)
	private Estados estado;
	
}
