package DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	
	private String url;
    private String username;
    private String password;

    public DAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    
	/*Cette méthode garantit qu'une seule instance de DaoFactory est créée 
    et partagée dans toute l'application.
    
    Elle ne fournit pas directement une connexion à la base de données, mais elle fournit 
    une instance de DaoFactory à partir de laquelle on peut obtenir une connexion.
    */
    public static DAOFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DAOFactory instance = new DAOFactory(
                "jdbc:mysql://localhost:3306/cas", "root", "Root@2003");
        return instance;
    }
    

    /*Son rôle est d'obtenir une connexion à la base de données à partir de 
     l'instance de DaoFactory*/
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    
 // Récupération du Dao
    public userDAO getuserDao() {
        return new userDAOImp(this);
    }

}
