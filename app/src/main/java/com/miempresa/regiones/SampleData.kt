package com.miempresa.regiones

data class Message(
    val titulo: String,
    val descripcion: String,
    val imagen : String,
    val region: String,
)

object SampleData {
    val comidas = listOf(
        Message(
            "Ceviche",
            "El ceviche es el plato bandera del Perú, este plato tiene ingredientes como pescado, limón, ají, cebolla, cilantro, sal y pimienta.",
            "https://www.todoenperu.net/platos-tipicos/wp-content/uploads/2019/04/ceviche-1024x683.jpg",
            "Costa"
        ),
        Message(
            "Lomo Saltado",
            "Su preparación consiste en freír trozos de lomo de res con verduras, pimiento amarillo y salsa de soja.",
            "https://www.todoenperu.net/platos-tipicos/wp-content/uploads/2019/04/lomo-saltado-1024x683.jpg",
            "Costa"
        ),
        Message(
            "Ají de Gallina",
            "Contiene gallina o pollo desmenuzado en una crema de pimientos amarillos, queso y pimientos picantes.",
            "https://decomidaperuana.com/wp-content/uploads/2017/09/receta-de-aji-de-gallina.jpg",
            "Costa"
        ),
        Message(
            "Causa Rellena",
            "Es un plato frío, preparado a base de papa blanca y amarilla, añadiendo aceitunas, cebolla, huevo y una cucharada de pimienta amarilla. Debe sazonarse con aceite, limón y sal al gusto.",
            "https://www.todoenperu.net/platos-tipicos/wp-content/uploads/2019/04/causa-rellena-1024x683.jpg",
            "Costa"
        ),
        Message(
            "Arroz con pollo",
            "Un plato bandera que hace que los condimentos que se agregan le hagan único e inigualable.",
            "https://www.todoenperu.net/platos-tipicos/wp-content/uploads/2019/04/arroz-con-pollo-1024x683.jpg",
            "Costa"
        ),
        Message(
            "Cuy chactado",
            "para cocinar el cuy chactado se fríe un ejemplar entero y se come en plato o con las manos, como si fuera un muslo de pollo.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/cuy-chactado.jpg",
            "Sierra"
        ),
        Message(
            "Pachamanca",
            "mezcla de carnes que se aderezan con chincho y huacatay, ají, pimiento, comino y otras especias.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/pachamanca-comida.jpg",
            "Sierra"
        ),
        Message(
            "Ocopa",
            "Es un platillo de papas cocidas, huevos duros troceados y, opcionalmente, aceitunas de botija, en el que el ingrediente distintivo es una salsa picante.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/ocopa-comida.jpg",
            "Sierra"
        ),
        Message(
            "Rocoto relleno",
            "El fruto se rellena de carne molida de res o de puerco, o una mezcla de ambas, más guisantes, aceitunas, queso fresco, perejil picado, comino y otras especias al gusto.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/rocoto-relleno.jpg",
            "Sierra"
        ),
        Message(
            "Patasca",
            "La patasca peruana se prepara con mondongo (vísceras), patas de res, carne vacuna y mote de maíz cocido. En algunos lugares se añade cabeza de cordero.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/mondongo-o-patasca.jpg",
            "Sierra"
        ),
        Message(
            "Juane",
            "Se hace con piezas de gallina, trozos de huevo duro y aceitunas de botija, ingredientes que se envuelven en la masa y luego en hojas de bijao que son hervidas.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/juane-peru.jpg",
            "Selva"
        ),
        Message(
            "Humitas",
            "Es una especie de tamal de maíz y otros ingredientes que se consume en la Amazonia y en los Andes, que está envuelto en hojas de mazorca llamadas chalas y pancas.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/humitas-peru.jpg",
            "Selva"
        ),
        Message(
            "Brochetas de suri",
            "Su suave textura y sabor se parece al del pollo y se comen acompañado de trozos de yuca y plátano sancochado o asado.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/brochetas-de-suri.jpg",
            "Selva"
        ),
        Message(
            "Tacacho con cecina y chorizo",
            "Se prepara a base de plátano verde que se ablanda al ser asado o freído. Luego se machaca y mezcla con manteca de puerco.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/tacacho-con-cecina-y-chorizo.jpg",
            "Selva"
        ),
        Message(
            "Timbuche",
            "es una sopa conocida en la selva peruana como “levanta muertos”. Sus principales ingredientes son pescado fresco, huevos batidos y sachacilantro.",
            "https://tipsparatuviaje.com/wp-content/uploads/2019/10/timbuche-peru.jpg",
            "Selva"
        ),
    )
}


