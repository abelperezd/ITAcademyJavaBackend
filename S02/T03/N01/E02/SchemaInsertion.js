
//---------------------------------------------------------- Provincia ----------------------------------------------------------
db.provincia.insertMany([
    { nom: "Madrid" },
    { nom: "Barcelona" },
    { nom: "Valencia" },
    { nom: "Sevilla" },
    { nom: "Málaga" }
])

//---------------------------------------------------------- Provincia ----------------------------------------------------------
db.adreca.insertMany([
    {
        adreca: "Calle Mayor, 1",
        codi_postal: "28013",
        localitat: "Madrid",
        provincia: ObjectId("6428243ba74747764451fbe2")
    },
    {
        adreca: "Rambla de Catalunya, 123",
        codi_postal: "08008",
        localitat: "Barcelona",
        provincia: ObjectId("6428243ba74747764451fbe3")
    },
    {
        adreca: "Carrer de la Pau, 1",
        codi_postal: "46003",
        localitat: "Valencia",
        provincia: ObjectId("6428243ba74747764451fbe4")
    },
    {
        adreca: "Calle Sierpes, 1",
        codi_postal: "41004",
        localitat: "Sevilla",
        provincia: ObjectId("6428243ba74747764451fbe5")
    },
    {
        adreca: "Calle Larios, 1",
        codi_postal: "29005",
        localitat: "Málaga",
        provincia: ObjectId("6428243ba74747764451fbe6")
    }
]);

//---------------------------------------------------------- clients ----------------------------------------------------------

db.client.insertMany([
    {
        nom: "Anna",
        cognoms: "Garcia Martinez",
        telefon: "+34 123456789",
        adreca: ObjectId("64282626a74747764451fbe7")
    },
    {
        nom: "David",
        cognoms: "Lopez Rodriguez",
        telefon: "+34 987654321",
        adreca: ObjectId("64282626a74747764451fbe8")
    },
    {
        nom: "Maria",
        cognoms: "Gonzalez Fernandez",
        telefon: "+34 555555555",
        adreca: ObjectId("64282626a74747764451fbe9")
    }
]);

//---------------------------------------------------------- botigues ----------------------------------------------------------

db.botiga.insertMany([
    {
        nom: "La Botiga del Barri",
        adreca: ObjectId("64282626a74747764451fbea")
    },
    {
        nom: "El Raco del Celler",
        adreca: ObjectId("64282626a74747764451fbeb")
    }
]);


//---------------------------------------------------------- treballadors ----------------------------------------------------------

db.treballador.insertMany([
    {
        nom: "Anna",
        cognoms: "Martínez García",
        telefon: "601234567",
        nif: "12345678A",
        posicio: "cuiner",
        botiga: ObjectId("6428275fa74747764451fbef")
    },
    {
        nom: "David",
        cognoms: "Fernández López",
        telefon: "602345678",
        nif: "23456789B",
        posicio: "repartidor",
        botiga: ObjectId("6428275fa74747764451fbf0")
    },
    {
        nom: "Laura",
        cognoms: "Gómez Hernández",
        telefon: "603456789",
        nif: "34567890C",
        posicio: "cuiner",
        botiga: ObjectId("6428275fa74747764451fbef")
    },
    {
        nom: "Sergio",
        cognoms: "Rodríguez García",
        telefon: "604567890",
        nif: "45678901D",
        posicio: "repartidor",
        botiga: ObjectId("6428275fa74747764451fbf0")
    },
    {
        nom: "María",
        cognoms: "García Martínez",
        telefon: "605678901",
        nif: "56789012E",
        posicio: "cuiner",
        botiga: ObjectId("6428275fa74747764451fbef")
    }
]);


//---------------------------------------------------------- categories_pizza ----------------------------------------------------------

db.categoria_pizza.insertMany([
    { nom: "Traditional" },
    { nom: "Gourmet" },
    { nom: "Vegetarian" },
    { nom: "Vegan" }
])

