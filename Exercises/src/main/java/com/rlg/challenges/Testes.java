package com.rlg.challenges;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.rlg.challenges.OpenClosePricesChallengeSolution.Data;

public class Testes {

    class Result {
    	
    	@SerializedName("page")
       	private String page;
    	@SerializedName("per_page")
    	private String per_page;
    	@SerializedName("total")
    	private String total;
    	@SerializedName("total_pages")
    	private String total_pages;
    	@SerializedName("data")
    	private List<Data> data;

    	public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public String getPer_page() {
			return per_page;
		}
		public void setPer_page(String per_page) {
			this.per_page = per_page;
		}
		public String getTotal() {
			return total;
		}
		public void setTotal(String total) {
			this.total = total;
		}
		public String getTotal_pages() {
			return total_pages;
		}
		public void setTotal_pages(String total_pages) {
			this.total_pages = total_pages;
		}
		public List<Data> getData() {
			return data;
		}
		public void setData(List<Data> data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Result [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
					+ total_pages + ", data=" + data.toString() + "]";
		}
    }
    
    class Data {
    	@SerializedName("date")
    	private String date;
    	@SerializedName("open")
    	private String open;
    	@SerializedName("high")
    	private String high;
    	@SerializedName("low")
    	private String low;
    	@SerializedName("close")
    	private String close;
    	
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getOpen() {
			return open;
		}
		public void setOpen(String open) {
			this.open = open;
		}
		public String getHigh() {
			return high;
		}
		public void setHigh(String high) {
			this.high = high;
		}
		public String getLow() {
			return low;
		}
		public void setLow(String low) {
			this.low = low;
		}
		public String getClose() {
			return close;
		}
		public void setClose(String close) {
			this.close = close;
		}
		@Override
		public String toString() {
			return "Data [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
					+ "]";
		}
    }

	public static void main (String args[]) {

//		List<String> dates = new ArrayList<String>();
//		
//		dates.add("20th Oct 2052");
//		dates.add("6th Jun 1933");
//		dates.add("26th May 1960");
//		dates.add("20th Sep 1958");
//		dates.add("16th Mar 2068");
//		dates.add("25th May 1912");
//		dates.add("16th Dec 2018");
//		dates.add("26th Dec 2061");
//		dates.add("4th Nov 2030");
//		dates.add("28th Jul 1963");
//		
//		List<String> datesListResult = new ArrayList<String>();
//	
//		for(String source : dates) {
//
//			//System.out.println("Source: "+source);
//			
//			String dateParts[] = source.split(" ");
//			String day = dateParts[0];
//			day = day.substring(0, day.length()-2);
//			String month = dateParts[1];
//			String year = dateParts[2];
//
//			String date1 = day + " " + month + " " + year;
//			//System.out.println("Date1: "+date1);
//			
//			SimpleDateFormat sdf1 = new SimpleDateFormat("d MMM yyyy", Locale.US);
//			
//			Date dateObj = null;
//			try {
//				dateObj = sdf1.parse(date1);
//				//System.out.println("DateObj: "+dateObj);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//
//			String dateResult = sdf2.format(dateObj);
//			
//			datesListResult.add(dateResult);
//			
//			System.out.println(source + " - " + dateResult);
//			
//		}
		
//		try {
//			URL url = new URL("https://jsonmock.hackerrank.com/api/stocks");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");
//			
//			if(connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//				throw new Exception("Erro ao disparar a URL");
//			}
//			
//			BufferedReader responseStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			
//			StringBuffer response = new StringBuffer();
//			
//			String line = responseStream.readLine();
//			while(line != null) {
//				response.append(line);
//				line = responseStream.readLine();
//			}
//			responseStream.close();
//			
//            Result result = new Gson().fromJson(String.valueOf(response), Result.class);
//            
////            System.out.println("Page: ["+result.getPage()+"]");
////            System.out.println("Per_Page: ["+result.getPer_page()+"]");
////            System.out.println("Total: ["+result.getTotal()+"]");
////            System.out.println("Total_pages: ["+result.getTotal_pages()+"]");
////            System.out.println("Data: ["+result.getData()+"]");
//            
//            
//
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.US);
		
		try {
			System.out.println(sdf.format(sdf.parse("1-January-2000")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int[] num = {1,0,0,1,0};
		
		Arrays.asList(num);
		List<Integer> test = new ArrayList<Integer>();
		
		
		
	}
}
