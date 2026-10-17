import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Menu[] daftarMenu = {
            new Menu("Nasi Kebuli", 30000, "Makanan"),
            new Menu("Bakso", 15000, "Makanan"),
            new Menu("Ayam Panggang", 45000, "Makanan"),
            new Menu("Ikan Bakar", 50000, "Makanan"),

            new Menu("Es teh", 5000, "Minuman"),
            new Menu("Teh Tarik", 10000, "Minuman"),
            new Menu("Air Mineral", 8000, "Minuman"),
            new Menu("Es Jeruk", 9000, "Minuman")
        };

        tampilkanMenu(daftarMenu);

        String[] pesanan = new String[4];
        int[] jumlah = new int[4];

        System.out.println("\nMasukan pesanan:");
        
        System.out.println("Pesanan 1: ");
        pesanan[0] = input.nextLine();
        System.out.println("Jumlah: ");
        jumlah[0] = input.nextInt();
        input.nextLine();

        System.out.println("Pesanan 2: ");
        pesanan[1] = input.nextLine();
        System.out.println("Jumlah: ");
        jumlah[1] = input.nextInt();
        input.nextLine();

        System.out.println("Pesanan 3: ");
        pesanan[2] = input.nextLine();
        System.out.println("Jumlah: ");
        jumlah[2] = input.nextInt();
        input.nextLine();

        System.out.println("Pesanan 4: ");
        pesanan[3] = input.nextLine();
        System.out.println("Jumlah: ");
        jumlah[3] = input.nextInt();
        
        hitungTotal(daftarMenu, pesanan, jumlah);
    }
    
    public static void tampilkanMenu(Menu[] daftarMenu) {
        System.out.println("=== Menu Makanan ===");
        for (Menu menu : daftarMenu) {
            if (menu.katagori.equals("Makanan")) {
                menu.tampilkanMenu();
            }
        }

        System.out.println("\n=== Menu Minuman ===");
        for (Menu menu : daftarMenu) {
            if ( menu.katagori.equals("Minuman")) {
                menu.tampilkanMenu();
            }
        }
    }

    public static void hitungTotal(Menu[] daftarMenu, String[] pesanan, int[] jumlah) {
        int total = 0;

        for (int i = 0; i < pesanan.length; i++) {
            for (Menu menu : daftarMenu) {
                if (pesanan[i].equalsIgnoreCase(menu.nama)) {
                    total += menu.harga * jumlah[i];

                }
            }
        }

        int diskon = 0;

        if(total > 100000) {
            diskon = total * 10 / 100;
        }

        int pajak = total * 10 / 100;
        int pelayan = 20000;

        int totalAkhir = total + pajak + pelayan - diskon;

        if (total > 50000) {
            System.out.println("\nPromo: Buy 1 Get 1 untuk salah satu makanan!");
        }

        System.out.println("\n=== STRUK PEMBAYARAN ===");
        System.out.println("Total Pesanan      : Rp" + total);
        System.out.println("Pajak 10%          : Rp" + pajak);
        System.out.println("Biaya Pelayanan    : Rp" + pelayan);
        System.out.println("Diskon             : Rp" + diskon);
        System.out.println("Total Bayar        : Rp" + totalAkhir);
    }
}
