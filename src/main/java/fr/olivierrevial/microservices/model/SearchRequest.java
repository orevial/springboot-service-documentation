package fr.olivierrevial.microservices.model;

import java.util.List;

public class SearchRequest {
    private String searchWord;
    private List<String> categories;
    private List<String> facets;
    private int nbResults;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getFacets() {
        return facets;
    }

    public void setFacets(List<String> facets) {
        this.facets = facets;
    }

    public int getNbResults() {
        return nbResults;
    }

    public void setNbResults(int nbResults) {
        this.nbResults = nbResults;
    }
}
