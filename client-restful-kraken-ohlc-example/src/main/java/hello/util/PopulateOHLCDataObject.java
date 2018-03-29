package hello.util;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import hello.po.OHLCData;

public class PopulateOHLCDataObject {

	   public static ArrayList<OHLCData> deserialize(String[][] lista) throws IOException, JsonProcessingException {
	    	OHLCData cs ;
	        ArrayList<OHLCData> cList = new ArrayList<OHLCData>();
	        String[][] a = lista;
	        for(String[] a1 : a){
	            cs = new OHLCData();
	            cs.setTime(a1[0].toString());
	            cs.setOpen(a1[1].toString());
	            cs.setHigh(a1[2].toString());
	            cs.setLow(a1[3].toString());
	            cs.setClose(a1[4].toString());
	            cs.setVwap(a1[5].toString());
	            cs.setVolume(a1[6].toString());
	            cs.setCount(a1[7].toString());
	            		
	            cList.add(cs);
	        }
	             return cList;
	    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
