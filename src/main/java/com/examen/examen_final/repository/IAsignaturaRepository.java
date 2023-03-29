package com.examen.examen_final.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examen.examen_final.entity.Asignatura;

public interface IAsignaturaRepository extends MongoRepository<Asignatura, Long> {

}
