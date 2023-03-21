package ra.controler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Catalog;
import ra.model.entity.Color;
import ra.model.entity.Size;
import ra.model.sevices.CatalogSevices;
import ra.model.sevices.ProductSevices;
import ra.model.sevices.SizeServices;
import ra.model.sevicesImp.CatalogSevicesImp;
import ra.model.sevicesImp.ProductSevicesImp;
import ra.model.sevicesImp.SizeServicesImp;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private static final Gson gSon = new GsonBuilder().create();
    CatalogSevices catalogSevices = new CatalogSevicesImp();
    ProductSevices productSevices = new ProductSevicesImp();
    SizeServices sizeServices = new SizeServicesImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
       if (action!=null && action.equals("GetSizeById")){
            int catalogParentId =Integer.parseInt(request.getParameter("catalogParentId")) ;
            Gson gsons = new Gson();
            List<Size> listSize = catalogSevices.getSizeByCatalogId(catalogParentId);
            PrintWriter out = response.getWriter();
            out.print(gsons.toJson(listSize));
            out.flush();
            out.close();

        } else if (action != null && action.equals("createProduct")) {

            List<Catalog> listCatalog = catalogSevices.getAll();
            List<Catalog> listCatalogRoot = catalogSevices.getByParentId(0);
            List<Color> listColor = productSevices.getAllColor();
            request.setAttribute("listColor",listColor);
            request.setAttribute("listCatalog",listCatalog);
            request.setAttribute("listCatalogRoot",listCatalogRoot);
            request.getRequestDispatcher("views/createProduct.jsp").forward(request,response);
        }else if (action!=null && action.equals("getChildCatalog")){
           int catalogParentId =Integer.parseInt(request.getParameter("catalogParentId")) ;
           Gson gsons = new Gson();
           List<Catalog> listCatalog = catalogSevices.getByParentId(catalogParentId);
           PrintWriter out = response.getWriter();
           out.print(gsons.toJson(listCatalog));
           out.flush();
           out.close();
       }
//       else if (action.equalsIgnoreCase("getSize")) {
//           String []  myData = request.getParameterValues("size");
//           String [] data = new String[30];
//           List<Integer> listInt = new ArrayList<>();
//           for (String str :myData) {
//               data = str.split(",");
//           }
//           for (String str :data) {
//               listInt.add(Integer.parseInt(str));
//           }
//           List<Size> listSize = sizeServices.getListSize(listInt);
//           Gson gsons = new Gson();
//           PrintWriter out = response.getWriter();
//           out.print(gsons.toJson(listSize));
//           out.flush();
//           out.close();
//       }else if (action.equalsIgnoreCase("getColor")){
//           String []  myData = request.getParameterValues("color");
//           String [] data = new String[20];
//           List<Integer> listInt = new ArrayList<>();
//           for (String str :myData) {
//               data = str.split(",");
//           }
//           for (String str :data) {
//               listInt.add(Integer.parseInt(str));
//           }
//           List<Color> listColor = sizeServices.getListColor(listInt);
//           Gson gsons = new Gson();
//           PrintWriter out = response.getWriter();
//           out.print(gsons.toJson(listColor));
//           out.flush();
//           out.close();
//       }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
