package bpos.Repository;

import bpos.Domain.Entity;

import java.util.Optional;

public interface IRepository<ID, E extends Entity<ID>> {
    Optional<E> findOne(ID id);
    Iterable<E> findAll();
    Optional<E> save(E entity);
    Optional<E> delete(E entity);
    Optional<E> update(E entity);
}