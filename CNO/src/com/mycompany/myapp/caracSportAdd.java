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
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.CaracSport;
import services.CaracService;

/**
 *
 * @author ASUS
 */
public class caracSportAdd extends SideMenuBaseForm {

    public caracSportAdd(Form previous, Resources res) {

        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        setTitle("Ajouter infos");

        TextField tfTaille = new TextField("", "taille (cm)");
        TextField tfPoids = new TextField("", "Poids (Kg)");
        TextField tfAge = new TextField("", "Age");
        ComboBox genre = new ComboBox();

        genre.addItem("Homme");

        genre.addItem("Femme");

        Button btnValider = new Button("Ajouter Informations");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("TAILLE : " + tfTaille.getText());
                if ((tfTaille.getText().length() == 0) || (tfPoids.getText().length() == 0) || (tfAge.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    try {
                        //Integer.parseInt(tfTaille.getText())
                        CaracSport cs = new CaracSport(Integer.parseInt(tfTaille.getText()), Integer.parseInt(tfPoids.getText()), Integer.parseInt(tfAge.getText()));

                        if (genre.getSelectedIndex() == 0) {
                            cs.setGenre("homme");
                        } else {
                            cs.setGenre("femme");
                        }

                        if (CaracService.getInstance().addCarac(cs)) {
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

        addAll(tfTaille, tfPoids, tfAge, genre, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new caracSportShow(res).show());

    }

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
