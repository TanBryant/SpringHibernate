package com.springmvc.hibernatecrudapp.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.hibernatecrudapp.entity.Province;

@Repository
@Transactional
public class ProvinceRepository implements BaseRepository<Province> {

    @Autowired
    private SessionFactory sessionFactory;
    
    public ProvinceRepository() {
        
    }

    @Override
    public List<Province> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Province > cq = cb.createQuery(Province.class);
        Root < Province > root = cq.from(Province.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void save(Province object) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(object);
        
    }

    @Override
    public Province getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Province province = currentSession.get(Province.class, id);
        return province;
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        Province object = session.byId(Province.class).load(id);
        session.delete(object);
    }

}
