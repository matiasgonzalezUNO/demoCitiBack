package ar.com.itrsa.demoCitiBackEnd.services;

import ar.com.itrsa.demoCitiBackEnd.exception.BadRequestException;
import ar.com.itrsa.demoCitiBackEnd.exception.NotFoundException;
import ar.com.itrsa.demoCitiBackEnd.models.RequestModel;
import ar.com.itrsa.demoCitiBackEnd.models.ResponseModel;
import ar.com.itrsa.demoCitiBackEnd.models.TipoDocumentoBackModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;
import ar.com.itrsa.demoCitiBackEnd.repositories.TipoDocumentoBackRepository;
import ar.com.itrsa.demoCitiBackEnd.repositories.UsuarioBackRepository;

import java.util.ArrayList;
import java.util.List;
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
		
		ArrayList<UsuarioBackModel> users = new ArrayList<UsuarioBackModel>();
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
		
		 if( ( String.valueOf(request.getTipoDocumento() ).equals("") || request.getTipoDocumento()==null )  ||
	        		( String.valueOf(request.getNumeroDocumento() ).equals("") || request.getNumeroDocumento()==null ) )  {
	        	throw new BadRequestException("El numero de documento y el tipo de documento no pueden estar vacio");
			}

		tipoDocRequest = request.getTipoDocumento();

	    numeroDocRequest = request.getNumeroDocumento();

	    System.out.println("El tipo doc es: " + tipoDocRequest + "El numero doc es: " + numeroDocRequest ); 

	    tipoDocumento = tipoDocumentoBackRepository.findById(tipoDocRequest);
	    
		usuario = usuarioBackRepository.findBytipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocRequest );
		
		if(usuario == null) {
			throw new NotFoundException("El usuario que esta intentando obtener no existe");
		}
		
		System.out.println("El user obtenido en el back-end es: " + usuario);
        respuesta.setCode(200);
        respuesta.setStatus(true);
        respuesta.setDescripcion("el saldo del cliente es: ");
        respuesta.setUsuarioBack(usuario);
		return respuesta;
	}
	
	//-------------------------------------ABM USER -------------------

    public UsuarioBackModel guardarUsuario(UsuarioBackModel user) {
		return usuarioBackRepository.save(user);
	}

    public Optional<UsuarioBackModel> obtenerUsuarioPorId(Integer id) {
		return usuarioBackRepository.findById(id);
	}

	public List<String> obtenerUsuarioPorPrioridad(Integer prioridad) {
        List<UsuarioBackModel> listUsuarioBackModel = (List<UsuarioBackModel>) usuarioBackRepository.findAll();
        List<String> listUsuarioBackPorPrioridad = new ArrayList<>();
        for (UsuarioBackModel u : listUsuarioBackModel) {
            listUsuarioBackPorPrioridad.add(u.getNombre());
        }
		return listUsuarioBackPorPrioridad;
	}

	public Boolean eliminarUsuario(Integer id) {
        try {
			usuarioBackRepository.deleteById(id);
			return true;
		}catch(Exception err){
			System.out.println("catch Exception err: "+ err);
			return false;

		}

	}
	
}
