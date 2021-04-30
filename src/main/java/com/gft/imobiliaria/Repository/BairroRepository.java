package com.gft.imobiliaria.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.imobiliaria.Entity.Bairro;
@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long>{

	public Collection<Bairro> findByNomeContainingIgnoreCase(String nome);
}
