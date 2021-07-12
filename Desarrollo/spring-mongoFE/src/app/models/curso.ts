export class Curso {

    nombre: string;
    costo: number;
    descripcion: string;
    horas: number;
    dirigidoa: string;
    modalidad: string;

    constructor(nombre: string, costo: number, descripcion: string, horas: number,
        dirigidoa: string, modalidad: string) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.dirigidoa = dirigidoa;
        this.modalidad = modalidad;
    }
 
}
