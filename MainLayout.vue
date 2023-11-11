<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated :class="$q.dark.isActive ? 'bg-secondary' : 'bg-black'">
        <q-toolbar>
          <!-- <q-btn flat @click="drawer = !drawer" round dense icon="menu" /> -->
          <q-toolbar-title><i>LTIMindtree</i></q-toolbar-title>
          <q-space />
          <q-btn
            flat
            round
            dense
            v-if="!$q.dark.isActive"
            icon="brightness_2"
            @click="toggleDarkMode"
          />
          <q-btn
            flat
            round
            dense
            v-else
            icon="wb_sunny"
            @click="toggleDarkMode"
          />
          <q-btn flat round dense icon="account_circle" @click="openProfile" />
        </q-toolbar>
      </q-header>
        <q-item class="drop-buttons">
          <div class="select-option" v-for="button in ribbonButtons" :key="button.label">
            <q-btn color="deep-orange" @click="showOption(button)" push>
              <div class="row items-center no-wrap">
                <q-icon left name="map" />
                <div class="text-center">
                  {{ button.label }}
                </div>
              </div>
            </q-btn>
          </div>
        </q-item>
        <!-- Scrollable Drop-down with Checkboxes -->
        <!-- Options Dropdown -->
        <div class="q-pa-md q-gutter-sm">
    <!-- <q-btn label="Click me" color="primary" @click="layout = true" /> -->

    <q-dialog v-model="optionsDialog">
      <q-layout view="Lhh lpR fff" container class="bg-white text-dark">
        <q-header class="bg-primary">
          <q-toolbar>
            <q-btn flat @click="drawer = !drawer" round dense icon="menu" />
            <q-toolbar-title>Header</q-toolbar-title>
            <q-btn flat @click="drawerR = !drawerR" round dense icon="menu" />
            <q-btn flat v-close-popup round dense icon="close" />
          </q-toolbar>
        </q-header>

        <q-footer class="bg-black text-white">
          <q-toolbar>
            <q-toolbar-title>Footer</q-toolbar-title>
          </q-toolbar>
        </q-footer>

        <q-drawer bordered v-model="drawer" :width="200" :breakpoint="600" class="bg-grey-3 text-dark q-pa-sm">
          <div v-for="n in 50" :key="n">Drawer {{ n }} / 50</div>
        </q-drawer>

        <q-drawer side="right" bordered v-model="drawerR" :width="200" :breakpoint="300" class="bg-grey-3 text-dark q-pa-sm">
          <div v-for="n in 50" :key="n">Drawer {{ n }} / 50</div>
        </q-drawer>

        <q-page-container>
          <q-page padding>
            <p v-for="n in contentSize" :key="n">
              {{ lorem }}
            </p>
          </q-page>
        </q-page-container>
      </q-layout>
    </q-dialog>
  </div>
        <!-- <q-dialog v-model="optionsDialog" persistent>
          <q-card>
            <q-card-section>
              <q-list class = "options">
                <q-item v-for="item in activeButton.Option" :key="item[0]">
                  <q-item-section>
                    <q-item-label for="item[1]">
                      <q-checkbox
                            v-model="item[1]"
                            checked-icon="visibility"
                            unchecked-icon="visibility_off"
                            class="q-ml-md"
                            :label="item[0]" 
                        />
                    </q-item-label>
                  </q-item-section>
                </q-item>
              </q-list>
            </q-card-section>
            <q-card-actions align="center">
              <q-btn label="Close" color="primary" @click="closeOptions" />
            </q-card-actions>
          </q-card>
        </q-dialog> -->
        
        
        <q-page-container>
          <router-view />
        </q-page-container>
  </q-layout>
</template>

<script setup>
import {ref, computed} from "vue"
import { useQuasar } from 'quasar'
  const $q = useQuasar()
  const moreContent = ref(true)
  const contentSize =  computed(() => moreContent.value ? 150 : 5)
  const drawer =  ref(false)
  const drawerR = ref(false)
  const lorem =  ref('Lorem ipsum dolor sit amet consectetur, adipisicing elit. Natus, ratione eum minus fuga, quasi dicta facilis corporis magnam, suscipit at quo nostrum!')
    
const ribbonButtons=  ref([
        { label: 'Domain', Option: [['OS',false], ['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],['Cloud' ,false],] },
        { label: 'Technology', Option: [] },
        { label: 'Deliverables', Option: [] },
        { label: 'Process', Option: [] },
        { label: 'Sub-processes', Option: [] },
        { label: 'Task', Option: [] },
      ])
      var check5 = ref(false)
      var activeButton = ref(null)
      var optionsDialog = ref(false)

      function showOption(button) {
          activeButton.value = button
          optionsDialog.value = true
      }

      function closeOptions () {
        activeButton.value = null
        optionsDialog.value = false
      }
      function toggleDarkMode() {
        $q.dark.toggle();
      }
</script>

<style scoped>
.drop-buttons{
  display: flex;
  align-items: center;
  justify-content: space-evenly;
}
.select-option{
  margin-top: 50px;
}
.options{
  
}
</style>


