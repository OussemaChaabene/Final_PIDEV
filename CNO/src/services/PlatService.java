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
import entities.Plat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.statics;

/**
 *
 * @author ASUS
 */
public class PlatService {
    
        public ArrayList<Plat> plats;

    public static PlatService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private PlatService() {
        req = new ConnectionRequest();
    }

    public static PlatService getInstance() {
        if (instance == null) {
            instance = new PlatService();
        }
        return instance;
    }

    public ArrayList<Plat> parsePlats(String jsonText) {
        try {
            plats = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                Plat p = new Plat();
                p.setId((int) Float.parseFloat(obj.get("id").toString()));
                p.setSodium(((int) Float.parseFloat(obj.get("sodium").toString())));
                p.setNom(obj.get("nom").toString());
                p.setCholesterol(((int) Float.parseFloat(obj.get("cholesterol").toString())));
                p.setCarbohydrate(((int) Float.parseFloat(obj.get("carbohydrate").toString())));
                p.setCalories(((int) Float.parseFloat(obj.get("calories").toString())));
                p.setProtein(((int) Float.parseFloat(obj.get("protein").toString())));
                p.setPoids(((int) Float.parseFloat(obj.get("poids").toString())));

                plats.add(p);
            }

        } catch (IOException ex) {

        }
        return plats;
    }

    public ArrayList<Plat> getAllPlats() {

        String url = statics.BASE_URL + "j/plat/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                plats = parsePlats(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return plats;
    }
    
    public ArrayList<Plat> getAllPlatsByName(String nom) {

        String url = statics.BASE_URL + "j/plat/all?nom="+nom;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                plats = parsePlats(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return plats;
    }

    public boolean addPlat(Plat p) {
        System.out.println(p.toString());
        System.out.println("********");
        String url = statics.BASE_URL + "j/addPlat";

        req.setUrl(url);

        req.addArgument("sod", p.getSodium()+ "");
        req.addArgument("poids", p.getPoids() + "");
        req.addArgument("chol", p.getCholesterol() + "");
        req.addArgument("carb", p.getCarbohydrate()+"");
        req.addArgument("prot", p.getProtein()+"");
        req.addArgument("cal", p.getProtein()+"");
        req.addArgument("nom", p.getNom());

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

    public boolean deletePlat(int id) {
        String url = statics.BASE_URL + "j/suppPlat/" + id;

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

    public boolean modifierPlat(Plat p) {
        String url = statics.BASE_URL + "j/modifPlat?sod=" + p.getSodium()+ "&chol=" + p.getCholesterol()+ "&carb=" + p.getCarbohydrate()+ "&prot=" + p.getProtein()+"&cal="+p.getCalories()+"&nom="+p.getNom();
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//executer request 
        return resultOK;

    }
    
}
