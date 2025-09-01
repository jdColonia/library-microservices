package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.dto.NotificationDTO;
import co.analisys.biblioteca.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationDTO notification) {
        notificationService.sendNotification(notification);
    }
}
