new Vue({
    // Etiqueta main desde donde iniciara vuejs
    el: "#app",
    // variables globales
    data: {
        quizId: 1,
        listQuiz: [],
        result: 0
    },
    mounted: function() {
            this.connect()
    },
    methods: {
        hola(){
            var radios = document.getElementsByName('quiz');
            for (var j = 0; j < radios.length; j++) {
                if (radios[j].checked) {
                    this.result = radios[j].value;
                }  
            }
            alert(this.result);
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