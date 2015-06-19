package org.roommanager.utils;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiRoomManager {

	public static String createResource(String name, String displayName, String icon, String description) throws Exception {
		String url = ReadConfig.getBaseUrl() + "resources";
		String id="";
		String stringJson="{"+" \"name\": \""+ name +"\","+" \"customName\": \""+ displayName +"\","
		+ "\"fontIcon\": \""+ icon +"\","+ " \"from\": \"\","+ "\"description\": \""+ description +"\""+ "}";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try{
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(stringJson);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(json);
            JSONObject obj =(JSONObject)resultObject;
            id=obj.get("_id").toString();     
        } catch (Exception e) {	
        	Log.error("The resource was not createdd by API");
			throw(e);
        } 
		return id;
    }
	public static void deleteResource(String id) throws IOException {
		String url = ReadConfig.getBaseUrl()  + "resources/" + id;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
            HttpDelete request = new HttpDelete(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
        } catch (IOException e) {
        	Log.error("The resource was not deleted by API");
			throw(e);
        }
    }	
}
