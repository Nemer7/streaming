package com.example.streaming.model;

public class PlanSuscripcion implements Cloneable {

    private String calidadVideo;
    private int dispositivosPermitidos;
    private boolean incluyeAnuncios;
    private boolean contenidoExclusivo;
    private int almacenamientoExtra;

    public PlanSuscripcion(String calidadVideo, int dispositivosPermitidos, boolean incluyeAnuncios, boolean contenidoExclusivo, int almacenamientoExtra) {
        this.calidadVideo = calidadVideo;
        this.dispositivosPermitidos = dispositivosPermitidos;
        this.incluyeAnuncios = incluyeAnuncios;
        this.contenidoExclusivo = contenidoExclusivo;
        this.almacenamientoExtra = almacenamientoExtra;
    }

    public void mostrarDetalles() {
        System.out.println("Plan de suscripción: " +
                "\nCalidad Video: " + calidadVideo +
                "\nDispositivos Permitidos: " + dispositivosPermitidos +
                "\nIncluye Anuncios: " + incluyeAnuncios +
                "\nContenido Exclusivo: " + contenidoExclusivo +
                "\nAlmacenamiento Extra: " + almacenamientoExtra + " GB");
    }

    public String getCalidadVideo() {
        return calidadVideo;
    }

    public void setCalidadVideo(String calidadVideo) {
        this.calidadVideo = calidadVideo;
    }

    public int getDispositivosPermitidos() {
        return dispositivosPermitidos;
    }

    public void setDispositivosPermitidos(int dispositivosPermitidos) {
        this.dispositivosPermitidos = dispositivosPermitidos;
    }

    public boolean isIncluyeAnuncios() {
        return incluyeAnuncios;
    }

    public void setIncluyeAnuncios(boolean incluyeAnuncios) {
        this.incluyeAnuncios = incluyeAnuncios;
    }

    public boolean isContenidoExclusivo() {
        return contenidoExclusivo;
    }

    public void setContenidoExclusivo(boolean contenidoExclusivo) {
        this.contenidoExclusivo = contenidoExclusivo;
    }

    public int getAlmacenamientoExtra() {
        return almacenamientoExtra;
    }

    public void setAlmacenamientoExtra(int almacenamientoExtra) {
        this.almacenamientoExtra = almacenamientoExtra;
    }

    @Override
    public PlanSuscripcion clone() {
        try {
            return (PlanSuscripcion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Error al clonar el objeto PlanSuscripcion", e);
        }
    }


}
