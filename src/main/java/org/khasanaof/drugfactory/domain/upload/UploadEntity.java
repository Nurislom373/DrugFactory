package org.khasanaof.drugfactory.domain.upload;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.khasanaof.drugfactory.domain.Auditable;

/**
 * Author: Nurislom
 * <br/>
 * Date: 12/27/2022
 * <br/>
 * Time: 7:14 PM
 * <br/>
 * Package: org.khasanaof.drugfactory.domain.upload
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "upload")
public class UploadEntity extends Auditable {

    @Column(name = "original_file_name", nullable = false)
    private String originalFileName;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "extension", nullable = false)
    private String extension;
}
