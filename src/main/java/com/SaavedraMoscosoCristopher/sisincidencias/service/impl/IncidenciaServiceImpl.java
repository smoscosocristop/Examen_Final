package com.SaavedraMoscosoCristopher.sisincidencias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SaavedraMoscosoCristopher.sisincidencias.entity.Incidencia;
import com.SaavedraMoscosoCristopher.sisincidencias.repository.IncidenciaRepository;
import com.SaavedraMoscosoCristopher.sisincidencias.service.IncidenciaService;

@Service
public class IncidenciaServiceImpl implements IncidenciaService{

	@Autowired
	private IncidenciaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findAll() {
		try {
			return repository.findAll();
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Incidencia findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Incidencia findByDenunciante(String denunciante) {
		try {
			return repository.findByDenunciante(denunciante);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findByDenuncianteContaining(String denunciante) {
		try {
			return repository.findByDenuncianteContaining(denunciante);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Incidencia create(Incidencia obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Incidencia update(Incidencia obj) {
		try {
			Incidencia incidenciaDb = repository.findById(obj.getId()).orElse(null);
			if(incidenciaDb==null) {
				return null;
			}
			incidenciaDb.setDenunciante(obj.getDenunciante());
			incidenciaDb.setUrbanizacion(obj.getUrbanizacion());
			incidenciaDb.setCalle(obj.getCalle());
			incidenciaDb.setReferencia(obj.getReferencia());
			incidenciaDb.setDescripcion(obj.getDescripcion());
			
			return repository.save(incidenciaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Incidencia incidenciaDb = repository.findById(id).orElse(null);
			if(incidenciaDb==null) {
				return 0;
			}else {
				repository.delete(incidenciaDb);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
