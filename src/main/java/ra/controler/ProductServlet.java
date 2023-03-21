package ra.controler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.*;
import ra.model.sevices.CatalogSevices;
import ra.model.sevices.ProductSevices;
import ra.model.sevices.SizeServices;
import ra.model.sevicesImp.CatalogSevicesImp;
import ra.model.sevicesImp.ProductSevicesImp;
import ra.model.sevicesImp.SizeServicesImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.File;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold =  1024 * 1024 * 1 ,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private static ProductSevices productSevices = new ProductSevicesImp();
    private static CatalogSevices catalogSevices = new CatalogSevicesImp();
    private static SizeServices sizeServices = new SizeServicesImp();

    public static void getAllProduct(){
//        List<Product> listProduct =

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("getAllProduct")){
           getAll(request,response);
        } else if (action.equalsIgnoreCase("deleteProductDetail")) {
            int proId = Integer.parseInt(request.getParameter("deleteProDetailId"));
            boolean checkExit = productSevices.deleteProductDetail(proId);
            if (checkExit){
                getAll(request,response);
            }
        } else if (action.equalsIgnoreCase("update")) {
            int proId = Integer.parseInt( request.getParameter("proId"));
            Product product = (Product) productSevices.getById(proId);
            request.setAttribute("product",product);
            request.getRequestDispatcher("views/updateProduct.jsp");
        } else if (action.equalsIgnoreCase("home")) {
            List<DisplayProduct> listProduct = productSevices.displayWebProduct();
            List<DisplayProduct> listNewProduct = productSevices.displayNewProducts();
            request.setAttribute("listNewProduct",listNewProduct);
            request.setAttribute("listProduct",listProduct);
            request.getRequestDispatcher("views/index.jsp").forward(request,response);
        } else if (action.equalsIgnoreCase("singerProduct")) {
            int proId = Integer.parseInt(request.getParameter("proId"));
            DisplayProduct displayProduct = productSevices.displaySingerProduct(proId);
            List<Color> listColor = productSevices.getAllColorOfProduct(proId);
            request.setAttribute("listColor",listColor);
            request.setAttribute("product",displayProduct);
            request.getRequestDispatcher("views/singerProduct.jsp").forward(request,response);
        }else if (action.equalsIgnoreCase("getByCatalog")) {
            int catId = Integer.parseInt(request.getParameter("catalogId"));
            List<DisplayProduct> listProduct = productSevices.getByCatalogId(catId);
            List<Color> listColor = sizeServices.getAllColor();
            List<Size> listSize = catalogSevices.getSizeByCatalogId(catId);
            List<Catalog> listCatalog = catalogSevices.getByParentId(catId);
            request.setAttribute("listColor",listColor);
            request.setAttribute("listCatalog",listCatalog);
            request.setAttribute("listSize",listSize);
            request.setAttribute("listProduct",listProduct);
            request.getRequestDispatcher("views/catelogies.jsp").forward(request,response);
        } else if (action.equals("main")) {
            List<DisplayProduct> listProduct = productSevices.displayWebProduct();
            List<DisplayProduct> listNewProduct = productSevices.displayNewProducts();
            request.setAttribute("listNewProduct",listNewProduct);
            request.setAttribute("listProduct",listProduct);
            request.getRequestDispatcher("views/home.jsp").forward(request,response);
        }
    }
    private static void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        List<Product> listProduct = productSevices.getProductForAdminTable(user.getUserId());
        request.setAttribute("listProduct",listProduct);
        request.getRequestDispatcher("views/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("createProduct")){
            Product product = new Product();
            User user = (User) request.getSession().getAttribute("userLogin");
            product.setProductName(request.getParameter("productName"));
            int catalogId = Integer.parseInt(request.getParameter("catalog"));
            Catalog catalog = catalogSevices.getCatalogById(catalogId);
            product.setCatalog(catalog);
            product.setDiscription(request.getParameter("description"));
            product.setUser(user);
            String pathRootTomcat = "D:/project_MD3/LastProject/src/main/webapp/image";
            File file = new File(pathRootTomcat);
            if (!file.exists()){
                file.mkdirs();
            }
            for (Part part :request.getParts()) {
                if (part.getName().equalsIgnoreCase("image")){
                    product.setProductImage(part.getSubmittedFileName());
                    part.write(pathRootTomcat + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equalsIgnoreCase("subImage")) {
                    product.getImageList().add(part.getSubmittedFileName());
                    part.write(pathRootTomcat + File.separator + part.getSubmittedFileName());
                }

            }
            boolean checkExit = productSevices.insert(product);
            if (checkExit){
                String [] size = request.getParameterValues("size");
                String [] color = request.getParameterValues("color");
                List<String> listS = new ArrayList<String>(Arrays.asList(size));
                List<Integer> listSearch = new ArrayList<>();
                for (String str :listS) {
                    listSearch.add(Integer.parseInt(str));
                }
                List<Size> listSize = sizeServices.getListSize(listSearch);
                List<Integer> listC = new ArrayList<>();
                for (String str :color) {
                    listC.add(Integer.parseInt(str));
                }
                List<Color> listColor = sizeServices.getListColor(listC);
                Product proNew = (Product) productSevices.getNewProduct(product.getUser().getUserId());
                request.setAttribute("size",listSize);
                request.setAttribute("color",listColor);
                request.setAttribute("product",proNew);
                HttpSession session = request.getSession();
                session.setAttribute("proNew",proNew);
                request.getRequestDispatcher("views/createProductDetail.jsp").forward(request,response);
            }
        } else if (action.equalsIgnoreCase("createProductDetail")) {
            String [] size = request.getParameterValues("size");
            String[] color = request.getParameterValues("color");
            String[] price = request.getParameterValues("price");
            String[] quantity = request.getParameterValues("quantity");
            List<String> listS = new ArrayList<String>(Arrays.asList(size));
            List<Integer> listSearch = new ArrayList<>();
            for (String str :listS) {
                listSearch.add(Integer.parseInt(str));
            }
            List<Size> listSize = sizeServices.getListSize(listSearch);
            List<Integer> listC = new ArrayList<>();
            for (String str :color) {
                listC.add(Integer.parseInt(str));
            }
            List<Color> listColor = sizeServices.getListColor(listC);
            List<ProductDetail> list = new ArrayList<>();
            for (int i = 0; i < listSize.size(); i++) {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setSize(listSize.get(i));
                productDetail.setColor(listColor.get(i));
                productDetail.setPrice(Float.parseFloat(price[i]));
                productDetail.setQuantity(Integer.parseInt(quantity[i]));
                list.add(productDetail);
            }

            Product product = (Product) request.getSession().getAttribute("proNew");
            boolean checkInsert = productSevices.insertProductDetail(product.getProductId(),list);
            if (checkInsert){
               getAll(request,response);
            }
        } else if (action.equalsIgnoreCase("updatePrice")) {
            String[] price = request.getParameterValues("price");
            String[] detailId= request.getParameterValues("detailIdPrin");
            List<Float> listPrice = new ArrayList<>();
            List<Integer> listDetailId = new ArrayList<>();
            for (String str :price) {
                listPrice.add(Float.parseFloat(str));
            }
            for (String str :detailId) {
                listDetailId.add(Integer.parseInt(str));
            }
            boolean checkUpdate = productSevices.updatePrice(listPrice,listDetailId);
            if (checkUpdate){
                getAll(request,response);
            }else {
                request.getRequestDispatcher("views/ERROR.jsp").forward(request,response);
            }
        }else if (action.equalsIgnoreCase("updateQuantity")) {
            String[] quantity = request.getParameterValues("quantity");
            String[] detailId= request.getParameterValues("detailIdQuant");
            List<Integer> listQ = new ArrayList<>();
            List<Integer> listDetailId = new ArrayList<>();
            for (String str :quantity) {
                listQ.add(Integer.parseInt(str));
            }
            for (String str :detailId) {
                listDetailId.add(Integer.parseInt(str));
            }
            boolean checkUpdate = productSevices.updateQuantity(listQ,listDetailId);
            if (checkUpdate){
                getAll(request,response);
            }else {
                request.getRequestDispatcher("views/ERROR.jsp").forward(request,response);
            }
        }
    }
}
