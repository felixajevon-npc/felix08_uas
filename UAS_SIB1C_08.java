// NAMA : FELIX ALBERTA JEVON
// KELAS : SIB - 1C
// NIM : 244107060111

import java.util.Scanner;

public class UAS_SIB1C_08 {
    static Scanner scanner = new Scanner(System.in);
    static String[] namaTim08;
    static int[][] skorTim08;
    static int jumlahTim08;
    static boolean dataSudahDiinput08 = false;

    public static void main(String[] args) {
        boolean ulangProgram08 = true;

        while (ulangProgram08) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4) : ");
            int menu08 = scanner.nextInt();
            scanner.nextLine();
            if (menu08 < 1 || menu08 > 4) {
                System.out.println("Pilihan Menu Tidak Valid!");
                continue;
            }

            switch (menu08) {
                case 1:
                    inputDataSkor08();
                    break;
                case 2:
                    tampilkanTabelSkor08();
                    break;
                case 3:
                    tentukanJuara08();
                    break;
                case 4:
                    System.out.print("\nYakin Ingin Keluar? (y/n): ");
                    String konfirmasi08 = scanner.nextLine();
                    if (konfirmasi08.equalsIgnoreCase("y")) {
                        ulangProgram08 = false;
                        System.out.println("Program Selesai. Terima Kasih!");
                    } else {
                        System.out.println("Kembali ke Menu Utama.");
                    }
                    break;
                default:
                    System.out.println("Pilihan Menu Tidak Valid!");
            }
        }
    }

    static void inputDataSkor08() {
        System.out.println("\n=== Input Data Skor Tim ===");

        jumlahTim08 = (11 % 3) + 4;
        namaTim08 = new String[jumlahTim08];
        skorTim08 = new int[jumlahTim08][2];

        for (int i = 0; i < jumlahTim08; i++) {
            System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
            namaTim08[i] = scanner.nextLine();

            for (int j = 0; j < 2; j++) {
                while (true) {
                    System.out.print("Masukkan skor " + namaTim08[i] + " untuk Level " + (j + 1) + ": ");
                    int skor08 = scanner.nextInt();

                    if (skor08 < 0) {
                        System.out.println("Skor harus bilangan positif. Ulangi!");
                    } else if (j == 0 && skor08 < 35) {
                        skorTim08[i][j] = 0;
                        break;
                    } else {
                        skorTim08[i][j] = skor08;
                        break;
                    }
                }
            }
            scanner.nextLine();
        }
        dataSudahDiinput08 = true;
        System.out.println("Data skor tim berhasil diinput!");
    }

    static void tampilkanTabelSkor08() {
        System.out.println("\n=== Tabel Skor Turnamen ===");
        System.out.printf("%-15s %-10s %-10s %-15s%n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
    
        for (int i = 0; i < jumlahTim08; i++) {
            int skorLevel108 = skorTim08[i][0];
            int skorLevel208 = skorTim08[i][1];
    
            if (skorLevel108 < 35) {
                skorLevel108 = 0;
            }

            int totalSkor08 = skorLevel108 + skorLevel208;
    
            if (totalSkor08 % 2 == 0) {
                totalSkor08 -= 15;
            }
    
            if (skorTim08[i][0] > 50 && skorTim08[i][1] > 50) {
                totalSkor08 += 8;
            }
    
            System.out.printf("%-15s %-10d %-10d %-15d%n", namaTim08[i], skorLevel108, skorLevel208, totalSkor08);
        }
    }
    

    static void tentukanJuara08() {
        int maxSkor08 = 0;
        int skorLevel2Max08 = 0;
        String timJuara08 = "";
        String timSeri08 = "";
        boolean seri08 = false;

        for (int i = 0; i < jumlahTim08; i++) {
            int totalSkor = skorTim08[i][0] + skorTim08[i][1];

            if (totalSkor > maxSkor08) {
                maxSkor08 = totalSkor;
                skorLevel2Max08 = skorTim08[i][1];
                timJuara08 = namaTim08[i];
                seri08 = false;
                timSeri08 = "";
            } else if (totalSkor == maxSkor08) {
                seri08 = true;

                if (skorTim08[i][1] > skorLevel2Max08) {
                    skorLevel2Max08 = skorTim08[i][1];
                    timJuara08 = namaTim08[i];
                } else if (skorTim08[i][1] == skorLevel2Max08) {
                    timSeri08 = timJuara08 + " dan " + namaTim08[i];
                }
            }
        }

        if (seri08 && !timSeri08.equals("")) {
            System.out.println();
            System.out.println("Turnamen berakhir seri! Tim terbaik adalah " + timSeri08);
        } else {
            System.out.println();
            System.out.println("Selamat kepada Tim " + timJuara08 + " yang telah memenangkan kompetisi!");
        }
    }
}