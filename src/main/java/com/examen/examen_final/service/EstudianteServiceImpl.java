package com.examen.examen_final.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.examen.examen_final.entity.Estudiante;
import com.examen.examen_final.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl extends GenericServiceImpl<Estudiante, Long> implements IEstudianteService {

	@Autowired
    IEstudianteRepository asignaturaRepository;

	@Override
	public CrudRepository<Estudiante, Long> getDao() {

		return asignaturaRepository;
	}

}
