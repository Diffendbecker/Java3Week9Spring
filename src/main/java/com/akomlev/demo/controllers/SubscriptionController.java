package com.akomlev.demo.controllers;
import com.akomlev.demo.models.Subscription;
import com.akomlev.demo.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Service
@RequestMapping(path="/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @GetMapping(path="/subscribe")
    public @ResponseBody String addNewSubscription(@RequestParam String name, @RequestParam String email) {
        Subscription n = new Subscription();
        n.setEmail(email);
        n.setName(name);
        subscriptionRepository.save(n);
        return "You are subscribed. Thank You!";
    }

    @GetMapping(path="/unsubscribe")
    public @ResponseBody String removeSubscription(@RequestParam String email) {

        Subscription n = new Subscription();
        n.setEmail(email);
        subscriptionRepository.delete(n);
        return "You are successfully unsubscribed. Good Luck!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
