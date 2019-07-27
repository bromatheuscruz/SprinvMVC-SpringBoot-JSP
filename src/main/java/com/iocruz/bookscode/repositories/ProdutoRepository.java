package com.iocruz.bookscode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iocruz.bookscode.models.*;
/**
 * ProdutoDAO
 */
@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}