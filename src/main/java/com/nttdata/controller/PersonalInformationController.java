package com.nttdata.controller;

import com.nttdata.exception.InformationException;
import com.nttdata.models.reponse.InformationPersonalResponse;
import com.nttdata.service.InformationPersonalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/v1/information")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@Slf4j
public class PersonalInformationController {
    private InformationPersonalService informationPersonalService;
    @GetMapping("/data")
    public ResponseEntity<List<InformationPersonalResponse>> findInformation(@RequestParam Integer id,
                                                                             @RequestParam String idNumber) throws InformationException {
        log.debug("PersonalInformationController.findInformation call for Information {}", id);
        return new ResponseEntity<List<InformationPersonalResponse>>(informationPersonalService.findByIdNumberAndTypeNumber(id, idNumber),HttpStatus.OK);
    }
}
