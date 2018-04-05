package hello.po;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultETH {
	@JsonProperty("XETHZUSD")
	private String[][] XXBTZUSD;

	public String[][] getXXBTZUSD() {
		return XXBTZUSD;
	}

	public void setXXBTZUSD(String[][] xXBTZUSD) {
		XXBTZUSD = xXBTZUSD;
	}
	private int last;
	
	

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	@Override
	public String toString() {
		
		return XXBTZUSD.toString();
		
	}


}
