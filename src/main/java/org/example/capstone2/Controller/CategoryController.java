package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Category;
import org.example.capstone2.Service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/vision/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    //  Logger logger =LoggerFactory.getLogger(CategoryController.class);
    @GetMapping("/get")
    public ResponseEntity getCategory(){
        // logger.info("inside the get all category");
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }
    @PostMapping("/add/{id}")
    public ResponseEntity addCategory(@PathVariable Integer id,@RequestBody @Valid Category category){
        // logger.info("inside add category");
                categoryService.addCategory(category,id);
        return ResponseEntity.status(200).body(new ApiResponse("category added "));
    }
    @PutMapping("/update/{id}/{adminId}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@PathVariable Integer adminId, @RequestBody @Valid Category category){
        // logger.info("inside update category");
               categoryService.updateCategory(id,category,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("category Updated "));
    }
    @DeleteMapping("/delete/{id}/{adminId}")
    public ResponseEntity deleteCategory(@PathVariable Integer id,@PathVariable Integer adminId){
        // logger.info("inside delete category");
        categoryService.deleteCategory(id,adminId);
        return ResponseEntity.status(200).body(new ApiResponse("category deleted"));
    }
}
