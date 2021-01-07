package com.acosta.springboot.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acosta.springboot.app.models.Productos;
import com.acosta.springboot.app.repository.IProductoRepository;
import com.acosta.springboot.app.services.IProductoService;

@Service("productoService")
public class ProductoServiceImpl implements IProductoService {

	// inyecto el Repository
	// Para usar sus funciones e implementar
	// en la logica de los servicios
	@Autowired
	private IProductoRepository productoRepository;

	// con este contrato o metodo de mi capa actual
	// creo la logica para poder hacer la consulta con mi base de datos mongo

	@Override
	public Productos IdProducto(String idProducto) {
		// Instancio un nuevo objeto producto
		Productos producto = null;

		// envolvemos en una validacion
		// para que en caso de falla por algun motivo
		// me imprima en consola que parte fallo de mi app
		try {

			producto = productoRepository.findById(idProducto);
			// producto = productoRepository.findById(idProducto).get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// en caso de exito devuelvo todos los datos que contiene Producto
		return producto;
	}

	@Override
	public Productos save(Productos entity) {
		// instancio un nuevo objeto producto
		Productos producto = null;

		// Envolvemos en validacion
		// para que en caso de falla por algun motivo
		// me imprima por consola en donde esta la falla

		try {

			producto = productoRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return producto;
	}

	@Override
	public List<Productos> findAll() {
		// instancio una Lista de Productos
		List<Productos> stProductos = new ArrayList<>();

		// Envolvemos en validacion
		// para que en caso de falla por algun motivo
		// me imprima por consola en donde esta la falla

		try {

			stProductos = productoRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stProductos;
	}

	@Override
	public Productos update(Productos entity) {
		// instancio nuevo objeto producto
		Productos producto = null;

		// Envolvemos en validacion
		// para que en caso de falla por algun motivo
		// me imprima por consola en donde esta la falla
		try {

			producto = productoRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// en caso de exito devuelvo los datos que contiene producto
		return producto;
	}

	@Override
	public Productos deleteById(String idProducto) {
		// instancio un nuevo objeto producto
		Productos producto = null;

		// Envolvemos en validacion
		// para que en caso de falla por algun motivo
		// me imprima por consola en donde esta la falla
		try {

			producto = productoRepository.deleteById(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// si todo sale bien retorna los datos de producto
		return producto;
	}

}
