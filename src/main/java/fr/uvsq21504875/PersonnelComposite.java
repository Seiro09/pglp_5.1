package fr.uvsq21504875;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonnelComposite implements Personne, Serializable {
  protected List<Personne> children = new ArrayList<>();

  /**
   * Fonction d'inforamations de la liste (non implémentée).
   */
  @Override
  public void informations() {
    //for (Personne p : children){
    //  p.informations();
    //}
  }

  /**
   * Fonction d'ajout dans la liste.
   *
   * @param p L'objet à ajouter.
   */
  public void add(final Personne p) {
    children.add(p);
  }

  /**
   * Fonction de suppression dans la liste.
   *
   * @param p L'objet à supprimer.
   */
  public void remove(final Personne p) {
    children.remove(p);
  }

  /**
   * Itérateur sur le premier élément de la liste.
   *
   * @return L'itérateur.
   */
  public Iterator<Personne> getChildrens() {
    return children.iterator();
  }

  /**
   * Fontion de sérialisation.
   *
   * @param filename Le fichier de sauvegarde.
   */
  public void serialize(final String filename) {
    for (Personne p : children) {
      p.serialize(filename);
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