import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class base {
    public base() {
    }
    public Document verificar(String usuario, String contraseña) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase data = mongoClient.getDatabase("Estudiantes");
        MongoCollection<Document> Poo = data.getCollection("Poo");
        Document query = new Document("correo", usuario).append("contraseña", contraseña);
        Document estudiante = Poo.find(query).first();
        return estudiante;
    }
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase data = mongoClient.getDatabase("Estudiantes");
        MongoCollection<Document> Poo = data.getCollection("Poo");

        //Insertar datos a mongo DB
        Document[] estudiantes= new Document[2];
        Scanner variable = new Scanner(System.in);
        for(int i=0;i<estudiantes.length;i++){
            Map<String, String> estudiante = new HashMap<String, String>();
            System.out.println("Ingrese el nombre del estudiante");
            estudiante.put("nombre", variable.nextLine());
            System.out.println("Ingrese el apellido del estudiante");
            estudiante.put("apellido", variable.nextLine());
            System.out.println("Ingrese la edad del estudiante");
            estudiante.put("edad", variable.nextLine());
            System.out.println("Ingrese la ciudad del estudiante");
            estudiante.put("ciudad", variable.nextLine());
            System.out.println("Ingrese su correo electronico");
            estudiante.put("correo", variable.nextLine());
            System.out.println("Ingrese su contraseña");
            estudiante.put("contraseña", variable.nextLine());
            System.out.println("Biografia del estudiante");
            estudiante.put("biografia", variable.nextLine());
            estudiantes[i]=new Document(estudiante);
        }
        Poo.insertMany(Arrays.asList(estudiantes));
        variable.close();
    }
}