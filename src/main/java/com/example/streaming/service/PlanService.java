package com.example.streaming.service;

import com.example.streaming.builder.PlanSuscripcionBuilder;
import com.example.streaming.factory.PlanSuscripcionFactory;
import com.example.streaming.model.PlanSuscripcion;
import com.example.streaming.prototype.SuscripcionClonador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

    private List<PlanSuscripcion> planesSuscripcion = new ArrayList<>();
    private final SuscripcionClonador suscripcionClonador = new SuscripcionClonador();

    public PlanSuscripcion crearPlan(PlanSuscripcionFactory factory, String nombreUsuario) {
        PlanSuscripcion nuevoPlan = factory.crearPlan(nombreUsuario);
        planesSuscripcion.add(nuevoPlan);
        return nuevoPlan;
    }

    public List<PlanSuscripcion> obtenerPlanes() {
        return planesSuscripcion;
    }

    public PlanSuscripcion personalizarPlan(String calidad, int dispositivos, boolean anuncios, boolean contenidoExclusivo, int almacenamientoExtra) {
        return new PlanSuscripcionBuilder()
                .setCalidadVideo(calidad)
                .setDispositivosPermitidos(dispositivos)
                .setIncluyeAnuncios(anuncios)
                .addContenidoExclusivo(contenidoExclusivo)
                .addAlmacenamientoExtra(almacenamientoExtra)
                .build();
    }

    public PlanSuscripcion clonarSuscripcion(PlanSuscripcion plan) {
        return suscripcionClonador.clonarSuscripcion(plan);
    }
}
