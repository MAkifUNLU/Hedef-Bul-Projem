package tr.com.akif.unlu.processor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processor")
public class ProcessorController {
  private final ProcessService processService;

  public ProcessorController(ProcessService processService) {
    this.processService = processService;
  }

  @PostMapping
  public ResponseEntity<Void> processInfo(@RequestBody InfoDto infoDto) {
    processService.process(infoDto);
    return ResponseEntity.ok().build();
  }
}
