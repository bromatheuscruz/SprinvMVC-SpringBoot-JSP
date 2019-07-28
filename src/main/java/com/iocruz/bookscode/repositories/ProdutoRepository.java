package com.iocruz.bookscode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.iocruz.bookscode.models.*;
/**
 * ProdutoDAO
 */
@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p INNER JOIN FETCH p.precos WHERE p.id = :id")
    Optional<Produto> findById(@Param("id") Integer id);

}