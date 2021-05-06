export class Info {
    startDate: Date;
    endDate: Date;
    duration: string;
    car: {
        id: number;
        placa: string;
    };
    poi: {
        id: number;
        nome: string;
        raio: number;
        latitude: number;
        longitude: number;
    }
}
