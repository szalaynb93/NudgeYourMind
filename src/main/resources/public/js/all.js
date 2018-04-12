function deleteToDo(id) {
    $.ajax({
        url: '/delete_todo',
        type: 'POST',
        data: {"toDoId" : id},
        success: function (data) {
            console.log("LineItem deleted. Data: " + data.responseText);
            $("#cartItem" + id).remove();
        },
        error: function (data) {
            console.log("LineItem deletion ERROR. Data: " + data.responseText);
        }
    })
}