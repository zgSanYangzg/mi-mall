webpackJsonp([16],{679:function(t,r,e){"use strict";function s(t){e(770)}Object.defineProperty(r,"__esModule",{value:!0});var a=e(772),i=e(773),n=e(9),o=s,c=n(a.a,i.a,!1,o,null,null);r.default=c.exports},696:function(t,r,e){"use strict";r.a={filters:{orderStatus:function(t){return["","等待付款","等待配货","等待出库","等待收货","交易成功","已关闭"][t]},orderStatusClass:function(t){return["","uc-order-item-pay","uc-order-item-shipping","uc-order-item-shipping","uc-order-item-shipping","uc-order-item-finish","uc-order-item-finish"][t]}},methods:{$_order_btnCancel:function(t){return"1"===this.$trim(t)},$_order_btnPay:function(t){return"1"===this.$trim(t)},$_order_btnReceive:function(t){return"4"===this.$trim(t)},$_order_getStatus:function(t){var r=t.orderStatus,e=t.shippingStatus,s=t.payStatus;return r=this.$trim(r),e=this.$trim(e),s=this.$trim(s),"3"===r?6:"4"===r||"2"===r?5:"0"===s?1:"1"===s&&"0"===r?2:"1"===r&&"0"===e?3:"1"===r&&"1"===e?4:0}}}},697:function(t,r,e){"use strict";function s(t){e(698)}var a=e(700),i=e(702),n=e(9),o=s,c=n(a.a,i.a,!1,o,null,null);r.a=c.exports},698:function(t,r,e){var s=e(699);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);e(671)("e48d6746",s,!0)},699:function(t,r,e){r=t.exports=e(670)(!1),r.push([t.i,"",""])},700:function(t,r,e){"use strict";var s=e(696),a=e(701);r.a={name:"OrderTable",mixins:[s.a,a.a],props:{data:{type:Object,default:function(){return{}}},emptyMsg:""},filters:{parseDate:function(t){return new Date(t).format("yyyy年MM月dd日 hh:mm")}},data:function(){return{form:this.data}},methods:{onReceive:function(t){var r=this;this.$confirm("确认已经收到货物吗？").then(function(){r.$service.order.receive({orderId:t}).then(function(){r.load()})})}}}},701:function(t,r,e){"use strict";var s=e(71),a=e.n(s);r.a={data:function(){var t={page:1,pageSize:5};return a.a.assign(t,this.form,a.a.pick(this.$route.query,["page","keywords"])),{loading:!1,form:t,table:{page:1,records:0,total:0,rows:[]}}},created:function(){this.load()},watch:{$route:function(t){a.a.assign(this.form,a.a.pick(t.query,["page","keywords"])),this.load()}},methods:{onPage:function(t){this.form.page=t,this.refresh()},refresh:function(){this.$router.push({query:a.a.pick(this.form,["page","keywords"])})},load:function(){var t=this;this.loading=!0,this.$service.order.queryOrderPage(this.form).then(function(r){t.loading=!1,t.table=r.data})}}}},702:function(t,r,e){"use strict";var s=function(){var t=this,r=t.$createElement,e=t._self._c||r;return e("div",{staticClass:"box-bd"},[e("div",[t.loading?e("div",{staticClass:"loading"},[e("div",{staticClass:"loader"})]):0===t.table.records?e("p",{staticClass:"empty"},[t._v(t._s(t.emptyMsg))]):e("ul",{staticClass:"order-list"},[t._l(t.table.rows,function(r){return[e("li",{staticClass:"uc-order-item",class:t._f("orderStatusClass")(t.$_order_getStatus(r))},[e("div",{staticClass:"order-detail"},[e("div",{staticClass:"order-summary"},[e("div",{staticClass:"order-status"},[t._v(t._s(t._f("orderStatus")(t.$_order_getStatus(r))))])]),t._v(" "),e("table",{staticClass:"order-detail-table"},[e("thead",[e("tr",[e("th",{staticClass:"col-main"},[e("p",{staticClass:"caption-info"},[t._v(t._s(t._f("parseDate")(r.addTime))),e("span",{staticClass:"sep"},[t._v("|")]),t._v(t._s(r.consignee)),e("span",{staticClass:"sep"},[t._v("|")]),t._v("订单号： "),e("router-link",{attrs:{to:"/main/orderDetail/"+r.orderId}},[t._v(t._s(r.orderSn))]),e("span",{staticClass:"sep"},[t._v("|")]),t._v("在线支付")],1)]),t._v(" "),e("th",{staticClass:"col-sub"},[e("p",{staticClass:"caption-price"},[t._v("订单金额："),e("span",{staticClass:"num"},[t._v(t._s(r.totalAmount))]),t._v("元")])])])]),t._v(" "),e("tbody",[e("tr",[e("td",{staticClass:"order-items"},[e("ul",{staticClass:"goods-list"},[t._l(r.orderGoodsList,function(r){return[e("li",[e("div",{staticClass:"figure figure-thumb"},[e("router-link",{attrs:{target:"_blank",to:"/product/"+r.specGoodsId}},[e("img",{directives:[{name:"image",rawName:"v-image",value:r.originalImg,expression:"product.originalImg"}],attrs:{width:"80",height:"80"}})])],1),t._v(" "),e("p",{staticClass:"name"},[e("router-link",{attrs:{target:"_blank",to:"/product/"+r.specGoodsId}},[t._v("\n                            "+t._s(r.goodsName)+" "+t._s(r.specKeyName))])],1),t._v(" "),e("p",{staticClass:"price"},[t._v(t._s(r.goodsPrice)+"元 × "+t._s(r.goodsNum))])])]})],2)]),t._v(" "),e("td",{staticClass:"order-actions"},[t.$_order_btnPay(t.$_order_getStatus(r))?e("router-link",{staticClass:"btn btn-small btn-primary",attrs:{to:"/confirmOrder/"+r.orderId}},[t._v("立即支付")]):t._e(),t._v(" "),t.$_order_btnReceive(t.$_order_getStatus(r))?e("a",{staticClass:"btn btn-small btn-primary",attrs:{href:"javascript:void(0)"},on:{click:function(e){t.onReceive(r.orderId)}}},[t._v("确认收货")]):t._e(),t._v(" "),e("router-link",{staticClass:"btn btn-small btn-line-gray",attrs:{to:"/main/orderDetail/"+r.orderId}},[t._v("订单详情")])],1)])])])])])]})],2)]),t._v(" "),t.table.total>1?e("c-pagination",{attrs:{"current-page":t.table.page,total:t.table.total},on:{change:t.onPage}}):t._e()],1)},a=[],i={render:s,staticRenderFns:a};r.a=i},770:function(t,r,e){var s=e(771);"string"==typeof s&&(s=[[t.i,s,""]]),s.locals&&(t.exports=s.locals);e(671)("ead40bf4",s,!0)},771:function(t,r,e){r=t.exports=e(670)(!1),r.push([t.i,"",""])},772:function(t,r,e){"use strict";var s=e(697);r.a={name:"Close",components:{OrderTable:s.a},data:function(){return{form:{type:4}}}}},773:function(t,r,e){"use strict";var s=function(){var t=this,r=t.$createElement;return(t._self._c||r)("order-table",{attrs:{data:t.form,"empty-msg":"当前没有已关闭订单。"}})},a=[],i={render:s,staticRenderFns:a};r.a=i}});