package ag.chat.model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ContactRepository {

    public int size() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    //prepara a requisição
                    URL url = new URL("http://192.168.57.1:40000/list/size");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.addRequestProperty("content-type", "application/json");
                    //recupera a consulta
                    byte[] b = new byte[1024];
                    conn.getInputStream().read(b);
                    //convert bytes para texto
                    String number = new String(b).trim();
                    //converter para número
                    return Integer.parseInt(number);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        //
        try {
            Future<Integer> future = Executors
                    .newSingleThreadExecutor()
                    .submit(callable);
            return future.get();//bloqueado
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //
        return 0;
    }

    public Contact get(final int position) {
        //
        Callable<Contact> callable = new Callable<Contact>() {
            @Override
            public Contact call() throws Exception {
                try {
                    //prepara a requisição
                    URL url = new URL("http://192.168.57.1:40000/list");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.addRequestProperty("content-type", "application/json");
                    //recupera a consulta
                    byte[] b = new byte[1024];
                    conn.getInputStream().read(b);
                    //convert bytes para texto
                    String json = new String(b).trim();
                    //converter o texto (json) em objetos
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    List<Contact> result = gson.fromJson(json,
                            new TypeToken<List<Contact>>() {}.getType());
                    return result.get(position);//return
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        //
        try {
            Future<Contact> future = Executors.newSingleThreadExecutor().submit(callable);
            return future.get();//bloqueado
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //
        return null;
    }


}
