package com.gft.imobiliaria.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.imobiliaria.Entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	public Collection<Estado> findByNomeContainingIgnoreCase(String nome);
}
