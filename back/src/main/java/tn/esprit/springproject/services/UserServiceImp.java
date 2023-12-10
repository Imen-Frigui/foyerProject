package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.dtos.CredentialsDto;
import tn.esprit.springproject.dtos.SignUpDto;
import tn.esprit.springproject.dtos.UserDto;
import tn.esprit.springproject.entities.Role;
import tn.esprit.springproject.entities.User;
import tn.esprit.springproject.exceptions.AppException;
import tn.esprit.springproject.mapper.UserMapper;
import tn.esprit.springproject.repositories.UserRepository;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service("UserServiceImp")
@AllArgsConstructor
public class UserServiceImp implements IUser {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;
    @Override
    public User addUser(User E) {
        return userRepository.save(E);
    }

    @Override
    public User updateUser(User u) {
        User trueUser = userRepository.findById(u.getIdUser()).orElse(null);
        if (!trueUser.getNom().equals(u.getNom()))
            trueUser.setNom(u.getNom());
        if (!trueUser.getPrenom().equals(u.getPrenom()))
            trueUser.setPrenom(u.getPrenom());
        if (!trueUser.getDateNaissance().equals(u.getDateNaissance()))
            trueUser.setDateNaissance(u.getDateNaissance());
        if (!trueUser.getEcole().equals(u.getEcole()))
            trueUser.setEcole(u.getEcole());
        if (!u.getMotDePasse().equals(""))
            trueUser.setMotDePasse(passwordEncoder.encode(u.getMotDePasse()));
        if (!trueUser.getEmail().equals(u.getEmail()))
            trueUser.setEmail(u.getEmail());
        return userRepository.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    @Override
    public List<User> findetudiantsStartsWith() {
        String nom = "AB";
        return userRepository.findByNomStartingWith(nom);
    }

    @Override
    public List<User> findByReservationList_EstValideTrue(){
        return userRepository.findByReservationList_EstValideTrue();
    }

    @Override
    public List<User> findAllByUniversity(String universityName) {
        return userRepository.findAllByUniversity(universityName);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByEmail(credentialsDto.email())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.motDePasse()), user.getMotDePasse())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto ) {
        Optional<User> optionalUser = userRepository.findByEmail(signUpDto.email());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDto);

        user.setMotDePasse(passwordEncoder.encode(CharBuffer.wrap(signUpDto.motDePasse())));
        user.setRole(Role.ETUDIANT);

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

}
