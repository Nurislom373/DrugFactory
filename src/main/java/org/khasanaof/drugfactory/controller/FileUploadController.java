package org.khasanaof.drugfactory.controller;

import org.khasanaof.drugfactory.domain.upload.UploadEntity;
import org.khasanaof.drugfactory.response.Data;
import org.khasanaof.drugfactory.service.upload.FileUploadService;
import org.khasanaof.drugfactory.service.upload.SimpleFileUploadService;
import org.khasanaof.drugfactory.utils.BaseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/27/2022
 * <br/>
 * Time: 4:43 PM
 * <br/>
 * Package: org.khasanaof.drugfactory.controller
 */
@RestController
@RequestMapping(value = BaseUtils.PATH + "/file/*")
public class FileUploadController {

    private final FileUploadService service;

    public FileUploadController(SimpleFileUploadService service) {
        this.service = service;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Data<UploadEntity>> upload(@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(new Data<>(service.save(file)), HttpStatus.OK);
    }

}
