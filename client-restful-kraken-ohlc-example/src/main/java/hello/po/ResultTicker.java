package hello.po;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultTicker {
	
	@JsonProperty("XXBTZUSD")
	private Ticker XXBTZUSD;

	public Ticker getXXBTZUSD() {
		return XXBTZUSD;
	}

	public void setXXBTZUSD(Ticker xXBTZUSD) {
		XXBTZUSD = xXBTZUSD;
	}
	
	@Override
	public String toString() {
		/*
		 *      a = ask array(<price>, <whole lot volume>, <lot volume>),
    			b = bid array(<price>, <whole lot volume>, <lot volume>),
    			c = last trade closed array(<price>, <lot volume>),
		 */
		String askPrice = XXBTZUSD.getAsk()[0];
		String askVolume = XXBTZUSD.getAsk()[1];
		String askLot = XXBTZUSD.getAsk()[2];
		String bidPrice = XXBTZUSD.getBid()[0];
		String bidVolume = XXBTZUSD.getBid()[1];
		String bidLot = XXBTZUSD.getBid()[2];		
		
		
		return "ask price: "+askPrice+
				" ask volume: "+askVolume+
				" ask lot: "+askLot+
				" bid prie: "+bidPrice+
				" bid volume: "+bidVolume+
				" bid lot: "+bidLot;
				
		
	}


}
