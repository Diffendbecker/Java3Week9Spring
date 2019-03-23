package com.akomlev.demo.controllers;

import com.akomlev.demo.models.Subscription;
import com.akomlev.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeSubscriptionsController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/subscriptions")
    public String showSubscriptions(Model model) {
        model.addAttribute("subscription", new Subscription());
        model.addAttribute("subscriptions", subscriptionRepository.findAll());
        return "subscriptions";
    }

    @PostMapping("/subscriptions")
    public String addSubscription(@ModelAttribute("book") Subscription subscription){
        subscriptionRepository.save(subscription);
        return "thankyou";
    }
}