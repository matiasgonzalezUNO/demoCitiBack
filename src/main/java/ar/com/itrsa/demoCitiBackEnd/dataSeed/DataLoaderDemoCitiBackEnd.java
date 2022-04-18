package ar.com.itrsa.demoCitiBackEnd.dataSeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ar.com.itrsa.demoCitiBackEnd.models.TipoDocumentoBackModel;
import ar.com.itrsa.demoCitiBackEnd.models.UsuarioBackModel;
import ar.com.itrsa.demoCitiBackEnd.repositories.TipoDocumentoBackRepository;
import ar.com.itrsa.demoCitiBackEnd.repositories.UsuarioBackRepository;

@Component
public class DataLoaderDemoCitiBackEnd implements CommandLineRunner {
	
	@Autowired
	TipoDocumentoBackRepository tipoDocumentoBackRepository;
	
	@Autowired
	UsuarioBackRepository usuarioBackRepository;
	
	@Override
    public void run(String... args) throws Exception {
        loadTipoDocumento();
        loadUsuario();
       
    }
	
private void loadTipoDocumento() {
		
		if (tipoDocumentoBackRepository.count() == 0) {
			TipoDocumentoBackModel tipoDocumento1 = new TipoDocumentoBackModel(
                    "DNI",
                    "Documento Nacional de Identidad");
			TipoDocumentoBackModel tipoDocumento2 = new TipoDocumentoBackModel(
                    "LE",
                    "Libreta de Enrolamiento");
			TipoDocumentoBackModel tipoDocumento3 = new TipoDocumentoBackModel(
                    "PA",
                    "Pasaporte");;
            TipoDocumentoBackModel tipoDocumento4 = new TipoDocumentoBackModel(
                     "CI",
                     "Cédula de Identidad");
                    
           tipoDocumentoBackRepository.save(tipoDocumento1);
           tipoDocumentoBackRepository.save(tipoDocumento2);
           tipoDocumentoBackRepository.save(tipoDocumento3);
           tipoDocumentoBackRepository.save(tipoDocumento4);
        }
        //System.out.println(tipoDocumentoBackRepository.count());
		
		
	}
	
	private void loadUsuario() {
		
		if (usuarioBackRepository.count() == 0) {
			TipoDocumentoBackModel tipoDoc = tipoDocumentoBackRepository.findByNombre("DNI");
			TipoDocumentoBackModel tipoDoc2 = tipoDocumentoBackRepository.findByNombre("LE");
			
			UsuarioBackModel usuarioModel1 = new UsuarioBackModel(
                    "Matias Gonzalez",
                    "Matias@gmail.com",
                    tipoDoc,
                    35311001,
                    1234567890789l,
                    5000
                    );
			UsuarioBackModel usuarioModel2 = new UsuarioBackModel(
                    "Lucas Perez",
                    "Lucas@gmail.com",
                    tipoDoc,
                    35333111,
                    1234567890790l,
                    10000
                    );
			
			UsuarioBackModel usuarioModel3 = new UsuarioBackModel(
                    "Vero Castana",
                    "Vero@gmail.com",
                    tipoDoc2,
                    35222002,
                    1234567890791l,
                    30000
                    );


			usuarioBackRepository.save(usuarioModel1);
            usuarioBackRepository.save(usuarioModel2);
            usuarioBackRepository.save(usuarioModel3);          
        }
        //System.out.println(usuarioBackRepository.count());
		
	}
	
}
