package io.github.sly321.viewcachu.datasync.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import io.github.sly321.viewcachu.datasync.service.TheTvDatabaseApiWrapper;

public class TheTvDatabaseApiWrapperImpl implements TheTvDatabaseApiWrapper {

	private String API_KEY = "ADD API KEY HERE <3";

	@Override
	public void getSerieById(int id) {
		String urlString = API_URL + API_KEY + "/series/" + id + "/" + LANG_KEY;
		requestUrl(urlString);
	}

	@Override
	public void findSerieByName(String name) {
		String urlString = "";
		try {
			urlString = API_URL + BY_NAME + URLEncoder.encode(name, "UTF-8") + LANG_PARAM;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		requestUrl(urlString);
	}

	private void requestUrl(String urlString) {
		try {

			URL url = new URL(urlString);
			System.out.println("URL: " + url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
