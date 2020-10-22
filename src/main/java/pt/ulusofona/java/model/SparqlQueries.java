package pt.ulusofona.java.model;

public class SparqlQueries {
    //Querys referentes a cada componente (hoteis, voos, restaurantes)
    //get restaurantes

    // get hoteis
    public static String getRestauranteQuery() {
        return  "PREFIX data:<http://example.org/data/>" +
                "SELECT ?restaurante ?cidade\n" +
                "WHERE{\n" +
                "  ?group a data:restaurante; data:cidade ?cidade .\n" +
                "}";
    }
    //get voos
    public static String getHotelQuery() {
        return "PREFIX data:<http://example.org/data/>" +
                "SELECT ?hotel ?cidade\n" +
                "WHERE{\n" +
                "  ?group a data:hotel; data:cidade ?cidade .\n" +
                "}";
    }

    public static String getVooQuery() {
      return  "PREFIX data:<http://example.org/data/>" +
              "SELECT ?voo ?cidade\n" +
              "WHERE{\n" +
              "  ?group a data:voo; data:cidade ?cidade .\n" +
              "}";
    }
}
