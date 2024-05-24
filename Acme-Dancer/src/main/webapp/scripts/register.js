document.addEventListener("DOMContentLoaded", function() {
    function toggleActorFields() {
        var actorType = document.getElementById("actorType").value;
        var alumnoFields = document.getElementById("alumnoFields");
        var academiaFields = document.getElementById("academiaFields");
        
        if (actorType === "ALUMNO") {
            alumnoFields.classList.remove("hidden");
            academiaFields.classList.add("hidden");
        } else if (actorType === "ACADEMIA") {
            alumnoFields.classList.add("hidden");
            academiaFields.classList.remove("hidden");
        } else {
            alumnoFields.classList.add("hidden");
            academiaFields.classList.add("hidden");
        }
    }

    toggleActorFields();
    document.getElementById("actorType").addEventListener("change", toggleActorFields);
});