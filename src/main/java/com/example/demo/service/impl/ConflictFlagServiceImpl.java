package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {
    private final ConflictFlagRepository repository;
    private final ConflictCaseRepository caseRepository;

    public ConflictFlagServiceImpl(ConflictFlagRepository repository, ConflictCaseRepository caseRepository) {
        this.repository = repository;
        this.caseRepository = caseRepository;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        ConflictCase conflictCase = caseRepository.findById(flag.getCaseId())
            .orElseThrow(() -> new ApiException("ConflictCase not found"));
        
        ConflictFlag saved = repository.save(flag);
        
        if ("HIGH".equals(flag.getSeverity())) {
            conflictCase.setRiskLevel("HIGH");
            caseRepository.save(conflictCase);
        }
        
        return saved;
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ApiException("Flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId) {
        return repository.findByCaseId(caseId);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repository.findAll();
    }
}


// package com.example.demo.service.impl;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.ConflictFlag;
// import com.example.demo.repository.ConflictCaseRepository;
// import com.example.demo.repository.ConflictFlagRepository;
// import com.example.demo.service.ConflictFlagService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ConflictFlagServiceImpl implements ConflictFlagService {

//     private final ConflictFlagRepository flagRepo;
//     private final ConflictCaseRepository caseRepo;

//     public ConflictFlagServiceImpl(ConflictFlagRepository flagRepo, ConflictCaseRepository caseRepo) {
//         this.flagRepo = flagRepo;
//         this.caseRepo = caseRepo;
//     }

//     @Override
//     public ConflictFlag addFlag(ConflictFlag flag) {
//         if (!caseRepo.existsById(flag.getCaseId())) {
//             throw new ApiException("case not found");
//         }
//         return flagRepo.save(flag);
//     }

//     @Override
//     public List<ConflictFlag> getFlagsByCase(Long caseId) {
//         return flagRepo.findByCaseId(caseId);
//     }

//     @Override
//     public ConflictFlag getFlagById(Long id) {
//         return flagRepo.findById(id)
//                 .orElseThrow(() -> new ApiException("flag not found"));
//     }

//     @Override
//     public List<ConflictFlag> getAllFlags() {
//         return flagRepo.findAll();
//     }
// }