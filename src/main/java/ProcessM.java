import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/ProcessM")
public class ProcessM extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("file_name");

        Process process = Runtime.getRuntime().exec(new String[] {
                "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output"
               // "/bin/bash", "-c", "spleeter separate -i audio_example.mp3 -p spleeter:2stems -o output"
        });
        printResults(process, response);


    }

    public static void printResults(Process process, HttpServletResponse response) throws IOException {
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

        printJson(st.toString(), response);
    }

    private static void printJson(String toString, HttpServletResponse response) throws IOException {
        Response response1 = new Response();
        response1.setError(false);
        response1.setFile_path("good");
        response1.setMessage("SUCCESS: app path " + toString);
        Gson gson = new Gson();
        String responseJsonString = gson.toJson(response1);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseJsonString);
        out.flush();
    }
}
