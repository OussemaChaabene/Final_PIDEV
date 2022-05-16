/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.CaracSport;
import utils.statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ASUS
 */
public class CaracService {
   
    
    public ArrayList<CaracSport> caracs;

    public static CaracService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private CaracService() {
        req = new ConnectionRequest();
    }

    public static CaracService getInstance() {
        if (instance == null) {
            instance = new CaracService();
        }
        return instance;
    }

    public ArrayList<CaracSport> parseCaracs(String jsonText) {
        try {
            caracs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                CaracSport cs = new CaracSport();
                cs.setId((int) Float.parseFloat(obj.get("id").toString()));
                cs.setAge(((int) Float.parseFloat(obj.get("age").toString())));
                cs.setGenre(obj.get("genre").toString());
                cs.setCalorieNeed(((int) Float.parseFloat(obj.get("calorieNeed").toString())));
                cs.setPrtoNeeds(((int) Float.parseFloat(obj.get("protNeeds").toString())));
                cs.setTaille(((int) Float.parseFloat(obj.get("taille").toString())));
                cs.setPoids(((int) Float.parseFloat(obj.get("poids").toString())));

                caracs.add(cs);
            }

        } catch (IOException ex) {

        }
        return caracs;
    }

    public ArrayList<CaracSport> getAllCaracs() {

        String url = statics.BASE_URL + "j/caracs";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                caracs = parseCaracs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return caracs;
    }

    public boolean addCarac(CaracSport cs) {
        System.out.println(cs.toString());
        System.out.println("********");
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = statics.BASE_URL + "j/addCarac";

        req.setUrl(url);

        req.addArgument("taille", cs.getTaille() + "");
        req.addArgument("poids", cs.getPoids() + "");
        req.addArgument("age", cs.getAge() + "");
        req.addArgument("genre", cs.getGenre());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deleteCarac(int id) {
        String url = statics.BASE_URL + "j/suppCarac/" + id;

        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                req.removeResponseCodeListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean modifierCarac(CaracSport c) {
        String url = statics.BASE_URL + "/j/modifCarac?id=" + c.getId() + "&age=" + c.getAge() + "&taille=" + c.getTaille() + "&poids=" + c.getPoids() + "&genre=" + c.getGenre();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        return resultOK;

    }
}
