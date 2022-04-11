package ar.com.itrsa.demoCitiBackEnd.services;

import ar.com.itrsa.demoCitiBackEnd.exception.BadRequestException;
import ar.com.itrsa.demoCitiBackEnd.models.RequestModel;
import ar.com.itrsa.demoCitiBackEnd.models.ResponseModel;
import ar.com.itrsa.demoCitiBackEnd.models.TipoDocumentoBackModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;
import ar.com.itrsa.demoCitiBackEnd.repositories.TipoDocumentoBackRepository;
import ar.com.itrsa.demoCitiBackEnd.repositories.UsuarioBackRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceBack {

	@Autowired
	UsuarioBackRepository usuarioBackRepository;
	
	@Autowired
	TipoDocumentoBackRepository tipoDocumentoBackRepository;
	
	
	public ArrayList<UsuarioBackModel> obtenerUsuariosDummy(){
		TipoDocumentoBackModel tipoDocumento1 = new TipoDocumentoBackModel(
				1,
                "DNI",
                "Documento Nacional de Identidad");
		
		UsuarioBackModel usuarioModel1 = new UsuarioBackModel(
				1,
                "Matias Gonzalez",
                "Matias@gmail.com",
                tipoDocumento1,
                35311001,
                1234567890789l,
                5000
                );
		ArrayList users = new ArrayList();
		users.add(usuarioModel1);
		return users;
	}
	
	public ArrayList<UsuarioBackModel> obtenerUsuarios(){
		return (ArrayList<UsuarioBackModel>) usuarioBackRepository.findAll();
	}
	
//	Optional<TipoDocumentoBackModel> tipoDocumentoModel, Integer numeroDocumento
	public ResponseModel obtenerSaldoDesdeElBack(RequestModel request) throws Exception {
		
		Integer tipoDocRequest;
		Integer numeroDocRequest;
		ResponseModel respuesta = new ResponseModel();
		
		Optional<TipoDocumentoBackModel> tipoDocumento = Optional.ofNullable(new TipoDocumentoBackModel());
		UsuarioBackModel usuario = new UsuarioBackModel();
		
		/*
        respuesta.setCode(400);
        respuesta.setStatus(false);
        respuesta.setDescripcion("Error 400: en obtenerSaldoDesdeElBack");
        */ 
		
		 if( ( String.valueOf(request.getTipoDocumento() ).equals("") || request.getTipoDocumento()==null )  ||
	        		( String.valueOf(request.getNumeroDocumento() ).equals("") || request.getNumeroDocumento()==null ) )  {
	        	throw new BadRequestException("El numero de documento y el tipo de documento no pueden estar vacio");
			}
		 
		tipoDocRequest = request.getTipoDocumento();
	    numeroDocRequest = request.getNumeroDocumento();
	        
	    tipoDocumento = tipoDocumentoBackRepository.findById(tipoDocRequest);
	    
		
		usuario = usuarioBackRepository.findBytipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocRequest );
		
        respuesta.setCode(200);
        respuesta.setStatus(true);
        respuesta.setDescripcion("el saldo del cliente es: ");
        respuesta.setUsuarioBack(usuario);
		return respuesta;
	}
}
