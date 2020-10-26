package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Supervisor;

public interface ISupervisorService {

	List<Supervisor> listar();

	Supervisor leerPorId(Integer id);

	Supervisor modificar(@Valid Supervisor supervisor);

	void eliminar(Integer id);

	Supervisor registrar(@Valid Supervisor supervisor);

}
