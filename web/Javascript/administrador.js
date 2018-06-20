/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function mostrar(conf) {
    let usuarios = document.getElementById('tablaUsuarios');
    let materias = document.getElementById('tablaMaterias');
    if (conf == "usuario") {
        if( usuarios.style.display === 'inline') {
            usuarios.style.display = 'none';
        } else {
            usuarios.style.display = 'inline';
        }
        materias.style.display = 'none';
    }
    else {
        if( materias.style.display === 'inline') {
            materias.style.display = 'none';
        } else {
            materias.style.display = 'inline';
        }
        usuarios.style.display = 'none';
    }
}
