package pt.ulusofona.java.service;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparqlService {
    private String mService;


    //servico para usar a propia base de dados em SPARQL
    public List<List<String>> query(String query, String... vars) {
        List<List<String>> resultSet = new ArrayList<>();
        resultSet.add(new ArrayList<>(Arrays.asList(vars)));
        mService = "http://localhost:8890/sparql";

        QueryExecution e = QueryExecutionFactory.sparqlService(mService, query);
        ResultSet results = e.execSelect();

        while (results.hasNext()) {
            List<String> row = new ArrayList<>();
            QuerySolution sol = results.nextSolution();

            // get every var
            for (String var : vars) {
                RDFNode node = sol.get(var);
                if (var.equals("count"))
                    row.add(node.toString().split("\\^")[0]);
                else
                    row.add(node.toString());
            }
            resultSet.add(row);
        }
        return resultSet;
    }
}
