package com.acosta.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acosta.springboot.app.models.Productos;

@Repository("IProductoRepository")
public interface IProductoRepository extends MongoRepository<Productos, Serializable> {
	// Dentro de este bloque de codigo se hacen consultas
	// que necesite contra mongo db

	// internamente actua como una querry de consulta
	// busca en base de datos un producto por medio del ID
	Productos findById(String id);

	// elimina en base de datos un producto por medio del ID
	Productos deleteById(String id);

}
