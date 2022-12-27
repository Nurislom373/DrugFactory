package org.khasanaof.drugfactory.service.upload;

import org.khasanaof.drugfactory.domain.upload.UploadEntity;
import org.khasanaof.drugfactory.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/27/2022
 * <br/>
 * Time: 7:42 PM
 * <br/>
 * Package: org.khasanaof.drugfactory.service
 */
public interface FileUploadService extends BaseService {

    UploadEntity save(MultipartFile file);

}
