package it.dorosz.examples;

public enum Rate {
    BUYING("bid"), SELLING("ask");

    private String selectedRate;

    Rate(String rateType) {
        selectedRate = rateType;
    }

    public String getRate() {
        return selectedRate;
    }
}
