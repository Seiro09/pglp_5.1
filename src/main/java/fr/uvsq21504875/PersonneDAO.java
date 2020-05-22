package fr.uvsq21504875;

import java.io.*;
import java.util.ArrayList;

public class PersonneDAO extends DAO<Personne>{
  @Override
  public Personne create(Personne obj, String filename) {
    ArrayList<Personne> personnes = new ArrayList<>();
    if (obj instanceof PersonnelComposite){
      for (Personne p : ((PersonnelComposite) obj).children){
        personnes.add(p);
      }
    }
    else personnes.add(obj);
    try{
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(personnes);

      out.close();
      file.close();
    }
    catch (IOException e){
      System.out.println("Exception lors de la serialisation");
      e.printStackTrace();
    }
    return obj;
  }

  @Override
  public Personne find(String filename) {
    ArrayList<Personne> list = new ArrayList<>();
    PersonnelComposite pc = new PersonnelComposite();
    try {
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);

      list=(ArrayList<Personne>)ois.readObject();
      pc.children.addAll(list);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pc;
  }

  @Override
  public Personne update(Personne obj) {
    return null;
  }

  @Override
  public void delete(Personne obj) {

  }
}
