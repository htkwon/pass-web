package com.example.passweb.service.pass;

import com.example.passweb.dto.pass.BulkPassDto;
import com.example.passweb.dto.pass.BulkPassModelMapper;
import com.example.passweb.dto.pass.BulkPassRequest;
import com.example.passweb.entity.pack.PackageEntity;
import com.example.passweb.entity.pass.BulkPassEntity;
import com.example.passweb.repository.BulkPassRepository;
import com.example.passweb.repository.PackageRepository;
import com.example.passweb.status.BulkPassStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BulkPassService {
    private final BulkPassRepository bulkPassRepository;
    private final PackageRepository packageRepository;

    public List<BulkPassDto> getAllBulkPasses(){
        List<BulkPassEntity> entities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(entities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest){
        PackageEntity entity = packageRepository.findById(bulkPassRequest.getPackageSeq())
                .orElseThrow();
        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(60);
        bulkPassEntity.setEndedAt(entity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }



}
