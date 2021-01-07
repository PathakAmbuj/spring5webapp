package com.ambuj.spring.controller;


import com.ambuj.spring.domain.Author;
import com.ambuj.spring.repositories.AuthorRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepositories authorRepositories;

    public AuthorController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping("authors")
    public String getAuthor(Model model){

        model.addAttribute("authors", authorRepositories.findAll());
        return "author/list";
    }
}
