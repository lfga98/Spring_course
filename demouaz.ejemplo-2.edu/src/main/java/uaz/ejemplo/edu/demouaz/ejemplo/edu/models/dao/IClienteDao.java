package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao;

import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente> findAll();
}
