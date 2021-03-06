package com.gft.imobiliaria.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gft.imobiliaria.Entity.Imovel;
import com.gft.imobiliaria.Service.ClassificadorService;
import com.gft.imobiliaria.Service.ImovelService;
import com.gft.imobiliaria.Service.LocalService;


@Controller
@RequestMapping("/user/imovel")
public class ImovelUserController {

	@Autowired
	private ImovelService iServ;
	
	@Autowired
	private LocalService lServ;
	
	@Autowired
	private ClassificadorService cServ;
	
	@GetMapping("/todos")
	public ModelAndView mostrarImoveis() {
		ModelAndView mv = new ModelAndView("imovelUser/imoveis");
		mv.addObject("imoveis",iServ.findAllImoveis());
		return mv;
	}
	
	@GetMapping("/pesquisar")
	public ModelAndView pesquisarImovel() {
		ModelAndView mv = new ModelAndView("imovelUser/imovelPesquisar");
		addObj(mv);
		mv.addObject("imovel",new Imovel());
		return mv;
	}
	
	@GetMapping("/pesquisarResultado")
	public ModelAndView pesquisaRealizadaImovel(Imovel imovel, Long idEstado, Long idMunicipio,
			BigDecimal valorMinimo, BigDecimal valorMaximo) {
		ModelAndView mv = new ModelAndView("imovelUser/imovelPesquisar");
		addObj(mv);
		mv.addObject("idEstado",idEstado);			
		mv.addObject("idMunicipio",idMunicipio);
		mv.addObject("valorMinimo",valorMinimo);
		mv.addObject("valorMaximo",valorMaximo);
		
		if(idEstado!=null) {
			mv.addObject("municipios",lServ.findEstadoById(idEstado).getMunicipios());
		}
		if(idMunicipio!=null) {
			mv.addObject("bairros",lServ.findMunicipioById(idMunicipio).getBairros());
		}
		mv.addObject("imovel",imovel);
		mv.addObject("imoveis",iServ.findImovelByExample(imovel, idMunicipio, idEstado,valorMinimo,valorMaximo));
		return mv;
	}
	
	@GetMapping("/visualizar/{id}")
	public ModelAndView visualizarImovel(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("imovelUser/imovelVisualizar");
		mv.addObject("imovel",iServ.findImovelById(id));
		return mv;
	}
		
	private void addObj(ModelAndView mv) {
		mv.addObject("negocios", cServ.findAllNegocio());
		mv.addObject("categorias",cServ.findAllCategoria());
		mv.addObject("quartos",cServ.findAllQuartos());
		mv.addObject("estados",lServ.findAllEstados());
		mv.addObject("municipios",lServ.findAllMunicipios());
		mv.addObject("bairros",lServ.findAllBairros());
	}
}
