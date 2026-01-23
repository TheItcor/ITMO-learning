public enum Currency {
    FERTINGS("Фертингов"),
    SANTIC("Сантиков");

    private final String name;

    public String getName() {
        return name;
    }
    
    Currency(String name) {
        this.name = name;
    }

    public static Currency getCurrency(double value) {
        if (value < 1) {
            return FERTINGS;
        } else {
            return SANTIC;
        }
    }

    
}