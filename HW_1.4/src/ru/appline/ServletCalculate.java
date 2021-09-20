package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Calculate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculate")
public class ServletCalculate  extends HttpServlet {
    Calculate calc = Calculate.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException

    {


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
        int a = jobj.get("a").getAsInt();
        int b = jobj.get("b").getAsInt();


        String math = jobj.get("math").getAsString();

        response.setContentType("application/json;character=utf-8");
        PrintWriter pw = response.getWriter();

        if (math.equals("+"))
        {
            pw.print(gson.toJson("result: " + calc.sum(a,b)));
        }


        else if(math.equals("-"))
        {
            pw.print(gson.toJson("result: " + calc.sub(a, b)));
        }


        else if(math.equals("*"))
        {
            pw.print(gson.toJson("result: " + calc.multipli(a, b)));
        }

        else if(math.equals("/"))
        {
            if(a==0 || b==0)
            {
                pw.print(gson.toJson("Can't use 0 for this operation"));
            }

            else{
                pw.print(gson.toJson("result: " + calc.div(a, b)));
                }

        }





        else
        {
            pw.print(gson.toJson("Enter valid operation"));
        }


    }
}
