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
import utils.statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author DELL
 */
public class comentairesS {
    
    
    public ArrayList<commentaires> com;

    public static comentairesS instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private comentairesS() {
        req = new ConnectionRequest();
    }

    public static comentairesS getInstance() {
        if (instance == null) {
            instance = new comentairesS();
        }
        return instance;
    }

    public ArrayList<commentaires> parsecom(String jsonText) {
        try {
            com = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                commentaires comm = new commentaires();
                comm.setId((int) Float.parseFloat(obj.get("id").toString()));
                comm.setNom(obj.get("nom").toString());              
                comm.setComment(obj.get("comment").toString());
                comm.setNote((int) Float.parseFloat(obj.get("note").toString()));


                com.add(comm);
            }

        } catch (IOException ex) {

        }
        return com;
    }

    public ArrayList<commentaires> getAllcom() {

        String url = statics.BASE_URL + "commentaire/j/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                com = parsecom(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return com;
    }

    public boolean addcom(commentaires com) {
        System.out.println(com.toString());
        System.out.println("********");
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = statics.BASE_URL + "commentaire/j/addcj";

        req.setUrl(url);

        req.addArgument("nom", com.getNom() + "");
        req.addArgument("comment", com.getComment() + "");
        req.addArgument("note", com.getNote() + "");
        

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
