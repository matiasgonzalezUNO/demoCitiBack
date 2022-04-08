package ar.com.itrsa.demoCitiBackEnd.models;

import javax.persistence.*;

@Entity
@Table(name = "usuariosBack")
public class UsuarioBackModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	
	private String nombre;
	
	private String email;
	
	@ManyToOne
	private TipoDocumentoBackModel tipoDocumento;
	
	private Integer numeroDocumento;
	
	private Long numeroCuentaBancaria;
	
	private Integer monto;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoDocumentoBackModel getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoBackModel tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Long getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}

	public void setNumeroCuentaBancaria(Long numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public UsuarioBackModel() {
	}

	public UsuarioBackModel(Integer id, String nombre, String email, TipoDocumentoBackModel tipoDocumento,
			Integer numeroDocumento, Long numeroCuentaBancaria, Integer monto) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.numeroCuentaBancaria = numeroCuentaBancaria;
		this.monto = monto;
	}
	
	public UsuarioBackModel(String nombre, String email, TipoDocumentoBackModel tipoDocumento,
			Integer numeroDocumento, Long numeroCuentaBancaria, Integer monto) {
		this.nombre = nombre;
		this.email = email;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.numeroCuentaBancaria = numeroCuentaBancaria;
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nombre=" + nombre + ", email=" + email + ", tipoDocumento=" + tipoDocumento
				+ ", numeroDocumento=" + numeroDocumento + ", numeroCuentaBancaria=" + numeroCuentaBancaria + ", monto="
				+ monto + "]";
	}
	
	
}
