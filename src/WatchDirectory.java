import javax.swing.*;
import java.nio.file.*;
import java.io.File;

public class WatchDirectory extends Thread {
    private String[] files;
    private Path path;
    private WatchService watchService;

    public WatchDirectory(String path) throws Exception {
        this.path = Paths.get(path);
        this.watchService = FileSystems.getDefault().newWatchService();
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        this.files = getAllFiles();
    }

    public void run() {
        while (true) {
            try {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        files = getAllFiles();
                    }
                }
                key.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String[] getAllFiles() {
        File folder = new File(path.toString());
        File[] allFiles = folder.listFiles();
        String[] fileNames = new String[allFiles.length];
        for (int i = 0; i < allFiles.length; i++) {
            String fileName = allFiles[i].getName();
            fileNames[i] = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return fileNames;
    }

    public String[] getFileNames() {
        return files;
    }
}