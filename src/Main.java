import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fungsi utama di main yang menjalankan kalkulator
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kalkulator");
        System.out.println("==============================");

        do {
            // Minta pengguna memasukkan angka pertama dan kedua
            int angka1 = readNumber("Masukkan angka pertama: ", scanner);
            int angka2 = readNumber("Masukkan angka kedua: ", scanner);

            // Validasi agar angka kedua tidak boleh nol jika operator adalah "/"
            while (angka2 == 0 && isValidOperator("/")) {
                System.out.println("Maaf, tidak dapat melakukan pembagian dengan nol.");
                angka2 = readNumber("Masukkan angka kedua: ", scanner);
            }

            // Minta pengguna memasukkan operator matematika
            String operator = readOperator(scanner);

            // Hitung hasil operasi berdasarkan angka dan operator yang diberikan
            int hasil = calculateResult(angka1, angka2, operator);

            // Tampilkan hasil perhitungan
            System.out.println("Hasil : " + hasil);

            // Tanya pengguna apakah ingin melakukan perhitungan lagi atau keluar dari program
        } while (askForAnotherCalculation(scanner));

        // Tutup scanner setelah selesai digunakan
        scanner.close();
    }

    // Fungsi untuk perhitungan tambah
    private static int plus(int angka1, int angka2) { // Ganti tipe data double menjadi int
        return angka1 + angka2;
    }

    // Fungsi untuk perhitungan kurang
    private static int minus(int angka1, int angka2) { // Ganti tipe data double menjadi int
        return angka1 - angka2;
    }

    // Fungsi untuk perhitungan kali
    private static int multiply(int angka1, int angka2) { // Ganti tipe data double menjadi int
        return angka1 * angka2;
    }

    // Fungsi untuk perhitungan bagi
    private static int divide(int angka1, int angka2) { // Ganti tipe data double menjadi int
        return angka1 / angka2;
    }

    // Fungsi untuk membaca angka dari input pengguna
    private static int readNumber(String message, Scanner scanner) {
        int angka;

        while (true) {
            try {
                System.out.print(message);
                angka = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Maaf, input yang anda masukan tidak valid.");
                scanner.nextLine();
            }
        }

        return angka;
    }


    // Fungsi untuk membaca operator matematika dari input pengguna
    private static String readOperator(Scanner scanner) {
        while (true) {
            System.out.print("Masukkan operator matematika (+, -, *, /): ");
            String operator = scanner.next();

            // Validasi agar operator yang dimasukkan harus sesuai dengan (+, -, *, /)
            if (!isValidOperator(operator)) {
                System.out.println("Maaf, operator yang Anda masukkan tidak valid.");
            } else {
                return operator;
            }
        }
    }

    // Fungsi untuk memvalidasi operator yang dimasukkan harus sesuai dengan (+, -, *, /)
    private static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    // Fungsi untuk melakukan perhitungan berdasarkan angka dan operator yang diberikan
    private static int calculateResult(int angka1, int angka2, String operator) { // Ganti tipe data double menjadi int
        int hasil = 0;

        // Lakukan operasi matematika berdasarkan operator yang diberikan
        switch (operator) {
            case "+" -> hasil = plus(angka1, angka2);
            case "-" -> hasil = minus(angka1, angka2);
            case "*" -> hasil = multiply(angka1, angka2);
            case "/" -> hasil = divide(angka1, angka2);
            default -> System.out.println("Maaf, operator yang Anda masukkan tidak valid.");
        }

        return hasil;
    }

    // Fungsi untuk menanyakan apakah pengguna ingin melakukan perhitungan lagi
    private static boolean askForAnotherCalculation(Scanner scanner) {
        System.out.print("Apakah Anda ingin menghitung lagi? (ya/tidak): ");
        String ulangi = scanner.next();
        return ulangi.equalsIgnoreCase("ya");
    }
}