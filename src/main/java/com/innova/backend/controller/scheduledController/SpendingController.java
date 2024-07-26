package com.innova.backend.controller.scheduledController;

import com.innova.backend.repository.ISpendingRepository;
import com.innova.backend.repository.ITotalSpendingCalc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/spending")
@RequiredArgsConstructor
public class SpendingController {
    private final ITotalSpendingCalc iTotalSpendingCalc;
    private final ISpendingRepository iSpendingRepository;

    @GetMapping("/{id}")
    public Integer getTotalSpendingById(@PathVariable Integer id) {
        int totalSpending = iSpendingRepository.getTotalSpendingById(id);
        return totalSpending;
    }



}
