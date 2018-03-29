package hello.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)	

public class OHLCData {

	private String  time;
	private String open;
	private String high;
	private String low;
	private String close;
	private String vwap;
	private String volume;
	private String count;

	

	public OHLCData(String time, String open, String high, String low, String close, String vwap, String volume,
			String count) {
		super();
		this.time = time;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.vwap = vwap;
		this.volume = volume;
		this.count = count;
	}

	public OHLCData() {
		
	}

	@Override
	public String toString() {
		return "TIME: "+time+" OPEN: "+open+" HIGH: "+high+" LOW: "+low+" CLOSE: "+close+" VWAP: "+vwap+" VOLUME: "+volume+" COUNT: "+count;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
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



	public String getVwap() {
		return vwap;
	}



	public void setVwap(String vwap) {
		this.vwap = vwap;
	}



	public String getVolume() {
		return volume;
	}



	public void setVolume(String volume) {
		this.volume = volume;
	}



	public String getCount() {
		return count;
	}



	public void setCount(String count) {
		this.count = count;
	}

	
}
