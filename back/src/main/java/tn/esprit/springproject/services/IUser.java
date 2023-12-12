package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.User;

import java.util.List;

public interface IUser {
    public User addUser(User E);
    public User updateUser(User E);
    public List<User> getAllUsers();
    public User getById(long id);

    public void deleteUser (long id);
    public User findUserByNom(String nom);
    public List<User> findetudiantsStartsWith();
    public List<User> findByReservationList_EstValideTrue();
    public List<User> findAllByUniversity(String universityName);
}
