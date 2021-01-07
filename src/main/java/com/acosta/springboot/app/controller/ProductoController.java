package com.acosta.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acosta.springboot.app.models.Productos;
import com.acosta.springboot.app.services.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	// Metodo POST para crear un nuevo producto
	// Persisto o Guardo en la BBDD
	@PostMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> save(@RequestBody Productos producto) {

		Productos productoData = productoService.save(producto);

		// si el servicio me devolvio un resultado exitoso = 200
		// devuelvo al FrontEnd los datos del producto creado
	 	return ResponseEntity.ok(productoData);

	}

	// metodo GET para obtener lista de producto
	// que ya existe en nuestra base de datos
	@GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {

		// instancio nueva lista de producto
		List<Productos> productos = new ArrayList<Productos>();

		// llamo al servicio creado y obtengo la lista
		productos = productoService.findAll();

		// si el servicio devolvio resultado exitoso = 200
		// devuelvo al FrontEnd toda la lista de productos
		return ResponseEntity.ok(productos);
	}

	// metodo GET para obtener los datos de 1 producto mediante su ID
	@GetMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> findByIdProducto(@PathVariable String idProducto) {

		// instancio un nuevo objeto producto
		Productos producto = new Productos();

		// llamo al servicio creado y le paso por parametro el idProducto
		producto = productoService.IdProducto(idProducto);

		// si el servicio devolvio resultado exitoso = 200
		// devuelvo al FrontEnd los datos del producto solicitado
		return ResponseEntity.ok(producto);

	}

	// metodo PUT modifica un producto existente
	// Pesisto y actualizo la BBDD
	@PutMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> updateProducto(@RequestBody Productos producto) {

		// llamo al servicio creado y le paso los nuevo datos
		// NO TENGO QUE MODIFICAR EL ID DEBE SER EL MISMO
		// me crea un nuevo producto si se modifica
		Productos productoData = productoService.save(producto);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del producto actualizado
		return ResponseEntity.ok(productoData);
	}

	// Metodo DELETE para eliminar los datos de 1 producto por su ID
	@DeleteMapping(value = "/producto/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productos> deleFindByIdProducto(@PathVariable String idProducto) {

		// instancio un nuevo objeto producto
		Productos producto = new Productos();

		// si el servicio devolvio resultado exitoso = 200
		// devuelvo al FrontEnd toda la lista de productos
		return ResponseEntity.ok(producto);

	}

}
