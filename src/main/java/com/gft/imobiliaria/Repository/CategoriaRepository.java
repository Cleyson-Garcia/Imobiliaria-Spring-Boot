package com.gft.imobiliaria.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.imobiliaria.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public Collection<Categoria> findByNomeContainingIgnoreCase(String nome);
}
