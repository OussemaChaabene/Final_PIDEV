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
public class StatService {
    
    public Map<String, String> stat;
    public static StatService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private StatService() {
        req = new ConnectionRequest();
    }

    public static StatService getInstance() {
        if (instance == null) {
            instance = new StatService();
        }
        return instance;
    }

    public Map<String, String> parseStats(String jsonText) {
        Map<String, String> stats = null ;
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            for (Map<String, Object> obj : list) {
                stats.put(obj.get("date").toString(), obj.get("sum").toString());
            }

        } catch (IOException ex) {

        }
        
        return stats;
    }

    public Map<String, String> getStats(int id) {

        String url = statics.BASE_URL + "Jstats/all?id="+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                stat = parseStats(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return stat;
    }

   
}
