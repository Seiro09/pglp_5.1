package fr.uvsq21504875;

public interface Personne {
  void informations();
  void serialize(String filename);
  void deserialize(String filename);
}
