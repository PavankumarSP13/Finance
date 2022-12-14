package com.springboot.finance.controller;

import com.springboot.finance.model.FinanceDTO;
import com.springboot.finance.model.ResponseFinance;
import com.springboot.finance.service.FinanceService;
import com.springboot.finance.service.FinanceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FinanceController {

    @Autowired //dependency injection
    private FinanceService financeService;

    private Logger LOGGER = LoggerFactory.getLogger(FinanceController.class);

    @GetMapping("/allSalary") //will be converted to json by spring mvc
    public ResponseFinance<List<FinanceDTO>> getAllSalary()
    {
        return financeService.getAllSalary();
    }

    @GetMapping("/salary/{id}")
    public ResponseFinance<FinanceDTO> getTopic(@PathVariable int id){
        return financeService.getSalary(id);
    }

    @PostMapping("/addSalary")
    public ResponseFinance<FinanceDTO> addTopic(@RequestBody FinanceDTO financeDTO) throws Exception//pick this instance from request payload
    {
        return financeService.addSalary(financeDTO);
    }

    @PutMapping( "/updateSalary/{id}")
    public ResponseFinance<FinanceDTO> updateTopic(@RequestBody FinanceDTO financeDTO, @PathVariable int id)//pick this instance from request payload
    {
        return financeService.updateSalary(id, financeDTO);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public ResponseFinance<FinanceDTO> deleteSalary(@PathVariable int id)
    {
        return financeService.deleteSalary(id);
    }

  /*  @PatchMapping("/topics/{id}/{name}")
    public ResponseFinance<FinanceDTO> updatePartialTopic( @PathVariable int id , @PathVariable int salary){
        return financeService.updatePartialSalary(id,salary);
    } */

}
