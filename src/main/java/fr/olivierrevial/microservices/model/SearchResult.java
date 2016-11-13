package fr.olivierrevial.microservices.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private int nbResults;
    private long took;
    private List<ProductResult> productsFound = new ArrayList<>();

    public int getNbResults() {
        return nbResults;
    }

    public void setNbResults(int nbResults) {
        this.nbResults = nbResults;
    }

    public long getTook() {
        return took;
    }

    public void setTook(long took) {
        this.took = took;
    }

    public List<ProductResult> getProductsFound() {
        return productsFound;
    }

    public void setProductsFound(List<ProductResult> productsFound) {
        this.productsFound = productsFound;
    }
}
