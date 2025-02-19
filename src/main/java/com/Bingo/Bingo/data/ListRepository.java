package com.Bingo.Bingo.data;

import com.Bingo.Bingo.models.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<List, Integer> {
}
