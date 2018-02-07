package com.leysoft.app.models;

import java.util.ArrayList;
import java.util.List;

public class Orden {
	
	private Long id;
	
	private List<Producto> productos;

	public Orden() {
		this.productos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		if(!productos.contains(producto)) {
			productos.add(producto);
		}
	}
	
	public Double getTotal() {
		return productos.stream().map(Producto::getPrecio).reduce(0.0, (x, y) -> (x + y))*100;
	}
}