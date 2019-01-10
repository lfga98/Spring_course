package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadServiceImp implements IUploadService {

    private final String UPLOADS_FOLDER = "uploads";

    private final Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString()+"_" +file.getOriginalFilename();
        Path rootPath =getPath(uniqueFilename);
        log.info("rootPath " +rootPath);
        Files.copy(file.getInputStream(),rootPath);
        return uniqueFilename;
    }

    @Override
    public boolean delete(String Filename) {
        Path rootPath = getPath(Filename);
        File archivo = rootPath.toFile();
        if(archivo.exists() || archivo.canRead()){
            if(archivo.delete()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectory(Paths.get(UPLOADS_FOLDER));
    }

    public Path getPath(String Filename){
        return Paths.get(UPLOADS_FOLDER).resolve(Filename).toAbsolutePath();
    }
}
