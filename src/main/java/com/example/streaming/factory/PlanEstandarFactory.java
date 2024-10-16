package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanEstandarFactory implements PlanSuscripcionFactory {

    private static final String TIPO_PLAN = "Estandar";
    private static final String CALIDAD_VIDEO = "HD";
    private static final int DISPOSITIVOS_PERMITIDOS = 2;
    private static final Boolean INCLUYE_ANUNCIOS = Boolean.FALSE;
    private static final Boolean CONTENIDO_EXCLUSIVO = Boolean.FALSE;
    private static final int ALMACENAMIENTO_EXTRA = 20;
    private static final double PRECIO_BASE = 16;
    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario) {
        return new PlanSuscripcion(TIPO_PLAN, nombreUsuario, CALIDAD_VIDEO,
                DISPOSITIVOS_PERMITIDOS, INCLUYE_ANUNCIOS, CONTENIDO_EXCLUSIVO, ALMACENAMIENTO_EXTRA,PRECIO_BASE);
    }

    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario, String calidad, int dispositivos,
                                     boolean anuncios, boolean contenidoExclusivo, int almacenamientoExtra, double precioPlan) {
        return new PlanSuscripcion(TIPO_PLAN, nombreUsuario, calidad, dispositivos, anuncios,
                contenidoExclusivo, almacenamientoExtra,PRECIO_BASE);
    }
}
