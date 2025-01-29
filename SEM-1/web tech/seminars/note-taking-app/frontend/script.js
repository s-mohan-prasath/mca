const displayNotes = () => {
    fetch("http://localhost:5000/notes", {
        method:"get"
    }).then(res => res.json()).then(data => {
        let noteContainer = document.getElementById("display-container")
        let noteCard;
        data?.notes.forEach(note => {
            noteCard =
                `<div class="note-card" id="${note?._id}" data-id="${note?._id}">
                    <p>${note?.title}</p>
                    <p>${note?.brief}</p>
                </div>`

                /**
                 * beforestart
                 * <div> start
                 * afterstart
                 * 
                 * beforeend
                 * </div> end
                 * afterend
                 */
                
            noteContainer.insertAdjacentHTML("beforeend", noteCard);
        })
    }).catch(e => {
        throw new Error("COULD NOT LOAD NOTES")
    })
}
displayNotes()