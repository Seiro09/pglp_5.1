package fr.uvsq21504875;

public interface Personne {
  /**
   * Fonction de récupération d'informations d'un type Personne.
   */
  void informations();

  /**
   * Fonction de sérialisation.
   *
   * @param filename Le fichier de sauvegarde.
   */
  void serialize(String filename);

  /**
   * Fonction de déserialisation.
   *
   * @param filename Le fichier de chargement.
   */
  void deserialize(String filename);
}
