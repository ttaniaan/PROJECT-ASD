import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    // Struktur data: ArrayList -> O(1) append, dinamis
    private List<MenuItem> menus = new ArrayList<>();

    // Menambah menu ke list (O(1) amortized)
    public void addMenu(MenuItem menu) {
        menus.add(menu);
    }

    // Mengambil semua menu (O(n))
    public List<MenuItem> getAllMenus() {
        return menus;
    }

    // Mencari menu berdasarkan nama (Linear Search) -> O(n)
    public MenuItem linearSearchByName(String nama) {
        for (MenuItem menu : menus) {
            if (menu.getNama().equalsIgnoreCase(nama)) {
                return menu;
            }
        }
        return null;
    }

    // Sorting harga dengan SELECTION SORT -> O(n^2)
    // Dipilih karena mudah dipahami
    public void sortByHargaSelection() {
        int n = menus.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (menus.get(j).getHarga() < menus.get(minIndex).getHarga()) {
                    minIndex = j;
                }
            }

            // Swap
            MenuItem temp = menus.get(i);
            menus.set(i, menus.get(minIndex));
            menus.set(minIndex, temp);
        }
    }

    // BINARY SEARCH harga -> O(log n)
    // SYARAT: data harus sudah di-sort ascending berdasarkan harga
    public MenuItem binarySearchByHarga(double target) {
        int low = 0;
        int high = menus.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            double hargaMid = menus.get(mid).getHarga();

            if (hargaMid == target) {
                return menus.get(mid);
            } else if (hargaMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Rekursi untuk menghitung total harga seluruh menu
    // Kompleksitas: O(n) time, O(n) stack
    public double totalHargaRecursive() {
        return totalHargaRecursive(0);
    }

    private double totalHargaRecursive(int index) {
        if (index == menus.size()) {
            return 0; // base case
        }
        return menus.get(index).getHarga() + totalHargaRecursive(index + 1);
    }
}
