package com.example.streaming.controller;

import com.example.streaming.factory.*;
import com.example.streaming.model.PlanSuscripcion;
import com.example.streaming.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/consultaPlanes")
    public List<PlanSuscripcion> obtenerTodosLosPlanes() {
        return planService.obtenerPlanes();
    }

    @PostMapping("/basico")
    public PlanSuscripcion crearPlanBasico(@RequestParam String nombreUsuario) {
        return planService.crearPlan(new PlanBasicoFactory(), nombreUsuario);
    }

    @PostMapping("/estandar")
    public PlanSuscripcion crearPlanEstandar(@RequestParam String nombreUsuario) {
        return planService.crearPlan(new PlanEstandarFactory(), nombreUsuario);
    }

    @PostMapping("/premium")
    public PlanSuscripcion crearPlanPremium(@RequestParam String nombreUsuario) {
        return planService.crearPlan(new PlanPremiumFactory(), nombreUsuario);
    }

    @PostMapping("/personalizado")
    public PlanSuscripcion crearPlanPerzonaliado(@RequestParam String nombreUsuario,
                                                 @RequestParam String calidad,
                                                 @RequestParam int dispositivos,
                                                 @RequestParam boolean anuncios,
                                                 @RequestParam boolean contenidoExclusivo,
                                                 @RequestParam int almacenamientoExtra) {
        return planService.crearPlan(new PlanPersonalizadoFactory(), nombreUsuario, calidad, dispositivos,
                anuncios, contenidoExclusivo, almacenamientoExtra);
    }

    @PostMapping("/modificarPlan")
    public PlanSuscripcion modificarPlan(@RequestParam String nombreUsuario,
                                            @RequestParam String calidad,
                                            @RequestParam int dispositivos,
                                            @RequestParam boolean anuncios,
                                            @RequestParam boolean contenidoExclusivo,
                                            @RequestParam int almacenamientoExtra) {
        return planService.modificarPlan(nombreUsuario, calidad, dispositivos, anuncios,
                contenidoExclusivo, almacenamientoExtra);
    }

    @GetMapping("/consultaPrecioPlan")
    public double consultarPrecioPlan(@RequestParam String calidad,
                                      @RequestParam int dispositivos,
                                      @RequestParam boolean anuncios,
                                      @RequestParam boolean contenidoExclusivo,
                                      @RequestParam int almacenamientoExtra) {
        return planService.consultarPrecioPlan(calidad, dispositivos, anuncios,
                contenidoExclusivo, almacenamientoExtra);
    }

    @PostMapping("/clonar")
    public PlanSuscripcion clonarPlan(@RequestBody PlanSuscripcion plan) {
        return planService.clonarSuscripcion(plan);
    }
}
