package fr.uvsq21504875;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;

public class PersonnelIterator implements Iterator {
  /**
   * Queue pour permettre de parcourir le Composite de différentes manières.
   */
  private final Deque<Iterator<Personne>> parcours = new ArrayDeque<>();

  /**
   * Variable pour déterminer le parcours.
   */
  private final boolean parcoursProfondeur;

  public PersonnelIterator(Personne p, boolean b){
    this.parcours.add(Collections.singleton(p).iterator());
    this.parcoursProfondeur=b;
  }

  @Override
  public boolean hasNext() {
    return !(this.parcours.isEmpty());
  }

  @Override
  public Personne next() {
    Iterator<Personne> iterator = this.parcours.removeFirst();
    Personne p = iterator.next();
    if (iterator.hasNext()) this.parcours.addFirst(iterator);
    if (p instanceof PersonnelComposite){
      if (!((PersonnelComposite) p).children.isEmpty()){
        if (parcoursProfondeur){
          this.parcours.addFirst(((PersonnelComposite) p).getChildrens());
        }
        else{
          this.parcours.addLast(((PersonnelComposite) p).getChildrens());
        }
      }
    }
    return p;
  }

}
