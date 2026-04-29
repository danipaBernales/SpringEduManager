// EFECTO SIMPLE AL CARGAR

document.addEventListener(
    "DOMContentLoaded",
    () => {

        const body =
            document.querySelector("body");

        body.style.opacity = 0;

        setTimeout(() => {

            body.style.transition =
                "opacity 1s";

            body.style.opacity = 1;

        }, 200);
    }
);

// VALIDACIÓN SIMPLE

function validarFormulario() {

    const inputs =
        document.querySelectorAll(
            "input"
        );

    let valido = true;

    inputs.forEach(input => {

        if (
            input.value.trim() === ""
        ) {

            valido = false;

            input.style.border =
                "2px solid red";
        }
    });

    return valido;
}
