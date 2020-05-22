package fr.uvsq21504875;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PersonneDAOTest {
  @Test
  public void create() throws Exception {
    Personnel P = new Personnel
        .Builder("Damien1","Damien1",
        LocalDateTime.of(1997,3,16,3,14),
        "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();
    Personnel P2 = new Personnel
        .Builder("Damien2","Damien2",
        LocalDateTime.of(1997,3,16,3,14),
        "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();
    Personnel P3 = new Personnel
        .Builder("Damien3","Damien3",
        LocalDateTime.of(1997,3,16,3,14),
        "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();
    Personnel P4 = new Personnel
        .Builder("Damien4","Damien4",
        LocalDateTime.of(1997,3,16,3,14),
        "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();

    //Ajouter informations pour le test du Composite
    PersonnelComposite group = new PersonnelComposite();
    group.add(P);
    PersonnelComposite group2 = new PersonnelComposite();
    group2.add(P2);
    group2.add(P3);
    group.add(group2);
    group.add(P4);
    PersonneDAO dao=new PersonneDAO();
    dao.create(group,"FichierI");
  }

  @Test
  public void find() throws Exception {
    Personne p1 = FactoryDAO.getPersonneDAO().find("FichierI");
    PersonnelIterator pi = new PersonnelIterator(p1,true);
    while (pi.hasNext()){
      Personne p = pi.next();
      p.informations();
    }
  }


}