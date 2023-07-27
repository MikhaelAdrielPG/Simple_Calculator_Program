import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fungsi utama untuk menjalankan kalkulator
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kalkulator");
        System.out.println("==============================");

        while (true) {
            // Meminta pengguna memasukkan angka pertama dan kedua
            double angka1;
            double angka2;

            while (true) {
                try {
                    // Meminta pengguna memasukkan angka pertama
                    System.out.print("Masukkan angka pertama: ");
                    angka1 = scanner.nextDouble();
                    break; // Berhenti dari loop jika input valid
                } catch (InputMismatchException e) {
                    // Tangani kesalahan jika pengguna memasukkan nilai non-numerik
                    System.out.println("Maaf, input yang Anda masukkan tidak valid.");
                    scanner.nextLine(); // Membersihkan buffer setelah input salah
                }
            }

            while (true) {
                try {
                    // Meminta pengguna memasukkan angka kedua
                    System.out.print("Masukkan angka kedua: ");
                    angka2 = scanner.nextDouble();

                    // Validasi angka kedua tidak boleh nol (0) untuk operator division '/'
                    if (angka2 == 0 && isValidOperator("/")) {
                        System.out.print("Masukkan operator matematika (+, -, *, /): ");
                        continue; // Mengulang loop meminta angka kedua
                    }

                    break; // Berhenti dari loop jika input valid
                } catch (InputMismatchException e) {
                    // Tangani kesalahan jika pengguna memasukkan nilai non-numerik
                    System.out.println("Maaf, input yang Anda masukkan tidak valid.");
                    scanner.nextLine(); // Membersihkan buffer setelah input salah
                }
            }

            String operator;

            // validasi operator
            while (true) {
                // Meminta pengguna memasukkan operator
                System.out.print("Masukkan operator matematika (+, -, *, /): ");
                operator = scanner.next();

                // Periksa apakah operator yang dimasukkan valid
                if (!isValidOperator(operator)) {
                    System.out.print("Masukkan operator matematika (+, -, *, /): ");
                } else {
                    break;
                }
            }

            double hasil = 0;

            // Evaluasi operator yang dimasukkan oleh pengguna dan lakukan perhitungan
            switch (operator) {
                case "+":
                    hasil = angka1 + angka2;
                    break;
                case "-":
                    hasil = angka1 - angka2;
                    break;
                case "*":
                    hasil = angka1 * angka2;
                    break;
                case "/":
                    hasil = angka1 / angka2;
                    break;
                default:
                    System.out.println("Invalid operator.");
            }

            // Menampilkan hasil dari perhitungan
            System.out.println("Hasil: " + hasil);

            // Tanya pengguna apakah ingin melakukan perhitungan lagi atau tidak
            System.out.print("Apakah Anda ingin menghitung lagi? (ya/tidak): ");
            String ulangi = scanner.next();

            // Jika pengguna memasukkan "n", keluar dari loop dan selesaikan program
            if (!ulangi.equals("y")) {
                break;
            }
        }
        scanner.close();  // Tutup scanner
    }

    // Fungsi untuk memeriksa apakah operator yang dimasukkan valid
    private static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }
}
