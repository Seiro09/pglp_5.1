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

  /**
   * Itérateur de la classe Personne.
   *
   * @param p Le groupe a parcourir.
   * @param b Le parcours souhaité.
   */
  public PersonnelIterator(final Personne p, final boolean b) {
    this.parcours.add(Collections.singleton(p).iterator());
    this.parcoursProfondeur = b;
  }

  /**
   * Vérifie si le groupe est vide.
   *
   * @return Le retour de la vérification.
   */
  @Override
  public boolean hasNext() {
    return !(this.parcours.isEmpty());
  }

  /**
   * Récupère l'élément suivant du groupe selon le parcours.
   *
   * @return L'élément suivant.
   */
  @Override
  public Personne next() {
    Iterator<Personne> iterator = this.parcours.removeFirst();
    Personne p = iterator.next();
    if (iterator.hasNext()) {
      this.parcours.addFirst(iterator);
    }
    if (p instanceof PersonnelComposite) {
      if (!((PersonnelComposite) p).children.isEmpty()) {
        if (parcoursProfondeur) {
          this.parcours.addFirst(((PersonnelComposite) p).getChildrens());
        } else {
          this.parcours.addLast(((PersonnelComposite) p).getChildrens());
        }
      }
    }
    return p;
  }

}
