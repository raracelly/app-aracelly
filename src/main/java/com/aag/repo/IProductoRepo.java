package com.aag.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
