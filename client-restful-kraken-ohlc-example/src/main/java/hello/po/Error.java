package hello.po;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.tools.javac.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {
	
	private String[] error;
	private Result result;

	
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
    public String toString() {
        return "Error{" +
                "error=" + error +
                ", result='" + result.toString() + '\'' +
                '}';
    }
	
}
