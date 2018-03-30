package hello.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * 
<pair_name> = pair name
a = ask array(<price>, <whole lot volume>, <lot volume>),
b = bid array(<price>, <whole lot volume>, <lot volume>),
c = last trade closed array(<price>, <lot volume>),
v = volume array(<today>, <last 24 hours>),
p = volume weighted average price array(<today>, <last 24 hours>),
t = number of trades array(<today>, <last 24 hours>),
l = low array(<today>, <last 24 hours>),
h = high array(<today>, <last 24 hours>),
o = today's opening price

*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

	@JsonProperty("a")
	private String[] ask;
	@JsonProperty("b")
	private String[] bid;
	@JsonProperty("c")
	private String[] last;
	@JsonProperty("v")
	private String[] volume;
	@JsonProperty("p")
	private String[] volumeWeightedAVGPrice;
	@JsonProperty("t")
	private String[] numberTrades;
	@JsonProperty("l")
	private String[] low;
	@JsonProperty("h")
	private String[] high;
	@JsonProperty("o")
	private String todayOpen;
	
	public String[] getAsk() {
		return ask;
	}
	public void setAsk(String[] ask) {
		this.ask = ask;
	}
	public String[] getBid() {
		return bid;
	}
	public void setBid(String[] bid) {
		this.bid = bid;
	}
	public String[] getLast() {
		return last;
	}
	public void setLast(String[] last) {
		this.last = last;
	}
	public String[] getVolume() {
		return volume;
	}
	public void setVolume(String[] volume) {
		this.volume = volume;
	}
	public String[] getVolumeWeightedAVGPrice() {
		return volumeWeightedAVGPrice;
	}
	public void setVolumeWeightedAVGPrice(String[] volumeWeightedAVGPrice) {
		this.volumeWeightedAVGPrice = volumeWeightedAVGPrice;
	}
	public String[] getNumberTrades() {
		return numberTrades;
	}
	public void setNumberTrades(String[] numberTrades) {
		this.numberTrades = numberTrades;
	}
	public String[] getLow() {
		return low;
	}
	public void setLow(String[] low) {
		this.low = low;
	}
	public String[] getHigh() {
		return high;
	}
	public void setHigh(String[] high) {
		this.high = high;
	}
	public String getTodayOpen() {
		return todayOpen;
	}
	public void setTodayOpen(String todayOpen) {
		this.todayOpen = todayOpen;
	}
	
	
	
}
