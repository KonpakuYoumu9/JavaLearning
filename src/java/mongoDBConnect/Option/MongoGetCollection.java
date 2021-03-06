package mongoDBConnect.Option;

/***Created by moyongzhuo
 *On 2017/10/11  ***20:12.
 ******/
        import org.bson.Document;
        import com.mongodb.MongoClient;
        import com.mongodb.client.MongoCollection;
        import com.mongodb.client.MongoDatabase;

public class MongoGetCollection {
    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("javadb");
            System.out.println("集合 errorlog 选择成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}