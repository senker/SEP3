package via.sep3.persistencetier.server;

import via.sep3.persistencetier.database.Seller;
import via.sep3.persistencetier.protobuf.CreateSellerResponse;

import java.sql.Connection;

public class DB {

    private static String dataUrl = "jdbc:postgresql://lucky.db.elephantsql.com:5432/boyasabw";
    private static String user = "boyasabw";
    private static String password = "JtcITVNLsyRU6P561d1trh4_1KHHiKeA";

    public static Seller createSeller(CreateSellerResponse seller){
        Connection conn = null;

    }
}
