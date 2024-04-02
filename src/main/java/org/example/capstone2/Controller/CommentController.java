package org.example.capstone2.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.capstone2.API.ApiResponse;
import org.example.capstone2.Model.Comment;
import org.example.capstone2.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/vision/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    //  Logger logger =LoggerFactory.getLogger(CommentController.class);
    @GetMapping("/get")
    public ResponseEntity getComment(){
        // logger.info("inside the get all comment ");
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }
    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment){
        // logger.info("inside add comment ");
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment added "));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment){
        // logger.info("inside update comment ");
        commentService.updateComment(id,comment);
        return ResponseEntity.status(200).body(new ApiResponse("comment Updated "));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        // logger.info("inside delete comment ");
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("comment deleted"));
    }
    @GetMapping("/list-coment-content/{id}")
    public ResponseEntity commentByContentId(@PathVariable Integer id){
        // logger.info("inside search comments by content id");
        List<Comment> commentListContentId=commentService.commentsOnContent(id) ;
        return ResponseEntity.status(200).body(commentListContentId);
    }

    @GetMapping("/list-user/{userId}")
    public ResponseEntity commentByUserId(@PathVariable Integer userId){
        // logger.info("inside search comment by user id");
        List<Comment> commentListUserId=commentService.commentsByUser(userId) ;
        return ResponseEntity.status(200).body(commentListUserId);
    }

    @GetMapping("/list-comment-date/{date}")
    public ResponseEntity commentByDate(@PathVariable LocalDate date){
        // logger.info("inside search comment by date");
        List<Comment> commentList=commentService.commentByDate(date) ;
        return ResponseEntity.status(200).body(commentList);
    }
}
