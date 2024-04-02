package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.User;
import org.example.capstone2.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/vision/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

  //  Logger logger =LoggerFactory.getLogger(UserController.class);


    @GetMapping("/get")
    public ResponseEntity getUsers(){
        // logger.info("inside the get all users ");
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){
        // logger.info("inside the add users ");
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added "));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user){
        // logger.info("inside update user ");
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User Updated "));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        // logger.info("inside delete user ");
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }

    @GetMapping("/search-username/{name}")
   public ResponseEntity findUSerByUsername(@PathVariable String name){
        // logger.info("inside  search : findUSerByUsername ");
      User u=userService.findUserByUserName(name);
        return ResponseEntity.status(200).body(u);
    }

    @GetMapping("/search-email/{email}")
    public ResponseEntity findUSerByEmail(@PathVariable String email){
        // logger.info("inside  search : findUserByEmail ");
        User u=userService.findUserByEmail(email);
        return ResponseEntity.status(200).body(u);
    }


    @GetMapping("/search-phonenumber/{num}")
    public ResponseEntity findUSerByPhoneNumber(@PathVariable Integer num){
        // logger.info("inside  search : findUserByPhoneNumber ");
        User u=userService.findUserByPhoneNumbe(num);
        return ResponseEntity.status(200).body(u);
    }
}
