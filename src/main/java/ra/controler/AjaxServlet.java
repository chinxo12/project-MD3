package ra.controler;

import com.google.gson.Gson;
import ra.model.entity.Product;
import ra.model.entity.ProductDetail;
import ra.model.sevices.ProductSevices;
import ra.model.sevicesImp.ProductSevicesImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    ProductSevices productSevices = new ProductSevicesImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("editPrice")) {
            int proId = Integer.parseInt(request.getParameter("productId"));
            Product product = (Product) productSevices.getById(proId);
            List<ProductDetail> listProductDetail = productSevices.getProductDetailForAdmin(proId);
            PrintWriter out = response.getWriter();
            for (ProductDetail pro : listProductDetail) {
                out.println("   <div>"
                        + "                        <h4>" + product.getProductName() + "</h4>"
                        + "                    </div>"
                        + "                    <div id=\"priceUpdate\">"
                        + "   <table class=\"table\">" +
                        "           <tr>"
                        + "                 <th> Phân loại hàng</th>"
                        + "                 <th>Giá</th>  "
                        + "            </tr> "
                        + "             <tr>"
                        + "                  <td>" + pro.getSize().getSizeName() + ',' + pro.getColor().getColorName()
                        + "                   <input type=\"hidden\" value=" + pro.getProductDetailId() + " name=\"detailIdPrin\">"
                        + "</td> "
                        + "                  <td><input style=\"width: 100px\" type=\"number\" name=\"price\"value=" + pro.getPrice() + "  class=\"form-control\"></td>"
                        + "            </tr>"
                        + "        </table>    "
                        + "      </div>"

                );
            }
        } else if (action.equalsIgnoreCase("editQuantity")) {
            int proId = Integer.parseInt(request.getParameter("productId"));
            Product product = (Product) productSevices.getById(proId);
            List<ProductDetail> listProductDetail = productSevices.getProductDetailForAdmin(proId);
            PrintWriter out = response.getWriter();
            for (ProductDetail pro : listProductDetail) {
                out.println("   <div>"
                        + "                        <h4>" + product.getProductName() + "</h4>"
                        + "                    </div>"
                        + "                    <div id=\"priceUpdate\">"
                        + "   <table class=\"table\">" +
                        "           <tr>"
                        + "                 <th> Phân loại hàng</th>"
                        + "                 <th>Số lượng còn lại</th>  "
                        + "            </tr> "
                        + "             <tr>"
                        + "                  <td>" + pro.getSize().getSizeName() + ',' + pro.getColor().getColorName()
                        + "                   <input type=\"hidden\" value=" + pro.getProductDetailId() + " name=\"detailIdQuant\">"
                        + "</td> "
                        + "                  <td><input style=\"width: 100px\" type=\"number\" name=\"quantity\"value=" + pro.getQuantity() + "  class=\"form-control\"></td>"
                        + "            </tr>"
                        + "        </table>    "
                        + "      </div>"

                );
            }
        } else if (action.equalsIgnoreCase("getSize")) {
            int proId = Integer.parseInt(request.getParameter("productId")) ;
            int colorId = Integer.parseInt(request.getParameter("colorId"));
            List<ProductDetail> list = productSevices.getProductDetailForAdmin(proId);
            PrintWriter out = response.getWriter();
            for (ProductDetail pro:list) {
                if (pro.getColor().getColorId()==colorId){
                    out.println("<button type=\"button\" class=\"btn btn-outline-success\" id=\"productDetail\"  value="+pro.getProductDetailId() +" >"+pro.getSize().getSizeName()+"</button>"
                    );
                }
            }
        } else if (action.equalsIgnoreCase("getPrice")) {
            int proId =Integer.parseInt(request.getParameter("productDetailId")) ;
            ProductDetail productDetail = productSevices.getProductDetailById(proId);
            PrintWriter out = response.getWriter();
            out.println("  <div id=\"displayPrice\" class=\"product_price\">" +
                    productDetail.getPrice() + "<sup>đ</sup>"
                    + "<input type=\"hidden\" value=" + productDetail.getProductDetailId() + " name=\"productDetail\">"
                    + "</div>"
            );
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
