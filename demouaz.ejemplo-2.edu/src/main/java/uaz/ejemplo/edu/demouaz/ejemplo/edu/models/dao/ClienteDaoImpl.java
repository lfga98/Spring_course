package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uaz.ejemplo.edu.demouaz.ejemplo.edu.models.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import java.util.List;

@Repository
public class ClienteDaoImpl implements IClienteDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Cliente> findAll() {

        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        em.persist(cliente);
    }

}
