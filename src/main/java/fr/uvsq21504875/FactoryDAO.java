package fr.uvsq21504875;

public final class FactoryDAO {

  /**
   * Constructeur privé de la Fabrique.
   */
  private FactoryDAO() {

  }

  /**
   * Fonction de construction d'un DAO de type Personne.
   *
   * @return Le DAO Personne créé.
   */
  public static DAO<Personne> getPersonneDAO() {
    return new PersonneDAO();
  }
}
