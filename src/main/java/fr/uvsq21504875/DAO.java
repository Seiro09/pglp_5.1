package fr.uvsq21504875;

public abstract class DAO<T> {

  /**
   * Fonction de sauvegarde.
   *
   * @param obj L'objet à sauvegarder.
   * @param filename Le nom du fichier.
   * @return L'objet sauvegardé.
   */
  public abstract T create(T obj, String filename);

  /**
   * Fonction de chargement.
   *
   * @param id Le nom du fichier à charger.
   * @return Les données du fichier.
   */
  public abstract T find(String id);

  /**
   * Fonction de mise à jour du fichier non implémentée.
   *
   * @param obj L'objet à mettre à jour.
   * @return L'objet mis à jour.
   */
  public abstract T update(T obj);

  /**
   * Fonction de suppression du fichier.
   *
   * @param obj L'objet à supprimer.
   */
  public abstract void delete(T obj);
}
