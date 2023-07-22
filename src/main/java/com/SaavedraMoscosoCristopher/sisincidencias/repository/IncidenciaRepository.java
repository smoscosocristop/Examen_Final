package com.SaavedraMoscosoCristopher.sisincidencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SaavedraMoscosoCristopher.sisincidencias.entity.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer>{
	List<Incidencia> findByDenuncianteContaining(String texto);
	Incidencia findByDenunciante(String texto);

}
