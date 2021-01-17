import com.google.gson.Gson;
import models.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Process process = Runtime.getRuntime().exec(new String[] {
                //  "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output"
                "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT && rm -r uploads"

        });

        StringBuilder st = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader readerError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line = "";

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            st.append(line+ "  -  \n");
        }

        while ((line = readerError.readLine()) != null) {
            System.out.println(line);
            st.append(line+ "  -  \n");
        }

        Response response1= new Response();
        response1.setError(false);
        response1.setFile_path("success");
        response1.setMessage("success");
        Gson gson = new Gson();
        String responseJsonString = gson.toJson(response1);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseJsonString);
        out.flush();
    }
}
