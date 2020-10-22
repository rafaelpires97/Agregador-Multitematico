package pt.ulusofona.java.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pt.ulusofona.java.models.Hotel;
import pt.ulusofona.java.models.Restaurante;
import pt.ulusofona.java.models.Voo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static pt.ulusofona.java.Application.*;

public class ReadRDF {

    public static void readRestaurantes(NodeList nodeList) {
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String cidade = eElement.getElementsByTagName("cidade").item(0).getTextContent();
                String rua = eElement.getElementsByTagName("rua").item(0).getTextContent();
                String codepostal = eElement.getElementsByTagName("codpostal").item(0).getTextContent();
                String especialidade = eElement.getElementsByTagName("especialidade").item(0).getTextContent();
                Restaurante restaurante = new Restaurante(id, name, cidade, rua, codepostal, especialidade);
                restaurante_map.put(cidade, restaurante);
            }
        }
    }


    public static void readHotel(NodeList nodeList) {
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String cidade = eElement.getElementsByTagName("cidade").item(0).getTextContent();
                String rua = eElement.getElementsByTagName("rua").item(0).getTextContent();
                String codepostal = eElement.getElementsByTagName("codpostal").item(0).getTextContent();
                int preco = Integer.parseInt(eElement.getElementsByTagName("preco").item(0).getTextContent());
                int estrelas = Integer.parseInt(eElement.getElementsByTagName("estrelas").item(0).getTextContent());
                String tipo = eElement.getElementsByTagName("tipo").item(0).getTextContent();
                Hotel hotel = new Hotel(id, name, cidade, rua, codepostal, preco, estrelas, tipo);
                hotel_map.put(cidade, hotel);
            }
        }
    }


    public static void readVoos(NodeList nodeList) {
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                String hora_partida = eElement.getElementsByTagName("hora_partida").item(0).getTextContent();
                String origem = eElement.getElementsByTagName("origem").item(0).getTextContent();
                String hora_chegada = eElement.getElementsByTagName("hora_chegada").item(0).getTextContent();
                String destino = eElement.getElementsByTagName("destino").item(0).getTextContent();
                boolean escalas = Boolean.parseBoolean(eElement.getElementsByTagName("escalas").item(0).getTextContent());
                int classe = Integer.parseInt(eElement.getElementsByTagName("classe").item(0).getTextContent());
                int preco = Integer.parseInt(eElement.getElementsByTagName("preco").item(0).getTextContent());
                String dia_partida= eElement.getElementsByTagName("dia_partida").item(0).getTextContent();
                String dia_chegada = eElement.getElementsByTagName("dia_chegada").item(0).getTextContent();
                Voo voo = new Voo(id, hora_partida, origem, hora_chegada, destino, escalas, classe, preco,dia_partida, dia_chegada);
                voos_map.put(origem + "_" + destino, voo);
            }
        }
    }

    public static void read(String tipo) {
        try {
//creating a constructor of file class and parsing an XML file
            File file = new File("src" + File.separator + "main" + File.separator + "java" + File.separator + "pt" + File.separator + "ulusofona" + File.separator + "java" + File.separator + "recurso" + File.separator + "another.xml");
//an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(tipo);
            switch (tipo) {
                case "restaurante":
                    readRestaurantes(nodeList);
                    break;
                case "hotel":
                    readHotel(nodeList);
                    break;
                case "voo":
                    readVoos(nodeList);
                    break;
                default:
                    System.out.println("NOT FOUND");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

