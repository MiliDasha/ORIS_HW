package app;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UsersService {
    private UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public int getCountFromDb() {
        try {
            return repository.getUsersCountLimit();
        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }
    }

    public void saveUsers(List<User> users) {
        try {
            repository.saveAll(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsersByEmail(String email) {
        try {
            return repository.findAllByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<User> getUsersByCity(String city) {
        try {
            return repository.findAllByCity(city);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<User> getUsersByPhone(String phone) {
        try {
            return repository.findAllByPhone(phone);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}