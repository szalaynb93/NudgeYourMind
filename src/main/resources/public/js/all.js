function deleteToDo(id) {
    $.ajax({
        url: '/delete_todo',
        type: 'POST',
        data: {"toDoId" : id},
        success: function (data) {
            $("#todo" + id).remove();
            alert("ToDo deleted.")
            console.log("ToDo Deleted: " + data.responseText);
        },
        error: function (data) {
            console.log("ToDo deletion ERROR. Data: " + data.responseText);
        }
    })
}