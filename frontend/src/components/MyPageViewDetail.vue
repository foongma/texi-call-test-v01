<template>

    <v-card outlined>
        <v-card-title>
            MyPage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="CallId" v-model="item.callId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UserLocation" v-model="item.userLocation" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Destination" v-model="item.destination" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TaxiNumber" v-model="item.taxiNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TaxiModel" v-model="item.taxiModel" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DriverName" v-model="item.driverName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DriverMobileNumber" v-model="item.driverMobileNumber" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Comment" v-model="item.comment" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyPageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myPages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

