//*******************************JAVASCRIPT PARA FORMULARIO***********************************************************
$(document).ready(function(){

    //$( "#persistirCompra" ).click(function(  ) {

//************************************  PRUEBA GET INFO **************************************************************
        //document.querySelector('#botonResult').addEventListener('click', accion1);

        //function accion1(){

        //var a = parseInt(document.getElementById('food0').value);
        //var b = parseInt(document.getElementById('food1').value);



        //console.log(a);
        //console.log(b);
        //}

//************************************  PRUEBA GET INFO **************************************************************

        //***************se deve habilitar ******>>>var x = document.getElementById("frm1");


        //window.confirm("vas a querer o se lo echo al perro!")
        //alert("GRACIAS POR SU COMPRA!!");
        //var urlVideogamesPersist = "/send-mail";

        //postearMail(urlVideogamesPersist);

   // });


/**
 *
 * Function "traerInfoComida" brings the info form GoogleSheets and shows up the menu available
 *
 **/
    traerInfoComida();
    function traerInfoComida()
    {
        /*$.getJSON("/sheets/Sheet1!A2:A", function (data) {
            //console.log(data);
            var foodData  = '';
            $.each(data, function (key, val) {
            //<option>Elige una opcion</option>
                foodData += '<option>' + val + "</option>";
            });
            $('.food1').append(foodData);
        });

        $.getJSON("/sheets/Sheet1!C2:C", function (data) {
            //console.log(data);
            var food1Data  = '';
            $.each(data, function (key, val) {
                //<option>Elige una opcion</option>
                food1Data += '<option>' + val + "</option>";
            });
            $('.food2').append(food1Data);
        });*/

        $.getJSON("/sheets/Sheet1!A2:C", function (data) {
            //console.log(data);
            var food2Data  = '';
            $.each(data, function (key, val) {

                var auxx = val.valueOf();

                //food2Data += '<h2>'+val+'</h2>';
                food2Data += "<div class='col-md-3'>";
                food2Data += "<div class='card mb-3 box-shadow'>";
                food2Data += "<img class='card-img-top' src='"+auxx[1]+"' alt='Card image cap' style='width:200px;height:300px;'>";
                food2Data += "<div class='card-body'>";
                food2Data += "<p class='card-text'>"+auxx[0]+"</p>";
                food2Data += "<input type='number'  id='food"+key+"' class='btn btn-sm btn-outline-secondary' name='quantity' min='0' max='10' step='1' value='0'>";
                food2Data += "<button type='button' class='btn btn-sm btn-outline-secondary'>Agregar</button>";
                food2Data += '</div>';
                food2Data += "<big class='text-muted price'>"+auxx[2]+"</big>";
                food2Data += '</div>';
                food2Data += '</div>';



                //console.log(auxx[0]);
            });
            $('.food3').append(food2Data);

        });
    }
});
console.log(a+b);
var a = 1;
var b = 1;

document.querySelector('#persistirCompra').addEventListener('click', accion1);

function accion1() {


    a = parseInt(document.getElementById('food0').value);
    b = document.getElementById('food1').value;
    var c = document.getElementById('firstName').value;

    var urlVideogamesPersist = "/send-mail/"+c;

    postearMail(urlVideogamesPersist);
    //window.location.href = "http://localhost:8083/result";

    //console.log(a+b);
    //console.log(c);
}

function postearMail(UrlAEnviar){
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: UrlAEnviar,
        dataType: "json"
    });
}
//*******************************    CONTACT SECTION       ***********************************************************
// Example starter JavaScript for disabling form submissions if there are invalid fields
//(function() {
    //'use strict';

    //window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        //var forms = document.getElementsByClassName('needs-validation');
        /*$( "#persistirCompra" ).click(forms, function( form ) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }else{
                    forms.classList.add('was-validated');
                    var urlVideogamesPersist = "/send-mail";
                    postearMail(urlVideogamesPersist);
                }

            });
        });*/
        // Loop over them and prevent submission
       /* var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }else{
                    forms.classList.add('was-validated');

                }
            });
        });
        console.log(validation);
    });*/

//})();


//*******************************    CONTACT SECTION       ***********************************************************
    /*$( "#persistirCompra" ).click(function( event ) {
        event.preventDefault();
        var urlVideogamesPersist = "/send-mail";


        postearMail(urlVideogamesPersist);

    });*/


//*******************************         FIN              ***********************************************************
//*******************************JAVASCRIPT PARA FORMULARIO***********************************************************
