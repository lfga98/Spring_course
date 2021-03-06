package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao.IClienteDao;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao.IFacturaDao;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao.IProductoDao;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Factura;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Producto;


@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);

	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional
	public Producto findProductoById(Long id) {

		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);
	}


}
