package ar.com.itrsa.demoCitiBackEnd.repositories;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.itrsa.demoCitiBackEnd.models.TipoDocumentoBackModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;

@Repository
public interface UsuarioBackRepository extends CrudRepository<UsuarioBackModel, Integer> {

	public abstract UsuarioBackModel findBytipoDocumentoAndNumeroDocumento(Optional<TipoDocumentoBackModel> tipoDocumentoModel, Integer numeroDocumento);
	
}
