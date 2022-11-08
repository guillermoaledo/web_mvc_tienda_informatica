package org.iesvegademijas.model;

import java.util.Objects;

public class Producto {

	private int codigo;
	private String nombre;
	private double precio;
	private int codigo_fabricante;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, codigo_fabricante, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && codigo_fabricante == other.codigo_fabricante
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigo_fabricante() {
		return codigo_fabricante;
	}

	public void setCodigo_fabricante(int codigo_fabricante) {
		this.codigo_fabricante = codigo_fabricante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigo_fabricante=" + codigo_fabricante + "]";
	}
	
	
	
}
