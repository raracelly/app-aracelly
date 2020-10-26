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
import com.aag.model.Marca;
import com.aag.service.IMarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	private IMarcaService service;
	
	@GetMapping
	public ResponseEntity<List<Marca>> listar(){
		List<Marca> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Marca> listarPorId(@PathVariable("id") Integer id){
		Marca obj = service.leerPorId(id);
		if(obj.getIdMarca() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		return new ResponseEntity<Marca>(obj, HttpStatus.OK);		
	}
	
	@PutMapping
	public ResponseEntity<Marca> modificar(@Valid @RequestBody Marca marca){
		Marca obj = service.modificar(marca);
		return new ResponseEntity<Marca>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Marca obj = service.leerPorId(id);
		if(obj.getIdMarca() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		service.eliminar(id);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Marca marca) {
		Marca obj = service.registrar(marca);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getIdMarca()).toUri();
		return ResponseEntity.created(location).build();
	}
}
