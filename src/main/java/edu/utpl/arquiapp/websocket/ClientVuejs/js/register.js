new Vue({
    // Etiqueta main desde donde iniciara vuejs
    el: "#app",
    // variables globales
    data: {
        // datos del profesor
        name: '',
        lastname: '',
        email: '',
        password: '',
        // Errores
        errors: []
    },
    // metodos de la app
    methods: {
        addTeacher: function (){
            if(this.name && this.lastname && this.email && this.password){
                alert("hola1");
                this.connect();
            }else{
                this.errors.push('All fields required.');
            }
        },
        // conectando con el servidor mediante un URL y puerto conexion WebSocket
        connect() {
            socket = new WebSocket("ws://localhost:4567/CreateTeacher");
            socket.onopen = this.openWs;
            socket.onerror = this.errorWs;
            socket.onmessage = this.messageWs;
        },
        // enviar cuestionario al servidor en formato JSON
        openWs() {
            var gson = {name: this.name, lastName: this.lastname, email: this.email, password: this.password};
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