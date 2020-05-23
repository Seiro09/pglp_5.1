package fr.uvsq21504875;


import java.io.*;
import java.util.ArrayList;

public class PersonneDAO extends DAO<Personne>{
  /**
   * Sauvegarder l'objet dans un fichier.
   *
   * @param obj      L'objet à sauvegarder.
   * @param filename Le nom du fichier.
   * @return
   */
  @Override
  public Personne create(final Personne obj, final String filename) {
    ArrayList<Personne> personnes = new ArrayList<>();
    if (obj instanceof PersonnelComposite) {
      for (Personne p : ((PersonnelComposite) obj).children) {
        personnes.add(p);
      }
    } else {
      personnes.add(obj);
    }
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(personnes);

      out.close();
      file.close();
    } catch (IOException e) {
      System.out.println("Exception lors de la serialisation");
      e.printStackTrace();
    }
    return obj;
  }

  /**
   * Fonction de chargement.
   *
   * @param filename Fichier de chargement.
   * @return LE fichier chargé dans une liste.
   */
  @Override
  public Personne find(final String filename) {
    ArrayList<Personne> list;
    PersonnelComposite pc = new PersonnelComposite();
    try {
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);

      list = (ArrayList<Personne>)ois.readObject();
      pc.children.addAll(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pc;
  }

  /**
   * Fonction de mise à jour non implémentée.
   *
   * @param obj L'objet à mettre à jour.
   * @return L'objet mis à jour.
   */
  @Override
  public Personne update(final Personne obj) {
    return null;
  }

  /**
   * Fonction de suppression non implémentée.
   *
   * @param obj L'objet à supprimer.
   */
  @Override
  public void delete(final Personne obj) {

  }
}
