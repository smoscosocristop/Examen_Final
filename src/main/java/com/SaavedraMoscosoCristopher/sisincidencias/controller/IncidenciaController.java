package com.SaavedraMoscosoCristopher.sisincidencias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.SaavedraMoscosoCristopher.sisincidencias.entity.Incidencia;
import com.SaavedraMoscosoCristopher.sisincidencias.service.impl.IncidenciaServiceImpl;

@RestController
@RequestMapping("api/incidencias")
public class IncidenciaController {
	@Autowired
	private IncidenciaServiceImpl service;
	
	@GetMapping()
	public ResponseEntity<List<Incidencia>> getAll(){
		List<Incidencia> incidencias = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(incidencias);		
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Incidencia> getById(@PathVariable("id") int id){
		Incidencia incidencia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(incidencia);		
	}

	@PostMapping
	public ResponseEntity<Incidencia> create(@RequestBody Incidencia incidencia){
		Incidencia incidenciaDb = service.create(incidencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(incidenciaDb);		
	}
	
	@PutMapping
	public ResponseEntity<Incidencia> update(@RequestBody Incidencia incidencia){
		Incidencia incidenciaDb = service.update(incidencia);
		return ResponseEntity.status(HttpStatus.OK).body(incidenciaDb);		
	}
	
	@DeleteMapping(value = "/{id}")
	public int delete(@PathVariable("id") int id){
		
		return service.delete(id);		
	}
}
 
