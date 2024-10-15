package com.example.streaming.builder;

import com.example.streaming.model.PlanSuscripcion;

public class PlanSuscripcionBuilder {

    private String tipoPlan;
    private String nombreUsuario;
    private String calidadVideo;
    private int dispositivosPermitidos;
    private boolean incluyeAnuncios;
    private boolean contenidoExclusivo;
    private int almacenamientoExtra;

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public PlanSuscripcionBuilder setCalidadVideo(String calidad) {
        this.calidadVideo = calidad;
        return this;
    }

    public PlanSuscripcionBuilder setDispositivosPermitidos(int num) {
        this.dispositivosPermitidos = num;
        return this;
    }

    public PlanSuscripcionBuilder setIncluyeAnuncios(boolean incluye) {
        this.incluyeAnuncios = incluye;
        return this;
    }

    public PlanSuscripcionBuilder addContenidoExclusivo(boolean contenido) {
        this.contenidoExclusivo = contenido;
        return this;
    }

    public PlanSuscripcionBuilder addAlmacenamientoExtra(int cantidad) {
        this.almacenamientoExtra = cantidad;
        return this;
    }

    public PlanSuscripcion build() {
        return new PlanSuscripcion(tipoPlan, nombreUsuario, calidadVideo, dispositivosPermitidos,
                incluyeAnuncios, contenidoExclusivo, almacenamientoExtra);
    }
}
