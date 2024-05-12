package tr.com.akif.unlu.target;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target")
public class TargetController {

  private final LocationService locationService;

  public TargetController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping
  public ResponseEntity<TargetDto> getLocationInformation(@RequestBody TargetRequestDto request) {
    return ResponseEntity.ok(locationService.getLocationInformation(request));
  }
}
