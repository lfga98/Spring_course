package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao;

import org.springframework.data.repository.CrudRepository;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
}
