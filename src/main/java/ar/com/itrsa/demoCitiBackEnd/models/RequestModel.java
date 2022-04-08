package ar.com.itrsa.demoCitiBackEnd.models;

import java.io.Serializable;
import java.util.Objects;

public class RequestModel implements Serializable {
	
	private Integer tipoDocumento;
    private Integer numeroDocumento;
    
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroDocumento, tipoDocumento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Objects.equals(numeroDocumento, other.numeroDocumento)
				&& Objects.equals(tipoDocumento, other.tipoDocumento);
	}

}
