package com.example.streaming.service;

import com.example.streaming.builder.PlanSuscripcionBuilder;
import com.example.streaming.factory.PlanSuscripcionFactory;
import com.example.streaming.model.PlanSuscripcion;
import com.example.streaming.prototype.SuscripcionClonador;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public PlanSuscripcion crearPlan(PlanSuscripcionFactory factory, String nombreUsuario,
                                     String calidad,
                                     int dispositivos,
                                     boolean anuncios,
                                     boolean contenidoExclusivo,
                                     int almacenamientoExtra) {
        PlanSuscripcion nuevoPlan = factory.crearPlan(nombreUsuario,calidad,dispositivos,anuncios,
                contenidoExclusivo,almacenamientoExtra,0);
        nuevoPlan.setPrecioPlan(calcularPrecio(nuevoPlan));
        planesSuscripcion.add(nuevoPlan);
        return nuevoPlan;
    }

    public List<PlanSuscripcion> obtenerPlanes() {
        return planesSuscripcion;
    }


    public PlanSuscripcion modificarPlan(String nombreUsuario, String calidad, int dispositivos,
                                            boolean anuncios, boolean contenidoExclusivo, int almacenamientoExtra) {

        for (PlanSuscripcion plan : planesSuscripcion) {
            if (plan.getNombreUsuario().equals(nombreUsuario)) {
                PlanSuscripcion planPersonalizado = new PlanSuscripcionBuilder()
                        .setTipoPlan("Personalizado")
                        .setNombreUsuario(nombreUsuario)
                        .setCalidadVideo(calidad)
                        .setDispositivosPermitidos(dispositivos)
                        .setIncluyeAnuncios(anuncios)
                        .addContenidoExclusivo(contenidoExclusivo)
                        .addAlmacenamientoExtra(almacenamientoExtra)
                        .build();
                planPersonalizado.setPrecioPlan(calcularPrecio(planPersonalizado));
                int index = planesSuscripcion.indexOf(plan);
                planesSuscripcion.set(index, planPersonalizado);
                return planPersonalizado;
            }
        }
        throw new IllegalArgumentException("No se encontró el plan para el usuario: " + nombreUsuario);
    }

    public double consultarPrecioPlan(String calidad, int dispositivos,
                                         boolean anuncios, boolean contenidoExclusivo, int almacenamientoExtra) {
        PlanSuscripcion planPersonalizado = new PlanSuscripcionBuilder()
                .setCalidadVideo(calidad)
                .setDispositivosPermitidos(dispositivos)
                .setIncluyeAnuncios(anuncios)
                .addContenidoExclusivo(contenidoExclusivo)
                .addAlmacenamientoExtra(almacenamientoExtra)
                .build();
        planPersonalizado.setPrecioPlan(calcularPrecio(planPersonalizado));
        return planPersonalizado.getPrecioPlan();
    }

    public PlanSuscripcion clonarSuscripcion(String nombreUsuarioReferencia,String nombreUsuarioNuevo) {

        for (PlanSuscripcion plan : planesSuscripcion) {
            if (plan.getNombreUsuario().equals(nombreUsuarioReferencia)) {
                PlanSuscripcion planPersonalizado = suscripcionClonador.clonarSuscripcion(plan);

                planPersonalizado.setNombreUsuario(nombreUsuarioNuevo);

                planesSuscripcion.add(planPersonalizado);
                return planPersonalizado;
            }
        }
        throw new IllegalArgumentException("No se encontró el plan para el usuario: " + nombreUsuarioReferencia);
    }

    private double calcularPrecio(PlanSuscripcion plan) {
        double precioTotal = 0;


        switch (plan.getCalidadVideo().toLowerCase()) {
            case "sd":
                precioTotal += 5;
                break;
            case "hd":
                precioTotal += 6;
                break;
            case "4k":
                precioTotal += 7;
                break;
            default:
                throw new IllegalArgumentException("Calidad de video no válida");
        }


        if (plan.getDispositivosPermitidos() > 1) {
            precioTotal += (plan.getDispositivosPermitidos() - 1);
        }

        if (!plan.isIncluyeAnuncios()) {
            precioTotal += 3;
        }


        if (plan.isContenidoExclusivo()) {
            precioTotal += 4;
        }

        if (plan.getAlmacenamientoExtra() > 0) {
            precioTotal += plan.getAlmacenamientoExtra() * 0.1;
        }

        return precioTotal;
    }

}
