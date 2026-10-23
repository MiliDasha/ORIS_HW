package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/select")
public class SelectUsersServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() {
        UsersRepository repo = new UsersRepositoryJdbcImpl(Database.getConnection());
        this.usersService = new UsersService(repo);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String field = req.getParameter("field");
        String value = req.getParameter("value");
        List<User> result = new ArrayList<>();

        if (field != null && value != null && !value.trim().isEmpty()) {
            if ("email".equals(field)) {
                result = usersService.getUsersByEmail(value.trim());
            } else if ("city".equals(field)) {
                result = usersService.getUsersByCity(value.trim());
            } else if ("phone".equals(field)) {
                result = usersService.getUsersByPhone(value.trim());
            }
        }

        req.setAttribute("users", result);
        req.getRequestDispatcher("/WEB-INF/select.jsp").forward(req, resp);
    }
}