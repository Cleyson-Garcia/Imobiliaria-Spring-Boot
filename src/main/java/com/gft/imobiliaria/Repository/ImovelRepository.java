package com.gft.imobiliaria.Repository;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.gft.imobiliaria.Entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>,QueryByExampleExecutor<Imovel>{

	public Collection<Imovel> findByNegocioIdAndCategoriaIdAndQuartosIdAndValorBetween(
			Long idNegocio, Long idCategoria, Long idQuartos, BigDecimal valorMinimo,BigDecimal valorMaximo);
}
