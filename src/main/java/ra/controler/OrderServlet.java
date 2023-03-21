package ra.controler;

import ra.model.entity.Cart;
import ra.model.entity.CartProduct;
import ra.model.entity.ProductDetail;
import ra.model.entity.User;
import ra.model.sevices.CartSevices;
import ra.model.sevices.ProductSevices;
import ra.model.sevicesImp.CartServicesImp;
import ra.model.sevicesImp.ProductSevicesImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static ProductSevices productSevices = new ProductSevicesImp();
    private static CartSevices cartSevices = new CartServicesImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("getAllCart")) {
            getAllCart(request, response);
        }

    }

    private static void getAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userLogin");
        if (user != null) {
            List<Cart> listCart = cartSevices.getAllCart(user);
            request.setAttribute("listCart", listCart);
            request.getRequestDispatcher("views/cart.jsp").forward(request, response);
        } else {
            String pageRequestLogin = "home";
            String productId = "0";
            request.setAttribute("productId", productId);
            request.setAttribute("pageRequestLogin", pageRequestLogin);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("addToCart")) {

            User user = (User) request.getSession().getAttribute("userLogin");
            if (user != null) {
                int proDetailId = Integer.parseInt(request.getParameter("productDetail"));
                ProductDetail productDetail = productSevices.getProductDetailById(proDetailId);
                String part = request.getParameter("requestURI");
                Cart cart = new Cart();
                cart.setUser(user);
                CartProduct cartProduct = new CartProduct();
                cartProduct.setProductDetail(productDetail);
                cart.setCartProduct(cartProduct);
                cart.setQuantity(1);
                boolean check = cartSevices.insert(cart);
                if (check) {
                    response.sendRedirect("ProductServlet?action=main");
                } else {
                    request.getRequestDispatcher("views/ERROR.jsp").forward(request, response);
                }
            } else {
                String pageRequestLogin = request.getParameter("productId");
                String login = "singer";
                request.setAttribute("productId", pageRequestLogin);
                request.setAttribute("pageRequestLogin", login);
                request.getRequestDispatcher("views/login.jsp").forward(request, response);
            }

        } else if (action.equals("pays")) {
            String[] cartId = request.getParameterValues("cartId");
            User user = (User) request.getSession().getAttribute("userLogin");
            List<Cart> listCart = cartSevices.getAllCart(user);
            request.setAttribute("listCart", listCart);
            request.getRequestDispatcher("views/cart.jsp").forward(request, response);
            String[] quantity = request.getParameterValues("quantity");
            List<Cart> paysCart = new ArrayList<>();
            for (Cart cart : listCart) {
                for (int i = 0; i < cartId.length; i++) {
                    if (cart.getCartId()==Integer.parseInt(cartId[i])){
                        cart.setQuantity(Integer.parseInt(quantity[i]));
                        paysCart.add(cart);
                    }
                }
            }

        }
    }
}
