package com.leysoft.app.models;

public class Checkout {
	
	private Long id;
	
	private Orden orden;
	
	public Checkout() {}

	public Checkout(Orden orden) {
		this.orden = orden;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
}