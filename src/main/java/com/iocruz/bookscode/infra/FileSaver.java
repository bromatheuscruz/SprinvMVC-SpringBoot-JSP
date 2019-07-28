package com.iocruz.bookscode.infra;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileSaver
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public String write(MultipartFile multipartFile) {
        try {

            String realPath = httpServletRequest.getServletContext()
                .getRealPath("/".concat("files").concat("/"));

            String path = realPath.concat(multipartFile.getOriginalFilename());

            multipartFile.transferTo(
                new File(path)
            );

            return "files"
                .concat("/")
                .concat(UUID.randomUUID().toString())
                .concat("-")
                .concat(multipartFile.getOriginalFilename());

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}