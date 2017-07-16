package com.beyondh.breakfast;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@SpringBootApplication
public class BreakfastApplication {

//	@RequestMapping("breakfast")
//	public String GetBreakfast()throws IOException
//	{
//		OkHttpClient client = new OkHttpClient();
//		Request request = new Request.Builder()
//				.url("http://localhost:31116/API/Breakfast/GetDailyAvailableBreakfast?occupationId=610966663036929")
//				.addHeader("Cookie","_ga=GA1.1.277922425.1499506613; CallDetect=Null; Shift=1; SessionId=52DE0EBA-D83C-4F2C-A2DA-A8C47EE89D5B; OwnerId=164-249-252-54-237-28-162-142-252-143-97-116-230-13-68-69; LoginOrgId=38-92-42-165-250-40-244-102-91-193-119-149-246-121-248-57; Token=0F5E103C-D1B7-4497-ADD4-2E0402EF600D; StorageKey=A8EEBAAFA8C33ABECA1DA3595E2F9503F0E853DC; IsShowByhHelp=true; tutorialAddress=http://tutorial.beyondh.com?r=; OperateOrgId=38-92-42-165-250-40-244-102-91-193-119-149-246-121-248-57")
//				.addHeader("Accept","application/json")
//				.build();
//		Response response = client.newCall(request).execute();
//		String cookie = response.header("Cookie");
//		System.out.println(cookie);
//		//String str = response.body().toString();
//		return response.body().string();
//	}
//
//	@RequestMapping("/")
//	public String GetBreakfast2()throws IOException {
//		OkHttpClient client = new OkHttpClient();
//		Request request = new Request.Builder()
//				.url("http://localhost:28303/api/test")
//				//.addHeader("Accept","application/json")
//				.build();
//		Response response = client.newCall(request).execute();
//		//String str = response.body().string();
//		return response.body().string();
//	}

	@RequestMapping("/")
	public String Breakfast() throws IOException {

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity) : null;
				} else {
					return String.valueOf(status);
				}
			}
		};
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet("http://localhost:31116/API/Breakfast/GetBreakfastInfo?Number=8339&SearchType=RoomNumber");
			httpGet.addHeader("Cookie","_ga=GA1.1.277922425.1499506613; CallDetect=Null; Shift=1; SessionId=52DE0EBA-D83C-4F2C-A2DA-A8C47EE89D5B; OwnerId=164-249-252-54-237-28-162-142-252-143-97-116-230-13-68-69; LoginOrgId=38-92-42-165-250-40-244-102-91-193-119-149-246-121-248-57; Token=0F5E103C-D1B7-4497-ADD4-2E0402EF600D; StorageKey=A8EEBAAFA8C33ABECA1DA3595E2F9503F0E853DC; IsShowByhHelp=true; tutorialAddress=http://tutorial.beyondh.com?r=; OperateOrgId=38-92-42-165-250-40-244-102-91-193-119-149-246-121-248-57");
			String responseBody = httpClient.execute(httpGet,responseHandler);
			return responseBody;
		}finally {
			httpClient.close();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(BreakfastApplication.class, args);
	}
}
