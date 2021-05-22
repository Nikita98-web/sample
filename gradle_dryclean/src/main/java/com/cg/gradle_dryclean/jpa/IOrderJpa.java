package com.cg.gradle_dryclean.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.gradle_dryclean.models.Order;



public interface IOrderJpa extends JpaRepository <Order, Long> {

}
