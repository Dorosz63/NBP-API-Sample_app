package it.dorosz.examples;


import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class JSONOperations {

    private JSONObject receivedJSON;

    public float[] getBidsOrAsks (String Rate) throws IOException {
        while(receivedJSON == null) {
            receivedJSON = getJSON(buildURL(new Menu().getInputData()));
        }
        float[] rates = new float[receivedJSON.getJSONArray("rates").length()];
        for(int i = 0; i < rates.length; i++) {
            rates[i] = receivedJSON.getJSONArray("rates").getJSONObject(i).getFloat(Rate);
        }
        return rates;
    }

    private URL buildURL(String inputData) throws MalformedURLException {

        StringBuilder builder = new StringBuilder();
        builder.append("http://api.nbp.pl/api/exchangerates/rates/c/");
        builder.append(inputData);
        builder.append("/?format=json");

        return new URL(builder.toString());
    }

    private JSONObject getJSON(URL buildedURL) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)buildedURL.openConnection();
        connection.setRequestMethod("GET");

        try {
            connection.connect();
            if (connection.getResponseCode() == 200) {
                Scanner scan = new Scanner(buildedURL.openStream());
                String jsonAsString = new String();
                while (scan.hasNext())
                    jsonAsString += scan.nextLine();
                scan.close();
                connection.disconnect();
                return new JSONObject(jsonAsString);
            } else {
                connection.disconnect();
                System.out.println("Bad input data. Try again.");
                new Menu().readUserInput();
                return null;
            }
        } catch(UnknownHostException exception) {
            System.out.println("Server connection error. Try again.");
            new Menu().readUserInput();
            return null;
        }
    }
}
