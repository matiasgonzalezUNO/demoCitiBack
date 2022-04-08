package ar.com.itrsa.demoCitiBackEnd.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.itrsa.demoCitiBackEnd.models.TipoDocumentoBackModel;


@Repository
public interface TipoDocumentoBackRepository extends CrudRepository<TipoDocumentoBackModel, Integer>{

	public abstract TipoDocumentoBackModel findByNombre(String nombre);
	
}
