package com.example.assignment2javafx;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class HelloController {
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> resultListView;

    @FXML
    protected void handleButtonAction() {
        String cityName = inputField.getText();
        fetchWeatherInfo(cityName);
    }

    private void fetchWeatherInfo(String cityName) {
        String url = String.format("https://api.open-meteo.com/v1/forecast?latitude=43.7&longitude=-79.42&hourly=temperature_2m", cityName);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(this::parseJsonAndUpdateUI)
                .exceptionally(e -> {
                    displayError("Failed to fetch data: " + e.getMessage());
                    return null;
                });
    }

    private void parseJsonAndUpdateUI(String responseBody) {
        System.out.println("Response Body: " + responseBody);  // Print the JSON response for inspection

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

        if (jsonObject.has("hourly")) {
            JsonObject hourly = jsonObject.getAsJsonObject("hourly");
            if (hourly.has("temperature_2m")) {
                String temperature = hourly.get("temperature_2m").getAsJsonArray().get(0).getAsString();
                updateUI("Temperature: " + temperature + " °C");
                return;
            }
        }

        displayError("Could not find temperature data in the response.");
    }

    private void updateUI(String weatherInfo) {
        resultListView.getItems().setAll(weatherInfo);
    }

    private void displayError(String errorMessage) {
        resultListView.getItems().setAll(errorMessage);
    }
}
