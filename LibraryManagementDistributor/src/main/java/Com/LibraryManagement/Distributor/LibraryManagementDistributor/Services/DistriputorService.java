package Com.LibraryManagement.Distributor.LibraryManagementDistributor.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
public class DistriputorService {
	
	
    @RequestMapping("/placeOrder")
    public ResponseEntity<String> placeOrder() {
    	
    	System.out.println(" Api Called Sucessfuly");
    	
        return ResponseEntity.status(HttpStatus.FOUND).body("Book Order Successfully");	    	

    	
    }
	
	

}
