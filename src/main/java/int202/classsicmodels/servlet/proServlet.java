package int202.classsicmodels.servlet;

import int202.classsicmodels.entities.Product;
import int202.classsicmodels.repo.ProductRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "proServlet", value = "/proServlet")
public class proServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepo productRepository = new ProductRepo();
        String pageParam = request.getParameter("page");
        String pageSizeParam = request.getParameter("pageSize");
        int page = pageParam == null ? 1 : Integer.valueOf(pageParam);
        int pageSize = pageSizeParam == null ? ProductRepo.getPageSize() : Integer.valueOf(pageSizeParam);
        List<Product> productList = productRepository.findAll(page, pageSize);
        request.setAttribute("products", productList);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("itemCount", ProductRepo.CountALL());
        getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
