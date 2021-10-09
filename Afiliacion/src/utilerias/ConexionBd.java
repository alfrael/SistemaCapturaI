/**
 * 
 */
package utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

import org.h2.tools.Server;

/**
 * @author JoseLuisE
 *
 */
public class ConexionBd {

	protected static String username = "alfrael";
	protected static String password = "sistemadecaptura";
	protected static String databaseUrl = "jdbc:h2:mem:sistemadecamptura";
	protected static Server server;
	
	public static void setUsername(String username) {
		ConexionBd.username = username;
	}

	public static void setPassword(String password) {
		ConexionBd.password = password;
	}

	public static void setConnectionUrl(String connectionUrl) {
		ConexionBd.databaseUrl = connectionUrl;
	}
	
	public static Connection createConnection() throws SQLException {
		TimeZone timeZone = TimeZone.getTimeZone("GMT+1:00");
		TimeZone.setDefault(timeZone);
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", username);
		connectionProps.put("password", password);
		connectionProps.put("serverTimezone","UTC");
		
		return DriverManager.getConnection(databaseUrl, connectionProps); 

	}
	
	public static Server iniciaConexionServidor() {
		try {
			server = Server.createTcpServer(new String[] {"-tcp","-tcpAllowOthers","-tcpPort","9001","-trace"});
			server.start();
			return server;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}