package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_proveedor")
public class Proveedor {
	
	@Id
	private int idproveedor;
	private String nombre_rs;
	private String telefono;
	private String email;
	
	
	public Proveedor() {	
	
	}


	public Proveedor(int idproveedor, String nombre_rs, String telefono, String email) {
		
		this.idproveedor = idproveedor;
		this.nombre_rs = nombre_rs;
		this.telefono = telefono;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Proveedor [idproveedor=" + idproveedor + ", nombre_rs=" + nombre_rs + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}


	public int getIdproveedor() {
		return idproveedor;
	}


	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}


	public String getNombre_rs() {
		return nombre_rs;
	}


	public void setNombre_rs(String nombre_rs) {
		this.nombre_rs = nombre_rs;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
