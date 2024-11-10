package com.jr.veterinary_clinic.controllers;

import com.jr.veterinary_clinic.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients/")
public class ClientController {

    @GetMapping("nouveau")
    public String getClientCreation(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("nouveau")
    public String createClient(@ModelAttribute("client") Client newClient) {
        System.out.println(newClient);
        return "redirect:/";
    }

}
