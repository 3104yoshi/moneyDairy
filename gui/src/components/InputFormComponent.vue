<script setup>
import axios from 'axios';
import { ref } from 'vue';

const postDataValue = ref('');

const category = defineProps(['category_name'])

const postData = async () => {
  try {
    const response = await axios.post('http://localhost:8082/addPrice', { "category": "food", "date": "202401", "price": 1111 });
    console.log(response.data);
  } catch (error) {
    console.error('Error posting data:', error);
  }
}


</script>

<template>
  <div>
    <div>{{ category.category_name }}</div>
    <input v-model="postDataValue" placeholder="Enter value">
    <button @click="postData">Post to API</button>
    <div v-if="responseMessage">{{ responseMessage }}</div>
  </div>
</template>

<style>
.paging-footer {
  display: flex;
  justify-content: center;
  list-style: none;
}

.paging-item {
  margin: 0 5px;
}

.selectedItem>.paging-button {
  background-color: #d0d0d0;
  font-weight: bold;
} 

</style>