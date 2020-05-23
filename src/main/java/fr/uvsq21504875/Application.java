package fr.uvsq21504875;

import java.time.LocalDateTime;

public enum Application {
  ENVIRONNEMENT;

  /**
   * Fonction contenant le code principal.
   *
   * @param args Les arguments entrés par l'utilisateur.
   */
  public void run(final String[] args) {
    Personnel personnel = new Personnel
        .Builder("Damien", "Damien",
            LocalDateTime.of(1997, 3, 16, 3, 14),
            "Directeur chez XXX")
        .numeros("Perso", "+33668168768")
        .build();

    //Ajouter informations pour le test du Composite
    PersonnelComposite group = new PersonnelComposite();
    group.add(personnel);
    //group.informations();
    //Test iterator
    PersonnelIterator pi = new PersonnelIterator(group, true);
    while (pi.hasNext()) {
      Personne p = pi.next();
      p.informations();
    }
  }

  /**
   * Fonction principale.
   *
   * @param args Les arguments entrés par l'utilisateur.
   */
  public static void main(final String[] args) {
    ENVIRONNEMENT.run(args);
  }
}
