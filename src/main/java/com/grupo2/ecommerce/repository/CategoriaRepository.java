package com.grupo2.ecommerce.repository;


import com.grupo2.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	


	}