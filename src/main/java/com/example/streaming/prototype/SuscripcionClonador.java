package com.example.streaming.prototype;

import com.example.streaming.model.PlanSuscripcion;

public class SuscripcionClonador {
    public PlanSuscripcion clonarSuscripcion(PlanSuscripcion plan) {
        return plan.clone();
    }
}
