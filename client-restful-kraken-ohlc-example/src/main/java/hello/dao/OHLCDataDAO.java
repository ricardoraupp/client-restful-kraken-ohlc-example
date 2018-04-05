package hello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.Application;
import hello.database.ConnectionFactory;
import hello.po.OHLCData;

public class OHLCDataDAO {
	private static final Logger log = LoggerFactory.getLogger(OHLCDataDAO.class);
	private Connection connection;  
	
	public OHLCDataDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	public void getConnection() {
		this.connection = ConnectionFactory.getConnection();
	}
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(OHLCData data, String table, String interval) {
		
        String sql = "INSERT INTO "+table+interval+" values(?,?,?,?,?,?,?,?)";  
        try {  
        	//log.info("FUCK");
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, Integer.parseInt(data.getTime()));
            stmt.setDouble(2, Double.parseDouble(data.getOpen()));
            stmt.setDouble(3, Double.parseDouble(data.getHigh()));
            stmt.setDouble(4, Double.parseDouble(data.getLow()));
            stmt.setDouble(5, Double.parseDouble(data.getClose()));
            stmt.setDouble(6, Double.parseDouble(data.getVwap()));
            stmt.setDouble(7, Double.parseDouble(data.getVolume()));
            stmt.setInt(8, Integer.parseInt(data.getCount()));
            stmt.execute();
            stmt.close();
            
            //connection.commit();
        } catch (SQLException u) {  
        	//log.info("erro U"+u.getMessage());
        	//u.printStackTrace();
        }
	}
}
