package com.laFortaleza.tienda.services;

import com.laFortaleza.tienda.models.StoresEntity;
import com.laFortaleza.tienda.repositories.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoresService {
    @Autowired
    StoresRepository storesRepository;
    public List<StoresEntity> getStores(){
        return storesRepository.findAll();
    }

    public int getStoreId(String name){
        return storesRepository.findByNombreAlmacen(name).getIdAlmacen();
    }
}
