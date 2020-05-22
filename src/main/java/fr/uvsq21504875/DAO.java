package fr.uvsq21504875;

import java.sql.Connection;

public abstract class DAO<T> {

  public abstract T create(T obj,String filename);
  public abstract T find(String id);
  public abstract T update(T obj);
  public abstract void delete(T obj);
}
