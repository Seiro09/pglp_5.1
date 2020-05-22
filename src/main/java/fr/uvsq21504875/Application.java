package fr.uvsq21504875;

import java.time.LocalDateTime;

public enum Application {
  ENVIRONNEMENT;

  public void run(String [] args){
    Personnel P = new Personnel
        .Builder("Damien","Damien",
            LocalDateTime.of(1997,3,16,3,14),
            "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();

    //Ajouter informations pour le test du Composite
    PersonnelComposite group = new PersonnelComposite();
    group.add(P);
    //group.informations();
    //Test iterator
    PersonnelIterator pi = new PersonnelIterator(group,true);
    while (pi.hasNext()){
      Personne p = pi.next();
      p.informations();
    }
  }

  public static void main(String [] args){
    ENVIRONNEMENT.run(args);
  }
}
