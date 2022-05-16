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
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import entities.abonnement;
import entities.categorieabo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import utils.statics;

/**
 *
 * @author MSI
 */
/*
public class categorieaboS {
      public ArrayList<categorieabo> abs;

    public static categorieaboS instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private categorieaboS() {
        req = new ConnectionRequest();
    }

    public static categorieaboS getInstance() {
        if (instance == null) {
            instance = new categorieaboS();
        }
        return instance;
    }

    public ArrayList<categorieabo> parseabonnementcat(String jsonText) {
        try {
            abs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                categorieabo ab = new categorieabo();
                
                 ab.setId((int) Float.parseFloat(obj.get("id").toString()));
                 ab.setNom(obj.get("nom").toString());
 
                abs.add(ab);
            }

        } catch (IOException ex) {

        }
        return abs;
    }

    public ArrayList<abonnement> getAllCaracs() {

        String url = statics.BASE_URL + "j/caracs";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                abs = parseabonnementcat(new String(req.getResponseData()));
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
        String url = statics.BASE_URL + "j/addCarac";

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

    public boolean modifierCarac(abonnement c) {
        String url = statics.BASE_URL + "/j/modifCarac?id=" + c.getId() + "&nom=" + c.getAb_nom() + "&type=" + c.getAb_type()+ "&prix=" + c.getAb_prix();
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

    }*/

