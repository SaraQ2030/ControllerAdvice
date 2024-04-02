package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Profile;
import org.example.capstone2.Model.User;
import org.example.capstone2.Service.ProfileService;
import org.example.capstone2.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/vision/profile")
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    //  Logger logger =LoggerFactory.getLogger(ProfileController.class);
    @GetMapping("/get")
    public ResponseEntity getProfile(){
        // logger.info("inside the get all profile ");
        return ResponseEntity.status(200).body(profileService.getAllProfile());
    }


    @PostMapping("/add/{adminId}")
    public ResponseEntity addProfile(@PathVariable Integer adminId,@RequestBody @Valid Profile profile){
        // logger.info("inside add profile ");
        profileService.addProfile(profile,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("Profile added "));
    }
    @PutMapping("/update/{id}/{adminId}")
    public ResponseEntity updateProfile(@PathVariable Integer id,@PathVariable Integer adminId, @RequestBody @Valid Profile profile){
        // logger.info("inside update profile ");
        profileService.updateProfile(id,profile,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("Profile Updated "));
    }
    @DeleteMapping("/delete/{id}/{adminId}")
    public ResponseEntity deleteProfile(@PathVariable Integer id,@PathVariable Integer adminId){
        // logger.info("inside delete profile ");
        profileService.deleteProfile(id,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("Profile deleted"));
    }
    @GetMapping("/search-profile/{contId}")
    public ResponseEntity searchProfileByContentId(@PathVariable Integer contId){
        // logger.info("inside search profile by content id");
        Profile p=profileService.searchProfileByContentId(contId);
        return ResponseEntity.status(200).body(p);
    }
}
