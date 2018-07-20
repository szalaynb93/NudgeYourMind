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






const NLB = document.querySelector("#newLinkBtn");
const CNLB = document.querySelector("#closeLinkCreation");
const NLDIV = document.querySelector("#newLinkDiv");

function revealNewLink() {
    NLB.classList.add("hide");
    CNLB.classList.remove("hide");
    NLDIV.classList.remove("hide");
}

function unrevealNewLink() {
    NLB.classList.remove("hide");
    CNLB.classList.add("hide");
    NLDIV.classList.add("hide");
}

NLB.onclick = revealNewLink;
CNLB.onclick = unrevealNewLink;





function areYouSureToDo(id) {
    let ok = confirm("Are you sure to delete this todo?");
    if (ok === true) {
        deleteToDo(id)
    }
}

function areYouSureProject(id) {
    let ok = confirm("Are you sure to delete this project? All todos related will be deleted as well.");
    if (ok === true) {
        deleteProject(id)
    }
}

function areYouSureLink(id) {
    let ok = confirm("Are you sure to delete this Link?");
    if (ok === true) {
        deleteLink(id);
    }
}





function deleteToDo(id) {
    $.ajax({
        url: '/delete_todo',
        type: 'POST',
        data: {"toDoId" : id},
        success: function (data) {
            $("#todo" + id).remove();
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

function deleteLink(id) {
    $.ajax({
        url: '/delete_link',
        type: 'POST',
        data: {"linkId" : id},
        success: function (data) {
            $("#link" + id).remove();
            console.log("Link Deleted: " + data.responseText);
        },
        error: function (data) {
            console.log("Link deletion ERROR. Data: " + data.responseText);
        }
    })
}