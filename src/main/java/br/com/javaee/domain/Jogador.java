package br.com.javaee.domain;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String categoria;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)
    private String jog;

    @Range(min = 0, max = 300)
    @Column(nullable = false)
    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_time_fk")
    private Time time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getJog() {
		return jog;
	}

	public void setJog(String jog) {
		this.jog = jog;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

    
}
