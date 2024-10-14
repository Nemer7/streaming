package com.example.streaming.controller;

import com.example.streaming.factory.*;
import com.example.streaming.model.PlanSuscripcion;
import com.example.streaming.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/basico")
    public PlanSuscripcion crearPlanBasico() {
        return planService.crearPlan(new PlanBasicoFactory());
    }

    @GetMapping("/estandar")
    public PlanSuscripcion crearPlanEstandar() {
        return planService.crearPlan(new PlanEstandarFactory());
    }

    @GetMapping("/premium")
    public PlanSuscripcion crearPlanPremium() {
        return planService.crearPlan(new PlanPremiumFactory());
    }

    @PostMapping("/personalizar")
    public PlanSuscripcion personalizarPlan(@RequestParam String calidad,
                                            @RequestParam int dispositivos,
                                            @RequestParam boolean anuncios,
                                            @RequestParam boolean contenidoExclusivo,
                                            @RequestParam int almacenamientoExtra) {
        return planService.personalizarPlan(calidad, dispositivos, anuncios, contenidoExclusivo, almacenamientoExtra);
    }

    @PostMapping("/clonar")
    public PlanSuscripcion clonarPlan(@RequestBody PlanSuscripcion plan) {
        return planService.clonarSuscripcion(plan);
    }
}
