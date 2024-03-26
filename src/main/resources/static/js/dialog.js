function confirmDelete(id) {
    console.log(id);
    swal({
        title: "¿Está seguro de Eliminar?",
        text: "Eliminará el producto y los inventarios asociados",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url:"/inventario/"+id+"/eliminar",
                    success: function(res) {
                        console.log(res);
                    },
                });
                swal("Poof! Registro eliminado!", {
                    icon: "success",
                }).then((ok)=>{
                    if(ok){
                        location.href="/inventario";
                    }
                });
            }
        });
}