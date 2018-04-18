
$(document).ready( function () {
	 var table = $('#itemsTable').DataTable({
			"sAjaxSource": "/items",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
				  { "mData": "creation_date" },
				  { "mData": "title" },
				  { "mData": "owner" },
			]
	 })
});