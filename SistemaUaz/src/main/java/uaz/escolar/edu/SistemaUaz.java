package uaz.escolar.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uaz.escolar.edu.Repositorios.ProgramaAcademicoRepositorio;

@SpringBootApplication

public class SistemaUaz {
    public static void main(String[] args){
        SpringApplication.run(SistemaUaz.class,args);
    }

}
