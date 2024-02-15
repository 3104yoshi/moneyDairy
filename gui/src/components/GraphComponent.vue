<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';

const price = ref(null);
onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8082/getTotalPrice')
    if (response.status === 200) {
      console.log(response.data);
      price.value = response.data.totalPrice;
    }
    else {
      console.error('Failed to fetch data:', response.status, response.statusText);
    }
  }
  catch (error) {
    console.log(error);
  }});

</script>

<template>
  <div>
    {{ price }}
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