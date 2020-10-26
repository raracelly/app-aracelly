package com.aag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aag.service.ICompraProductoService;

@RestController
@RequestMapping("/CompraProducto")
public class CompraProductoController {

	@Autowired
	private ICompraProductoService service;
}
