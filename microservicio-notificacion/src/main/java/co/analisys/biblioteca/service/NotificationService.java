package co.analisys.biblioteca.service;

import co.analisys.biblioteca.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(NotificationDTO notification) {
        // Simulate notification sending
        System.out.println("Notification sent to " + notification.getUserId() + ": " + notification.getMessage());
    }
}