package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanEstandarFactory implements PlanSuscripcionFactory{

    @Override
    public PlanSuscripcion crearPlan() {
        return new PlanSuscripcion("HD", 2, false, true, 20);
    }
}
