<template>
    <div id="main-container">
        <div id="library-nav-container">
            <button id="add-record">Add a Record</button>
            <button id="add-collection">Add a Collection</button>
            <button id="add-friend">Add a Friend</button>
        </div>
        <div id="collection-container">
            <ul id="list-container">
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
                <li class="item">
                    <img src="placeholder.jpg" alt="record" />
                <div class="details">
                    <p>Album Title</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            
        }
    }
</script>

<style scoped>
#main-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
}

#library-nav-container {
    display: flex;
    justify-content: space-around;
    width: 100%;
    margin-bottom: 20px;
}

#library-nav-container button {
    padding: 10px 20px;
    font-size: 16px;
}

#collection-container {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    width: 100%;
}

.list-container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 20px;
    list-style-type: none;
    padding: 0;
}

.item {
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #f0f0f0;
    padding: 10px;
    border-radius: 10px;
    width: 200px;
    text-align: center;
}

.item img {
    width: 100%;
    height: auto;
    border-radius: 10px;
}

.details {
    margin-top: 10px;
}

.details p {
    margin: 0 0 10px;
}

.details button {
    margin: 5px;
    padding: 5px 10px;
}
</style>