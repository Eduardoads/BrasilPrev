package com.aeon.brasilprev.app.model;

import java.io.Serializable;

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

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidoItens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItens implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7244214376803305230L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name = "idPedido", nullable = false)
	private Pedidos pedido;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name = "idProduto", nullable = false)
	private Produtos idProduto;
	
	@Column(name = "produto", nullable = false, length = 50)
	private String produto;
	
	@NumberFormat(style = Style.CURRENCY,pattern = "#,###,###,###.##")
	@Column(name = "valor",precision=2,columnDefinition="double default 0")
	private Double valor;
	
	@Column(name = "quantidade",nullable = false)
	private Integer quantidade;
	
	@NumberFormat(style = Style.CURRENCY,pattern = "#,###,###,###.##")
	@Column(name = "subTotal",precision=2,columnDefinition="double default 0")
	private Double subTotal;

}
