package git.duynguyen.doancnpm.service;

import git.duynguyen.doancnpm.DTO.PoisCreationRequest;
import git.duynguyen.doancnpm.DTO.PoisUpdateRequest;
import git.duynguyen.doancnpm.entity.Pois;
import git.duynguyen.doancnpm.repository.PoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class PoisService {
    @Autowired
    private PoisRepository poisRepository;
    public Pois create(PoisCreationRequest request){
        Pois poi = new Pois();
        poi.setPoiNameVi(request.getPoiNameVi());
        poi.setHistoricalPeriod(request.getHistoricalPeriod());
        poi.setLatitude(request.getLatitude());
        poi.setLongitude(request.getLongitude());
        poi.setProximityRadius(request.getProximityRadius());
        poi.setThumbnailUrl(request.getThumbnailUrl());
        poi.setStatus(request.getStatus());
        poi.setThumbnailUrl(request.getThumbnailUrl());
        poi.setCreatedAt(request.getCreatedAt());
        return poisRepository.save(poi);
    }
    public List<Pois> getPoisList(){
        return poisRepository.findAll();
    }
    public Pois getPoisById(String poiId){
        return poisRepository.findById(poiId)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
    public Pois updatePoi(String poiId, PoisUpdateRequest request){
        Pois poi = getPoisById(poiId);
        poi.setPoiNameVi(request.getPoiNameVi());
        poi.setHistoricalPeriod(request.getHistoricalPeriod());
        poi.setLatitude(request.getLatitude());
        poi.setLongitude(request.getLongitude());
        poi.setProximityRadius(request.getProximityRadius());
        poi.setThumbnailUrl(request.getThumbnailUrl());
        poi.setStatus(request.getStatus());
        return poisRepository.save(poi);
    }
    public void deletePoi(String poiId){
        poisRepository.deleteById(poiId);
    }
}
