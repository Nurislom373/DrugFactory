package org.khasanaof.drugfactory.service.upload;

import org.khasanaof.drugfactory.domain.upload.UploadEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/27/2022
 * <br/>
 * Time: 4:48 PM
 * <br/>
 * Package: org.khasanaof.drugfactory.service
 */
@Service
public class SimpleFileUploadService implements FileUploadService {

    private final String SHORT_PATH = "src/main/resources/data/";
    private final String ABSOLUTE_PATH = "D:\\Nurislom\\Projects\\DrugFactory\\src\\main\\resources";

    @Override
    public UploadEntity save(MultipartFile file) {
        try {
            String org_name = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(org_name);
            String generatedName = System.currentTimeMillis() + "." + extension;
            Files.copy(file.getInputStream(), Paths.get(SHORT_PATH, generatedName),
                    StandardCopyOption.REPLACE_EXISTING);
            return returnEntity(file, extension, generatedName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UploadEntity returnEntity(MultipartFile file, String extension, String generatedName) {
        return new UploadEntity(file.getOriginalFilename(), generatedName,
                SHORT_PATH + generatedName, extension);
    }

}
