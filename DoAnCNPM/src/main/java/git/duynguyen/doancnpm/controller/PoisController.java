package git.duynguyen.doancnpm.controller;

import git.duynguyen.doancnpm.DTO.APIResponse;
import git.duynguyen.doancnpm.DTO.PoisCreationRequest;
import git.duynguyen.doancnpm.DTO.PoisUpdateRequest;
import git.duynguyen.doancnpm.entity.Pois;
import git.duynguyen.doancnpm.service.PoisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poi-manage/api")
public class PoisController {
    @Autowired
    private PoisService poisService;
    @PostMapping
    APIResponse<Pois> createPoi(@RequestBody @Valid PoisCreationRequest request){
        APIResponse<Pois> response = new APIResponse<>();
        response.setData(poisService.create(request));
        return response;
    }
    @GetMapping
    List<Pois> getPois(){
        return poisService.getPoisList();
    }

    @GetMapping("/{poiId}")
    Pois getPoi(@PathVariable("poiId") String poiId){
        return poisService.getPoisById(poiId);
    }

    @PutMapping("/{poiId}")
    Pois updatePoi(@PathVariable("poiId") String poiId, @RequestBody PoisUpdateRequest request){
        return poisService.updatePoi(poiId,request);
    }
    @DeleteMapping("/{poiId}")
    void deletePoi(@PathVariable("poiId") String poiId){
        poisService.deletePoi(poiId);
    }
}
