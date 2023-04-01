//---------------------------------------------------------- Adreca ----------------------------------------------------------

db.adreca.insertMany([
    {
        carrer: "Passeig de Gracia",
        numero: "92",
        pis: "1",
        porta: "1A",
        ciutat: "Barcelona",
        codi_postal: "08008",
        pais: "España"
    },
    {
        carrer: "Calle Mayor",
        numero: "7",
        pis: "4",
        porta: "D",
        ciutat: "Madrid",
        codi_postal: "28013",
        pais: "España"
    },
    {
        carrer: "Rua Augusta",
        numero: "123",
        pis: "2",
        porta: "C",
        ciutat: "Lisboa",
        codi_postal: "1100-048",
        pais: "Portugal"
    },
    {
        carrer: "Friedrichstraße",
        numero: "23",
        pis: "6",
        porta: "12",
        ciutat: "Berlin",
        codi_postal: "10117",
        pais: "Alemania"
    },
    {
        carrer: "Rue de Rivoli",
        numero: "18",
        pis: "5",
        porta: "B",
        ciutat: "Paris",
        codi_postal: "75001",
        pais: "Francia"
    },
    {
        carrer: "Via del Corso",
        numero: "100",
        pis: "3",
        porta: "7",
        ciutat: "Roma",
        codi_postal: "00186",
        pais: "Italia"
    },
    {
        carrer: "Plaza Mayor",
        numero: "5",
        pis: "1",
        porta: "1B",
        ciutat: "Salamanca",
        codi_postal: "37002",
        pais: "España"
    },
    {
        carrer: "Praca do Comercio",
        numero: "1",
        pis: "4",
        porta: "D",
        ciutat: "Lisboa",
        codi_postal: "1100-148",
        pais: "Portugal"
    },
    {
        carrer: "Bahnhofstrasse",
        numero: "15",
        pis: "2",
        porta: "C",
        ciutat: "Zurich",
        codi_postal: "8001",
        pais: "Suiza"
    },
    {
        carrer: "Calle de Alcalá",
        numero: "45",
        pis: "6",
        porta: "12",
        ciutat: "Madrid",
        codi_postal: "28014",
        pais: "España"
    }
]);

//---------------------------------------------------------- Proveidor ----------------------------------------------------------

db.proveidor.insertMany([
    {
        nom: "Acme Products Co.",
        adreca: ObjectId("6426df4911330f85d3f42b06"),
        telefon: "123-456-7890",
        fax: "098-765-4321",
        nif: "A12345678"
    },
    {
        nom: "Bob's Supplies Inc.",
        adreca: ObjectId("6426df4911330f85d3f42b07"),
        telefon: "234-567-8901",
        fax: "987-654-3210",
        nif: "B12345678"
    },
    {
        nom: "Charlie's Distribution",
        adreca: ObjectId("6426df4911330f85d3f42b08"),
        telefon: "345-678-9012",
        fax: "876-543-2109",
        nif: "C12345678"
    },
    {
        nom: "Delta Enterprises",
        adreca: ObjectId("6426df4911330f85d3f42b09"),
        telefon: "456-789-0123",
        fax: "765-432-1098",
        nif: "D12345678"
    },
    {
        nom: "Echo Supplies Co.",
        adreca: ObjectId("6426df4911330f85d3f42b0a"),
        telefon: "567-890-1234",
        fax: "654-321-0987",
        nif: "E12345678"
    }
]);

//---------------------------------------------------------- Client ----------------------------------------------------------

db.client.insertOne(
    {
        nom: "Francisco Gutierrez",
        telefon: "652589657",
        correu: "fg3000@gmail.com",
        data_registre: new Date("2016-05-18T16:00:00Z"),
        adreca: ObjectId("6426df4911330f85d3f42b0b"),
    }
);

db.client.insertOne(
    {
        nom: "Maria Rodriguez",
        telefon: "654982347",
        correu: "mrodriguez@gmail.com",
        data_registre: new Date("2020-09-21T10:00:00Z"),
        client_recomanador: ObjectId("6426ea5e11330f85d3f42b16"),
        adreca: ObjectId("6426df4911330f85d3f42b0c"),
    });
db.client.insertOne(
    {
        nom: "Carlos Ramirez",
        telefon: "625387219",
        correu: "cramirez@gmail.com",
        data_registre: new Date("2018-03-15T14:00:00Z"),
        adreca: ObjectId("6426df4911330f85d3f42b0d"),
    });
db.client.insertOne(
    {
        nom: "Ana Perez",
        telefon: "678435128",
        correu: "aperez@gmail.com",
        data_registre: new Date("2021-01-05T09:00:00Z"),
        client_recomanador: ObjectId("6426ec4f11330f85d3f42b17"),
        adreca: ObjectId("6426df4911330f85d3f42b0e"),
    });
