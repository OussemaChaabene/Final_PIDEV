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
import entities.abonnement;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.statics;

/**
 *
 * @author MSI
 */
public class abonnementS {
    public ArrayList<abonnement> abs;

    public static abonnementS instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private abonnementS() {
        req = new ConnectionRequest();
    }

    public static abonnementS getInstance() {
        if (instance == null) {
            instance = new abonnementS();
        }
        return instance;
    }

    public ArrayList<abonnement> parseabonnement(String jsonText) {
        try {
            
            abs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            
            for (Map<String, Object> obj : list) {
                abonnement ab = new abonnement();
                
                 ab.setId((int) Float.parseFloat(obj.get("id").toString()));
                 ab.setAb_nom(obj.get("nom").toString());
                 ab.setAb_prix(((int) Float.parseFloat(obj.get("prix").toString())));
                 ab.setAb_type(obj.get("type").toString());
                abs.add(ab);
            }

        } catch (IOException ex) {

        }
        return abs;
    }

    public ArrayList<abonnement> getAllCaracs() {

        String url = statics.BASE_URL + "abonnement/abJ";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                abs = parseabonnement(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return abs;
    }

    public boolean addCarac(abonnement cs) {
        System.out.println(cs.toString());
        System.out.println("********");
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = statics.BASE_URL + "abonnement/j/addAb";

        req.setUrl(url);

        req.addArgument("nom", cs.getAb_nom()+ "");
        req.addArgument("type", cs.getAb_type()+ "");
        req.addArgument("prix", cs.getAb_prix()+ "");

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

    public boolean deleteabonnement(int id) {
        String url = statics.BASE_URL + "abonnement/j/suppab/" + id;

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

  
    
}
