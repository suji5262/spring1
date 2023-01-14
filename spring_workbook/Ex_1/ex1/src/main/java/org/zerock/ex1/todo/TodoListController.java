package org.zerock.ex1.todo;

import org.zerock.ex1.todo.dto.TodoDTO;
import org.zerock.ex1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name= "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("/todo/list");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        request.setAttribute("list", dtoList);

        request.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(request, response);

    }
}
// getRequestDispatcher → 전달관련
// forward → 지금까지 들어온 모든 명령 무시, jsp가 작성하는 것만 브라우저로 전달
