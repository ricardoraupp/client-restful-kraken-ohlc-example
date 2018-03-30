package hello.po;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.javac.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorTicker {
	
	private String[] error;
	@JsonProperty("result")
	private ResultTicker resultTicker;

	
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public ResultTicker getResultTicker() {
		return resultTicker;
	}
	public void setResultTicker(ResultTicker resultTicker) {
		this.resultTicker = resultTicker;
	}
	
    public String toString() {
        return "Error{" +
                "error=" + error +
                ", result='" + resultTicker.toString() + '\'' +
                '}';
    }
	
}
