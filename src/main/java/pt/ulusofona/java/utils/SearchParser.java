package pt.ulusofona.java.utils;

import pt.ulusofona.java.models.Hotel;
import pt.ulusofona.java.models.Restaurante;
import pt.ulusofona.java.models.Voo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static pt.ulusofona.java.Application.*;

public class SearchParser {

    public static ArrayList voos = new ArrayList<Voo>();
    public static ArrayList restaurante = new ArrayList<Restaurante>();
    public static ArrayList hotel = new ArrayList<Hotel>();

    public static String parseSearch(String q) {
        if (q.contains("restaurante") || q.contains("esplanada") || q.contains("café") || q.contains("tasca")
                || q.contains("Restaurante") || q.contains("Esplanada") || q.contains("Café") || q.contains("Tasca"))
            return "restaurante"; // correr uma query
        if (q.contains("Voo") || q.contains("voo"))
            return "voo"; // correr outra query
        if (q.contains("Hotel") || q.contains("Hoteis") || q.contains("Apartamento") || q.contains("Moradia") || q.contains("Apartamentos") || q.contains("Moradias")
                || q.contains("hotel") || q.contains("hoteis") || q.contains("apartamento") || q.contains("moradia") || q.contains("apartamentos") || q.contains("moradias"))
            return "hotel";// correr outra query
        return "";
    }

    public static String parseSearchDate(String q) {
        String[] currencies = q.split(" ");
        return currencies[currencies.length - 1 - 3];
    }


    public static String parseCidade(String q) {
        if (q.contains("Coimbra") || q.contains("coimbra"))
            return "Coimbra"; // correr uma query
        if (q.contains("Lisboa") || q.contains("lisboa"))
            return "Lisboa"; // correr uma query
        if (q.contains("Paris") || q.contains("paris"))
            return "Paris"; // correr uma query
        return "";
    }


    public static int result(String q) {
        String tipoServico = parseSearch(q);
        String cidade = parseCidade(q);
        switch (tipoServico) {
            case "voo": {
                Iterator iterator = voos_map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    if (me2.getKey() == cidade) {
                        String day = parseSearchDate(q);
                        Voo vootemp = (Voo) me2.getValue();
                        if (vootemp.getHora_chegada().equals(day)) {
                            voos.add(vootemp);
                        }
                    }
                }
                return 1;
            }
            case "restaurante": {
                Iterator iterator = restaurante_map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    if (me2.getKey() == cidade) {
                        Restaurante restaurantetemp = (Restaurante) me2.getValue();
                        restaurante.add(restaurantetemp);
                    }
                }
                return 2;
            }
            case "hotel": {
                Iterator iterator = hotel_map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry me2 = (Map.Entry) iterator.next();
                    if (me2.getKey() == cidade) {
                        Hotel hoteltemp = (Hotel) me2.getValue();
                        restaurante.add(hoteltemp);
                    }
                }
                return 3;
            }
            default:
                System.out.println("No more results");
                return 0;
        }
    }

    public static ArrayList<String> start(String q) {
        int tipo =result(q);
        ArrayList<String> listaApassar = new ArrayList<String>();
        switch (tipo){
            case 0:
                listaApassar.add("");
            case 1:
                listaApassar=vooToString();
                break;
            case 2:
                listaApassar=restauranteToString();
                break;
            case 3:
                listaApassar=hotelToString();
                break;
        }

        return listaApassar;
    }


    public static ArrayList<String> restauranteToString(){
        ArrayList<String> novo = new ArrayList<>();
        for (int i = 0; i <restaurante.size(); i++) {
            novo.add((String) restaurante.get(i).toString());
        }
        return novo;
    }

    public static ArrayList<String> vooToString(){
        ArrayList<String> novo = new ArrayList<>();
        for (int i = 0; i <voos.size(); i++) {
            novo.add((String) voos.get(i).toString());
        }
        return novo;
    }

    public static ArrayList<String> hotelToString(){
        ArrayList<String> novo = new ArrayList<>();
        for (int i = 0; i <hotel.size(); i++) {
            novo.add((String) hotel.get(i).toString());
        }
        return novo;
    }


}
