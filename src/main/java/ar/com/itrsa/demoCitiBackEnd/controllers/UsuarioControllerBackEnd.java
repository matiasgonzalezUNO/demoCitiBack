package ar.com.itrsa.demoCitiBackEnd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    //-------------------------------------
    @GetMapping( path = "/{id}")
	public Optional<UsuarioBackModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
		return usuarioServiceBack.obtenerUsuarioPorId(id);
	}

	@GetMapping( path = "/query/{prioridad}")
	public List<String> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
		return usuarioServiceBack.obtenerUsuarioPorPrioridad(prioridad);
	}

	@PostMapping
	public ResponseEntity<?> guardarUsuario (@RequestBody UsuarioBackModel usuario) {
		usuarioServiceBack.guardarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Integer id) {
		boolean ok = this.usuarioServiceBack.eliminarUsuario(id);
		if(ok) {
			return "Se elimino el usuario con id " + id ;
		} else {
			return "No se pudo eliminar el usuario con id " + id ;
		}
	}

}
