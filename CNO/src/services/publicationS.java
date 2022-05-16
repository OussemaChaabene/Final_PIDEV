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
import entities.commentaires;
import entities.publication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.statics;

/**
 *
 * @author DELL
 */
public class publicationS {

    
     
    public ArrayList<publication> pubs;

    public static publicationS instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private publicationS() {
        req = new ConnectionRequest();
    }

    public static publicationS getInstance() {
        if (instance == null) {
            instance = new publicationS();
        }
        return instance;
    }

    public ArrayList<publication> parsePub(String jsonText) {
        try {
            pubs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                publication comm = new publication();
                comm.setId((int) Float.parseFloat(obj.get("id").toString()));
                comm.setNom(obj.get("nom").toString());              
                comm.setAdresse(obj.get("adr").toString());
                comm.setDescription(obj.get("note").toString());


                pubs.add(comm);
            }

        } catch (IOException ex) {
            System.out.println(ex.toString());

        }
        return pubs;
    }

    public ArrayList<publication> getAllPub() {

        String url = statics.BASE_URL + "publication/apubJ";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                pubs = parsePub(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return pubs;
    }

    public boolean addPub(publication com) {

        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = statics.BASE_URL + "publication/j/addpub";

        req.setUrl(url);

        req.addArgument("nom", com.getNom() + "");
        req.addArgument("adresse", com.getAdresse()+ "");
        req.addArgument("descrip", com.getDescription()+ "");
        req.addArgument("im", com.getImage()+ "");
        

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

    public boolean deleteCom(int id) {
        String url = statics.BASE_URL + "commentaire/j/suppComm/" + id;

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
