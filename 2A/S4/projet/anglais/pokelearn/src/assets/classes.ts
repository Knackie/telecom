export class ItemQuantity {
    type: number;
    quantity: number;

    constructor(type: number) {
        this.type = type;
        this.quantity = Math.floor(Math.random() * Math.floor(3));
    }
}

export const TYPE_POTION = 1;
export const TYPE_REPEL = 2;
