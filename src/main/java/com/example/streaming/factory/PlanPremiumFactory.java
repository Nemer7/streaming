package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanPremiumFactory implements PlanSuscripcionFactory{

    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario) {
        return new PlanSuscripcion("Premium",nombreUsuario,"4K", 4, false, true, 50);
    }
}
