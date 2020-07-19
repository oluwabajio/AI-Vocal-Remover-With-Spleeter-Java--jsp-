import com.google.gson.Gson;
import models.AudioResultResponse;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("file_name");

        Process process = Runtime.getRuntime().exec(new String[] {
                //  "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output"
                "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output -c mp3"

        });
        printResults(process, response, fileName);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("file_name");

        Process process = Runtime.getRuntime().exec(new String[] {
              //  "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output"
                "/bin/bash", "-c", "cd /opt/tomcat/webapps/ROOT/uploads && spleeter separate -i "+ fileName +" -p spleeter:2stems -o output -c mp3"

        });
        printResults(process, response, fileName);


    }

    public static void printResults(Process process, HttpServletResponse response, String fileName) throws IOException {
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

        printJson(st.toString(), response, fileName);
    }

    private static void printJson(String toString, HttpServletResponse response, String fileName) throws IOException {
        AudioResultResponse mp3Response = new AudioResultResponse();
        mp3Response.setError(false);
        mp3Response.setFile_path("http://161.35.71.36/uploads/output/"+ fileName+"/vocals.mp3");
        mp3Response.setVocal_path("http://161.35.71.36/uploads/output/"+ fileName+"/vocals.mp3");
        mp3Response.setInstrumental_path("http://161.35.71.36/uploads/output/"+ fileName+"/accompaniment.mp3");
        mp3Response.setMessage("SUCCESS: app path " + toString);
        Gson gson = new Gson();
        String responseJsonString = gson.toJson(mp3Response);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseJsonString);
        out.flush();
    }
}
