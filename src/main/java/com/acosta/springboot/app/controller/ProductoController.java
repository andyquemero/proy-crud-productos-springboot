package com.acosta.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acosta.springboot.app.models.Productos;
import com.acosta.springboot.app.services.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping(value = "/producto/{idProducto}")
	public ResponseEntity<Productos> findByProductos(@PathVariable String idProducto) {

		Productos producto = new Productos("112312", "Algo", "noce", "cosa", 10.0, 1, "que se yo");

		producto = productoService.IdProducto(idProducto);
		return new ResponseEntity<Productos>(producto, HttpStatus.OK);

	}
}
