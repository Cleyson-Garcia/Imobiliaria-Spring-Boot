package com.gft.imobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.gft.imobiliaria.Entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>,QueryByExampleExecutor<Imovel>{

}
