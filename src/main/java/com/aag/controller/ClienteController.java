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
import com.aag.model.Cliente;
import com.aag.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> lista = service.listar();
		return new ResponseEntity<>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id){
		Cliente obj = service.leerPorId(id);
		if(obj.getIdCliente() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);		
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente){
		Cliente obj = service.modificar(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Cliente obj = service.leerPorId(id);
		if(obj.getIdCliente() == null)
			throw new ModeloNotFoundException("NO SE ENCUENTRA ID "+id);
		service.eliminar(id);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente) {
		Cliente obj = service.registrar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();
	}
}
