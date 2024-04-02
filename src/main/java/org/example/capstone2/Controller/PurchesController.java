package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Purches;
import org.example.capstone2.Model.User;
import org.example.capstone2.Service.PurchesService;
import org.example.capstone2.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/vision/purches")
@AllArgsConstructor
public class PurchesController {
    private final PurchesService purchesService;
    //  Logger logger =LoggerFactory.getLogger(PurchesController.class);

    @GetMapping("/get")
    public ResponseEntity getPurches(){

        // logger.info("inside the get all purches ");
        return ResponseEntity.status(200).body(purchesService.getAllPurches());
    }
    @PostMapping("/add")
    public ResponseEntity addPurches(@RequestBody @Valid Purches purches){
        // logger.info("inside add purches");
        purchesService.addPurches(purches);
        return ResponseEntity.status(200).body(new ApiResponse("purches added "));
    }
    @PutMapping("/update/{id}/{adminId}")
    public ResponseEntity updatePurches(@PathVariable Integer id,@PathVariable Integer adminId, @RequestBody @Valid Purches purches){
        // logger.info("inside update purches");
        purchesService.updatePurches(id,adminId,purches);
        return ResponseEntity.status(200).body(new ApiResponse("Purches Updated "));
    }
    @DeleteMapping("/delete/{id}/{adminId}")
    public ResponseEntity deletePurches(@PathVariable Integer id,@PathVariable Integer adminId){
        // logger.info("inside delete purches ");
    purchesService.deletePurches(id,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("Purches deleted"));
    }

    @GetMapping("/get-user-purches/{id}")
    public ResponseEntity listUserpurches(@PathVariable Integer id){
        // logger.info("inside search users by  purches id");
        List<Purches> purchesList=purchesService.purchesByUser(id);
        return ResponseEntity.status(200).body(purchesList);
    }

    @GetMapping("/purches-progress/{b}")
    public ResponseEntity purchesProgress(@PathVariable Boolean b){
        // logger.info("inside search purches progress");
        List<Purches> purchesList=purchesService.purchesProgress(b);
        return ResponseEntity.status(200).body(purchesList);
    }

    @GetMapping("/progress/{b}")
    public ResponseEntity listPurchesStatus(@PathVariable String b){
        // logger.info("inside search purches status");
        List<Purches> purchesList=purchesService.purchesStatus(b);
        return ResponseEntity.status(200).body(purchesList);
    }



    @GetMapping("/purches-date/{date}")
    public ResponseEntity purchesByDate(@PathVariable LocalDate date){
        // logger.info("inside search purches by date");
        List<Purches> p=purchesService.purchesEndDate(date);
        return ResponseEntity.status(200).body(p);
    }

    @GetMapping("/purches-content/{id}")
    public ResponseEntity purchesContentID(@PathVariable Integer id){
        // logger.info("inside search purches by content id");
        List<Purches> p=purchesService.purchesContentId(id);
        return ResponseEntity.status(200).body(p);
    }
}
