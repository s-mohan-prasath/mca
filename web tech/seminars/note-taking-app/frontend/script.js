const displayNotes = () => {
    fetch("http://localhost:5000/notes", {
    }).then(res => res.json()).then(data => {
        let noteContainer = document.getElementById("display-container")
        let noteCard;
        data?.notes.forEach(note => {
            noteCard =
                `<div class="note-card">
                    <p>${note?.title}</p>
                    <p>${note?.brief}</p>
                </div>`
            noteContainer.insertAdjacentHTML("beforeend", noteCard);
        })
    }).catch(e => {
        throw new Error("COULD NOT LOAD NOTES")
    })
}
displayNotes()