package com.yong2ss.toberich.web.User;

import com.yong2ss.toberich.domain.posts.PostsRepository;
import com.yong2ss.toberich.domain.question.Question;
import com.yong2ss.toberich.domain.question.QuestionRepository;
import com.yong2ss.toberich.domain.user.User;
import com.yong2ss.toberich.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/users/{id}/questions")
    public List<Question> getAllQuestionsByUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return user.getQuestions();
    }

    @PostMapping("/users/{id}/questions")
    public ResponseEntity<Question> createQuestion(@PathVariable Long id, @RequestBody Question question) {
        User user = userRepository.findById(id).orElseThrow();
        question.setUser(user);
        Question savedQuestion = questionRepository.save(question);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")   //현재 생성되어 있는 ID값을 헤더로 저장해서 보냄
                .buildAndExpand(savedQuestion.getId())    //id매핑
                .toUri();

        return ResponseEntity.created(location).build();
    }



}
