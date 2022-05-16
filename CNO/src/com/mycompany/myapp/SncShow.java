/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Seance;
import java.util.ArrayList;
import java.util.Date;
import services.SncService;

/**
 *
 * @author mayro
 */
public class SncShow extends SideMenuBaseForm{
    Form current;

    public SncShow(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ProfileForm(res).show());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        setTitle("Liste des Seances");

        ArrayList<Seance> list = SncService.getInstance().getAllSeance();
            
        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        for (Seance s : list) {
            
            System.out.println(s.toString());
            
            MultiButton fourLinesIcon = new MultiButton();
            fourLinesIcon.setTextLine1("Seance de : " + s.getTypeseance()+ "\n");
            fourLinesIcon.setTextLine2("date : " + toString(s.getDate())+ "\n");
            container.add(fourLinesIcon);
            
            
            //supprimer button
            Button btnSupPlat = new Button("Supprimer");
            btnSupPlat.setUIID("LoginButton");
            container.add(btnSupPlat);
            
         
            
            //click sup button
            btnSupPlat.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if (dig.show("Suppression", "Vous voulez supprimer cet Seance ?", "Annuler", "Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();
                }
                if (SncService.getInstance().deleteSnc(s.getId_seance())) {
                    System.out.println("Supprimé");
                    dig.dispose();        

                }
                //current.show();

            });
            
        }
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.addActionListener(e -> new SncAdd(current, res).show());
        //fab.bindFabToContainer(current.getContentPane());

       /* Button btnAddSnc = new Button("Ajouter seance");
        btnAddSnc.setUIID("LoginButton");
        btnAddSnc.addActionListener(e -> new SncAdd(current, res).show());*/

        addAll(container,fab);
    }

    @Override
    protected void showOtherForm(Resources res) {
    }

    private String toString(Date date) {
        return date.toString();
    }

    
}
