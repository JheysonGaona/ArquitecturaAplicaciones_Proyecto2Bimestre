Vue.http.headers.common['Accept'] = 'application/json';

Vue.component('opcionm', {
    template: "#template-listOptionmultiple",
    props: ['opcionm'],
    methods: {
        deleteQuestionOptionM: function (opcionm) {
            var index = vm.listOptionmultiple.indexOf(opcionm);
            vm.listOptionmultiple.splice(index, 1);
        }
    }
});

Vue.component('opciontf', {
    template: "#template-listTrueFalse",
    props: ['opciontf'],
    methods: {
        deleteQuestionOptionTF: function (opciontf) {
            var index = vm.listTrueFalse.indexOf(opciontf);
            vm.listTrueFalse.splice(index, 1);
        }
    }
});

Vue.component('opcionsa', {
    template: "#template-listShortAnswer",
    props: ['opcionsa'],
    methods: {
        deleteQuestionOptionSA: function (opcionsa) {
            var index = vm.listShortAnswer.indexOf(opcionsa);
            vm.listShortAnswer.splice(index, 1);
        }
    }
});

Vue.component('q-option2', {
  props: ['opcion'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" name="quiz" :value="opcion.idQuiz"> {{opcion.nameQuiz}}
            </label        
        </div>
    `
});

var vm = new Vue({
    // Etiqueta main desde donde iniciara vuejs
    el: "#app",
    // variables globales
    data: {
        quizId: '',
        listQuiz: [],
        result: 0,
        listOptionmultiple: [],
        listTrueFalse: [],
        listShortAnswer: []
    },
    mounted: function() {
            this.connect()
    },
    // metodos de la app
    methods: {
    	hola(){
            var radios = document.getElementsByName('quiz');
            for (var j = 0; j < radios.length; j++) {
                if (radios[j].checked) {
                    this.result = radios[j].value;
                }  
            }
            this.listOptionmultiple = this.listQuiz[this.result - 1].optionMultiple;
            this.listTrueFalse = this.listQuiz[this.result - 1].optionTrueFalse;
            this.listShortAnswer = this.listQuiz[this.result - 1].optionShortAnswer;
    	},
        // conectando con el servidor mediante un URL y puerto conexion WebSocket
        connect() {
            socket = new WebSocket("ws://localhost:4567/CreateQuiz");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        // enviar cuestionario al servidor en formato JSON
        openWs() {
            this.sendMessage(this.quizId);
        },
        // Error de conexion
        errorWs(evt) {
            this.status = 'error';
        },
        // message recivido desde el servidor
        messageWs(evt) {
        	this.listQuiz = JSON.parse(evt.data);
            
        },
        sendMessage(msgData) {
            socket.send(msgData);
        }
    }
});