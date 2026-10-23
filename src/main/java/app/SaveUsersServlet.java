package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/save")
public class SaveUsersServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() {
        UsersRepository repo = new UsersRepositoryJdbcImpl(Database.getConnection());
        this.usersService = new UsersService(repo);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = usersService.getCountFromDb();
        req.setAttribute("count", count);
        req.getRequestDispatcher("/WEB-INF/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        int count = Integer.parseInt(req.getParameter("count"));
        List<User> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new User(
                    req.getParameter("name_" + i),
                    req.getParameter("surname_" + i),
                    Integer.parseInt(req.getParameter("age_" + i)),
                    req.getParameter("email_" + i),
                    req.getParameter("city_" + i),
                    req.getParameter("phone_" + i)
            ));
        }

        usersService.saveUsers(list);
        resp.sendRedirect(req.getContextPath() + "/success.html");
    }
}