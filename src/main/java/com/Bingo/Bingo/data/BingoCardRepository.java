package com.Bingo.Bingo.data;

import com.Bingo.Bingo.models.BingoCard;
import org.springframework.data.repository.CrudRepository;

public interface BingoCardRepository extends CrudRepository <BingoCard, Integer> {
}
