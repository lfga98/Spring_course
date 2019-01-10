package uaz.ejemplo.edu.demouaz.ejemplo.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service.UploadServiceImp;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {
	@Autowired
    UploadServiceImp uploadServiceImp;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        uploadServiceImp.deleteAll();
        uploadServiceImp.init();
	}
}
