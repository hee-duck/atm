package atm;

import java.io.*;

public class FileManager {
    private File file;
    private FileWriter filseWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private FileManager() {}
    private static FileManager instance = new FileManager();
    public static FileManager getInstance() {
        return instance;
    }                   // 여기까지가 싱글톤 작업



}