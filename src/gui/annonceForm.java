/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import entity.annonce;
import java.io.IOException;
import service.AnnonceService;

import java.util.ArrayList;

public class annonceForm extends Form {


public annonceForm() throws IOException {
    super("Annonces");

    // Créer une nouvelle instance de Style
    Style s = UIManager.getInstance().getComponentStyle("Label");

    // Définir la police et la couleur de fond pour les titres
    //s.setFont(s.getFont().derive(Font.STYLE_BOLD, Font.SIZE_LARGE));
    s.setBgColor(0xFFFFFF, true);

    // Ajouter un conteneur pour les annonces
    Container annoncesContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    ArrayList<annonce> annonces = AnnonceService.getInstance().getAllAnnonces();

    // Parcourir les annonces et ajouter chaque annonce au conteneur
   // Obtenir le chemin absolu du dossier "public/uploads/images"
//String imagesDir = FileSystemStorage.getInstance().getAppHomePath() + "uploads/images";

// Parcourir les annonces et ajouter chaque annonce au conteneur
for (annonce a : annonces) {
    // Créer un nouveau conteneur pour chaque annonce
    Container annonceContainer = new Container(new BorderLayout());

    // Créer un EncodedImage à partir du chemin absolu de l'image
   

    // Ajouter le titre de l'annonce comme nom de l'utilisateur
    Label nomUtilisateur = new Label(a.getType());
    nomUtilisateur.setUIID("SideCommand");
    annonceContainer.add(BorderLayout.NORTH, nomUtilisateur);

    // Ajouter l'image de l'annonce
  
    Container imageContainer = new Container(new BorderLayout());
   

    // Ajouter la description de l'annonce comme contenu du post
    Label descriptionLabel = new Label(a.getDescription());
   // Label descriptionLabel = new Label(a.getDate_annonce());
    descriptionLabel.setUIID("Label");
    Container descriptionContainer = new Container(new BorderLayout());
    descriptionContainer.add(BorderLayout.CENTER, descriptionLabel);
    annonceContainer.add(BorderLayout.SOUTH, descriptionContainer);

    // Ajouter une séparation entre les annonces
    annonceContainer.getStyle().setBorder(Border.createLineBorder(1, 0xCCCCCC));

    // Ajouter le conteneur de l'annonce au conteneur des annonces
    annoncesContainer.add(annonceContainer);
}

// Ajouter le conteneur des annonces à la forme
add(annoncesContainer);

}

}