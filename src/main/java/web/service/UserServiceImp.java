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
    @Transactional
    public List<User> index() {
        return userDaoImp.index();
    }

    @Override
    @Transactional
    public User show(int id) {
        return userDaoImp.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDaoImp.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDaoImp.update(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaoImp.delete(id);
    }
}
