package br.com.unifeicontabilidade.controllers;

import br.com.unifeicontabilidade.services.IndicesService;
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

    @GetMapping("/get-values")
    public ResponseEntity<IndicesDto> getAllIndices(@RequestParam(value = "year") String year) {

        return new ResponseEntity<>(indicesService.calculateAllIndices(year), HttpStatus.OK);
    }
}
