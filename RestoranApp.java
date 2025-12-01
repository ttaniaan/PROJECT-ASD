import java.util.Scanner;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MenuManager manager = new MenuManager();

        while (true) {
            System.out.println("\n=== MENU RESTORAN ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Semua Menu");
            System.out.println("3. Sorting Harga (Selection Sort)");
            System.out.println("4. Cari Menu (Linear Search Nama)");
            System.out.println("5. Cari Menu (Binary Search Harga)");
            System.out.println("6. Hitung Total Harga (Rekursi)");
            System.out.println("0. Exit");
            System.out.print("Pilih: ");

            int pilihan = input.nextInt();
            input.nextLine(); // buffer

            switch (pilihan) {
                case 1:
                    System.out.print("ID Menu: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Menu: ");
                    String nama = input.nextLine();

                    System.out.print("Harga: ");
                    double harga = input.nextDouble();

                    manager.addMenu(new MenuItem(id, nama, harga));
                    System.out.println("Menu berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n=== DAFTAR MENU ===");
                    for (MenuItem m : manager.getAllMenus()) {
                        System.out.println(m);
                    }
                    break;

                case 3:
                    manager.sortByHargaSelection();
                    System.out.println("Menu berhasil di-sort berdasarkan harga!");
                    break;

                case 4:
                    System.out.print("Masukkan nama menu: ");
                    String cariNama = input.nextLine();
                    MenuItem hasilNama = manager.linearSearchByName(cariNama);

                    if (hasilNama != null)
                        System.out.println("Ditemukan: " + hasilNama);
                    else
                        System.out.println("Menu tidak ditemukan.");
                    break;

                case 5:
                    System.out.print("Masukkan harga menu: ");
                    double cariHarga = input.nextDouble();

                    // Pastikan list sudah sorted sebelum binary search
                    manager.sortByHargaSelection();

                    MenuItem hasilHarga = manager.binarySearchByHarga(cariHarga);

                    if (hasilHarga != null)
                        System.out.println("Ditemukan: " + hasilHarga);
                    else
                        System.out.println("Menu tidak ditemukan.");
                    break;

                case 6:
                    double total = manager.totalHargaRecursive();
                    System.out.println("Total harga semua menu (rekursi): Rp " + total);
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
