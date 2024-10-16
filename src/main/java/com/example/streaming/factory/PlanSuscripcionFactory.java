package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public interface PlanSuscripcionFactory {

    PlanSuscripcion crearPlan(String nombreUsuario);

    PlanSuscripcion crearPlan(String nombreUsuario,
                              String calidad,
                              int dispositivos,
                              boolean anuncios,
                              boolean contenidoExclusivo,
                              int almacenamientoExtra,
                              double precioPlan);
}
