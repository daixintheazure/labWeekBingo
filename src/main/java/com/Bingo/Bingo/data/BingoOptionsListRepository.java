package com.Bingo.Bingo.data;

import com.Bingo.Bingo.models.BingoOptionsList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoOptionsListRepository extends CrudRepository<BingoOptionsList, Integer> {
}
