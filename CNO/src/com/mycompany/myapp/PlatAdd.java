/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.CaracSport;
import entities.Plat;
import services.CaracService;
import services.PlatService;

/**
 *
 * @author ASUS
 */
public class PlatAdd extends SideMenuBaseForm{

        public PlatAdd(Form previous, Resources res) {
        

        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new PlatShow(res,current).show());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        setTitle("Ajouter Plat");

        //poids,sodium,cholesterol,carbohydrate,protein,calories,nom
        TextField tfnom = new TextField("", "Nom (cm)");
        TextField tfPoids = new TextField("", "Poids (g)");
        TextField tfSodium = new TextField("", "Sodium (g)");
        TextField tfcholesterol = new TextField("", "cholesterol (g)");
        TextField tfcarbohydrate = new TextField("", "carbohydrate (g)");
        TextField tfprotein = new TextField("", "protein (g)");
        TextField tfcalories = new TextField("", "calories (Kcal)");

        

        Button btnValider = new Button("Ajouter Plat");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if ((tfprotein.getText().length() == 0) || (tfcalories.getText().length() == 0) ||(tfcarbohydrate.getText().length() == 0) ||(tfcholesterol.getText().length() == 0) ||(tfnom.getText().length() == 0) || (tfPoids.getText().length() == 0) || (tfSodium.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        //Integer.parseInt(tfTaille.getText())
                         
                        Plat p = new Plat(Integer.parseInt(tfPoids.getText()), Integer.parseInt(tfPoids.getText()), Integer.parseInt(tfcholesterol.getText()), Integer.parseInt(tfcarbohydrate.getText()), Integer.parseInt(tfprotein.getText()),Integer.parseInt(tfcalories.getText()), tfnom.getText());

 
                        if (PlatService.getInstance().addPlat(p)) {
                            Dialog.show("Success", "Connection accepted", new Command("OK"));
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Erreur !!", new Command("OK"));
                    }

                }

            }
        });
 

        addAll(tfSodium,tfPoids,tfcholesterol,tfcarbohydrate,tfprotein,tfcalories,tfnom, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new ProfileForm(res).show());

    }


   @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
