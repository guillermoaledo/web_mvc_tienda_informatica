package org.iesvegademijas.dto;

import java.util.Optional;

import org.iesvegademijas.model.*;

public class FabricanteDTO extends Fabricante{
	
	private Optional<Integer> numero_productos;
	private Integer numero_productos_int;

	public Integer getNumero_productos_int() {
		return numero_productos_int;
	}

	public void setNumero_productos_int(Integer numero_productos_int) {
		this.numero_productos_int = numero_productos_int;
	}

	public FabricanteDTO(Fabricante f) {
		this.setCodigo(f.getCodigo());
		this.setNombre(f.getNombre());
	}
	
	public Optional<Integer> getNumero_productos() {
		return numero_productos;
	}

	public void setNumero_productos(Optional<Integer> numero_productos) {
		this.numero_productos = numero_productos;
	}
	
	
	public String toString() {
		String result = super.toString() + " Numero de productos: " + this.numero_productos_int +"\n";
		
		return result;
	}
}
