package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getUsersCountLimit() throws SQLException {
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT val FROM settings WHERE key = 'users_count'")) {
            if (rs.next()) {
                return rs.getInt("val");
            }
        }
        return 3;
    }

    @Override
    public void saveAll(List<User> users) throws SQLException {
        if (users == null || users.isEmpty()) return;

        StringJoiner values = new StringJoiner(", ");
        for (User u : users) {
            values.add(String.format("('%s', '%s', %d, '%s', '%s', '%s')",
                    u.getName(), u.getSurname(), u.getAge(),
                    u.getEmail(), u.getCity(), u.getPhone()));
        }

        String sql = "INSERT INTO drivers (first_name, last_name, age, email, city, phone) VALUES " + values;
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(sql);
        }
    }

    @Override
    public List<User> findAllByEmail(String email) throws SQLException {
        return findByCondition("email = '" + email + "'");
    }

    @Override
    public List<User> findAllByCity(String city) throws SQLException {
        return findByCondition("city = '" + city + "'");
    }

    @Override
    public List<User> findAllByPhone(String phone) throws SQLException {
        return findByCondition("phone = '" + phone + "'");
    }

    private List<User> findByCondition(String condition) throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, age, email, city, phone FROM drivers WHERE " + condition;
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new User(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("city"),
                        rs.getString("phone")
                ));
            }
        }
        return list;
    }
}