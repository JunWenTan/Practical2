package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Created by 153907N on 10/24/2016.
 */
@WebServlet(name = "BookCatalogServlet", urlPatterns = "/bookcatalog")
public class BookCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<BookDetails> bdList = new ArrayList<BookDetails>();
        BookDBAO bdao = new BookDBAO();
        PrintWriter out = response.getWriter();
        bdList = bdao.getAllBooks();

        for(BookDetails a: bdList)
        {
            BookDetails bd = a;

            //Print out the information obtained
            out.println("<h2>" + bd.getTitle() + "</h2>" + "&nbsp;" +
                    " by<em>" + bd.getFirstName() +
                    " " + bd.getSurname() + "</em> &nbsp; &nbsp; " + "(" +
                    bd.getYear() + ")<br> &nbsp; <br>" + "<h4>" +
                    "Here's what the critcs say: </h4><blockquote>" +
                    bd.getDescription() + "</blockquote>" + "<h4>" +
                    "Our Price: " + bd.getPrice() + "</h4>" +
                    "<p><strong><a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookcatalog?bookId=" + a.getBookId()) + "\">" +
                    "Add to Cart</a>&nbsp;&nbsp;&nbsp;" +
                    "<a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookcatalog") + "\">" +
                    "Continue Shopping</a></p></strong>");
        }
    }
}
