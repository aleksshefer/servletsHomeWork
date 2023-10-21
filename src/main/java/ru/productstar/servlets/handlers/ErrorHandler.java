package ru.productstar.servlets.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/errorHandler")
public class ErrorHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Exception exception = (Exception)
                req.getAttribute("jakarta.servlet.error.exception");
        Integer statusCode = (Integer)
                req.getAttribute("jakarta.servlet.error.status_code");

        if (statusCode == 404) {
            resp.getWriter().println("Error (" + statusCode + ") - page not found");
        } else if (exception != null) {
            resp.getWriter().println("Error (" + statusCode + ") - " + exception.getClass().getName());
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
