

const displaySubscribers = () => {
    fetch("http://localhost:3000/", {
    }).then(res => res.json()).then(data => {
        let subscriberContainer = document.getElementById("display-container");
        subscriberContainer.innerHTML = '<h2>Subscribers</h2>';
        data?.subscribers.forEach(subscriber => {
            const subscriberJson = JSON.stringify(subscriber).replace(/"/g, '&quot;'); // Escape quotes
            const subscriberCard = `
                <div class="subscriber-card" id="note-${subscriber._id}">
                    <div class="icon-cont">
                        <i class="fas fa-edit" onclick="editSubscriber('${subscriber._id}', ${subscriberJson})"></i> <!-- Edit Icon -->
                        <i class="fas fa-trash-alt" onclick="deleteSubscriber('${subscriber._id}')"></i>
                    </div>  
                    <p><strong>${subscriber?.aadharno}</strong></p>
                    <p>${subscriber?.name}</p>
                    <p><strong>hobbies : </strong>${subscriber?.hobbies}</p>
                    <p><strong>websites : </strong>${subscriber?.websites}</p>
                </div>
            `;
            subscriberContainer.insertAdjacentHTML("beforeend", subscriberCard);
        });

    }).catch(e => {
        console.error("Could not load notes", e);
        alert("could not display subscribers")
    });
};

const createSubscriber = (e) => {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const aadharno = document.getElementById("aadharno").value;
    const hobbies = document.getElementById("hobbies").value;
    const websites = document.getElementById("websites").value;
    const network = document.getElementById("network").value;

    const subscriberId = document.getElementById("subscriberForm").getAttribute("data-subscriber-id");

    if (subscriberId) {
        fetch(`http://localhost:3000/${subscriberId}`, {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, aadharno, network, hobbies, websites }),
        })
            .then(res => res.json())
            .then(() => {
                displaySubscribers();
                document.getElementById("subscriberForm").reset();
                document.getElementById("submit-button").value = "SUBMIT";
                document.getElementById("subscriberForm").removeAttribute("data-subscriber-id");
                alert("Subscriber Updated!")
            })
            .catch(e => {
                console.error("Error updating note", e);
                alert("could not update subscriber")
            });
    } else {
        fetch("http://localhost:3000/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, aadharno, network, hobbies, websites }),
        })
            .then(res => res.json())
            .then(() => {
                displaySubscribers();
                document.getElementById("subscriberForm").reset();
                alert("Subscriber Created!")
            })
            .catch(e => {
                console.error("Error creating note", e);
                alert("could not create subscriber")
            });
    }
};

const editSubscriber = (id, subscriberData) => {
    // subscriberData = JSON.parse(subscriberData)
    document.getElementById("name").value = subscriberData?.name;
    document.getElementById("aadharno").value = subscriberData?.aadharno;
    document.getElementById("hobbies").value = subscriberData?.hobbies;
    document.getElementById("websites").value = subscriberData?.websites;
    document.getElementById("network").value = subscriberData?.network;
    document.getElementById("subscriberForm").setAttribute("data-subscriber-id", id);
    document.getElementById("submit-button").value = "Update";
};

const deleteSubscriber = (id) => {
    let yes = prompt("Do you want to delete? (yes/no)")
    if (yes == 'no') return;
    fetch(`http://localhost:3000/${id}`, {
        method: "DELETE",
    })
        .then(res => res.json())
        .then(() => {
            displaySubscribers();
            alert("subscriber deleted!")
        })
        .catch(e => {
            console.error("Error deleting note", e);
            alert("could not subscriber")
        });
};
const searchSubscribers = () => {
    const query = document.getElementById("search-input").value.trim();

    fetch(`http://localhost:3000/search?query=${encodeURIComponent(query)}`)
        .then((res) => res.json())
        .then((data) => {
            const subscriberContainer = document.getElementById("display-container");
            subscriberContainer.innerHTML = "<h2>Subscribers</h2>"; // Clear current subscribers

            if (data?.subscribers?.length) {
                data.subscribers.forEach((subscriber) => {
                    const subscriberCard = `
              <div class="subscriber-card" id="note-${subscriber._id}">
                <div class="icon-cont">
                  <i class="fas fa-edit" onclick="editSubscriber('${subscriber._id}')"></i>
                  <i class="fas fa-trash-alt" onclick="deleteSubscriber('${subscriber._id}')"></i>
                </div>
                <p><strong>${subscriber.aadharno}</strong></p>
                <p>${subscriber.name}</p>
                <p><strong>Hobbies:</strong> ${subscriber.hobbies}</p>
                <p><strong>Websites:</strong> ${subscriber.websites}</p>
              </div>
            `;
                    subscriberContainer.insertAdjacentHTML("beforeend", subscriberCard);
                });
            } else {
                subscriberContainer.innerHTML += "<p>No subscribers found for this query.</p>";
            }
        })
        .catch((error) => {
            console.error("Error fetching search results:", error);
            alert("Error occurred while searching subscribers.");
        });
};


document.getElementById("subscriberForm").addEventListener("submit", createSubscriber);
displaySubscribers();