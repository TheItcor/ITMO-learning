public enum PeopleReaction {
    LAUGH("смех"),
    IGNORE("никто не обратил внимание на"),
    ANGER("гнев");

    private final String description;

    PeopleReaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
