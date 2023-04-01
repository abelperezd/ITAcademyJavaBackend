//https://www.mongodb.com/docs/manual/reference/bson-types/
//https://www.mongodb.com/docs/manual/core/schema-validation/specify-json-schema/specify-allowed-field-values/#std-label-schema-allowed-field-values

use cul_d_ampolla;

db.createCollection('proveidor', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "adreca", "telefon", "fax", "nif"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                adreca: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                telefon: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                fax: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                nif: {
                    bsonType: "string",
                    description: "must be a string and is required"
                }
            }
        }
    }
})

db.createCollection('adreca', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["carrer", "numero", "ciutat", "codi_postal", "pais"],
            properties: {
                carrer: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                numero: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                pis: {
                    bsonType: "string",
                    description: "must be string"
                },
                porta: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                ciutat: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                codi_postal: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                pais: {
                    bsonType: "string",
                    description: "must be string and is required"
                }
            }
        }
    }
})

db.createCollection('client', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nom", "telefon", "correu", "data_registre", "adreca"],
            properties: {
                nom: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                telefon: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                correu: {
                    bsonType: "string",
                    description: "must be string and is required"
                },
                data_registre: {
                    bsonType: "date",
                    description: "must be date and is required"
                },
                client_recomanador: {
                    bsonType: "objectId",
                    description: "must be an objectId"
                },
                adreca: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
            }
        }
    }
})

db.createCollection('venda', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["data_venda", "client_id", "empleat_id", "ulleres_id"],
            properties: {
                data_venda: {
                    bsonType: "date",
                    description: "must be date and is required"
                },
                client: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                empleat: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                ulleres: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
            }
        }
    }
})

db.createCollection('empleat', {
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

db.createCollection('ulleres', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["marca", "graduacio_esq", "graduacio_dre", "color_montura", "color_esq", "color_dre", "preu", "montura", "proveidor"],
            properties: {
                marca: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                graduacio_esq: {
                    bsonType: "decimal",
                    description: "must be a decimal and is required"
                },
                graduacio_dre: {
                    bsonType: "decimal",
                    description: "must be a decimal and is required"
                },
                color_montura: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                color_esq: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                color_dre: {
                    bsonType: "string",
                    description: "must be a string and is required"
                },
                preu: {
                    bsonType: "decimal",
                    description: "must be a decimal and is required"
                },
                montura: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
                proveidor: {
                    bsonType: "objectId",
                    description: "must be an objectId and is required"
                },
            }
        }
    }
})

db.createCollection('montura', {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["tipus"],
            properties: {
                tipus: {
                    bsonType: "string",
                    description: "must be string and is required"
                }
            }
        }
    }
})