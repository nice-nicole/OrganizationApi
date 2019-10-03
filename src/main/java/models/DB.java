package models;

import org.sql2o.Sql2o;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/organizationdb","nice", "12345");
static String connectionString = "jdbc:postgresql://ec2-54-243-241-62.compute-1.amazonaws.com:5432/d1lv574h8farps"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "qofelinsoommau", "c7875150d0c8bd078c7f34a0d4ac249733267b0f41d1dab757601d1813014144"); //!
}