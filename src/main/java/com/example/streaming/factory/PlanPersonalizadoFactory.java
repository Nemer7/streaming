package com.example.streaming.factory;

import com.example.streaming.model.PlanSuscripcion;
import org.springframework.web.bind.annotation.RequestParam;

public class PlanPersonalizadoFactory implements PlanSuscripcionFactory {

    private static final String TIPO_PLAN = "Personalizado";
    private static final String CALIDAD_VIDEO = "4K";
    private static final int DISPOSITIVOS_PERMITIDOS = 4;
    private static final Boolean INCLUYE_ANUNCIOS = Boolean.FALSE;
    private static final Boolean CONTENIDO_EXCLUSIVO = Boolean.TRUE;
    private static final int ALMACENAMIENTO_EXTRA = 50;
    private static final double PRECIO_BASE = 15;
    @Override
    public PlanSuscripcion crearPlan(String nombreUsuario) {
        return new PlanSuscripcion(TIPO_PLAN,nombreUsuario,CALIDAD_VIDEO,
                DISPOSITIVOS_PERMITIDOS, INCLUYE_ANUNCIOS, CONTENIDO_EXCLUSIVO, ALMACENAMIENTO_EXTRA,PRECIO_BASE);
    }

    public PlanSuscripcion crearPlan(String nombreUsuario, String calidad, int dispositivos, boolean anuncios,
                                     boolean contenidoExclusivo, int almacenamientoExtra, double precioPlan) {
        return new PlanSuscripcion(TIPO_PLAN, nombreUsuario, calidad,
                dispositivos, anuncios, contenidoExclusivo, almacenamientoExtra,precioPlan);
    }
}
