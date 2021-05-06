package com.gft.imobiliaria.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.imobiliaria.Entity.Bairro;
import com.gft.imobiliaria.Entity.Estado;
import com.gft.imobiliaria.Entity.Municipio;
import com.gft.imobiliaria.Repository.BairroRepository;
import com.gft.imobiliaria.Repository.EstadoRepository;
import com.gft.imobiliaria.Repository.MunicipioRepository;

@Service
public class LocalService {

	
	@Autowired
	private EstadoRepository estRep;
	
	@Autowired
	private MunicipioRepository munRep;
	
	@Autowired
	private BairroRepository baiRep;
	
	public Collection<Estado> findAllEstados(){
		return estRep.findAll();
	}
	
	public Estado findEstadoById(Long id){
		return estRep.findById(id).get();
	}
	
	public Collection<Estado> findEstadoByNome(String nome){
		return estRep.findByNomeContainingIgnoreCase(nome);
	}
	
	public void saveEstado(Estado estado) {
		estRep.save(estado);
	}
	
	public void excluirEstadoById(Long id) {
		estRep.deleteById(id);
	}
	
	public Collection<Municipio> findAllMunicipios(){
		return munRep.findAll();
	}
	
	public Municipio findMunicipioById(Long id){
		return munRep.findById(id).get();
	}
	
	public void saveMunicipio(Municipio municipio) {
		munRep.save(municipio);
	}
	
	public void excluirMunicipioById(Long id) {
		munRep.deleteById(id);
	}

	public Collection<Municipio> findMunicipioByNome(String nome){
		return munRep.findByNomeContainingIgnoreCase(nome);
	}
	
	public Collection<Bairro> findAllBairros(){
		return baiRep.findAll();
	}
	
	public Bairro findBairroById(Long id){
		return baiRep.findById(id).get();
	}
	
	public void saveBairro(Bairro bairro) {
		baiRep.save(bairro);
	}
	
	public void excluirBairroById(Long id) {
		baiRep.deleteById(id);
	}

	public Collection<Bairro> findBairroByNome(String nome){
		return baiRep.findByNomeContainingIgnoreCase(nome);
	}
	
	//Para pesquisas ajax utilizar apenas a pesquisa findById retorna
	//uma Collection com os objetos de tal forma que o json entra em um
	//loop em relações bidirecionais |estado( municipio( estado( municipio( ...))))|
	//Assim para quebrar o loop retorno um mapa apenas com o Id, para ser capaz de 
	//identificar o objeto, e o nome, para apresentar na tela.
	public Map<Long, String> findMunicipioAsMapPerEstado(Long id){
		Map<Long, String> response = new HashMap<Long,String>();
		List<Municipio> municipios = findEstadoById(id).getMunicipios();
		for(Municipio municipio : municipios) {
			response.put(municipio.getId(), municipio.getNome());
		}
		return response;
	}
	
	public Map<Long, String> findBairroAsMapPerMunicipio(Long id){
		Map<Long, String> response = new HashMap<Long,String>();
		List<Bairro> bairros = findMunicipioById(id).getBairros();
		for(Bairro bairro: bairros) {
			response.put(bairro.getId(), bairro.getNome());
		}
		return response;
	}
}
