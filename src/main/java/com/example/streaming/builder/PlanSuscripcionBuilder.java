package com.example.streaming.builder;

import com.example.streaming.model.PlanSuscripcion;

public class PlanSuscripcionBuilder {

        private String calidadVideo;
        private int dispositivosPermitidos;
        private boolean incluyeAnuncios;
        private boolean contenidoExclusivo;
        private int almacenamientoExtra;

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
            return new PlanSuscripcion(calidadVideo, dispositivosPermitidos, incluyeAnuncios, contenidoExclusivo, almacenamientoExtra);
        }
}
