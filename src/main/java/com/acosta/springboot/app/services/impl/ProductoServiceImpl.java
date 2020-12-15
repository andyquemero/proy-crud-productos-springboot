package com.acosta.springboot.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acosta.springboot.app.models.Productos;
import com.acosta.springboot.app.repository.IProductoRepository;
import com.acosta.springboot.app.services.IProductoService;

@Service("productoService")
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public Productos IdProducto(String idProducto) {

		Productos producto = null;

		try {
			
			producto= productoRepository.findById(idProducto);
			//producto = productoRepository.findById(idProducto).get();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return producto;
	}

}
