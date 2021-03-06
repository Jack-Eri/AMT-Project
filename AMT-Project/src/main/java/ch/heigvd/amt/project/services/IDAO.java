package ch.heigvd.amt.project.services;


import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.utils.Pagination;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<PK, E> {
  List<E> findAll(Pagination pagination);
  E create(E entity) throws SQLException;
  E findById(PK id) throws KeyNotFoundException;
  void update(E entity) throws KeyNotFoundException;
  void deleteById(PK id) throws KeyNotFoundException;
}
