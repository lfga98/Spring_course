package uaz.ejemplo.edu.demouaz.ejemplo.edu.models.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IUploadService {

    public String copy(MultipartFile file) throws IOException;
    public boolean delete(String Filename);
    public void deleteAll();
    public void init() throws IOException;
}
