package com.aag.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.model.Vendedor;

public interface IVendedorRepo extends JpaRepository<Vendedor, Integer>{

}
