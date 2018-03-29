package hello.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import hello.po.OHLCData;

public class CStickListDeserializer extends StdDeserializer<ArrayList<OHLCData>> { 

    public CStickListDeserializer() { 
        this(null); 
    } 

    public CStickListDeserializer(Class<?> c) { 
        super(c); 
    }

    @Override
    public ArrayList<OHLCData> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	OHLCData cs ;
        ArrayList<OHLCData> cList = new ArrayList<OHLCData>();
        String[][] a = jp.readValueAs(String[][].class);
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
}