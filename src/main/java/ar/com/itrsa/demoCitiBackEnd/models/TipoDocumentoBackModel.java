package ar.com.itrsa.demoCitiBackEnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoDocumentosBack")
public class TipoDocumentoBackModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
    private String nombre;
	private String descripcion;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoDocumentoBackModel() {
		
	}
	
	public TipoDocumentoBackModel(String nombre, String descripcion) {	
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public TipoDocumentoBackModel(Integer id, String nombre, String descripcion) {	
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "TipoDocumentoModel [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
