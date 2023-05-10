package service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entity.annonce;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;





public class AnnonceService {
    
    
  


    
    
    private ArrayList<annonce> annonces;
    public static AnnonceService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public AnnonceService() {
        req = new ConnectionRequest();
    }

    public static AnnonceService getInstance() {
        if (instance == null) {
            instance = new AnnonceService();
        }
        return instance;
    }

    public boolean addAnnonce(annonce a) {
        String url = Statics.BASE_URL + "create/" + a.getType() + "/" + a.getDescription() +  "/" + a.getImage() + "/" + a.getDate_annonce();

        req.setUrl(url);
        req.setPost(false);

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

public ArrayList<annonce> parseAnnonces(String jsonText) {
    try {
        annonces = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> annoncesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

        List<Map<String, Object>> list = (List<Map<String, Object>>) annoncesListJson.get("root");
       for (Map<String, Object> obj : list) {
    annonce a = new annonce();
    float id = Float.parseFloat(obj.get("idAnnonce").toString());
    a.setId_annonce((int) id);
    a.setType(obj.get("type").toString());
    a.setDescription(obj.get("description").toString());
   // a.setImage(obj.get("image").toString());

    annonces.add(a);
}

    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    return annonces;
}





    public ArrayList<annonce> getAllAnnonces() {
        String url = Statics.BASE_URL + "/api/annonces";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                annonces = parseAnnonces(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return annonces;
    }
}
