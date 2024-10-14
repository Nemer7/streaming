package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanBasicoFactory implements PlanSuscripcionFactory{


    @Override
    public PlanSuscripcion crearPlan() {
        return new PlanSuscripcion("SD", 1, true, false, 0);
    }

}
