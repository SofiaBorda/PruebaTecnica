function updateCities() {
        var countrySelect = document.getElementById("country");
        var citySelect = document.getElementById("city");

        // Limpiar las opciones actuales
        citySelect.innerHTML = "";

        // Obtener el valor seleccionado del país
        var selectedCountry = countrySelect.value;

        // Agregar opciones de ciudad según el país seleccionado
        if (selectedCountry === "usa") {
            addOption(citySelect, "new-york", "Nueva York");
            addOption(citySelect, "los-angeles", "Los Ángeles");
            addOption(citySelect, "chicago", "Chicago");
        } else if (selectedCountry === "canada") {
            addOption(citySelect, "toronto", "Toronto");
            addOption(citySelect, "vancouver", "Vancouver");
            addOption(citySelect, "montreal", "Montreal");
        } else if (selectedCountry === "mexico") {
            addOption(citySelect, "mexico-city", "Ciudad de México");
            addOption(citySelect, "guadalajara", "Guadalajara");
            addOption(citySelect, "monterrey", "Monterrey");
        }
    }

    function addOption(selectElement, value, text) {
        var option = document.createElement("option");
        option.value = value;
        option.text = text;
        selectElement.add(option);
    }

    // Llamar a updateCities al cargar la página para establecer las opciones iniciales
    updateCities();

function del(id) {
    console.log("Button clicked")
    console.log(id);

    // Mostrar un cuadro de confirmación nativo del navegador
    var confirmacion = window.confirm("¿Está seguro de eliminar?");

    // Verificar si el usuario hizo clic en "Aceptar" o "Cancelar"
    if (confirmacion) {
        // Realizar la operación de eliminación si el usuario hizo clic en "Aceptar"
        $.ajax({
            url: "/del/" + id,
            type: 'GET',
            success: function (res) {
                console.log(res);

                // Mostrar un mensaje de éxito
                alert("Registro eliminado!");

                // Eliminar la fila correspondiente en la tabla
                window.location.href = "/";
            },
            error: function (error) {
                console.error(error.responseText);
                alert("Error al eliminar el registro");
            }
        });
    } else {
        // Hacer algo si el usuario hizo clic en "Cancelar" (opcional)
        console.log("Operación de eliminación cancelada");
    }
}
function mostrarMensaje() {
    alert('Guardado exitosamente');
}