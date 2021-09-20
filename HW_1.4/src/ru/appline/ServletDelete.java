package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delete")
public class ServletDelete extends  HttpServlet{




    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws  IOException
    {


//////////////
        Model model = Model.getInstance();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        response.setContentType("application/json;character=utf-8");


        PrintWriter pw = response.getWriter();
    /////////////


        int id = Integer.parseInt(request.getParameter("id"));

        model.delete(id);

        pw.print(gson.toJson(model.getFromList()));

    }

}
