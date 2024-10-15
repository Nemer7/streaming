package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanEstandarFactory implements PlanSuscripcionFactory{

    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario) {
        return new PlanSuscripcion("Estandar",nombreUsuario,"HD", 2, false, true, 20);
    }
}
