public record News(Share share, boolean isHasPhotos) {
    public News(Share share, boolean isHasPhotos) {
        this.isHasPhotos = isHasPhotos;
        this.share = share;
    }

    public void publishNews() {
        System.out.println("Во всех газетах были напечатаны статьи, сообщавшие о том что...");
    }

    public void publishPhoto() {
        if (isHasPhotos) {
            System.out.println("Опубликованы фотографии, снятые в том момент, когда... ");
            People.revoltInStroke(share);
            People.demandMoney(share);
        } else {
            System.out.println("ЭПШТЕЙН НЕ УБИВАЛ СЕБЯ.");
        }
    }
}
