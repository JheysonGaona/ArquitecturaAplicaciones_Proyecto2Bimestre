Vue.component('q-option1', {
  props: ['opcion', 'groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" :value="opcion.answer"> {{opcion.textOption}}
            </label        
        </div>
    `
});
Vue.component('q-option2', {
  props: ['groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="true">Verdadero
            </label>
            <br>
            <br>
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="false">Falso
            </label>
        </div>
    `
});
Vue.component('q-option3', {
  props: ['groupid'],
  template: `
        <div id="correcta">
            <label>
                <input class="txtAnswerStudent" type="text" :name="groupid">
            </label>
        </div>
    `
});

new Vue({
    el: "#app",
    data: {
        key: '',
        status: '',
        nameUser: '',
        survey: {},
        answer: [],
        estado: 0
    },
    methods: {
        saveAnswer: function(){

            for (var index in this.survey.optionMultiple) {
                this.key = this.survey.optionMultiple[index].idQuestionOptionMultiple;
                var result = null;
                var radios = document.getElementsByName(this.key);
                for (var i = 0; i < radios.length; i++) {
                    if (radios[i].checked) {
                        result = radios[i].value;
                    }  
                }
                this.answer.push({
                question: this.survey.optionMultiple[index].textQuestion,
                answer: result
                });
            }
            
            for (var index in this.survey.optionTrueFalse) {
                this.key = this.survey.optionTrueFalse[index].idQuestionTrueFalse;
                var result = null;
                var radios = document.getElementsByName(this.key);
                for (var i = 0; i < radios.length; i++) {
                    if (radios[i].checked) {
                        result = radios[i].value;
                    }  
                }
                this.answer.push({
                question: this.survey.optionTrueFalse[index].textQuestion,
                answer: result
                });
            }
            
            for (var index in this.survey.optionShortAnswer) {
                this.key = this.survey.optionShortAnswer[index].idQuestionShortAnswer;
                var result = document.getElementsByName(this.key).value;
                this.answer.push({
                question: this.survey.optionShortAnswer[index].textQuestion,
                answer: result
                });
            }
            this.estado = 1;
            var gson = {idQuiz: this.survey.idQuiz, nameQuiz: this.survey.nameQuiz, student: this.nameUser, answers: this.answer};
            this.sendMessage(gson);
        },
        connect() {
            socket = new WebSocket("ws://localhost:4567/Student");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        openWs() {
            this.status = "connected";
            this.sendMessage(this.key);
        },
        errorWs(evt) {
            alert("Lo sentimos pero no existe esa sala");
        },
        messageWs(evt) {
            this.survey = JSON.parse(evt.data);
            
        },
        sendMessage(msgData) {
            if(this.estado === 0){
                socket.send(msgData);
            }else{
                var myJSON = JSON.stringify(msgData);
                socket.send(myJSON);
            }
        }
    }
});