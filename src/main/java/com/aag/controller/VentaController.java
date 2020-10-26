package com.aag.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aag.exception.ModeloNotFoundException;
import com.aag.model.Venta;
import com.aag.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService service;

	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id){
		Venta obj = service.leerPorId(id);
		if(obj.getIdVenta() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);		
	}
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta){
		Venta obj = service.modificar(venta);
		return new ResponseEntity<Venta>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Venta obj = service.leerPorId(id);
		if(obj.getIdVenta() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		service.eliminar(id);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Venta venta) {
		Venta obj = service.registrar(venta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
}
