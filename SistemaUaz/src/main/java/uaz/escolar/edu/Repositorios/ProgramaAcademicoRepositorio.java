package uaz.escolar.edu.Repositorios;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uaz.escolar.edu.Entidades.ProgramaAcademico;



@Repository
public interface ProgramaAcademicoRepositorio extends CrudRepository<ProgramaAcademico,Integer> {


}
