package com.springmvc.hibernatecrudapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.hibernatecrudapp.entity.Province;
import com.springmvc.hibernatecrudapp.repository.BaseRepository;


@Service
public class ProvinceBaseService implements BaseService<Province> {
    
    @Autowired
    private BaseRepository<Province> provinceRepository;

    public ProvinceBaseService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Province> getAll() {
        // TODO Auto-generated method stub
        return provinceRepository.getAll();
    }

    @Override
    public void save(Province object) {
        // TODO Auto-generated method stub
        provinceRepository.save(object);
    }

    @Override
    public Province get(int id) {
        // TODO Auto-generated method stub
        return provinceRepository.getById(id);
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        provinceRepository.deleteById(id);
    }
    
    

}
