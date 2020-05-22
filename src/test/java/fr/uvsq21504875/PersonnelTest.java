package fr.uvsq21504875;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PersonnelTest {

  @Test
  public void informations() throws Exception {
    Personnel P = new Personnel
        .Builder("Damien","Damien",
        LocalDateTime.of(1997,3,16,3,14),
        "Directeur chez XXX")
        .numeros("Perso","+33668168768")
        .build();
    P.informations();
  }

}