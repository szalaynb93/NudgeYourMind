console.log("KUTYA");
const TODOTABLE = document.querySelector("#todos");

$(function(){
    $.getJSON('http://0.0.0.0:8080/api/toDoNodes', function(data) {
        let toDoNodes = data._embedded.toDoNodes;

        for (let i in toDoNodes) {
            if (toDoNodes.hasOwnProperty(i)){
                $(TODOTABLE).append($('<tr>').attr('id', 'toDoNode' + i));
                let row = document.querySelector('#toDoNode' + i);
                $(row).append($('<td>').text(toDoNodes[i].toDoName));
                $(row).append($('<td>').text(toDoNodes[i].urgency));
                $(row).append($('<td>').text(toDoNodes[i].priority));
                $(row).append($('<td>').text(toDoNodes[i].duration));
                $(row).append($('<td>').text(toDoNodes[i].color));
                $.getJSON(toDoNodes[i]['_links'].project.href, data => {
                    $(row).append($('<td>').text(data.projectName));
                });
            }
        }

    });
});


