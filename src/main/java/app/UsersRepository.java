package app;

import java.sql.SQLException;
import java.util.List;

public interface UsersRepository {
    int getUsersCountLimit() throws SQLException;
    void saveAll(List<User> users) throws SQLException;

    // 3 метода выборки с условием WHERE
    List<User> findAllByEmail(String email) throws SQLException;
    List<User> findAllByCity(String city) throws SQLException;
    List<User> findAllByPhone(String phone) throws SQLException;
}