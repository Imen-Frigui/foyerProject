package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface IEtudiant {
    public Etudiant addEtudiant(Etudiant E);
    public Etudiant updateEtudaint(Etudiant E);
    public List<Etudiant> getAllEtudiants();
    public Etudiant getById(long id);
    public void deleteEtudiant (long id);
    public Etudiant findEtudiantByNom(String nom);
    public List<Etudiant> findetudiantsStartsWith();
}
