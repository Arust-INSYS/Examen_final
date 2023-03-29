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

import com.examen.examen_final.entity.Asignatura;
import com.examen.examen_final.service.IAsignaturaService;

@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {

	@Autowired
	IAsignaturaService asignaturaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Asignatura>> listarAsignatura() {
		return new ResponseEntity<>(asignaturaService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Asignatura> crearDepartamento(@RequestBody Asignatura p) {
		return new ResponseEntity<>(asignaturaService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Asignatura> actualizarDepartamento(@PathVariable Long id, @RequestBody Asignatura p) {
		Asignatura asig = asignaturaService.findById(id);
		if (asig == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				asig.setNombre(p.getNombre());
				asig.setN_horas(p.getN_horas());

				return new ResponseEntity<>(asignaturaService.save(p), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Asignatura> eliminarDepartamento(@PathVariable Long id) {
		asignaturaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
