package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Factura;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Producto;


public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);

	public List<Producto> findByNombre(String term);

	public void saveFactura(Factura factura);

	public Producto findProductoById(Long id);

	public Factura findFacturaById(Long id);

	public void deleteFactura(Long id);

}
