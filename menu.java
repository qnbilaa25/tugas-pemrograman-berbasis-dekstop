public class Menu {
    String nama;
    int harga;
    String katagori;

    public Menu(String nama, int harga, String katagori) {
        this.nama = nama;
        this.harga = harga;
        this.katagori = katagori;
    }
    public void tampilkanMenu() {
        System.out.println(nama + " - Rp" + harga + " (" + katagori + ")");
    }
}
