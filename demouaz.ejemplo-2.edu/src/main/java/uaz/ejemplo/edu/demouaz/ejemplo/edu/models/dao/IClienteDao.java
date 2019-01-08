package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;


public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {


}
