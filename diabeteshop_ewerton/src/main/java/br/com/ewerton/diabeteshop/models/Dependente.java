package br.com.ewerton.diabeteshop.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="dependentes")

public class Dependente implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_dependente;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate data_aniversario;

    private String genero_dependente;

   // @ManyToOne
   // @JoinColumn(name="cliente_id")
   // private Cliente cliente;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_dependente() {
        return this.nome_dependente;
    }

    public void setNome_dependente(String nome_dependente) {
        this.nome_dependente = nome_dependente;
    }

    public LocalDate getData_aniversario() {
        return this.data_aniversario;
    }

    public void setData_aniversario(LocalDate data_aniversario) {
        this.data_aniversario = data_aniversario;
    }

    public String getGenero_dependente() {
        return this.genero_dependente;
    }

    public void setGenero_dependente(String genero_dependente) {
        this.genero_dependente = genero_dependente;
    }

}
