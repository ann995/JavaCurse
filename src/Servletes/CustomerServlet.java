package Servletes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customers.add(new Customer(1, "Jan", "Kowalski", 1992));
        customers.add(new Customer(2, "Tomasz", "Nowak", 1997));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String allCustomers = customers.stream().map(c -> "Klient " + c + "; ").collect(Collectors.joining());

        String name = req.getParameter("name");

        Customer customer = customers.stream().filter(c -> c.getName().equals(name)).findAny().orElse(null);

        if (customer != null) {
            resp.getWriter().write(String.valueOf(customer));
        } else {
            resp.getWriter().write(allCustomers);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int id = Integer.parseInt(req.getParameter("id"));
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));

        customers.add(new Customer(id, name, surname, birthYear));
        resp.getWriter().write("Customer has been added");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int id = Integer.parseInt(req.getParameter("id"));
        int birthYear = Integer.parseInt(req.getParameter("birthYear"));

        Customer customer = customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (customer != null) {
            customer.setName(name);
            customer.setSurname(surname);
            customer.setBirthYear(birthYear);
            resp.getWriter().write("Customer has been updated");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("Customer with specified id " + id + " doesn't exist");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (customer != null) {
            customers.remove(customer);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("Customer has been deleted");
        } else {
            resp.getWriter().write("Customer with specified id " + id + " doesn't exist");
        }
    }
}
