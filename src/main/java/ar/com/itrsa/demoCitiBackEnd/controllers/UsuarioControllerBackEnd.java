package ar.com.itrsa.demoCitiBackEnd.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.itrsa.demoCitiBackEnd.models.RequestModel;
import ar.com.itrsa.demoCitiBackEnd.models.ResponseModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;
import ar.com.itrsa.demoCitiBackEnd.services.UsuarioServiceBack;

@RestController
@RequestMapping("/usuarioBackEnd")
public class UsuarioControllerBackEnd {
	
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
		return usuarioServiceBack.obtenerSaldoDesdeElBack(request);
	}

}
