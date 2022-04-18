package ar.com.itrsa.demoCitiBackEnd.models;

import java.io.Serializable;

public class ResponseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;
    private boolean status;
    private String descripcion;
    private UsuarioBackModel Usuario;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UsuarioBackModel getUsuarioBack() {
        return Usuario;
    }

    public void setUsuarioBack(UsuarioBackModel saldoActual) {
        this.Usuario = saldoActual;
    }

}