//---------------------------------------------------------- productes ----------------------------------------------------------
db.producte.insertMany([
    {
        nom: "Pepperoni Pizza",
        preu: NumberDecimal("12.99"),
        descripcio: "A classic pizza topped with spicy pepperoni slices.",
        categoria: {
            tipus: "pizza",
            categoria_pizza: ObjectId("64283f5fa74747764451fbfd")
        }
    },
    {
        nom: "Mushroom Pizza",
        preu: NumberDecimal("13.99"),
        descripcio: "A pizza topped with sautéed mushrooms, mozzarella cheese, and tomato sauce.",
        categoria: {
            tipus: "pizza",
            categoria_pizza: ObjectId("64283f5fa74747764451fbfe")
        }
    },
    {
        nom: "Spinach and Feta Pizza",
        preu: NumberDecimal("12.99"),
        descripcio: "A vegetarian pizza topped with spinach, feta cheese, and black olives.",
        categoria: {
            tipus: "pizza",
            categoria_pizza: ObjectId("64283f5fa74747764451fbff")
        }
    },
    {
        nom: "Vegan Pizza",
        preu: NumberDecimal("13.99"),
        descripcio: "A pizza with vegan cheese, vegetables, and tomato sauce.",
        categoria: {
            tipus: "pizza",
            categoria_pizza: ObjectId("64283f5fa74747764451fc00")
        }
    },
    {
        nom: "Bacon Cheeseburger",
        preu: NumberDecimal("10.99"),
        descripcio: "A burger with bacon, cheese, lettuce, tomato, and onion.",
        categoria: {
            tipus: "hamburguesa"
        }
    },
    {
        nom: "Veggie Burger",
        preu: NumberDecimal("9.99"),
        descripcio: "A vegetarian burger made with a vegetable patty, lettuce, tomato, and onion.",
        categoria: {
            tipus: "hamburguesa"
        }
    },
    {
        nom: "Hamburguesa clàssica",
        preu: NumberDecimal("5.50"),
        descripcio: "Hamburguesa amb carn de vedella, enciam, tomàquet i ceba caramel·litzada",
        categoria: {
            tipus: "hamburguesa"
        }
    },
    {
        nom: "Hamburguesa de pollastre",
        preu: NumberDecimal("6.00"),
        descripcio: "Hamburguesa amb carn de pollastre, enciam, tomàquet i maionesa",
        categoria: {
            tipus: "hamburguesa"
        }
    },
    {
        nom: "Coca-Cola",
        preu: NumberDecimal("1.50"),
        descripcio: "Refresc carbonatat de cola",
        categoria: {
            tipus: "beguda"
        }
    },
    {
        nom: "Aquarius Llimona",
        preu: NumberDecimal("1.20"),
        descripcio: "Beguda isotònica de llimona",
        categoria: {
            tipus: "beguda"
        }
    },
    {
        nom: "Zumo de naranja",
        preu: NumberDecimal("1.80"),
        descripcio: "Zumo natural de naranja",
        categoria: {
            tipus: "beguda"
        }
    }
])

//---------------------------------------------------------- comandes ----------------------------------------------------------


db.comanda.insertMany([{
    data: new Date("2022-03-15T12:30:00Z"),
    client: ObjectId("642826a9a74747764451fbec"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: { tipus: "recollida" },
    productes: [
        { producte: ObjectId("64284279a74747764451fc0e"), quantitat: 3 },
        { producte: ObjectId("64284279a74747764451fc0f"), quantitat: 2 }
    ]
},
{
    data: new Date("2022-03-16T13:45:00Z"),
    client: ObjectId("642826a9a74747764451fbec"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: {
        tipus: "lliurament",
        treballador: ObjectId("64283dffa74747764451fbf9")
    },
    productes: [
        { producte: ObjectId("64284279a74747764451fc10"), quantitat: 1 },
        { producte: ObjectId("64284279a74747764451fc11"), quantitat: 2 },
        { producte: ObjectId("64284279a74747764451fc12"), quantitat: 1 }
    ]
},
{
    data: new Date("2022-03-17T11:15:00Z"),
    client: ObjectId("642826a9a74747764451fbec"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: {
        tipus: "recollida"
    },
    productes: [
        { producte: ObjectId("64284279a74747764451fc0e"), quantitat: 1 },
        { producte: ObjectId("64284279a74747764451fc13"), quantitat: 2 }
    ]
},
{
    data: new Date("2022-03-18T10:00:00Z"),
    client: ObjectId("642826a9a74747764451fbee"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: {
        tipus: "lliurament",
        treballador: ObjectId("64283dffa74747764451fbfb")
    },
    productes: [
        { producte: ObjectId("64284279a74747764451fc11"), quantitat: 1 },
        { producte: ObjectId("64284279a74747764451fc14"), quantitat: 3 }
    ]
},
{
    data: new Date("2023-03-31"),
    client: ObjectId("642826a9a74747764451fbee"),
    botiga: ObjectId("6428275fa74747764451fbf0"),
    repartiment: {
        tipus: "lliurament",
        treballador: ObjectId("64283dffa74747764451fbf9")
    },
    productes: [
        {
            producte: ObjectId("64284279a74747764451fc10"),
            quantitat: 3
        },
        {
            producte: ObjectId("64284279a74747764451fc11"),
            quantitat: 1
        }
    ]
},
{
    data: new Date("2023-04-01"),
    client: ObjectId("642826a9a74747764451fbec"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: {
        tipus: "recollida"
    },
    productes: [
        {
            producte: ObjectId("64284279a74747764451fc12"),
            quantitat: 2
        },
        {
            producte: ObjectId("64284279a74747764451fc13"),
            quantitat: 1
        }
    ]
},
{
    data: new Date("2023-04-02"),
    client: ObjectId("642826a9a74747764451fbed"),
    botiga: ObjectId("6428275fa74747764451fbf0"),
    repartiment: {
        tipus: "lliurament",
        treballador: ObjectId("64283dffa74747764451fbfb")
    },
    productes: [
        {
            producte: ObjectId("64284279a74747764451fc14"),
            quantitat: 3
        },
        {
            producte: ObjectId("64284279a74747764451fc15"),
            quantitat: 1
        }
    ]
},
{
    data: new Date("2023-04-03"),
    client: ObjectId("642826a9a74747764451fbec"),
    botiga: ObjectId("6428275fa74747764451fbef"),
    repartiment: {
        tipus: "recollida"
    },
    productes: [
        {
            producte: ObjectId("64284279a74747764451fc16"),
            quantitat: 2
        },
        {
            producte: ObjectId("64284279a74747764451fc17"),
            quantitat: 1
        }
    ]
},
])


