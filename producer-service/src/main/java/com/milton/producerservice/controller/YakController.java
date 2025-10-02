package com.milton.producerservice.controller;

import com.milton.commonservice.model.Yak;
import com.milton.producerservice.service.YakService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class YakController {

    private final YakService yakService;

    public YakController(YakService yakService) {
        this.yakService = yakService;
    }

    @Operation(summary = "Add Yak data")
    @PostMapping(value = "/yak", produces = "application/json")
    @ApiResponses( value = { @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request / Error in the request payload"),
            @ApiResponse(responseCode = "500", description = "internal server error") })
    public ResponseEntity<Yak> postVehicle(@RequestBody Yak yak) {
        Yak YakResult = yakService.addYak(yak);
        return ResponseEntity.ok(YakResult);
    }
}
