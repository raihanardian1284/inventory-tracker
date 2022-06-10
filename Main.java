import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static ArrayList<String> barang;
    public static ArrayList<String> jumlah;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> barang = new ArrayList<String>();
        ArrayList<String> jumlah = new ArrayList<String>();

        Main.barang = barang;
        Main.jumlah = jumlah;
        menu(input);
    }

    public static void menu(Scanner input) {
        System.out.println("MENU:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Hapus Produk");
        System.out.println("3. Ubah  Produk");
        System.out.println("4. Lihat PRoduk");
        System.out.println("5. Keluar");
        System.out.println("Masukkan Pilihan Anda Pada Menu Di Atas: ");

        int answer_menu = input.nextInt();
        switch (answer_menu) {
            case 1:
                add(input);
                break;
            case 2:
                delete(input);
                break;
            case 3:
                update(input);
                break;
            case 4:
                Show(input);
                break;
            case 5:
                System.out.println("Terima Kasih");
                System.out.println("-----------------");
                break;
            default:
        }
    }

    public static void add(Scanner input) {
        System.out.println("Menambahkan Data Barang");
        System.out.println("------------------------");
        System.out.println("Masukkan Nama Barang: ");
        String nama = input.next();

        System.out.print("Masukkan Jumlah Barang :");
        String jumlah_barang = input.next();

        ArrayList<String> barang = new ArrayList<String>();
        ArrayList<String> jumlah = new ArrayList<String>();

        barang = (ArrayList) Main.barang.clone();
        jumlah = (ArrayList) Main.jumlah.clone();

        barang.add(nama);
        jumlah.add(jumlah_barang);

        Main.barang = barang;
        Main.jumlah = jumlah;

        System.out.println("Berhasil Menambah Data Barang Ke Keranjang");
        System.out.println("------------------------------------------");
        System.out.println("Kembali Ke Menu ?");

        String menu = input.next();
        menu(input);
    }

    public static void delete(Scanner input) {
        System.out.println("Menghapus Data Barang!");
        System.out.println("----------------------");
        System.out.println("Masukkan Barang Yang Ingin Dihapus: ");
        String nama = input.next();

        ArrayList<String> barang = new ArrayList<String>();
        ArrayList<String> jumlah = new ArrayList<String>();
        barang = (ArrayList) Main.barang.clone();
        jumlah = (ArrayList) Main.jumlah.clone();

        boolean find = false;
        int index = 0;
        for (int i = 0; i < barang.size(); i++) {
            if (nama.equals(barang.get(i))) {
                find = true;
                index = i;
                break;
            }
        }
        if (find) {
            System.out.println("Apakah Anda Yakin Untuk Menghapus Data Produk Dari Keranjang");
            String confirm = input.next();
            if (confirm.equals("Y") || confirm.equals("y")) {
                barang.remove(index);
                jumlah.remove(index);

                Main.barang = barang;
                Main.jumlah = jumlah;

                System.out.println("Berhasil Menghapus Data");
                System.out.println("-----------------------");
                System.out.println("Kembali Ke Menu");

                String menu = input.next();
                menu(input);
            } else {
                menu(input);
            }
        } else {
            System.out.println("Produk Yang Anda Cari Tidak Ada");
            menu(input);
        }
    }

    public static void Show(Scanner input) {
        System.out.println("Menampilkan Data Barang!");
        System.out.println("------------------------");
        System.out.println("List Data Produk Dalam Keranjang : ");

        ArrayList<String> barang = new ArrayList<String>();
        ArrayList<String> jumlah = new ArrayList<String>();
        barang = (ArrayList) Main.barang.clone();
        jumlah = (ArrayList) Main.jumlah.clone();

        boolean find = false;
        int index = 0;
        for (int i = 0; i < barang.size(); i++) {
            System.out.println((i + 1) + ". nama : " + barang.get(i) + ", jumlah : " + jumlah.get(i));
        }
        System.out.println("Berhasil Menampilkan Data Barang");
        System.out.println("--------------------------------");
        System.out.println("Kembali Ke Menu ?");
        String menu = input.next();
        menu(input);
    }

    public static void update(Scanner input) {
        System.out.println("Mengubah Data Barang!");
        System.out.println("---------------------");
        System.out.println("Masukkan Nama Barang Yang Ingin Diubah :");
        String nama = input.next();
        
        ArrayList<String> barang = new ArrayList<String>();
        ArrayList<String> jumlah = new ArrayList<String>();
        barang = (ArrayList) Main.barang.clone();
        jumlah = (ArrayList) Main.jumlah.clone();
        boolean find = false;
        int index = 0;
        for (int i = 0; i < barang.size(); i++) {
            if (nama.equals(barang.get(i))){
                find = true;
                index = i;
                break;
            }
        }
        if (find) {
            System.out.println("Masukkan Jumlah Barang Yang Baru : ");
            String jumlah_barang = input.next();

            System.out.println("Apakah Anda Yakin Dengan Jumlah Produk Saat ini ?");
            String confirm = input.next();

            if (confirm.equals("Ya") || confirm.equals("ya")){
                jumlah.set(index, jumlah_barang);

                Main.barang = barang;
                Main.jumlah = jumlah;
                System.out.println("Berhasil Mengubah Data Barang");
                System.out.println("-----------------------------");
                System.out.println("Kembali Ke Menu ?");

                String menu = input.next();
                menu(input);
            } else {
                menu(input);
            }
        } else {
            System.out.println("Produk Yang Anda Cari Tidak Ada");
            menu(input);
        }      
    }
}



