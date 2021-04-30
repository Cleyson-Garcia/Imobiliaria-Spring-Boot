package com.gft.imobiliaria.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gft.imobiliaria.Entity.Imovel;
import com.gft.imobiliaria.Repository.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository rep;
	

	public Collection<Imovel> findAllImoveis(){
		return rep.findAll();
	}
	
	public Imovel findImovelById(Long id){
		return rep.findById(id).get();
	}
	
	public void saveImovel(Imovel imovel) {
		rep.save(imovel);
	}
	
	public void excluirImovelById(Long id) {
		rep.deleteById(id);
	}
	
	public Collection<Imovel> findImovelByExample(Imovel imovel, Long idMunicipio, Long idEstado,
			BigDecimal valorMinimo, BigDecimal valorMaximo){
		Long idMun = idMunicipio;
		if(idEstado==null) {
			idMun=null;
		}
		if(idMun==null) {
			imovel.getBairro().setId(null);
		}

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnoreNullValues();
		Example<Imovel> example = Example.of(imovel,matcher);
		Collection<Imovel> todosImoveis = rep.findAll(example);
		
		if(valorMinimo!=null) {
			todosImoveis = todosImoveis.stream().filter(imovelMinimo ->
				imovelMinimo.getValor().compareTo(valorMinimo.subtract(new BigDecimal(0.01)))==1).collect(Collectors.toList());
		}
		if(valorMaximo!=null) {
			todosImoveis = todosImoveis.stream().filter(imovelMaximo ->
				imovelMaximo.getValor().compareTo(valorMaximo.add(new BigDecimal(0.01)))==-1).collect(Collectors.toList());
		}
		
		if(imovel.getBairro().getId()==null) {			
			if(idMun!=null) {
				return todosImoveis.stream().filter(imovelMunicipio -> 
					imovelMunicipio.getBairro().getMunicipio().getId()==idMunicipio).collect(Collectors.toList());
			}else if(idEstado!=null) {
				return todosImoveis.stream().filter(imovelEstado-> 
					imovelEstado.getBairro().getMunicipio().getEstado().getId()==idEstado).collect(Collectors.toList());
			}
		}
		
		return todosImoveis;
	}
}
