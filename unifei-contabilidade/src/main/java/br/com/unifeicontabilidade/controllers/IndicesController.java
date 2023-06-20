package br.com.unifeicontabilidade.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/indices")
public class IndicesController {

    @PostMapping("/upload-csv-file")
    public ResponseEntity<String> uploadCsvFile(@RequestParam("file")MultipartFile multipartFile) {

        return new ResponseEntity<>( "File uploaded!", HttpStatus.CREATED);
    }
}
