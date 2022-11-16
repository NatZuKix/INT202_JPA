package int202.classsicmodels.servlet;

import int202.classsicmodels.repo.OfficeRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/office-list")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepo officeRepository = new OfficeRepo();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }
        getServletContext().getRequestDispatcher("/OfficeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
