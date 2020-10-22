package pt.ulusofona.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import pt.ulusofona.java.model.ReadRDF;
import pt.ulusofona.java.model.readFile;
import pt.ulusofona.java.models.Hotel;
import pt.ulusofona.java.models.Restaurante;
import pt.ulusofona.java.models.Voo;

import java.io.IOException;
import java.util.HashMap;


@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static HashMap restaurante_map = new HashMap<String, Restaurante>();
    public static HashMap voos_map = new HashMap<String, Voo>();
    public static HashMap hotel_map = new HashMap<String, Hotel>();

    public static void main(String[] args) throws IOException {
        ReadRDF.read("restaurante");
        ReadRDF.read("voo");
        ReadRDF.read("hotel");
        SpringApplication.run(Application.class, args);
        while(true) {
            readFile.read();
        }
    }
}
