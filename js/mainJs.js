Vue.component('option-m', {
    props: ['txtNameQuestion', 'optionA', 'optionB', 'optionC'],
    template: `
        <div>

        </div>
    `
});

new Vue({
    el: "#app",
    data: {
        status: "",
        nameQuiz: null,
        option: 0,
        // Opcion multiple

        // Verdadero y falso
        nameQuestion: null,
        lists: [],
        btn: true,
        // Respuesta corta

        // Error
        errors: []
    },
    methods: {
        checkForm: function () {
            if (this.nameQuiz) {
                if(this.lists.length != 0){
                    this.connect();
                }else{
                    this.errors.push('Quiz empty');
                }
                return true;
            }
            if (!this.nameQuiz) {
                this.errors.push('Name Quiz required.');
            }
        },
        addQuiz: function() {
            if (this.nameQuestion) {
                this.lists.push({question: this.nameQuestion, answer: this.btn});
                return true;
            }
            if (!this.nameQuestion) {
                this.errors.push('Name Question required.');
            }
        },
        trueFalse: function(message){
            this.btn = message;
        },
        connect() {
            this.status = 'connected';
        },
        pregunta(number){
            this.option = number;
        }
    }
});



/*

    methods: {
        sendData() {
            this.status = "conectado";
            alert(this.status);
            this.$http.post(
                "https://httpbin.org/post", this.input, {
                    headers: {
                        "content-type": "application/json"
                    } 
                ).then(result => {
                    this.response = result.data;
                }, error => {
                    console.error(error);
                });
            }
        }
    }
});
*/