package fr.uvsq21504875;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Personnel implements Personne, Serializable {

  /**
   * Nom du Personnel.
   */
  private final String nom;
  /**
   * Prénom du personnel.
   */
  private final String prenom;
  /**
   * Date de naissance du Personnel.
   */
  private final LocalDateTime date;
  /**
   * Numéros de téléphone du Personnel.
   */
  private final HashMap<String, String> numeros;
  /**
   * Fonctions du Personnel.
   */
  private final String fonctions;

  public static class Builder {
    /**
     * Nom du Personnel du Builder.
     */
    private final String nom;
    /**
     * Prénom du Personnel du Builder.
     */
    private final String prenom;
    /**
     * Date de naissance du Personnel du Builder.
     */
    private final LocalDateTime date;
    /**
     * Fonctions du Personnel du Builder.
     */
    private final String fonctions;

    /**
     * Numéros du Personnel du Builder.
     */
    private final HashMap<String, String> numeros = new HashMap<>();

    /**
     * Création du Personnel à partir du pattern Builder.
     *
     * @param nom Nom du Personnel.
     * @param prenom Prénom du Personnel.
     * @param date Date de naissance du Personnel.
     * @param fonctions Fonctions du Personnel.
     */
    public Builder(final String nom, final String prenom,
                   final LocalDateTime date, final String fonctions) {
      this.nom = nom;
      this.prenom = prenom;
      this.date = date;
      this.fonctions = fonctions;
    }

    /**
     * Fonction optionnelle d'ajout de numéro.
     *
     * @param key Le type de numéro.
     * @param numero Le numéro.
     * @return Le builder avec le numéro ajouté.
     */
    public Builder numeros(final String key, final String numero) {
      this.numeros.put(key, numero);
      return this;
    }

    /**
     * Fonction de cration d'un Personnel à partir d'un Builder.
     *
     * @return Le Personnel créé.
     */
    public Personnel build() {
      return new Personnel(this);
    }
  }

  protected Personnel(final Builder builder) {
    nom = builder.nom;
    prenom = builder.prenom;

    date = builder.date;
    numeros = builder.numeros;
    fonctions = builder.fonctions;
  }

  /**
   * Fonction d'affichage des informations du Personnel.
   */
  @Override
  public void informations() {
    System.out.println("[Nom : " +  this.nom);
    System.out.println(" Prenom : " +  this.prenom);
    System.out.println(" Date : " +  this.date);
    System.out.println(" Fonctions : " +  this.fonctions);
    for (Map.Entry<String, String> e : numeros.entrySet()) {
      System.out.println("Numero " + e.getKey() + " : " + e.getValue());
    }
    System.out.println("]");
  }

  /**
   * Fonction de sérialisation.
   *
   * @param filename Le fichier de sauvegarde.
   */
  public void serialize(final String filename) {
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(this);

      out.close();
      file.close();
    } catch (IOException e) {
      System.out.println("Exception lors de la serialisation");
      e.printStackTrace();
    }

  }

  /**
   * Fonction de désérialisation.
   *
   * @param filename Le fichier de chargement.
   */
  @Override
  public void deserialize(final String filename) {

  }
}
