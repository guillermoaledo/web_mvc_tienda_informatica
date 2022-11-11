package org.iesvegademijas.dto;

import java.util.Optional;

import org.iesvegademijas.model.*;

public class FabricanteDTO extends Fabricante{
	private Optional<Integer> numero_productos;

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
	
}
