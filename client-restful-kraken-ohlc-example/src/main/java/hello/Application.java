package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import hello.po.Error;
import hello.po.OHLCData;
import hello.util.PopulateOHLCDataObject;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			/*
			ResponseEntity<Result> error = restTemplate.getForEntity("https://api.kraken.com/0/public/OHLC?pair=XBTUSD", Result.class);
					//"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
					//"https://api.kraken.com/0/public/Time", Error.class);
					//"https://api.kraken.com/0/public/OHLC?pair=XBTUSD", Error.class);
			log.info("FUCK "+error.getBody().toString());
			
			ResponseEntity<List<Result>> rateResponse =
			        restTemplate.exchange("https://api.kraken.com/0/public/OHLC?pair=XBTUSD",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Result>>() {
			            });
			List<Result> rates = rateResponse.getBody();
			*/
			ParameterizedTypeReference<Map<String, List<OHLCData>>> typeRef = new ParameterizedTypeReference<Map<String, List<OHLCData>>>() {};
			String url = "https://api.kraken.com/0/public/OHLC?pair=XBTUSD";
			//ResponseEntity<Map<String, List<OHLCData>>> response = restTemplate.exchange(url, HttpMethod.GET, null, typeRef);
			ResponseEntity<Error> response = restTemplate.exchange(url, HttpMethod.GET,null, Error.class);
			//List resulte = response.getBody();
			//String tmp = response.getBody()getResult().toString();
			
			//response.getBody().getResult().getXXBTZUSD().forEach(new OHLCData());
	        //List<List<String>> csvList = response.getBody().getResult().getXXBTZUSD();
			/*
	        //pretend you're looping through lines in a file here
	        for(int i = 0; i < csvList.size(); i++)
	        {
	            List<String> csvPieces = csvList.get(i);
	            System.out.println("FOR: "+csvPieces.toString());
	            for(int j = 0; j < csvPieces.size(); j++)
	            {
	            	System.out.println("FOR DO FOR: "+csvPieces.get(j));
	            }
	            //csvList.add(csvPieces);
	        }
			//OHLCData lista = response.getBody().getResult().getXXBTZUSD().get(0)
			*/
			ArrayList<OHLCData> cList = PopulateOHLCDataObject.deserialize(response.getBody().getResult().getXXBTZUSD());
			cList.forEach(ohlcdata->System.out.println(ohlcdata.toString()));
			//log.info(response.getBody().toString());
			};	
	}
 

}