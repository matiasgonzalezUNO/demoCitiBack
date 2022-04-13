package ar.com.itrsa.demoCitiBackEnd.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ar.com.itrsa.demoCitiBackEnd.exception.BadRequestException;
import ar.com.itrsa.demoCitiBackEnd.exception.NotFoundException;
import ar.com.itrsa.demoCitiBackEnd.models.RequestModel;
import ar.com.itrsa.demoCitiBackEnd.models.ResponseModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;
import ar.com.itrsa.demoCitiBackEnd.services.UsuarioServiceBack;

@RestController
@RequestMapping("/usuarioBackEnd")
public class UsuarioControllerBackEnd {
	
	private static final Logger logger = LogManager.getLogger(UsuarioControllerBackEnd.class);
	
	@Autowired
	UsuarioServiceBack usuarioServiceBack;
	
	@GetMapping( path = "/getUsersDummy")
	public ArrayList<UsuarioBackModel> obtenerUsuariosDummy() {
		return usuarioServiceBack.obtenerUsuariosDummy();
	}
	
	@GetMapping( path = "/getUsers")
	public ArrayList<UsuarioBackModel> obtenerUsuarios() {
		return usuarioServiceBack.obtenerUsuarios();
	}
	
	@PostMapping( path = "/obtenerSaldoBack")
	public @ResponseBody ResponseModel ObtenerSaldo(@RequestBody RequestModel request) {
		try {
			logger.info("Obteniendo datos del usuario");
			return usuarioServiceBack.obtenerSaldoDesdeElBack(request);
		}catch(NotFoundException nfe) {
			logger.error(nfe.getMessage(), nfe);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, nfe.getMessage());
		}
		catch(BadRequestException bre) {
			logger.error("Los datos enviados son incorrectos", bre);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bre.getMessage());
		} 
		catch(Exception e) {
			logger.error("Error general al obtener datos del usuario", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error general al obtener datos del usuario");
		}
		
	}

}
