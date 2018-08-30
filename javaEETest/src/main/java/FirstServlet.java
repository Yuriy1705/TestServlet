import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        String nane=request.getParameter("name");
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        if (cart == null) {
            cart = new Cart();
            cart.setName(nane);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart",cart);


//        Integer count=(Integer)session.getAttribute("count");
//
//        if(count==null){
//            session.setAttribute("count",1);
//            count=1;
//        }else {
//            session.setAttribute("count",count+1);
//        }


//        String name=request.getParameter("name");
//        String surname=request.getParameter("surname");


        PrintWriter pw = response.getWriter();

        pw.println("<html>");
//        pw.println("<h1> Hello Loser)) With name " +name+" "+surname+"  </h1>");
        pw.println("<h1> Name your product " + cart.getName() + "<h1>");
        pw.println("<h2> Quantity your product " + cart.getQuantity() + "<h2>");
        pw.println(new java.util.Date());
        pw.println("</html>");

        //response.sendRedirect("https://www.instagram.com");
        //response.sendRedirect("/secondservlet");

//        RequestDispatcher dispatcher=request.getRequestDispatcher("/secondservlet");
//        dispatcher.forward(request,response);

    }
}
