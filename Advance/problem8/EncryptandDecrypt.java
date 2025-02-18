package org.example.Advance.problem8;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

// Problem: Encrypt sensitive fields (Salary, Email) in a CSV file while writing.
// Decrypt them when reading the file.

public class EncryptandDecrypt {
    private static final String CSV_FILE = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem8\\employeeEncrypted.csv";
    private static final String SECRET_KEY = "1234567890123456"; // 16-char key for AES

    public static void main(String[] args) {
        // Sample Data
        String[][] employees = {
                {"ID", "Name", "Email", "Salary"},
                {"1", "John Doe", "john@example.com", "75000"},
                {"2", "Jane Smith", "jane@example.com", "65000"},
                {"3", "Alice Brown", "alice@example.com", "72000"}
        };

        // Encrypt and write to CSV
        encryptAndWriteCSV(employees, CSV_FILE);

        // Read and decrypt from CSV
        decryptAndReadCSV(CSV_FILE);
    }

    // Encrypt & Write CSV
    public static void encryptAndWriteCSV(String[][] data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < data.length; i++) {
                String encryptedEmail = (i == 0) ? "Email" : encrypt(data[i][2]); // Encrypt email
                String encryptedSalary = (i == 0) ? "Salary" : encrypt(data[i][3]); // Encrypt salary

                writer.write(data[i][0] + "," + data[i][1] + "," + encryptedEmail + "," + encryptedSalary + "\n");
            }
            System.out.println("CSV file encrypted and saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read & Decrypt CSV
    public static void decryptAndReadCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                String decryptedEmail = values[0].equals("ID") ? "Email" : decrypt(values[2]); // Decrypt email
                String decryptedSalary = values[0].equals("ID") ? "Salary" : decrypt(values[3]); // Decrypt salary

                System.out.println(values[0] + ", " + values[1] + ", " + decryptedEmail + ", " + decryptedSalary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AES Encryption
    public static String encrypt(String data) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    // AES Decryption
    public static String decrypt(String data) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
    }
}
