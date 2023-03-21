package ra.controler;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import ra.model.entity.DisplayProduct;
import ra.model.entity.User;
import ra.model.sevices.ProductSevices;
import ra.model.sevices.SizeServices;
import ra.model.sevices.UserSevices;
import ra.model.sevicesImp.ProductSevicesImp;
import ra.model.sevicesImp.SizeServicesImp;
import ra.model.sevicesImp.UserSevicesImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
     private static  UserSevices userSevices = new UserSevicesImp();
    private static ProductSevices productSevices = new ProductSevicesImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("register")) {
            User user = new User();
            user.setUserName(request.getParameter("userName"));
            user.setPasswood(request.getParameter("passwood"));
            user.setFullName(request.getParameter("fullname"));
            user.setAddress(request.getParameter("address"));
            user.setSex(Integer.parseInt(request.getParameter("sex")));
            user.setPhoneNumber(request.getParameter("phoneNumber"));
            user.setEmail(request.getParameter("email"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthOfDate(sdf.parse(request.getParameter("birthOfDate")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            boolean check = userSevices.insert(user);
            if (check) {
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("views/ERROR.jsp").forward(request, response);
            }

        }else if (action.equals("login")){

            String userName = request.getParameter("userName");
            String passwood = request.getParameter("passwood");
            User user = userSevices.login(userName,passwood);
            if (user!=null){
                HttpSession session = request.getSession();
                User userLogin = (User) session.getAttribute("userLogin");
                if (userLogin==null){
                    userLogin = user;
                    session.setAttribute("userLogin",userLogin);
                    String pageRequest = request.getParameter("pageRequestLogin");
                     if (pageRequest.equals("singer")){
                        String proId = request.getParameter("productId");
                        response.sendRedirect(" ProductServlet?action=singerProduct&&proId="+proId);
                    }else {
                         List<DisplayProduct> listProduct = productSevices.displayWebProduct();
                         List<DisplayProduct> listNewProduct = productSevices.displayNewProducts();
                         request.setAttribute("listNewProduct",listNewProduct);
                         request.setAttribute("listProduct",listProduct);
                         request.getRequestDispatcher("views/home.jsp").forward(request,response);
                     }
                }
            }else {
                request.getRequestDispatcher("views/login.jsp").forward(request,response);
            }
        }
    }
}
