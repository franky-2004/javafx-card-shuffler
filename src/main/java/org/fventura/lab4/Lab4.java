package org.fventura.lab4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Lab4 extends Application {

    // ImageViews to hold the 4 card images
    private final ImageView[] cardViews = new ImageView[4];

    // Label to display match result
    private final Label matchLabel = new Label();

    // Uses the Card class to draw and display 4 cards
    private void drawCards() {
        ArrayList<Card> pickedCards = Card.drawCards();

        // Display each card
        for (int i = 0; i < 4; i++) {
            int cardNumber = pickedCards.get(i).getNumber();
            Image cardImage = new Image(getClass().getResourceAsStream("/card/" + cardNumber + ".png"));
            cardViews[i].setImage(cardImage);
        }

        // Card matching logic
        boolean matchFound = false;
        for (int i = 0; i < pickedCards.size(); i++) {
            for (int j = i + 1; j < pickedCards.size(); j++) {
                if (pickedCards.get(i).getRank() == pickedCards.get(j).getRank()) {
                    matchFound = true;
                    break;
                }
            }
        }

        // Update label text based on match result
        if (matchFound) {
            matchLabel.setText("Match Found!");
        } else {
            matchLabel.setText("No match.");
        }
    }

    @Override
    public void start(Stage stage) {
        // Card display HBox
        HBox cardBox = new HBox(25);
        cardBox.setAlignment(Pos.CENTER);

        // Add 4 card slots
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(150);
            cardBox.getChildren().add(cardViews[i]);
        }

        // Refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> drawCards());

        // Layout
        VBox root = new VBox(10, cardBox, refreshButton, matchLabel);
        root.setAlignment(Pos.CENTER);

        drawCards(); // Show initial set of cards

        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.setTitle("Lab 4 - Card Display");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
