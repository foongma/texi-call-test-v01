
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CallManager from "./components/listers/CallCards"
import CallDetail from "./components/listers/CallDetail"

import TaxiManager from "./components/listers/TaxiCards"
import TaxiDetail from "./components/listers/TaxiDetail"

import PointManager from "./components/listers/PointCards"
import PointDetail from "./components/listers/PointDetail"


import CommentManager from "./components/listers/CommentCards"
import CommentDetail from "./components/listers/CommentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/calls',
                name: 'CallManager',
                component: CallManager
            },
            {
                path: '/calls/:id',
                name: 'CallDetail',
                component: CallDetail
            },

            {
                path: '/taxis',
                name: 'TaxiManager',
                component: TaxiManager
            },
            {
                path: '/taxis/:id',
                name: 'TaxiDetail',
                component: TaxiDetail
            },

            {
                path: '/points',
                name: 'PointManager',
                component: PointManager
            },
            {
                path: '/points/:id',
                name: 'PointDetail',
                component: PointDetail
            },


            {
                path: '/comments',
                name: 'CommentManager',
                component: CommentManager
            },
            {
                path: '/comments/:id',
                name: 'CommentDetail',
                component: CommentDetail
            },



    ]
})
