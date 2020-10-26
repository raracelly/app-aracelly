package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Supervisor;
import com.aag.repo.ISupervisorRepo;
import com.aag.service.ISupervisorService;

@Service
public class SupervisorServiceImpl implements ISupervisorService{

	@Autowired
	private ISupervisorRepo repo;

	@Override
	public List<Supervisor> listar() {
		return repo.findAll();
	}

	@Override
	public Supervisor leerPorId(Integer id) {
		Optional<Supervisor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Supervisor();
	}

	@Override
	public Supervisor modificar(@Valid Supervisor supervisor) {
		return repo.save(supervisor);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Supervisor registrar(@Valid Supervisor supervisor) {
		return repo.save(supervisor);
	}
}
