package com.grupo2.ecommerce.repository;


import com.grupo2.ecommerce.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public boolean existsByDescricao(String descricao);
    
}


	


