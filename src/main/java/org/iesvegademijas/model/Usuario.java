package org.iesvegademijas.model;

import java.util.Objects;

public class Usuario {
	private int id;
	private String usuario;
	private String password;
	private String rol;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, password, rol, usuario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(rol, other.rol)
				&& Objects.equals(usuario, other.usuario);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", rol=" + rol + "]";
	}
	
	
	
	
}
