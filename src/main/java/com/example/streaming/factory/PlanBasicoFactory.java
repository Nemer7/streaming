package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;

public class PlanBasicoFactory implements PlanSuscripcionFactory {
    private static final String TIPO_PLAN = "Basico";
    private static final String CALIDAD_VIDEO = "SD";
    private static final int DISPOSITIVOS_PERMITIDOS = 1;
    private static final Boolean INCLUYE_ANUNCIOS = Boolean.TRUE;
    private static final Boolean CONTENIDO_EXCLUSIVO = Boolean.FALSE;
    private static final int ALMACENAMIENTO_EXTRA = 0;
    private static final double PRECIO_BASE = 5;

    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario) {
        return new PlanSuscripcion(TIPO_PLAN, nombreUsuario, CALIDAD_VIDEO, DISPOSITIVOS_PERMITIDOS,
                INCLUYE_ANUNCIOS, CONTENIDO_EXCLUSIVO, ALMACENAMIENTO_EXTRA, PRECIO_BASE);
    }


    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario, String calidad, int dispositivos,
                                     boolean anuncios, boolean contenidoExclusivo, int almacenamientoExtra,double precioPlan) {
        return new PlanSuscripcion("Basico", nombreUsuario, calidad, dispositivos, anuncios,
                contenidoExclusivo, almacenamientoExtra, PRECIO_BASE);
    }

}
