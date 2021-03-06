package com.gft.imobiliaria.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gft.imobiliaria.Service.LocalService;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private LocalService localService;
	
	@RequestMapping(value= "/municipioEstado", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Map<Long, String> retornaMunicipios(Long idEstado) {
		//mapear id municipio e nomes
		return  localService.findMunicipioAsMapPerEstado(idEstado);
    }
	
	@RequestMapping(value= "/bairroMunicipio", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    public Map<Long, String> retornaBairros(Long idMunicipio) {
		//mapear id municipio e nomes
		return  localService.findBairroAsMapPerMunicipio(idMunicipio);
    }
}
