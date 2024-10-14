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

    @Override
    public PlanSuscripcion clone() {
        try {
            return (PlanSuscripcion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
