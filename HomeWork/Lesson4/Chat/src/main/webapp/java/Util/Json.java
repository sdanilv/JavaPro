package Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Json {
    private Gson gson;
    HttpURLConnection conn;

    public Json() {
        gson = new GsonBuilder().create();
    }

    public String toJSON(Object object) {
        return gson.toJson(object);
    }

    public <T> T fromJSON(HttpServletRequest request, Class<T> tClass) {
        InputStream is = null;
        try {
            is = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(is);
        return gson.fromJson(reader, tClass);
    }

    public <T> T fromJSON(String string, Class<T> tClass) {
        return gson.fromJson(string, tClass);
    }

    public void sendJSON(URL url, String requestMethod, Object object) {
        try {
            URL obj = url;
            conn = (HttpURLConnection) obj.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(requestMethod);
            try (OutputStream os = conn.getOutputStream()) {
                String json = toJSON(object);
                os.write(json.toString().getBytes(StandardCharsets.UTF_8));
                int res = conn.getResponseCode();
                if (res != 200) { // 200 OK
                    System.out.println("HTTP error occured: " + res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readString() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void out(HttpServletResponse resp, String json) {
        OutputStream os;
        try {
            os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
