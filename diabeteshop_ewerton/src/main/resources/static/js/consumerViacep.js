//    Consumo da API - Viacep: https://viacep.com.br/

new Vue({
    el: "#viaCep",
    data: {
        endereco: {
            cep: null,
            cidade: null
        }
    },
    methods: {
        getCidadeByCep(){
            axios({
                method: "get",
                url: `https://viacep.com.br/ws/${this.endereco.cep}/json/`,
                responseType: "application/json"
            }).then(response => {
                var bean = response.data;
                this.endereco.cidade = bean.localidade;
            })
        }
    }
})