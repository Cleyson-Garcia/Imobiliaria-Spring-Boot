package com.gft.imobiliaria.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.imobiliaria.Repository.BairroRepository;
import com.gft.imobiliaria.Repository.CategoriaRepository;
import com.gft.imobiliaria.Repository.EstadoRepository;
import com.gft.imobiliaria.Repository.ImovelRepository;
import com.gft.imobiliaria.Repository.MunicipioRepository;
import com.gft.imobiliaria.Repository.NegocioRepository;
import com.gft.imobiliaria.Repository.QuartosRepository;

@Service
public class SetupService {
	
	@Autowired
	private BairroRepository bR;
	
	@Autowired
	private CategoriaRepository cR;
	
	@Autowired
	private EstadoRepository eR;

	@Autowired
	private ImovelRepository iR;

	@Autowired
	private MunicipioRepository mR;

	@Autowired
	private NegocioRepository nR;

	@Autowired
	private QuartosRepository qR;
	
	public boolean checkState(){
		if(cR.count()>0 || eR.count()>0 || nR.count()>0)
			return true;
		return false;
	}
	
	public void loadDb() {
		
	}
}
