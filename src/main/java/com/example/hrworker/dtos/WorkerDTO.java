package com.example.hrworker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO implements Serializable {
    private String name;
    private BigDecimal dailyIncome;

    // Métodos getters e setters para 'name'
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos getters e setters para 'dailyIncome'
    public BigDecimal getDailyIncome() {
        return this.dailyIncome;
    }

    public void setDailyIncome(BigDecimal dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
