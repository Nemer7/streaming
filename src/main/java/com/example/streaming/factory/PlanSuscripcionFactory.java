package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public interface PlanSuscripcionFactory {

    PlanSuscripcion crearPlan(String nombreUsuario);
}
