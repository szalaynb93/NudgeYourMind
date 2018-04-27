function deleteToDo(id) {
    $.ajax({
        url: '/delete_todo',
        type: 'POST',
        data: {"toDoId" : id},
        success: function (data) {
            $("#todo" + id).remove();
            $("#ptodo" + id).remove();

            console.log("ToDo Deleted: " + data.responseText);
        },
        error: function (data) {
            console.log("ToDo deletion ERROR. Data: " + data.responseText);
        }
    })
}

function deleteProject(id) {
    $.ajax({
        url: '/delete_project',
        type: 'POST',
        data: {"projectId" : id},
        success: function (data) {
            $("#project" + id).remove();
            console.log("Project Deleted: " + data.responseText);
        },
        error: function (data) {
            console.log("Project deletion ERROR. Data: " + data.responseText);
        }
    })
}


const NTDB = document.querySelector("#newToDoBtn");
const CNTDB = document.querySelector("#closeToDoCreation");
const NTDDIV = document.querySelector("#newToDoDiv");

function revealNewToDo() {
    NTDB.classList.add("hide");
    CNTDB.classList.remove("hide");
    NTDDIV.classList.remove("hide");
}

function unrevealNewToDo() {
    NTDB.classList.remove("hide");
    CNTDB.classList.add("hide");
    NTDDIV.classList.add("hide");
}

NTDB.onclick = revealNewToDo;
CNTDB.onclick = unrevealNewToDo;





const NPB = document.querySelector("#newProjectBtn");
const CNPB = document.querySelector("#closeProjectCreation");
const NPDIV = document.querySelector("#newProjectDiv");

function revealNewProject() {
    NPB.classList.add("hide");
    CNPB.classList.remove("hide");
    NPDIV.classList.remove("hide");
}

function unrevealNewProject() {
    NPB.classList.remove("hide");
    CNPB.classList.add("hide");
    NPDIV.classList.add("hide");
}

NPB.onclick = revealNewProject;
CNPB.onclick = unrevealNewProject;



const ATDB = document.querySelector("#AllToDoBtn");
const APB = document.querySelector("#AllProjectsBtn");
const ATDDIV = document.querySelector("#allToDoDiv");
const APDIV = document.querySelector("#allProjectsDiv");


function todoView() {
    APDIV.classList.add("hide");
    ATDDIV.classList.remove("hide");
}

function projectView() {
    APDIV.classList.remove("hide");
    ATDDIV.classList.add("hide");
}

ATDB.onclick = todoView;
APB.onclick = projectView;