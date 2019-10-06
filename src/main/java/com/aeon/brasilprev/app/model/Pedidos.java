package com.aeon.brasilprev.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742076295618911327L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
	private Clientes cliente;
	
	@Column(name = "status", nullable = false, length = 20)
	private String status;
	
	@Column(name = "sessao", nullable = false, length = 20)
	private String sessao;
}
