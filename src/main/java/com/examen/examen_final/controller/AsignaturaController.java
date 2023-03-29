package com.examen.examen_final.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.examen_final.entity.Estudiante;
import com.examen.examen_final.service.IEstudianteService;

@RestController
@RequestMapping("/api/estudiante")
public class AsignaturaController {

	@Autowired
	IEstudianteService estudianteService;

	@GetMapping("/listar")
	public ResponseEntity<List<Estudiante>> listarEstudiante() {
		return new ResponseEntity<>(estudianteService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante p) {
		return new ResponseEntity<>(estudianteService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante p) {
		Estudiante estud = estudianteService.findById(id);
		if (estud == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				estud.setNombre(p.getNombre());
				estud.setApellido(p.getApellido());

				return new ResponseEntity<>(estudianteService.save(p), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Long id) {
		estudianteService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
