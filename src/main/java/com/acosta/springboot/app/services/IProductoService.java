package com.acosta.springboot.app.services;

import java.util.List;

import com.acosta.springboot.app.models.Productos;

public interface IProductoService {

	//metodo interface para poder utilizar tanto en Service implementacion
	//como en el Controller
	public abstract Productos IdProducto(String idProducto);
			
	//Guarda un producto
	public abstract Productos save(Productos entity);
	
	//Obtiene Toda la Lista de productos existente en la base de datos
	public abstract List<Productos> findAll();
	
	//modifica los datos de 1 user
	public abstract Productos update(Productos entity);
	
	//Elimina producto
	public abstract Productos deleteById(String idProducto);
	
	
}
