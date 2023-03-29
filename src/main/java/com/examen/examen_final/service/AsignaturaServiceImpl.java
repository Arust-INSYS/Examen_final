package com.examen.examen_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.examen_final.entity.Asignatura;
import com.examen.examen_final.repository.IAsignaturaRepository;

@Service
public class AsignaturaServiceImpl extends GenericServiceImpl<Asignatura, Long> implements IAsignaturaService {

	@Autowired
    IAsignaturaRepository asignaturaRepository;

	@Override
	public CrudRepository<Asignatura, Long> getDao() {

		return asignaturaRepository;
	}

}
