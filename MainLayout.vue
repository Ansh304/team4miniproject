<template>
  <q-layout background-color = "#DBDBDB"  view="lHh Lpr lFf">
    <q-header elevated>
        <q-toolbar :class="$q.dark.isActive ? 'bg-secondary' : 'bg-black'">
          <q-toolbar-title><i>LTIMindtree</i></q-toolbar-title>
          <q-space />
          <q-btn flat round dense v-if="!$q.dark.isActive" icon="brightness_2" @click="toggleDarkMode"/>
          <q-btn flat round dense v-else icon="wb_sunny" @click="toggleDarkMode"/>
          <q-btn flat round dense icon="account_circle" @click="openProfile" />

          
        </q-toolbar>
          <div class="row bg-white">
            <q-btn outline  square  style = "padding:10px" v-for="button in buttons" :key="button" class="col" color="primary" @click="showOption(button)" push>
                <q-icon left name="map" />{{ button }}
                <q-tooltip class="bg-black">Select Option </q-tooltip>
              </q-btn>
          </div>
        
      </q-header>
        <div class="q-pa-md q-gutter-sm">

    <q-dialog v-model="optionsDialog">
      <q-layout view="Lhh lpR fff" container class="bg-white text-dark">
        <q-header class="bg-primary">
          <q-toolbar>
            <q-btn v-if="activeButton !='Domain' " flat @mouseover="drawer = !drawer" round dense icon="menu"/>
            <q-toolbar-title>{{ activeButton }}</q-toolbar-title>
            <q-btn flat v-close-popup round dense icon="close" />
          </q-toolbar>
        </q-header>

        <q-footer class="bg-black text-white">
          <q-toolbar>
            <q-toolbar-title>Footer</q-toolbar-title>
          </q-toolbar>
        </q-footer>

        <q-drawer bordered  v-model="drawer" :width="200" :breakpoint="600" class="bg-grey-3 text-dark">
          <div>
            <q-list>
              <q-item clickable v-ripple v-for="sideOption in sideNavOption[activeButton]" :key="sideOption" class = "side-list-item">
                  <q-item-section>{{ sideOption }}</q-item-section>
                <q-separator />
              </q-item>
            </q-list>
          </div>
          <div></div>
        </q-drawer>

        <q-page-container>
          <q-page padding>
            <div  class="q-gutter-sm">
              <q-checkbox v-for = "box in optionsList[activeButton]" @click = "addRemoveFeild(box)" :key = "box[0]"  keep-color v-model="box[1]" :label="box[0]" color="cyan" />
            </div>
          </q-page>
        </q-page-container>
      </q-layout> 
    </q-dialog>

  </div>
        <q-page-container>
          <router-view />
        </q-page-container>
  </q-layout>
</template>

<script setup>
import {ref, computed} from "vue"
import { useQuasar } from 'quasar'
const $q = useQuasar()
const drawer =  ref(false)
const activeButton = ref(null)
const optionsDialog = ref(false)
const link = ref('inbox')

  const optionsList =  ref({
    "Domain":[["OS" , false] , ["Network", false] , ["Cloud", false] , ["Infra", false]],
    "Technology":[["Windows" , false] , ["linux", false] , ["ubuntu", false] , ["centos", false]],
    "Deliverables":[],
    "Process":[],
    "Sub-processes":[],
    "Task":[],
  })
  const sideNavOption = ref({
    "Technology":[],
    "Deliverables":[],
    "Process":[],
    "Sub-processes":[],
    "Task":[]
})
const buttons = ref(['Domain' ,'Technology',"Deliverables","Process","Sub-processes","Task" ])
      function showOption(button) {
          activeButton.value = button
          optionsDialog.value = true
          drawer.value = false
      }

      function closeOptions () {
        activeButton.value = null
        optionsDialog.value = false
      }

      function toggleDarkMode() {
        $q.dark.toggle();
      }

      function removeItemAll(arr, value) {
          var i = 0;
          while (i < arr.length) {
            if (arr[i] === value) {
              arr.splice(i, 1);
              // break;
            } else {
              ++i;
            }
          }
          return arr;
      }

      function addRemoveFeild(checkbox){
        if(checkbox[1]){
          if(activeButton.value == "Domain"){
            console.log(checkbox[0])
            sideNavOption.value["Technology"].push(checkbox[0]);

          }else if(activeButton.value == "Technology"){
          
            sideNavOption.value["Deliverables"].push(checkbox[0]);
          
          }else if(activeButton.value == "Deliverables"){

            sideNavOption.value["Process"].push(checkbox[0]);
            
          }else if(activeButton.value == "Process"){

            sideNavOption.value["Sub-processes"].push(checkbox[0]);
          
          }else if(activeButton.value == "Sub-processes"){
            
            sideNavOption.value["Task"].push(checkbox[0]);
          
          }
        }else{
          if(activeButton.value == "Domain"){
          
            sideNavOption.value["Technology"] = removeItemAll(sideNavOption.value["Technology"] ,checkbox[0] )

        }else if(activeButton.value == "Technology"){
        
          sideNavOption.value["Deliverables"] = removeItemAll(sideNavOption.value["Deliverables"] ,checkbox[0] )
        
        }else if(activeButton.value == "Deliverables"){

          sideNavOption.value["Process"] = removeItemAll(sideNavOption.value["Process"] ,checkbox[0] )

          }
          else if(activeButton.value == "Process"){

          sideNavOption.value["Sub-processes"] = removeItemAll(sideNavOption.value["Sub-processes"] ,checkbox[0] )
        
        }else if(activeButton.value == "Sub-processes"){
          
          sideNavOption.value["Task"] = removeItemAll(sideNavOption.value["Task"] ,checkbox[0] )

        }
        }
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
.my-menu-link{
  color: white;
  background-color:#1976d2;
}
.side-list-item{
  border-bottom: 1px solid #1976d2;
  color: black;
}
.option-btn:hover{
  background-color: #1976d2;
}
</style>
