package fr.uvsq21504875;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonnelComposite implements Personne, Serializable {
  protected List<Personne> children = new ArrayList<>();

  @Override
  public void informations() {
    //for (Personne p : children){
    //  p.informations();
    //}
  }

  public void add(Personne p) {
    children.add(p);
  }

  public void remove(Personne p) {
    children.remove(p);
  }

  public Iterator<Personne> getChildrens() {
    return children.iterator();
  }

  public void serialize(String filename) {
    for (Personne p : children) {
      p.serialize(filename);
    }
  }

  @Override
  public void deserialize(String filename) {

  }
}