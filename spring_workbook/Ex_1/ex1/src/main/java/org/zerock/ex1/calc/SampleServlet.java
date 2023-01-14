package org.zerock.ex1.calc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServletConfig).........");
    } // 초기화

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...." + this);
    } // 처리되는 부분

    @Override
    public void destroy() {
        System.out.println("destroy......");
    } // 변경이나 종료


}
