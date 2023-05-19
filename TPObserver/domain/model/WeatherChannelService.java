package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class WeatherChannelService implements ClimaOnline {

	@Override
	public String temperatura() {
		String apiKey = "533fae606f9160f15a04501706138a34";
		String tipoDeGrado = "metric";
		String temp = "";
		HttpURLConnection connection = null;

		try {
			// Construir la URL de la solicitud
			String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=" + apiKey + "&units="
					+ tipoDeGrado;
			URL url = new URL(apiUrl);

			// Crear una conexión HTTP
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Leer la respuesta
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Procesar la respuesta
			System.out.println(response.toString());

			String jsonString = response.toString();
			Gson gson = new GsonBuilder().create();
			var jsonObject = gson.fromJson(jsonString, JsonObject.class);
			temp = jsonObject.getAsJsonObject("main").getAsJsonObject().get("temp").toString();
			return temp;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return temp;

	}
}