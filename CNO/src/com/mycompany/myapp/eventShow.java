/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.events;
import java.util.ArrayList;

import services.evenservice;

/**
 *
 * @author pc
 */
public class eventShow extends SideMenuBaseForm {
       Form current;
       
public eventShow(Resources res,Form current) {

        super(BoxLayout.y());

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ProfileForm(res).show());
        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ArrayList<events> list = evenservice.getInstance().getAllevents();
        for (events c : list) {
            MultiButton fourLinesIcon = new MultiButton("");
            fourLinesIcon.setTextLine1("nom : " + c.getNom()+ "\n");
            fourLinesIcon.setTextLine2("Description : " + c.getDescri()+ "\n");
            fourLinesIcon.setTextLine3("Prix : " + c.getPrix()+ "\n");
            fourLinesIcon.setTextLine4("Date : " + c.getDateeven()+ "\n");
            container.add(fourLinesIcon);
     
            
         
            Button btnSup = new Button("Supprimer");
            btnSup.setUIID("LoginButton");

            //click delete icon
            btnSup.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if (dig.show("Suppression", "Vous voulez supprimer cet evenement ?", "Annuler", "Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();
                }
                if (evenservice.getInstance().deleteevents(c.getIdeven())) {
                    System.out.println("supprimé");
                    dig.dispose();
                    current.revalidate();
                }
                


            });
       container.add(btnSup);
        }
        setTitle("Liste evenements");
     addAll(container);
    }

   

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}