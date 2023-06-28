package br.com.unifeicontabilidade.controllers;

import br.com.unifeicontabilidade.IndicesService;
import br.com.unifeicontabilidade.dto.IndicesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indices")
public class IndicesController {

    @Autowired
    private IndicesService indicesService;

//    @PostMapping("/upload-csv-file-BP")
//    public ResponseEntity<String> uploadCsvFileBP(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//
//        try (Reader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
//
//            // create csv bean reader
//            final var csvToBean = new CsvToBeanBuilder<DadosBalancoPatrimonial>(reader)
//                    .withType(DadosBalancoPatrimonial.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//
//            // convert `CsvToBean` object to list of users
//            List<DadosBalancoPatrimonial> balancoPatrimonialList = csvToBean.parse();
//
//
//        } catch (Exception ex) {
//            throw new IOException("Error to upload the file!");
//        }
//
//        return new ResponseEntity<>( "File uploaded for BP!", HttpStatus.CREATED);
//    }

//    @PostMapping("/upload-csv-file-DRE")
//    public ResponseEntity<String> uploadCsvFileDRE(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//
//        try (Reader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
//
//            // create csv bean reader
//            final var csvToBean = new CsvToBeanBuilder<DadosDre>(reader)
//                    .withType(DadosDre.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//
//            // convert `CsvToBean` object to list of users
//            List<DadosDre> users = csvToBean.parse();
//
//
//        } catch (Exception ex) {
//            throw new IOException("Error to upload the file!");
//        }
//
//        return new ResponseEntity<>( "File uploaded for DRE!", HttpStatus.CREATED);
//    }

    @GetMapping("/get-values")
    public ResponseEntity<IndicesDto> getAllIndices(@RequestParam(value = "year") String year) {

        return new ResponseEntity<>(indicesService.calculateAllIndices(year), HttpStatus.OK);
    }
}
