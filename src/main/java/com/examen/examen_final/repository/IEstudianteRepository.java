package com.examen.examen_final.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.examen_final.entity.Estudiante;

public interface IEstudianteRepository extends MongoRepository<Estudiante, Long> {

}
