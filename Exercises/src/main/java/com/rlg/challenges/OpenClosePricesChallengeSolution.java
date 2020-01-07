package com.rlg.challenges;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class OpenClosePricesChallengeSolution {

	 /*
     * Complete the function below.
     */
    static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {

		try {
			
			URL url = new URL("https://jsonmock.hackerrank.com/api/stocks");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			if(connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("URL connection error: " + connection.getResponseCode());
			}
			
			BufferedReader	responseStream	= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer	response 		= new StringBuffer();			

			String 			line			= responseStream.readLine();
			while(line != null) {
			
				response.append(line);
				line = responseStream.readLine();
			}
			
			responseStream.close();
			
            Result result = new Gson().fromJson(String.valueOf(response), Result.class);
            
            SimpleDateFormat sdf 			= new SimpleDateFormat("dd-MMMM-yyyy", Locale.US);
            SimpleDateFormat sdfWeekDayName	= new SimpleDateFormat("EEEE", Locale.US);
            
            Calendar calendarFirstDate	= Calendar.getInstance(Locale.US);
            calendarFirstDate.setTime(sdf.parse(firstDate));
            
            Calendar calendarLastDate	= Calendar.getInstance(Locale.US);
            calendarLastDate.setTime(sdf.parse(lastDate));
            
            for (Data data : result.getData()) {

            	Calendar calendarDataDate = Calendar.getInstance(Locale.US);
            	calendarDataDate.setTime(sdf.parse(data.getDate()));
            	
            	if(calendarDataDate.after(calendarFirstDate) && calendarDataDate.before(calendarLastDate)) {
            		
            		String dataWeekDayName = sdfWeekDayName.format(calendarDataDate.getTime());
            	
            		if(dataWeekDayName.equals(weekDay)) {
            			System.out.println(data.getDate() + " " + data.getOpen() + " " + data.getClose());
            		}
            	}
            }
		} catch (Exception e) {
			System.out.println("Error while processing prices: " + e.getMessage());
		}
    }
    
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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _firstDate;
        try {
            _firstDate = in.nextLine();
        } catch (Exception e) {
            _firstDate = null;
        }
        
        String _lastDate;
        try {
            _lastDate = in.nextLine();
        } catch (Exception e) {
            _lastDate = null;
        }
        
        String _weekDay;
        try {
            _weekDay = in.nextLine();
        } catch (Exception e) {
            _weekDay = null;
        }
        
        openAndClosePrices(_firstDate, _lastDate, _weekDay);
        
    }
}
