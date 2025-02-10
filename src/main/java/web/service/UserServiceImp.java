package web.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDaoImp.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return userDaoImp.getUserById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDaoImp.addUser(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDaoImp.modifyUser(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaoImp.deleteUserById(id);
    }
}
