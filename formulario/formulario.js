var inputs = document.getElementsByClassName("formularioinput");
for (let i=0; i<inputs.length; i++){
    inputs[i].addEventListener("keyup", function(){
        if(this.value.length>=1){
            this.nextElementSibling.classList.add("fijar");
        }else{
            this.nextElementSibling.classList.remove("fijar");
        }
    });
}

(function(e){
    let = document.getElementsByClassName("formulario")
    elementos = formulario.elements,
    boton = document.getElementsById("btn");

    let validarNombre = function(e){
        if(formulario.nombre.value = 0){
            alert("Completa el campo nombre");
            e.preventDefault();
        }
    };

    let validarApellido = function(e){
        if(formulario.apellido.value == 0){
            alert("Completa el campo apellido");
            e.preventDefault();
        }
    };

    let validarDocumento = function(e){
        if(formulario.documento.value == 0){
            alert("Completa el campo tipo de documento");
            e.preventDefault();
        }
    };
    
    let validarNDocumento = function(e){
        if(formulario.ndocumento.value == 0){
            alert("Completa el campo Numero de documento");
            e.preventDefault();
        }
    };

    let validarDireccion = function(e){
        if(formulario.direccion.value == 0){
            alert("Completa el campo Dirección");
            e.preventDefault();
        }
    };

    let validarCiudad = function(e){
        if(formulario.ndocumento.value == 0){
            alert("Completa el campo Ciudad");
            e.preventDefault();
        }
    };

    let validarTelefono = function(e){
        if(formulario.telefono.value == 0){
            alert("Completa el campo Telefono");
            e.preventDefault();
        }
    };

    let validarEmail = function(e){
        if(formulario.email.value == 0){
            alert("Completa el campo Numero de Email");
            e.preventDefault();
        }
    };

    let validar = function(e){
        validarNombre(e)
        validarApellido(e)
        validarDocumento(e)
        validarNDocumento(e)
        validarDireccion(e)
        validarCiudad(e)
        validarTelefono(e)
        validarEmail(e)
    };

    formulario.addEventListener("submit", validar);
    
})