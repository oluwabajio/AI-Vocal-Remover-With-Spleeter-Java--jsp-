import com.google.gson.Gson;
import models.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/ProcessMp3")
public class ProcessMp3 extends HttpServlet {

    Response response1= new Response();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sd = new StringBuilder();
        String fileName = request.getParameter("file_name");



        String s = null;

   //     Process p = Runtime.getRuntime().exec("conda activate && spleeter separate -i /home/audio_example.mp3 -o /home/output");
//        String[] cmd = {"/root/anaconda3/bin/spleeter"};
//        String[] cmd = {"spleeter"};
//        Process p = Runtime.getRuntime().exec(cmd);
        ProcessBuilder builder = new ProcessBuilder();
////           // builder.command("/bin/bash", "-c", "ls");
            builder.command("/bin/bash", "-c","spleeter separate -i /home/baj/audio_example.mp3 -o /home/baj/output");
            builder.directory(new File(System.getProperty("user.home")));
            Process p = builder.start();

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(p.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");

        try  {
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                sd.append("  -  " + s);
                response1.setError(false);
                response1.setFile_path("NN"+sd.toString());
                response1.setMessage("Uploabkded Successfully"+ fileName);
                Gson gson = new Gson();
                String responseJsonString = gson.toJson(response1);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(responseJsonString);
                out.flush();
            }
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                sd.append("-"+s);
                response1.setError(false);
                response1.setFile_path("NN"+sd.toString());
                response1.setMessage("Uploabkded Successfully"+ fileName);
                Gson gson = new Gson();
                String responseJsonString = gson.toJson(response1);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(responseJsonString);
                out.flush();
            }
//

        } catch (Exception e) {
            System.out.println("dd"+e.getMessage());
            sd.append("  -  " + e.getMessage());
        }
//
//        String s = null;
//
//        try {
//
//            // run the Unix "ps -ef" command
//            // using the Runtime exec method:
//         //   Process p = Runtime.getRuntime().exec("sh -c /usr/bin/wget https://github.com/deezer/spleeter/raw/master/audio_example.mp3");
//           // Process p = Runtime.getRuntime().exec("/root/anaconda3/bin/spleeter");
//           //  Process p = Runtime.getRuntime().exec("spleeter separate -i /home/audio_example.mp3");
////            ProcessBuilder builder = new ProcessBuilder();
////           // builder.command("/bin/bash", "-c", "ls");
////          //  builder.command("/bin/bash", "-c","/usr/local/bin/spleeter separate -i /root/audio_example.mp3 -p spleeter:2stems -o /root/output");
////            builder.directory(new File(System.getProperty("user.home")));
////            Process p = builder.start();
//
//            String[] command = { "spleeter", "separate", "-i", "/home/audio_example.mp3" };
//            Process p = Runtime.getRuntime().exec(command);
//
//            BufferedReader stdInput = new BufferedReader(new
//                    InputStreamReader(p.getInputStream()));
//
//            BufferedReader stdError = new BufferedReader(new
//                    InputStreamReader(p.getErrorStream()));
//
//            // read the output from the command
//            System.out.println("Here is the standard output of the command:\n");
//
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//                sd.append("  -  "+s);
//            }
//
//            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//                sd.append("-"+s);
//            }
//
////            System.exit(0);
//        }
//        catch (IOException e) {
//            System.out.println("exception happened - here's what I know: ");
//            e.printStackTrace();
//            sd.append(e.getMessage());
//           // System.exit(-1);
//        }
//
//


//
//        ProcessBuilder processBuilder = new ProcessBuilder();
//
//// -- Linux --
//
//// Run a shell command
//        processBuilder.command("ls");
//
//// Run a shell script
////processBuilder.command("path/to/hello.sh");
//
//// -- Windows --
//
//// Run a command
////processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");
//
//// Run a bat file
////processBuilder.command("C:\\Users\\mkyong\\hello.bat");
//
//        try {
//            System.out.println("1. Success!");
//
//            Process process = processBuilder.start();
//
//            StringBuilder output = new StringBuilder();
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line + "\n");
//            }
//
//            int exitVal = process.waitFor();
//            if (exitVal == 0) {
//                System.out.println("Success!");
//                System.out.println(output);
////                System.exit(0);
//            } else {
//                //abnormal...
//                System.out.println("Abnormal");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Failed!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("Failed!");
//        }

        response1.setError(false);
        response1.setFile_path(""+sd.toString());
        response1.setMessage("Uploaded Successfully"+ fileName);
        Gson gson = new Gson();
        String responseJsonString = gson.toJson(response1);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(responseJsonString);
        out.flush();




    }


}
