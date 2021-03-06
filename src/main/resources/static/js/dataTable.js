function getAnswer() {
    var question = document.getElementById("searchBox").value;
    if ($.fn.DataTable.isDataTable("#itemsTable")) {
      $('#itemsTable').DataTable().clear().destroy();
    };
        var table = $('#itemsTable').DataTable({
        "sAjaxSource": "/items?title="+question,
        "sAjaxDataProp": "",
        "order": [[ 0, "desc" ]],
        "aoColumns": [
              { "mData": "creation_date",
                "width": "15%"},
              { "mData": "title",
                "width": "70%",
                "render": function ( mData, type, row, meta ) {
                    return '<a href="' + row.link + '" target="_blank">' + mData+'</a>';
              }},
              { "mData": "owner",
                "width": "15%"},
              { "mData": "is_answered",
                "visible": false},
              { "mData": "link",
                "visible": false}
        ],
        "createdRow": function ( row, data, index ) {
                    if ( data["is_answered"] == true ) {
                        $('td', row).addClass('lightGreen');
                    }
                }
    });

$('#itemsTable').DataTable().ajax.reload();
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

$(document).ready(function() {
    var table = $('#itemsTable').DataTable({
            "aoColumns": [
                  { "width": "15%"},
                  { "width": "70%"},
                  { "width": "15%"},
                  { "visible": false},
                  { "visible": false}]});

    table.row.add( [ '', '', '', '', '' ] )
    .draw();
})