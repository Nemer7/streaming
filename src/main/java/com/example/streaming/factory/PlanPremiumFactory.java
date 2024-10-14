package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanPremiumFactory implements PlanSuscripcionFactory{

    @Override
    public PlanSuscripcion crearPlan() {
        return new PlanSuscripcion("4K", 4, false, true, 50);
    }
}
