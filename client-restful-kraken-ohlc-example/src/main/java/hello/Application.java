package hello;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import hello.dao.OHLCDataDAO;
import hello.database.ConnectionFactory;
import hello.po.ErrorETH;
import hello.po.ErrorXBT;
import hello.po.OHLCData;
import hello.util.PopulateOHLCDataObject;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
    String lastETH = "0000000000";
    String lastXBT = "0000000000";
    
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
			
				OHLCDataDAO conn = new OHLCDataDAO();
				int delay = 1000;   // delay de 1 seg.
			    int interval = 120000;  // intervalo de 120 seg.
			    Timer timer = new Timer();

			    timer.scheduleAtFixedRate(new TimerTask() {
			            public void run() {
			            	try {
			            		
				    			log.info("Start ETH");
				    			String intervalETH = "15";
				    			String tableETH = "ethusd";
				    			log.info("LAST ETH FIRST "+lastETH);
				    			String urlETH = "https://api.kraken.com/0/public/OHLC?pair=ETHUSD&interval="+intervalETH+"&since="+lastETH;
				    			ResponseEntity<ErrorETH> responseETH = restTemplate.exchange(urlETH, HttpMethod.GET,null, ErrorETH.class);
				    			ArrayList<OHLCData> cListETH;
				    			cListETH = PopulateOHLCDataObject.deserialize(responseETH.getBody().getResult().getXXBTZUSD());
				    			lastETH = responseETH.getBody().getResult().getLast()+"";
				    			log.info("LAST ETH "+lastETH);
				    			log.info("XBT COUNT "+cListETH.size());
				    			cListETH.forEach(ohlcdata->conn.insert(ohlcdata,tableETH,intervalETH));
				    			//cList.forEach(ohlcdata->System.out.println(ohlcdata.getClose()));
				    			//cList.forEach(ohlcdata->OHLCDataDAO.insert(ohlcdata))
				    			log.info("Finish");
				    			
				    			log.info("Start XBT");
				    			String intervalXBT = "15";
				    			String tableXBT = "xbtusd";
				    			log.info("LAST XBT FIRST "+lastXBT);
				    			String urlXBT = "https://api.kraken.com/0/public/OHLC?pair=XBTUSD&interval="+intervalXBT+"&since="+lastXBT;
				    			ResponseEntity<ErrorXBT> responseXBT = restTemplate.exchange(urlXBT, HttpMethod.GET,null, ErrorXBT.class);
				    			ArrayList<OHLCData> cListXBT = PopulateOHLCDataObject.deserialize(responseXBT.getBody().getResult().getXXBTZUSD());			
				    			//OHLCDataDAO connXBT = new OHLCDataDAO();
				    			lastXBT = responseXBT.getBody().getResult().getLast()+"";
				    			log.info("LAST XBT "+lastXBT);
				    			log.info("XBT COUNT "+cListXBT.size());
				    			cListXBT.forEach(ohlcdata->conn.insert(ohlcdata,tableXBT,intervalXBT));
				    			
				    			//cList.forEach(ohlcdata->System.out.println(ohlcdata.getClose()));
				    			//cList.forEach(ohlcdata->OHLCDataDAO.insert(ohlcdata))
				    			log.info("Finish");
			            	}catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
							}	
			            }
			        }, delay, interval);
			    
			    //conn.closeConnection();
			};	
	}

}