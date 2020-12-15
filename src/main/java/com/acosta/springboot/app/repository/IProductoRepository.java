package com.acosta.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acosta.springboot.app.models.Productos;

@Repository("IProductoRepository")
public interface IProductoRepository extends MongoRepository<Productos, Serializable> {

	Productos findById(String id);

}
