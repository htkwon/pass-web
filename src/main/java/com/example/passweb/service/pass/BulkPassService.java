package com.example.passweb.service.pass;

import com.example.passweb.dto.pass.BulkPassDto;
import com.example.passweb.dto.pass.BulkPassModelMapper;
import com.example.passweb.dto.pass.BulkPassRequest;
import com.example.passweb.entity.pack.PackageEntity;
import com.example.passweb.entity.pass.BulkPassEntity;
import com.example.passweb.repository.BulkPassRepository;
import com.example.passweb.repository.PackageRepository;
import com.example.passweb.status.BulkPassStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkPassService {
    private BulkPassRepository bulkPassRepository;
    private PackageRepository packageRepository;

    public List<BulkPassDto> getAllBulkPasses(){
        List<BulkPassEntity> entities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(entities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest){
        PackageEntity entity = packageRepository.findById(bulkPassRequest.getPackageSeq())
                .orElseThrow();
        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setBulkPassStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(entity.getCount());
        bulkPassEntity.setEndedAt(entity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }



}
