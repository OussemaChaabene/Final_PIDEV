/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.CaracSport;
import java.util.ArrayList;
import services.CaracService;

/**
 *
 * @author ASUS
 */
public class caracSportShow extends SideMenuBaseForm {

    Form current;

    public caracSportShow(Resources res) {

        super(BoxLayout.y());

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ProfileForm(res).show());

        ArrayList<CaracSport> list = CaracService.getInstance().getAllCaracs();
        for (CaracSport c : list) {
            MultiButton fourLinesIcon = new MultiButton("nom");
            fourLinesIcon.setTextLine1("Besoins proteins : " + c.getPrtoNeeds()+ "\n");
            fourLinesIcon.setTextLine2("Taille : " + c.getTaille()+ "\n");
            fourLinesIcon.setTextLine3("Poids : " + c.getPoids()+ "\n");
            fourLinesIcon.setTextLine4("Besoins calories : " + c.getCalorieNeed()+ "\n");
            
     
            
            //modif button
            Button btnModifCarac = new Button("Modifié Carac");
            btnModifCarac.setUIID("LoginButton");

            //supprimer button
            Button btnModifPlat = new Button("Modifier");
            btnModifPlat.setUIID("LoginButton");
            Button btnSup = new Button("Supprimer");
            btnSup.setUIID("LoginButton");

            //click delete icon
            btnSup.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if (dig.show("Suppression", "Vous voulez supprimer ce reclamation ?", "Annuler", "Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();
                }
                if (CaracService.getInstance().deleteCarac(c.getId())) {
                    System.out.println("supprimé");
                }
                current.show();


            });
            addAll(btnModifCarac, btnSup,fourLinesIcon);
        }
        setTitle("Liste caracs");
         
        //modif button
        Button btnAddCarac = new Button("Ajouter Carac");
        btnAddCarac.setUIID("LoginButton");
        btnAddCarac.addActionListener(e -> new caracSportAdd(current, res).show());

        addAll(btnAddCarac);
    }

   

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
