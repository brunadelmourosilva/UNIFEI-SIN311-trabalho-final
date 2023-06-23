package br.com.unifeicontabilidade.controllers;

import br.com.unifeicontabilidade.models.DadosBalancoPatrimonial;
import br.com.unifeicontabilidade.models.Dre;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/indices")
public class IndicesController {

    @PostMapping("/upload-csv-file-BP")
    public ResponseEntity<String> uploadCsvFileBP(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        try (Reader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {

            // create csv bean reader
            final var csvToBean = new CsvToBeanBuilder<DadosBalancoPatrimonial>(reader)
                    .withType(DadosBalancoPatrimonial.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<DadosBalancoPatrimonial> balancoPatrimonialList = csvToBean.parse();

            // TODO: save users in DB?

        } catch (Exception ex) {
            throw new IOException("Error to upload the file!");
        }

        return new ResponseEntity<>( "File uploaded for BP!", HttpStatus.CREATED);
    }

    @PostMapping("/upload-csv-file-DRE")
    public ResponseEntity<String> uploadCsvFileDRE(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        try (Reader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {

            // create csv bean reader
            final var csvToBean = new CsvToBeanBuilder<Dre>(reader)
                    .withType(Dre.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<Dre> users = csvToBean.parse();

            // TODO: save users in DB?

        } catch (Exception ex) {
            throw new IOException("Error to upload the file!");
        }

        return new ResponseEntity<>( "File uploaded for DRE!", HttpStatus.CREATED);
    }

    @GetMapping("/get-values")
    public ResponseEntity<String> getAllIndices() {

        return new ResponseEntity<>( "File uploaded for DRE!", HttpStatus.CREATED);
    }

}
