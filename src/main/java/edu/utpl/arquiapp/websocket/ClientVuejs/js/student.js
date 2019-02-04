Vue.component('template-optionmultiple', {
    props: ['option','groupid'],
    template: `
        <div class="form-check">
            <input class="form-check-input" type="radio" :name="groupid" :value="option.idOption"> 
            <label class="form-check-label">
                {{ option.textOption }}
            </label>
        </div>                 
    `
});


Vue.component('template-optiontruefalse', {
    props: ['option'],
    template: `
        <div class="form-button">
            <button class="btnTrueFalse" name="true">Verdadero</button>
            <button class="btnTrueFalse" name="false">Falso</button>
        </div>                 
    `
});


Vue.component('template-optionshortanswer', {
    props: ['option'],
    template: `
        <div class="form-check">
            <input class="txtAnswer" type="text" name="option.idQuestionShortAnswer" placeholder="Escribe tu respuesta">
        </div>                 
    `
});

new Vue({
    el: "#app",
    data: {
        key: '',
        status: '',
        optionMutiple: [],
        optionTrueFalse: [],
        optionShortAnswer: [],
        survey: {},

        // option multiple;
        idQuestionOptMul: 0,
        nameQuestion: '',
        count: 0,
        nameQuiz: '',
        option: 0,
        answerTrueFalse: true,
        option1: '',
        option2: '',
        option3: '',
        option4: '',
        answer1: false,
        answer2: false,
        answer3: false,
        answer4: false

    },
    methods: {
        connect() {
            socket = new WebSocket("ws://localhost:4567/Student");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        setTrueFalse: function (bandera){
            this.answerTrueFalse = bandera;
        },
        segPregunta(){
            this.clear();
            if(this.optionMutiple.length != 0){
                this.count = this.optionMutiple.length - 1;
                this.option1 = this.optionMutiple[this.count].options[0].textOption;
                this.option2 = this.optionMutiple[this.count].options[1].textOption;
                this.option3 = this.optionMutiple[this.count].options[2].textOption;
                this.option4 = this.optionMutiple[this.count].options[3].textOption;
                this.nameQuestion = this.optionMutiple[this.count].textQuestion;
                this.optionMutiple.splice(this.count, 1);
                this.option = 1;
            }else if(this.optionTrueFalse != 0){
                this.count = this.optionTrueFalse.length - 1;
                this.nameQuestion = this.optionTrueFalse[this.count].textQuestion;
                this.optionTrueFalse.splice(this.count, 1);
                this.option = 2;
            }else if(this.optionShortAnswer != 0){
                this.count = this.optionShortAnswer.length - 1;
                this.nameQuestion = this.optionShortAnswer[this.count].textQuestion;
                this.optionShortAnswer.splice(this.count, 1);
                this.option = 3;
            }else{
                alert("Acabaste");
                this.option = 4;
            }
        },
        clear(){
            this.answer1 = false;
            this.answer2 = false;
            this.answer3 = false;
            this.answer4 = false;
            this.answerTrueFalse = true;
        },
        openWs() {
            this.status = "connected";
            this.sendMessage(this.key);
        },
        errorWs(evt) {
            alert("Lo sentimos pero no existe esa sala");
            console.log(evt.data);
        },
        messageWs(evt) {
            this.survey = JSON.parse(evt.data);
            this.nameQuiz = this.survey.nameQuiz;
            this.optionMutiple = this.survey.optionMultiple;
            this.optionTrueFalse = this.survey.optionTrueFalse;
            this.optionShortAnswer = this.survey.optionShortAnswer;
            this.segPregunta();
            console.log(evt.data);
        },
        sendMessage(msgData) {
            socket.send(msgData);
        }
    }
});