db.client.insertOne(
    {
        nom: "Juan Lopez",
        telefon: "633574981",
        correu: "jlopez@gmail.com",
        data_registre: new Date("2017-07-03T12:00:00Z"),
        adreca: ObjectId("6426df4911330f85d3f42b0f"),
    });


//---------------------------------------------------------- Empleat ----------------------------------------------------------

db.empleat.insertMany([
    { nom: "John Doe" },
    { nom: "Jane Smith" },
    { nom: "Bob Johnson" },
    { nom: "Alice Lee" },
    { nom: "Mike Brown" }
])

//---------------------------------------------------------- Montura ----------------------------------------------------------

db.montura.insertMany([
    {
        tipus: "Rounded"
    },
    {
        tipus: "Rectangular"
    },
    {
        tipus: "Cat Eye"
    },
    {
        tipus: "Browline"
    },
    {
        tipus: "Aviator"
    }
])


//---------------------------------------------------------- Ulleres ----------------------------------------------------------

db.ulleres.insertOne(
    {
      marca: "Ray-Ban",
      graduacio_esq: NumberDecimal("2.5"),
      graduacio_dre: NumberDecimal("2.0"),
      color_montura: "negre",
      color_esq: "transparent",
      color_dre: "transparent",
      preu: NumberDecimal("150.99"),
      montura: ObjectId("6426ee8611330f85d3f42b20"),
      proveidor: ObjectId("6426e0a411330f85d3f42b10")
    })
    db.ulleres.insertMany([
        {
          marca: "Oakley",
          graduacio_esq: NumberDecimal("1.75"),
          graduacio_dre: NumberDecimal("2.25"),
          color_montura: "blau",
          color_esq: "blau",
          color_dre: "verd",
          preu: NumberDecimal("200.50"),
          montura: ObjectId("6426ee8611330f85d3f42b21"),
          proveidor: ObjectId("6426e0a411330f85d3f42b11")
        },
        {
          marca: "Prada",
          graduacio_esq: NumberDecimal("3.0"),
          graduacio_dre: NumberDecimal("3.0"),
          color_montura: "rosa",
          color_esq: "marro",
          color_dre: "lila",
          preu: NumberDecimal("350.75"),
          montura: ObjectId("6426ee8611330f85d3f42b22"),
          proveidor: ObjectId("6426e0a411330f85d3f42b12")
        },
        {
          marca: "Tom Ford",
          graduacio_esq: NumberDecimal("1.25"),
          graduacio_dre: NumberDecimal("1.0"),
          color_montura: "marró",
          color_esq: "gris",
          color_dre: "negre",
          preu: NumberDecimal("280.25"),
          montura: ObjectId("6426ee8611330f85d3f42b23"),
          proveidor: ObjectId("6426e0a411330f85d3f42b13")
        },
        {
          marca: "Gucci",
          graduacio_esq: NumberDecimal("1.5"),
          graduacio_dre: NumberDecimal("1.75"),
          color_montura: "vermell",
          color_esq: "transparent",
          color_dre: "rosa",
          preu: NumberDecimal("420.99"),
          montura: ObjectId("6426ee8611330f85d3f42b24"),
          proveidor: ObjectId("6426e0a411330f85d3f42b14")
        }
      ]);

//---------------------------------------------------------- Vendes ----------------------------------------------------------

db.venda.insertMany([
    {
      data_venda: new Date('2023-03-31'),
      client_id: ObjectId("6426ea5e11330f85d3f42b16"),
      empleat_id: ObjectId("6426ee0e11330f85d3f42b1b"),
      ulleres_id: ObjectId("6426f14711330f85d3f42b2b")
    },
    {
      data_venda: new Date('2023-03-30'),
      client_id: ObjectId("6426ec4f11330f85d3f42b17"),
      empleat_id: ObjectId("6426ee0e11330f85d3f42b1c"),
      ulleres_id: ObjectId("6426f26011330f85d3f42b2c")
    },
    {
      data_venda: new Date('2023-03-29'),
      client_id: ObjectId("6426eccf11330f85d3f42b18"),
      empleat_id: ObjectId("6426ee0e11330f85d3f42b1d"),
      ulleres_id: ObjectId("6426f26011330f85d3f42b2d")
    },
    {
      data_venda: new Date('2023-03-28'),
      client_id: ObjectId("6426ecdf11330f85d3f42b19"),
      empleat_id: ObjectId("6426ee0e11330f85d3f42b1e"),
      ulleres_id: ObjectId("6426f26011330f85d3f42b2e")
    },
    {
      data_venda: new Date('2023-03-27'),
      client_id: ObjectId("6426ecf511330f85d3f42b1a"),
      empleat_id: ObjectId("6426ee0e11330f85d3f42b1f"),
      ulleres_id: ObjectId("6426f26011330f85d3f42b2f")
    }
  ])

  