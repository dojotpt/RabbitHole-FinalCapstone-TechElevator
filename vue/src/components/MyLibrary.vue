<template>
    <div id="main-container">

    <div id="my-library-container">

        <div id="album-container">
            <ul>
                <li>
                    <button>Add Record</button>
                </li>
                <li v-for="album in albums" :key="album.id">
                    <h1>{{ album.title }}</h1>
                    <p>{{ album.artist }}</p>
                    <p>{{ album.genre }}</p>
            <div class="card-container">
                <div class="card">
                    <img src="@/images/vinyl-record_.png" />
                    <h2>Add a New Record</h2>
                    <div class="text-box">
                        <p>....</p>
                        <p>....</p>
                    </div>
                    <button class="add-record-button">Add Record</button>
                </div>
            

                <div class="card" v-for="album in albums" :key="album.id">

                    <img src="@/images/vinyl-record_.png" />
                    <div class="text-box">
                        <h2>{{ album.title }}</h2>
                        <p>{{ album.artist }}</p>
                        <p>{{ album.genre }}</p>
                    </div>
                    <div class="button-container">
                        <button>Edit Record</button>
                        <button>Delete Record</button>
                        <button id="edit-button"><img src="@/images/edit_.png"></button>
                        <button id="delete-button"><img src="@/images/trash_.png"></button>
                    </div>
                </li>
                </ul>
                </div>
            </div>
        </div>
   

</template>
</script>

<style scoped>
#main-container {
#my-library-container {
    display: flex;
    flex-direction: column;
    background-color: rgba(94, 65, 36, 0.9);
    border: black 2px solid;
    margin: auto;
    justify-content: center;
    list-style-type: none;
}


#album-container {

.card-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    list-style-type: none;
}

.card {
    background-color: #FCEBB6;
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    margin: 20px;
}

h2 {
    text-align: center;
}

.text-box p {
    padding-left: 20px;
}

.button-container {
    display: flex;
    justify-content: space-evenly;
    margin: 20px;
}

.add-record-button {
    display: flex;
    margin-left: 70px;
    justify-content: center;
}

.card img {
    width: 100%;
}

#edit-button img {
    width: 25px;

}

#delete-button img {
    width: 25px;
}
</style>
