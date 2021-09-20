package ru.appline;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.deploy.net.HttpRequest;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")

public class ServletPut extends HttpServlet {


        protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Model model = Model.getInstance();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();


            StringBuffer jb = new StringBuffer();
            String line;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    jb.append(line);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }

            JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

            request.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));
            String name = jobj.get("name").getAsString();
            String surname = jobj.get("surname").getAsString();
            double salary = jobj.get("salary").getAsDouble();

            User user = new User(name, surname, salary);

            //////////

            model.put(user, id);
            ////////////



            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.print(gson.toJson(model.getFromList()));

        }

}
