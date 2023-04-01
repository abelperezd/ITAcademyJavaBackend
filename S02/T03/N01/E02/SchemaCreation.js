//https://www.mongodb.com/docs/manual/reference/bson-types/
//https://www.mongodb.com/docs/manual/core/schema-validation/specify-json-schema/specify-allowed-field-values/#std-label-schema-allowed-field-values

use pizzeria;

db.createCollection('provincia', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                }
            }
        }
    }
})

db.createCollection('adreca', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["adreca", "codi_postal", "localitat", "provincia"],
            properties: {
                adreca: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                codi_postal: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                localitat: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                provincia: {
                    bsonType: "objectId",
                    description: "must be objectId and is required"
                }
            }
        }
    }
})

db.createCollection('botiga', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "adreca"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                adreca: {
                    bsonType: "objectId",
                    description: "must be string and is required"
                }
            }
        }
    }
})


db.createCollection('treballador', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "cognoms", "telefon", "nif", "posicio", "botiga"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                cognoms: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                telefon: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                nif: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                posicio: {
                    enum: ["cuiner", "repartidor"],
                    description: "must be a cuiner or repartidor and is required"
                },
                botiga: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
            }
        }
    }
})

db.createCollection('comanda', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["data", "client", "botiga", "repartiment", "productes"],
            properties: {
                data: {
                    bsonType: "date",
                    description: "must be date and is required"
                },
                client: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                botiga: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                repartiment: {
                    bsonType: "object",
                    description: "must be an object and is required",
                    required: ["tipus"],
                    properties: {
                        tipus: {
                            enum: ["recollida", "lliurament"],
                            description: "must be recollida or lliurament and is required"
                        },
                        treballador: {
                            bsonType: "objectId",
                            description: "must be an objectId and is optional, just for lliuraments"
                        },
                    }
                },
                productes: {
                    bsonType: "array",
                    description: "must be an array and is required",
                    items: {
                        bsonType: "object",
                        description: "must be an object and is required",
                        required: ["producte", "quantitat"],
                        properties: {
                            producte: {
                                bsonType: "objectId",
                                description: "must be an objectId and is required",
                            },
                            quantitat: {
                                bsonType: "int",
                                description: "must be an int and is optional, just for lliuraments"
                            },
                        }
                    }
                }
            }
        }
    }
})

db.createCollection('client', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "cognoms", "telefon", "adreca"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                cognoms: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                telefon: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                adreca: {
                    bsonType: "objectId",
                    description: "must be string and is required"
                }
            }
        }
    }
})

db.createCollection('producte', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "preu", "descripcio", "categoria"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                preu: {
                    bsonType: "decimal",
                    description: "must be decimal and is required"
                },
                descripcio: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                categoria: {
                    bsonType: "object",
                    description: "must be an object and is required",
                    required: ["tipus"],
                    properties: {
                        tipus: {
                            enum: ["pizza", "hamburguesa", "beguda"],
                            description: "must be enum and is required"
                        },
                        categoria_pizza: {
                            bsonType: "objectId",
                            description: "must be an objectId and is optional, just for lliuraments"
                        },
                    }
                },
                imatge: {
                    bsonType: "binData",
                    description: "must be binData and is required"
                }
            }
        }
    }
})

db.createCollection('categoria_pizza', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                }
            }
        }
    }
})
