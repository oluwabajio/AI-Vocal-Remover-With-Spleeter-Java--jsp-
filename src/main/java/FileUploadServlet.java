
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.*;
import java.util.List;
import java.util.Random;

@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 205242440643911308L;
    private static final String UPLOAD_DIR = "uploads";
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }

        Response response1= new Response();
        response1.setError(false);
        response1.setFile_path(uploadFilePath + File.separator + fileName);
        response1.setMessage("Uploaded Successfully");
        Gson gson = new Gson();
        String responseJsonString = gson.toJson(response1);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseJsonString);
        out.flush();



        String dbUrl = "jdbc:mysql://localhost:3306/downloads?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String uname = "root";
        String pass = "";


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("forname worked");
            String uuid = generateRandom(7);


            Connection con = DriverManager.getConnection(dbUrl, uname, pass);
            Statement st = con.createStatement();
            String insertInitQuery = "insert into download_table (uuid, file_path, status) values ('" + uuid + "', 'sdjs',  'done')";
            int count = st.executeUpdate(insertInitQuery);


            System.out.println("what i inserted "+ uuid);

            st.close();
            con.close();



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }









//        request.setAttribute("message", fileName + " File uploaded successfully!");
//        getServletContext().getRequestDispatcher("/response.jsp").forward(
//                request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

    public static String generateRandom(int length) {
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

}
