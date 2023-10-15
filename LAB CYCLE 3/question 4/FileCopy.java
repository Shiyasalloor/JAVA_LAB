import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Get the source file path
            System.out.print("Enter the source file path: ");
            String sourceFilePath = reader.readLine();

            // Get the target file path
            System.out.print("Enter the target file path: ");
            String targetFilePath = reader.readLine();

            File sourceFile = new File(sourceFilePath);
            File targetFile = new File(targetFilePath);

            // Check if the source file exists
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            // Check if the target file already exists
            if (targetFile.exists()) {
                System.out.print("Target file already exists. Do you want to overwrite? (yes/no): ");
                String confirmation = reader.readLine().toLowerCase();

                if (!confirmation.equals("yes")) {
                    System.out.println("File copy aborted.");
                    return;
                }
            }

            // Perform the file copy
            try (InputStream inStream = new FileInputStream(sourceFile);
                 OutputStream outStream = new FileOutputStream(targetFile)) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = inStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, length);
                }

                System.out.println("File copied successfully.");
            } catch (IOException e) {
                System.out.println("Error copying file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing the input reader: " + e.getMessage());
            }
        }
    }
}
