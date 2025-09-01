package co.analisys.biblioteca.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "catalog-service",
    url = "${CATALOG_SERVICE_URL:http://localhost:8082}"
)
public interface CatalogServiceClient {
    @GetMapping("/books/{bookId}/available")
    Boolean isBookAvailable(@PathVariable("bookId") String bookId);

    @PutMapping("/books/{bookId}/availability")
    void updateBookAvailability(@PathVariable("bookId") String bookId, @RequestBody Boolean available);

    @GetMapping("/books/{bookId}")
    Object getBook(@PathVariable("bookId") String bookId);
}
