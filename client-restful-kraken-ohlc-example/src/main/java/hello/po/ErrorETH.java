package hello.po;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.javac.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorETH {
	
	private String[] error;
	@JsonProperty("result")
	private ResultETH result;

	
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public ResultETH getResult() {
		return result;
	}
	public void setResult(ResultETH result) {
		this.result = result;
	}
	
    public String toString() {
        return "Error{" +
                "error=" + error +
                ", result='" + result.toString() + '\'' +
                '}';
    }
	
}
