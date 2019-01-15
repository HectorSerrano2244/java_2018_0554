package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Video {

	// Atributos
	private long id;
	
	@NotEmpty
	@Size(min=5, max=150)
	private String nombre;
	
	@NotEmpty
	@Size(min=11, max=11)
	private String codigo;

	private Agente usuario;
	
	private Categoria categoria;
	
	// Constructores

	public Video() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
		this.usuario = new Agente();
		this.categoria = new Categoria();
	}
	
	public Agente getUsuario() {
		return usuario;
	}

	public void setUsuario(Agente usuario) {
		this.usuario = usuario;
	}

	public Video(String nombre) {
		this();
		this.nombre = nombre;
	}
	

	// Getters y Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}





}
