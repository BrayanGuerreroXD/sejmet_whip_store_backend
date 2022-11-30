package com.project.sejmet.controllers;

import com.project.sejmet.entities.Question;
import com.project.sejmet.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;


    @GetMapping
    public List<Question> getQuestionAll() {
        return questionRepository.findAll();
    }


    @GetMapping("/{id}")
    public Question getQuestionbyId(@PathVariable int id) {

        Optional<Question> question = questionRepository.findById(id);

        if (question.isPresent()) {
            return question.get();
        }

        return null;
    }


    @PostMapping
    public Question postQuestion(@RequestBody Question question) {
        questionRepository.save(question);
        return question;
    }


    @PutMapping("/{id}")
    public Question putQuestionbyId(@PathVariable int id, @RequestBody Question question) {

        Optional<Question> questionCurrent = questionRepository.findById(id);

        if (questionCurrent.isPresent()) {
            Question questionReturn = questionCurrent.get();

            questionReturn.setProduct(question.getProduct());
            questionReturn.setUser(question.getUser());
            questionReturn.setStrQuestion(question.getStrQuestion());

            questionRepository.save(questionReturn);
            return questionReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Question deleteQuestionbyId(@PathVariable int id) {

        Optional<Question> question = questionRepository.findById(id);

        if (question.isPresent()) {
            Question questionReturn = question.get();
            questionRepository.deleteById(id);
            return questionReturn;
        }

        return null;
    }
}
