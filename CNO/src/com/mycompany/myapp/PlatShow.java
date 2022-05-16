/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.MultiButton;
import com.codename1.ui.*;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Plat;
import java.util.ArrayList;
import services.PlatService;

/**
 *
 * @author ASUS
 */
public class PlatShow extends SideMenuBaseForm{
    Form current;

    public PlatShow(Resources res,Form previous) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ProfileForm(res).show());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        setTitle("Liste Plats");

        ArrayList<Plat> list = PlatService.getInstance().getAllPlats();

        for (Plat p : list) {
     
            MultiButton fourLinesIcon = new MultiButton(p.getNom());
            fourLinesIcon.setTextLine2("Proteins : " + p.getProtein()+ "\n");
            fourLinesIcon.setTextLine3("Poids : " + p.getPoids()+ "\n");
            fourLinesIcon.setTextLine4("Calories : " + p.getCalories()+ "\n");
            
            //supprimer button
            Button btnModifPlat = new Button("Modifier");
            btnModifPlat.setUIID("LoginButton");
            Button btnSupPlat = new Button("Supprimer");
            btnSupPlat.setUIID("LoginButton");
            
         
            
            //click sup button
            btnSupPlat.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if (dig.show("Suppression", "Vous voulez supprimer ce reclamation ?", "Annuler", "Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();
                }
                if (PlatService.getInstance().deletePlat(p.getId())) {
                    System.out.println("supprimé");
                              

                }
                current.show();

            });
            
            addAll(fourLinesIcon,btnModifPlat, /*poids,sodium,cholesterol,carbohydrate,protein,calories,nom,*/btnSupPlat);
        }

        Button btnAddPlat = new Button("Ajouter Plat");
        btnAddPlat.setUIID("LoginButton");
        btnAddPlat.addActionListener(e -> new PlatAdd(current, res).show());

        addAll(btnAddPlat);
    }

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
