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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import entities.events;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utils.statics;

/**
 *
 * @author pc
 */
public class evenservice {
    
 public ArrayList<events> ev;

    public static evenservice instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private evenservice() {
        req = new ConnectionRequest();
    }

    public static evenservice getInstance() {
        if (instance == null) {
            instance = new evenservice();
        }
        return instance;
    }

    public ArrayList<events> parseevents(String jsonText) {
        try {
            ev = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                events cs = new events();
                cs.setIdeven((int) (double) obj.get("ideven"));
                cs.setPrix(((int) Float.parseFloat(obj.get("prix").toString())));
                cs.setDescri((String)obj.get("descri").toString());
                cs.setNom((String)obj.get("nom").toString());
                 try {  
                            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("dateeven").toString());
                            cs.setDateeven(date1);

                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                             
                ev.add(cs);
            }

        } catch (IOException ex) {

        }
        return ev;
    }

    public ArrayList<events> getAllevents() {

        String url = statics.BASE_URL + "events/allEvents";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ev = parseevents(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ev;
    }


    public boolean deleteevents(int id) {
        String url = statics.BASE_URL + "events/deleteeventsJSON/" + id;

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
