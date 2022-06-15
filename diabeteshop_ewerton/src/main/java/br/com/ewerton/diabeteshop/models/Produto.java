package br.com.ewerton.diabeteshop.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="produtos")

public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_produto;

    private String marca_produto;

    private double altura_produto;

    private double largura_produto;

    private double profundidade_produto;

    private double volume_produto; //AUTOMATICO

    private String peso_produto;

    private String preco_compra;

    private String preco_venda;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate data_cadastro; //AUTOMATICO

    @Lob
    private byte[] imagem;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_produto() {
        return this.nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getMarca_produto() {
        return this.marca_produto;
    }

    public void setMarca_produto(String marca_produto) {
        this.marca_produto = marca_produto;
    }

    public double getAltura_produto() {
        return this.altura_produto;
    }

    public void setAltura_produto(double altura_produto) {
        this.altura_produto = altura_produto;
    }

    public double getLargura_produto() {
        return this.largura_produto;
    }

    public void setLargura_produto(double largura_produto) {
        this.largura_produto = largura_produto;
    }

    public double getProfundidade_produto() {
        return this.profundidade_produto;
    }

    public void setProfundidade_produto(double profundidade_produto) {
        this.profundidade_produto = profundidade_produto;
    }

    public double getVolume_produto() {
        return this.volume_produto;
    }

    public void setVolume_produto(double volume_produto) {
        this.volume_produto = volume_produto;
    }

    public String getPeso_produto() {
        return this.peso_produto;
    }

    public void setPeso_produto(String peso_produto) {
        this.peso_produto = peso_produto;
    }

    public String getPreco_compra() {
        return this.preco_compra;
    }

    public void setPreco_compra(String preco_compra) {
        this.preco_compra = preco_compra;
    }

    public String getPreco_venda() {
        return this.preco_venda;
    }

    public void setPreco_venda(String preco_venda) {
        this.preco_venda = preco_venda;
    }

    public LocalDate getData_cadastro() {
        return this.data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public byte[] getImagem() {
        return this.imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
}
