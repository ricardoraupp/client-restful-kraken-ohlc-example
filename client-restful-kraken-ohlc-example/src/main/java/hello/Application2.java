package hello;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import hello.po.ErrorTicker;
import hello.util.PopulateOHLCDataObject;

@SpringBootApplication
public class Application2 {

	private static final Logger log = LoggerFactory.getLogger(Application2.class);

	public static void main(String args[]) {
		SpringApplication.run(Application2.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			log.info("Start");
			String url = "https://api.kraken.com/0/public/Ticker?pair=XBTUSD";
			ResponseEntity<ErrorTicker> response = restTemplate.exchange(url, HttpMethod.GET,null, ErrorTicker.class);
			log.info("Finish: "+response.getBody().getResultTicker().toString());
			};	
	}
 

}