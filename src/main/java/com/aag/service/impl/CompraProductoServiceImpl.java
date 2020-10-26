package com.aag.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.repo.ICompraProductoRepo;
import com.aag.service.ICompraProductoService;

@Service
public class CompraProductoServiceImpl implements ICompraProductoService{

	@Autowired
	private ICompraProductoRepo repo;
	
}
