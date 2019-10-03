package models;
//
//import org.sql2o.Sql2o;
//
//public class DB {
////    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/organizationdb","nice", "12345");
//static String connectionString = "jdbc:postgresql://ec2-54-243-241-62.compute-1.amazonaws.com:5432/d1lv574h8farps"; //!
//    static Sql2o sql2o = new Sql2o(connectionString, "qofelinsoommau", "c7875150d0c8bd078c7f34a0d4ac249733267b0f41d1dab757601d1813014144"); //!
//}

import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;

    static {
        Logger logger = LoggerFactory.getLogger(DB.class);

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/organizationdb");
                logger.info("Using local database.");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }

            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "nice" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "12345" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {
            logger.error("Unable to connect to database.");
        }
    }
}