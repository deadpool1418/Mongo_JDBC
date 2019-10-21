package mongodb;
import com.mongodb.MongoClient;  
import com.mongodb.client.*;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Scanner;
import org.bson.Document;
import java.util.*;
public class mongo {
	public static void main(String args[]) {
		MongoClient mongo=new MongoClient("localhost",27017);
		MongoDatabase dbDatabase=mongo.getDatabase("mydb");
		Scanner scanner=new Scanner(System.in);
		int ch=0;
		while(true) {
			System.out.println("Menu");
			System.out.println("Database and collection is already created");
			System.out.println("1.Add Records");
			System.out.println("2.Read Records");
			System.out.println("3.Update Records");
			System.out.println("4.Delete Records");
			ch=scanner.nextInt();
			MongoCollection<Document> collection=dbDatabase.getCollection("sample");
			switch(ch) {
				case 1:
					int roll;
					int marks;
					roll=scanner.nextInt();
					marks=scanner.nextInt();
					Document document=new Document();
					document.append("Roll", roll);
					document.append("Marks", marks);
					collection.insertOne(document);
					break;
				case 2:
					MongoCollection<Document> collection1=dbDatabase.getCollection("sample");
					FindIterable<Document> it=collection1.find();
					Iterator itr=it.iterator();
					while(itr.hasNext()) {
						System.out.println(itr.next());
					}
					break;
				case 3:
					MongoCollection<Document> collection2=dbDatabase.getCollection("sample");
					System.out.println("Enter the filtering field(roll)");
					int r=scanner.nextInt();
					System.out.println("Enter the updated marks");
					int m=scanner.nextInt();
					collection2.updateOne(Filters.eq("Roll",r), Updates.set("Marks", m));
					break;
				case 4:
					MongoCollection<Document> collection3=dbDatabase.getCollection("sample");
					System.out.println("Enter roll no to be deleted");
					int ro=scanner.nextInt();
					collection3.deleteOne(Filters.eq("Roll",ro));
			}
		}
		
				}
}
 	 	        