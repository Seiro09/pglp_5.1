package fr.uvsq21504875;

public class FactoryDAO {
  public static DAO<Personne> getPersonneDAO(){
    return new PersonneDAO();
  }
}
