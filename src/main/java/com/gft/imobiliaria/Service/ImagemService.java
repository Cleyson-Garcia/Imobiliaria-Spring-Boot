package com.gft.imobiliaria.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.imobiliaria.Entity.Imagem;
import com.gft.imobiliaria.Repository.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository rep;
	
	public void saveImage(Imagem imagem) {
		rep.save(imagem);
	}
	
}
