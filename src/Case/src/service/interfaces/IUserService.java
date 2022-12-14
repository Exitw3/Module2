package service.interfaces;

import model.Role;
import utils.TypeSort;
import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User login(String userName, String passWord, Role role);

    void add(User newUser);

    void update(User newUser);

    void deleteById(long id);

    User findById(long id);

    boolean existsByUserName(String userName);

    boolean existById(long id);

    List<User> sortById(TypeSort type);

    List<User> sortByUserName(TypeSort type);

    List<User> sortByFullName(TypeSort type);

    List<User> sortByEmail(TypeSort type);

    List<User> sortByPhone(TypeSort type);

    List<User> sortByRole(TypeSort type);

    List<User> sortByAddress(TypeSort type);

    List<User> findByUserName(String value);

    List<User> findByFullName(String value);

    List<User> findByEmail(String value);

    List<User> findByPhone(String value);

    List<User> findByAddress(String value);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    String findNameById(long id);
}
