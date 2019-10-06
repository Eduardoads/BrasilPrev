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
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produtos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4587409753625089873L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name = "idCategoria", nullable = false)
	private Categorias categoria;
	
	@Column(name = "produto", nullable = false, length = 50)
	private String produto;
	
	@NumberFormat(style = Style.CURRENCY,pattern = "#,###,###,###.##")
	@Column(name = "preco",precision=2,columnDefinition="double default 0")
	private Double preco;
	
	@Column(name = "quantidade",nullable = false)
	private Integer quantidade;
	
	@Column(name = "descricao", length = 500, nullable = false)
	private String descricao;
	
	@Column(name = "foto", length = 5000)
	private String foto;
}
