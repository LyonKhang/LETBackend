package com.unwe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "please provide a short description")
    @Size(max = 50)
    private String textTitle;
    @NotBlank
    private double amountEnter;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate exchangeDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Selection selection;
    @OneToOne(cascade = CascadeType.ALL)
    private Spent spent;
}
