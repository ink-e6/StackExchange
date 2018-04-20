function getAnswer() {
    var question = document.getElementById("searchBox").value;
    if ($.fn.DataTable.isDataTable("#itemsTable")) {
      $('#itemsTable').DataTable().clear().destroy();
    };
        var table = $('#itemsTable').DataTable({
        "sAjaxSource": "/items?title="+question,
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
              { "mData": "creation_date" },
              { "mData": "title",
                "render": function ( mData, type, row, meta ) {
                    return '<a href="' + row.link + '" target="_blank">' + mData+'</a>';
              }},
              { "mData": "owner" },
              { "mData": "link",
                "visible": false}
        ]
    });

$('#itemsTable').DataTable().ajax.reload();

//    table.ajax.reload( function ( json ) {
//        $('#myInput').val( json.lastInput );
//    } );
};

$(document).ready( function () {
    var input = document.getElementById("searchBox");
    input.addEventListener("keyup", function(event) {
        event.preventDefault();
        if (event.keyCode === 13) {
            document.getElementById("searchBtn").click();
        }
});
}
);