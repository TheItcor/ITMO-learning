public enum PeopleReaction {
    LAUGH("смех"),
    IGNORE("пофик"),
    ANGER("гнев");

    private final String description;

    PeopleReaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void getReaction(Share share) {
        if (this != IGNORE) {
            System.out.println(share.getName() + " вызывает " + this.getDescription() + " у толпы");
        } else {
            System.out.println("Всем плевать на " + share.getName());
        }
    }
}
