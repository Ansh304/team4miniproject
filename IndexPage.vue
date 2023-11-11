<template>
  <div>
    <q-select
      v-model="selectedCategory"
      :options="categoryOptions"
      label="Select a Category"
      emit-value
      map-options
    />
 
    <q-select
      v-model="selectedOption"
      :options="filteredOptions"
      label="Select an Option"
      emit-value
      map-options
      :disable="!selectedCategory"
    />
  </div>
</template>
 
<script>
export default {
  data() {
    return {
      selectedCategory: null,
      selectedOption: null,
      categories: ['Category 1', 'Category 2', 'Category 3'],
      optionsByCategory: {
        'Category 1': ['Option 1A', 'Option 1B', 'Option 1C'],
        'Category 2': ['Option 2A', 'Option 2B', 'Option 2C'],
        'Category 3': ['Option 3A', 'Option 3B', 'Option 3C'],
      },
    };
  },
  computed: {
    categoryOptions() {
      return this.categories.map((category) => ({
        label: category,
        value: category,
      }));
    },
    filteredOptions() {
      return this.optionsByCategory[this.selectedCategory] || [];
    },
  },
};
</script>