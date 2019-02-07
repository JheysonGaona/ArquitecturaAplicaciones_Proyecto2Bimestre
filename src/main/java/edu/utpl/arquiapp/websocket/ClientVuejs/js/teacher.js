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


var vm = new Vue({
    // Etiqueta main desde donde iniciara vuejs
    el: "#app",
    // variables globales
    data: {
        // evaluar boton seleccionado
        status: '',
        user: '',
        password: '',
        option: 0,
        // nombre del cuestionario
        nameQuiz: '',
        // nombre de la pregunta
        textQuestion: '',
        // opción múltiple
        listOptionmultiple: [],
        option1: '',
        option2: '',
        option3: '',
        option4: '',
        answer1: false,
        answer2: false,
        answer3: false,
        answer4: false,
        // verdadero / falso
        listTrueFalse: [],
        answerTrueFalse: true,
        // respuesta corta
        listShortAnswer: [],
        answerShortAnswer: '',
        // Errores
        errors: []
    },
    // metodos de la app
    methods: {
        addQuiz: function (){
            if(this.nameQuiz){
                if(this.listOptionmultiple.length != 0 || this.listTrueFalse.length != 0 || this.listShortAnswer.length != 0){
                    this.connect();
                }else{
                    this.errors.push('not added questions.');
                }
            }else{
                this.errors.push('Name quiz required.');
            }
        },
        addQuestionOptionMultiple: function () {
            if(this.textQuestion && this.option1 && this.option2 && this.option3 && this.option4){
				var list = [];
	            list.push({textOption: this.option1, answer: this.answer1});
	            list.push({textOption: this.option2, answer: this.answer2});
	            list.push({textOption: this.option3, answer: this.answer3});
	            list.push({textOption: this.option4, answer: this.answer4});
	            this.listOptionmultiple.push({textQuestion: this.textQuestion, options: list});
	            this.clear(1);
            }else{
            	this.errors.push('Question or options required.');
            }
        },
        addQuestionTrueFalse: function () {
        	if(this.textQuestion){
        		this.listTrueFalse.push({textQuestion: this.textQuestion, answer: this.answerTrueFalse});
        		this.clear(2);
        	}else{
        		this.errors.push('Name Question required.');
        	}
        },
        addQuestionShortAnswer: function () {
        	if(this.textQuestion && this.answerShortAnswer){
        		this.listShortAnswer.push({textQuestion: this.textQuestion, answer: this.answerShortAnswer});
        		this.clear(3);
        	}else{
        		this.errors.push('Name Question or answer required.');
        	}
        },
        setTrueFalse: function (bandera){
            this.answerTrueFalse = bandera;
        },
        setOption: function (number) {
            if(this.option == number){
                this.option = 0;
            }else{
                this.option = number;
            }
        },
        clear: function (number){
        	switch(number){
        		case 1:
        			this.textQuestion = "";
		        	this.option1 = "";
			        this.option2 = "";
			        this.option3 = "";
			        this.option4 = "";
			        this.answer1 = false;
			        this.answer2 = false;
			        this.answer3 = false;
			        this.answer4 = false;
        		break;

        		case 2:
        			this.textQuestion = "";
		        	this.answerTrueFalse = true;
        		break;

        		case 3:
	        		this.textQuestion = "";
	        		this.answerShortAnswer = "";
        		break;
        	}
        },
        login(){
            if(this.user == "jheyson" && this.password == "123"){
                this.status = "teacherLogin";
            }else{
                alert("Nombre de usuario o contraseña incorrectos");
            }
            
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
            var gson = {nameQuiz: this.nameQuiz, optionMultiple: this.listOptionmultiple,
                optionTrueFalse: this.listTrueFalse, optionShortAnswer: this.listShortAnswer};
            var myJSON = JSON.stringify(gson);
            this.sendMessage(myJSON);
        },
        // Error de conexion
        errorWs(evt) {
            this.status = 'error';
        },
        // message recivido desde el servidor
        messageWs(evt) {
            this.msm = evt.data;
        },
        sendMessage(msgData) {
            socket.send(msgData);
        }
    }
});