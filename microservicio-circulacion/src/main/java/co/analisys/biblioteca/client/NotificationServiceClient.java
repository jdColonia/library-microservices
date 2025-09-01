package co.analisys.biblioteca.client;

import co.analisys.biblioteca.dto.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "notification-service", 
    url = "${NOTIFICATION_SERVICE_URL:http://localhost:8084}"
)
public interface NotificationServiceClient {
    @PostMapping("/notify")
    void sendNotification(@RequestBody NotificationDTO notification);
}
